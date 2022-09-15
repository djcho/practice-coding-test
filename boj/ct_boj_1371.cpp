// codingtest.cpp : 이 파일에는 'main' 함수가 포함됩니다. 거기서 프로그램 실행이 시작되고 종료됩니다.
//
#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <string>
#include <map>
using namespace std;

class Tag
{
private:
    std::string tagName;
    std::map<std::string, std::string> attributes;
    std::vector<Tag*> childTags;
    Tag* parentTag;

public:

    void setParent(Tag* parentTag)
    {
        this->parentTag = parentTag;
    }

    Tag* getParentTag()
    {
        return this->parentTag;
    }

    std::string getName()
    {
        return this->tagName;
    }

    Tag(std::string tagName, std::map<std::string, std::string> attributes)
        :tagName(tagName), attributes(attributes)
    {
    }

    std::map<std::string, std::string>& getAttributes() { return this->attributes; }
    void addChildTag(Tag* tag)
    {
        childTags.push_back(tag);
    }

    Tag* getChildByTagName(const std::string& tagName)
    {
        std::vector<Tag*>::iterator pos = std::find_if(this->childTags.begin(), this->childTags.end(), [&](Tag* tag) {
            return tag->getName() == tagName; });

        if (pos != this->childTags.end())
            return *pos;
        return nullptr;
    }
};

class StringUtil
{
public:

    static std::string replace(const std::string& src, const std::string& from, const std::string& to) {

        std::string replaced = src;
        size_t start_pos = 0;
        while ((start_pos = replaced.find(from, start_pos)) != std::string::npos) {
            replaced.replace(start_pos, from.length(), to);
            start_pos += to.length();
        }
        return replaced;
    }

    static std::vector<std::string> splitString(const std::string& src, const std::string& delimiter)
    {
        std::vector<std::string> vec;
        std::string tmp_src = src;
        std::size_t pos;
        while ((pos = tmp_src.find(delimiter)) != std::string::npos)
        {
            std::string splitStr = tmp_src.substr(0, pos);
            vec.push_back(splitStr);

            tmp_src.erase(0, pos + delimiter.length());
        }
        vec.push_back(tmp_src);
        return vec;
    }
};

class HrmlParser
{
private:
    std::vector<std::string> sourceCode;
    std::vector<Tag*> tags;

public:
    HrmlParser(std::vector<std::string> sourceCode) : sourceCode(sourceCode) {}
    ~HrmlParser() {}

    std::string query(const std::string queryString)
    {
        std::vector<std::string> splitedQueryString = StringUtil::splitString(queryString, "~");
        std::vector<std::string> splitedTagNames = StringUtil::splitString(splitedQueryString[0], ".");
        std::string attributeName = splitedQueryString[1];

        Tag* currentTag = nullptr;
        std::vector<Tag*>::iterator tagPos = std::find_if(this->tags.begin(), this->tags.end(), [&](Tag* tag)
            {
                return tag->getName() == splitedTagNames[0];
            });

        if(tagPos == this->tags.end())
            return std::string("Not Found!");

        currentTag = *tagPos;

        if (splitedTagNames.size() >= 2)
        {
            for (std::vector<std::string>::iterator iter = splitedTagNames.begin() + 1; iter != splitedTagNames.end(); iter++)
            {
                currentTag = currentTag->getChildByTagName(*iter);
                if(!currentTag)
                    return std::string("Not Found!");
            }
        }

        std::map<std::string, std::string> attributes = currentTag->getAttributes();
        std::map<std::string, std::string>::iterator pos = attributes.find(attributeName);
        if (pos == attributes.end())
            return std::string("Not Found!");
        else
            return pos->second;
    }


    std::string getTagName(const std::string& tagString)
    {
        //<tag1 value = "HelloWorld">
        std::string temp = tagString;
        temp.erase(std::remove(temp.begin(), temp.end(), '<'), temp.end());
        temp.erase(std::remove(temp.begin(), temp.end(), '>'), temp.end());
        size_t found = temp.find(' ');
        if (found == std::string::npos)
            return temp;

        return  temp.substr(0, tagString.find(' ') - 1);;
    }

    std::map<std::string, std::string> getAttributes(const std::string& tag)
    {
        //<tag3 another = "another" final = "final">
        std::map<std::string, std::string> attributes;

        std::size_t found = tag.find(' ');
        if (found == std::string::npos)
           return attributes;

        std::string attributeStrings = tag.substr(found + 1, tag.find_last_of('>') - (found + 1));
        
        std::vector<std::string> splitedAttributes = StringUtil::splitString(attributeStrings, "\" ");
        
        
        for (auto& splitedAttribute : splitedAttributes)
        {
            splitedAttribute.erase(std::remove(splitedAttribute.begin(), splitedAttribute.end(), '\"'), splitedAttribute.end());
            std::vector<std::string> attKeyValue = StringUtil::splitString(splitedAttribute, " = ");
            attributes.insert(std::pair<std::string, std::string>(attKeyValue[0], attKeyValue[1]));
        }

        return attributes;
    }

     Tag* createTag(const std::string& tagString)
     {
         return new Tag(getTagName(tagString), getAttributes(tagString));
     }

     void parse()
     {
         Tag* currentTag = nullptr;
         for (auto& tagString : this->sourceCode)
         {
             if (isCloser(tagString))
             {
                 currentTag = currentTag->getParentTag();
                 continue;
             }

             Tag *newTag = createTag(tagString);
             if (currentTag)
                 currentTag->addChildTag(newTag);  

             newTag->setParent(currentTag);
             currentTag = newTag;

             if(!currentTag->getParentTag())
                tags.push_back(newTag);
         }
     }
    
    bool isCloser(const std::string& tag)
    {
        if (tag.empty())
            return false;

        std::size_t found = tag.find("</");
        if (found != std::string::npos)
            return true;
        else
            return false;
    }
};


std::vector<std::string> inputCode(int inputLine)
{
    std::string lineOfCode;
    std::vector<std::string> intputData;

    for (int i = 0; i < inputLine; ++i)
    {
        std::getline(std::cin, lineOfCode);
        intputData.push_back(lineOfCode);
    }

    return intputData;
}

int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    int sourceLine = 0;
    int queryLine = 0;

    std::cin >> sourceLine >> queryLine;
    std::cin.ignore();

    std::vector<std::string> sourceCode = inputCode(sourceLine);
    std::vector<std::string> queryCode = inputCode(queryLine);

    HrmlParser hrmlParser(sourceCode);
    hrmlParser.parse();
    for (auto& query : queryCode)
        std::cout << hrmlParser.query(query) << std::endl;

    return 0;
}
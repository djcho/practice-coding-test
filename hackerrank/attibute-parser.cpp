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

class TagNode
{
private:
    std::vector<std::string> attributes;
    TagNode* childNode;

public:
    TagNode(std::vector<std::string> attributes,TagNode* childNode)
        :attributes(attributes), childNode(childNode)
    {
    }

    TagNode* getChildNode() { return this->childNode; }
    std::vector<std::string>& getAttributes() { return this->attributes; }
    
};

class StringUtil
{
public:

    std::string replace(const std::string& src, const std::string& from, const std::string& to) {

        std::string replaced = src;
        size_t start_pos = 0;
        while ((start_pos = replaced.find(from, start_pos)) != std::string::npos) {
            replaced.replace(start_pos, from.length(), to);
            start_pos += to.length();
        }
        return replaced;
    }

    std::vector<std::string> splitString(const std::string& src, const std::string& delimiter)
    {
        std::vector<std::string> vec;
        std::string tmp_src = src;
        std::size_t pos;
        while ((pos = tmp_src.find(delimiter)) != std::string::npos)
        {
            std::string splitStr = tmp_src.substr(0, pos);
            std::cout << splitStr << std::endl;
            vec.push_back(splitStr);

            tmp_src.erase(0, pos + delimiter.length());
        }
        vec.push_back(tmp_src);
        std::cout << tmp_src << std::endl;
        return vec;
    }
};

class HrmlParser
{
private:
    std::vector<std::string> sourceCode;
    std::map<std::string, TagNode*> tagMap;

public:
    HrmlParser(std::vector<std::string> sourceCode) : sourceCode(sourceCode) {}
    ~HrmlParser() {}

    std::string query(const std::string queryString)
    {
        std::string src = queryString;
        std::size_t pos = src.find_first_of(".~");
        
        StringUtil su;

        TagNode* tagNode = nullptr;
        while (pos != std::string::npos)
        {
            switch (src[pos])
            {
            case '.': 
            {
                std::string tagName = src.substr(0, pos);
                if (!tagNode)
                {
                    std::map<std::string, TagNode*>::iterator iter = this->tagMap.find(tagName);
                    if (iter != this->tagMap.end())
                        tagNode = iter->second;
                }
                else
                    tagNode = tagNode->getChildNode();
                src.erase(0, pos + 1);
                break;
            }
            case '~':                
                std::string query = src.substr(0, pos);
                std::vector<std::string> tagKeyValue = su.splitString(query, "~");
                std::string tagName = tagKeyValue[0];
                if (!tagNode)
                {
                    std::map<std::string, TagNode*>::iterator iter = this->tagMap.find(tagName);
                    if (iter != this->tagMap.end())
                        tagNode = iter->second;
                }

                std::string attributeName = tagKeyValue[1];
                for (auto& attributeKeyValue : tagNode->getAttributes())
                {
                    std::vector<std::string> splitedVec = su.splitString(attributeKeyValue, " = ");
                    if(splitedVec[0] == attributeName)
                    {
                        return splitedVec[1];
                    }
                }
                return std::string("Not Found!");
            }
        }
        


        return std::string();
    }


    std::string getTagName(const std::string& tag)
    {
        //<tag1 value = "HelloWorld">
        std::size_t found = tag.find('<');
        std::string tagName = tag.substr(found + 1, tag.find(' ', found) - 1);
        return tagName;
    }

     std::vector<std::string> getAttributeNames(const std::string& tag)
    {
        //<tag3 another="another" final = "final">
        std::size_t found = tag.find(' ');
        std::string attributeStrings = tag.substr(found + 1, tag.find_last_of('>') - (found + 1));
        
        StringUtil su;

        std::vector<std::string> splitedAttributes = su.splitString(attributeStrings, "\" ");
        
        for(auto& splitedAttribute : splitedAttributes)
            splitedAttribute.erase(std::remove(splitedAttribute.begin(), splitedAttribute.end(), '\"'), splitedAttribute.end());

        return splitedAttributes;
    }

    void parse(TagNode* parentTagNode, std::vector<std::string>::iterator iter)
    {
        if (iter == this->sourceCode.end())
            return;

        std::string code = *iter;

        if (!this->isCloser(code))
        {
            std::string tagName = getTagName(code);
            std::vector<std::string> attributes = getAttributeNames(code);

            TagNode* tagNode = new TagNode(attributes, parentTagNode);
            std::pair<std::string, TagNode*> tag(tagName, tagNode);
            this->tagMap.insert(tag);
        }

        iter++;
        parse(nullptr, iter);
    }

    void parse()
    {
        TagNode* parentTagNode = nullptr;
        std::vector<std::string>::iterator iter = this->sourceCode.begin();

        parse(nullptr, iter);
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


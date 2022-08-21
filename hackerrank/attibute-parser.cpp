#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <map>
using namespace std;

class StringUtil
{
public:
    static void ltrim(std::string &s) {
    s.erase(s.begin(), std::find_if(s.begin(), s.end(),
            std::not1(std::ptr_fun<int, int>(std::isspace))));
    }

    static void rtrim(std::string &s) {
        s.erase(std::find_if(s.rbegin(), s.rend(),
                std::not1(std::ptr_fun<int, int>(std::isspace))).base(), s.end());
    }

    static std::vector<std::string> splitString(const std::string &src, const std::string & delimiter, bool isTrim = false)
    {
        std::vector<std::string> vec;
        std::string tmp_src = src;
        std::size_t pos;
         while((pos = tmp_src.find(delimiter)) != std::string::npos)
        {
            std::string splitStr = tmp_src.substr(0, pos);
            if(isTrim)
            {
                StringUtil::ltrim(splitStr);
                StringUtil::rtrim(splitStr);
            }
            std::cout << splitStr <<  std::endl;
            vec.push_back(splitStr);
            
            tmp_src.erase(0, pos + delimiter.length());
        }
        vec.push_back(tmp_src);
        std::cout << tmp_src <<  std::endl;
    }
};

class HrmlParser
{
private:
    std::vector<std::string> sourceCode;
    std::map<std::string, std::pair<std::string, std::string>> attributeMap;
    
public:
    HrmlParser(std::vector<std::string> sourceCode) : sourceCode(sourceCode){}
    ~HrmlParser(){}
     
    std::string query(const std::string queryString)
    {
        return std::string();
    }
    

    std::string getTagName(const std::string& tag)
    {
        //<tag1 value = "HelloWorld">
        std::size_t found = tag.find('<');
        std::string tagName = tag.substr(found + 1, tag.find(' ', found));
        return tagName;
    }
    
    std::pair<std::string, std::string> parse()
    {
        std::string tagName;
        std::vector<std::pair<std::string, std::string>> attributes;
        for(auto & code : this->sourceCode)
        {
            if(this->isCloser(code))
                continue;
            
            tagName = getTagName(code);
            if(tagName.empty())
                continue;
            
            attributes = getAttributeNames(code);
            for(auto& attribute : attributes)
            {
                std::pair<std::string, std::pair<std::string, std::string>> tag(tagName, attribute);
                this->attributeMap.insert(tag);
            }            
        }
    }

    std::vector<std::pair<std::string, std::string>> getAttributeNames(const std::string& tag)
    {
        //<tag3 another="another" final = "final">
        std::vector<std::pair<std::string, std::string>> attributes;

        std::size_t found = tag.find(' ');
        std::string attributeStrings = tag.substr(found + 1, tag.find_last_of('>'));

        std::vector<std::string> splitAttributes = StringUtil::splitString(attributeStrings, """ ");
        for(auto& splitAttribut : splitAttributes)
        {
            std::vector<std::string> keyValue = StringUtil::splitString(splitAttribut, "=", true);    
            attributes.push_back(std::pair<std::string, std::string>(keyValue[0], keyValue[1]));
        }
        
        return attributes; 
    }


    bool isCloser(const std::string& tag)
    {
        if(tag.empty())
            return false;
        
        std::size_t found = tag.find("</");
        if(found != std::string::npos)
            return true;
        else
            return false;
    }
};


std::vector<std::string> inputCode(int inputLine)
{
    std::string lineOfCode;
     std::vector<std::string> intputData;
     
    for(int i = 0; i < inputLine; ++i)
    {
        std::cin >> lineOfCode;
        
        intputData.push_back(lineOfCode);
    }
    
    return intputData;
}

void printVector(const std::vector<std::string>& vec)
{
    for(auto& str : vec)
    {
        std::cout << str << std::endl;
    }
}

int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */   
    int sourceLine = 0;
    int queryLine = 0;

    std::cin >> sourceLine >> queryLine;
    std::cin.ignore();
    
    std::vector<std::string> sourceCode = inputCode(sourceLine);
    std::vector<std::string> queryCode = inputCode(queryLine);
    
    printVector(sourceCode);
    printVector(queryCode);
    
    HrmlParser hrmlParser(sourceCode);
    hrmlParser.parse();
    for(auto& query : queryCode)
        std::cout << hrmlParser.query(query) << std::endl;
    
    return 0;
}


#include <cassert>
#include <cstdio>
#include <cstdlib>
#include <vector>
#include <map>
#include <list>
#include <set>
#include <string>
#include <deque>
#include <queue>
#include <stack>
#include <sstream>
#include <iostream>
#include <algorithm>
#include <unordered_map>

using namespace std;

static set<long>
        evaluate_helper(const vector<string> &tokens,int start,int end)
        {
   /* ADD YOUR CODE HERE */
        set<long> res;
        if(start==end)
        {
            res.insert(stoi(tokens.at(start)));
            return res;
        }
        string oper;
        for(int i=start;i<end;i++){
        if((tokens.at(i).compare("*")==0)||(tokens.at(i).compare("+")==0)||(tokens.at(i).compare("-")==0)||(tokens.at(i).compare("/")==0))
        {
        oper=tokens.at(i);
        auto left=evaluate_helper(tokens,start,i-1);
        auto right=evaluate_helper(tokens,i+1,end);
        for(auto it=left.begin();it!=left.end();it++){
        for(auto it1=right.begin();it1!=right.end();it1++){
        if((oper.compare("*")==0))
            res.insert((*it)*(*it1));
        if((oper.compare("+")==0))
            res.insert((*it)+(*it1));
        if((oper.compare("-")==0))
            res.insert((*it)-(*it1));
        if((oper.compare("/")==0)&&*it1!=0)
            res.insert((*it)/(*it1));
        }
        }
        }

        }

        return res;
        }
static set<long>
        evaluate(const vector<string> &tokens){
        set<long> res=evaluate_helper(tokens,0,tokens.size()-1);
        return res;
        }

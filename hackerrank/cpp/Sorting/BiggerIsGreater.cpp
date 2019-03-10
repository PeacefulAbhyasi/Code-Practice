#include <iostream>
#include <cstdio>
#include <cstdlib>
#include <cstring>
#include <string>
#include <queue>
#include <stack>
#include <fstream>
#include <map>
#include <vector>
#include <algorithm>
#include <climits>
using namespace std;
int main(){
	int T;
	string str;
	cin>>T;
	while(T--){
		cin>>str;
		int flag = 0;
		for(int i=0;i<str.size()-1;i++)
			if(str[i] < str[i+1])
				flag = 1;
		if(flag == 0)
			cout<<"no answer"<<endl;
		else{
			next_permutation(str.begin(),str.end());
			cout<<str<<endl;
		}
	}
	return 0;
}
#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;
int main() {
    int i,x,V[10002],N,index;
    cin>>x;cin>>N;
    for(i=0;i<N;i++){
        cin>>V[i];
        if(V[i] == x)
            index = i;
    }
    cout<<index<<endl;
    return 0;
}

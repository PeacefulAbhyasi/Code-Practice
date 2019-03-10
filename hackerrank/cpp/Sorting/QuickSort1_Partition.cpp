#include <iostream>
#include <cstdio>
#include <cstdlib>
#include <cstring>
#include <string>
#include <vector>
#include <stack>
#include <queue>
#include <algorithm>
using namespace std;
void print(int arr[],int l,int h){
	for(int i=l;i<=h;i++)
		cout<<arr[i]<<" ";
	//cout<<endl;
}
void partition(int arr[],int l,int h){
	int pivot = arr[l];
	int till = l,i,j,temp;
	for(i=l;i<=h;i++){
		if(arr[i] < pivot){
			j = i;
			temp = arr[j];
			while(j != till){
				arr[j] = arr[j-1];
				j--;
			}
			arr[till] = temp;
			till++;
		}
	}
	print(arr,l,h);
}
int main(){
	int arr[1000];
	int N,i,j;
	cin>>N;
	for(i=0;i<N;i++)
		cin>>arr[i];
	partition(arr,0,N-1);
	return 0;
}
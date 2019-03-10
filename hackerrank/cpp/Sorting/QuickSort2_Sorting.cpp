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
void print(int *arr,int l,int h){
	for(int i=l;i<=h;i++)
		cout<<arr[i]<<" ";
	cout<<endl;
}
int partition(int *arr,int l,int h){
	int x = arr[l];
	int temp1[h+1],temp2[h+1];
	int i,j,k,m = 0,n = 0;
	for(i=l+1;i<=h;i++){
		if(arr[i] < x)
			temp1[m++] = arr[i];
		else
			temp2[n++] = arr[i];
	}
	i = 0;k = l;
	while(i<m)
		arr[k++] = temp1[i++];
	int index = k;
	arr[k++] = x;
	j = 0;
	while(j<n)
		arr[k++] = temp2[j++];
	return index;
}
void QuickSort(int *arr,int l,int h){
	if(l < h){
		int pivot = partition(arr,l,h);
		QuickSort(arr,l,pivot-1);
		QuickSort(arr,pivot+1,h);
		print(arr,l,h);
	}
}
int main(){
	int *arr = new int[1000];
	int N,i,j;
	cin>>N;
	for(i=0;i<N;i++)
		cin>>arr[i];
	QuickSort(arr,0,N-1);
	return 0;
}
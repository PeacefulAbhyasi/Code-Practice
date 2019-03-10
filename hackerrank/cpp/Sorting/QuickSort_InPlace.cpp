#include <iostream>
#include <cstdio>
#include <cstdlib>
#include <cstring>
#include <string>
#include <vector>
#include <stack>
#include <queue>
#include <cmath>
#include <algorithm>
using namespace std;
int arr[1002],n;
void swap(int *a,int *b){
	int p = *a;
	*a = *b;
	*b = p;
}
void print(){
	for(int i=0;i<n;i++)
		cout<<arr[i]<<" ";
	cout<<endl;
}
int partition(int l,int h){
	int x = arr[h];
	int i = l - 1;
	for(int j=l;j<h;j++){
		if(arr[j] < x){
			i++;
			swap(&arr[i],&arr[j]);
		}
	}
	swap(&arr[i+1],&arr[h]);
	print();
	return i+1;
}
void quickSort(int l,int h){
	if(l < h){
		int pivot = partition(l,h);
		quickSort(l,pivot-1);
		quickSort(pivot+1,h);
	}
}
int main(){
	cin>>n;
	int a;
	for(int i=0;i<n;i++)
		cin>>arr[i];
	quickSort(0,n-1);
}
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
int shift = 0,cnt = 0;
void swap(int *a,int *b){
	int p = *a;
	*a = *b;
	*b = p;
}
int partition(int arr[],int l,int h){
	int x = arr[h];
	int i = l - 1;
	for(int j=l;j<h;j++){
		if(arr[j] < x){
			i++;
			swap(&arr[i],&arr[j]);
			cnt += 1;
		}
	}
	swap(&arr[i+1],&arr[h]);
	cnt += 1;
	return i+1;
}
void quickSort(int arr[],int l,int h){
	if(l < h){
		int pivot = partition(arr,l,h);
		quickSort(arr,l,pivot-1);
		quickSort(arr,pivot+1,h);
	}
}
void insertionSort(int arr[],int n){
	int j,k;
	int a;
	for(j=1;j<n;j++){
		a = arr[j];
		k = j;
		while(arr[k-1] > a && k>0){
			arr[k] = arr[k-1];
			k--;
			shift += 1;
		}
		arr[k] = a;
	}
}
int main(){
	int arrI[1002],arrQ[1002],n;
	cin>>n;
	int a;
	for(int i=0;i<n;i++){
		cin>>a;
		arrI[i] = a; arrQ[i] = a;
	}
	insertionSort(arrI,n);
	quickSort(arrQ,0,n-1);
	cout<<(shift - cnt)<<endl;
}
#include<iostream>
#include<cstdio>
#include<cstdlib>
#include<map>
#include<vector>
#include<algorithm>
using namespace std;
void display(int a[],int N){
	for(int i=0;i<N;i++){
		printf("%d ",a[i]);
	}
	printf("\n");
}
int main(){
	int arr[100005],n,a;
	scanf("%d",&n);
	for(int i=0;i<n;i++){
		scanf("%d",&arr[i]);
	}
	int j,k;
	for(j=2;j<n;j++){
		a = arr[j];
		k = j;
		while(arr[k-1] > a && k>=1){
			arr[k] = arr[k-1];
			k--;
			display(arr,n);
		}
		arr[k] = a;
	}
	display(arr,n);
	return 0;
}
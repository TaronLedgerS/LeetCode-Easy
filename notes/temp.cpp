
#include <iostream>
#include<stdlib.h>
using namespace std;
int N,S;
int T[1100];
int charging[1100];
int Maxcharging = 0;

int compare1(const void *a,const void *b)//倒序
{
     return *(int*)b-*(int*)a;
}
int compare2(const void *a,const void *b)//升序
{
     return *(int*)a-*(int*)b;
}

int main() {

    cin>>N;
    cin>>S;
    for(int i = 0;i<N;i++)
        cin>>T[i];

    qsort((void *)T,N,sizeof(int),compare1);

//    for(int i=0;i<N;i++)      cout<<T[i]<<endl;

    if (S>=N){
        cout<<T[0]<<endl;
        return 0;
    }

    int count = 0;
    for(int i = 0;i<N;i++){

        if (count==S){
            count = 0;
            qsort((void *)charging,S,sizeof(int),compare2);
        }

        charging[count] += T[i];
        count++;
    }

    qsort((void *)charging,S,sizeof(int),compare1);
    Maxcharging = charging[0];
    cout<<Maxcharging<<endl;

	return 0;
}

#include <iostream>
#include <string.h>
using namespace std;
int arr[1001];
int d[1001];
 
int max(int *arr, int n) {
    int max = arr[0];
    for (int i = 0; i < n; i++) {
        if (arr[i] > max)
            max = arr[i];
    }
    return max;
}
 
int main(void) {
    int tc;
    cin >> tc;
    for (int k = 0; k < tc; k++) {
        int n;
        cin >> n;
        int Answer = 0;
        memset(arr, 0,sizeof(arr));
        memset(d, 0,sizeof(d));
        for (int i = 0; i < n; i++) {
            cin >> arr[i];
        }
 
        for (int i = 0; i < n; i++) {
            d[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && d[i] < d[j] + 1)
                    d[i] = d[j] + 1;
            }
        }
        Answer= max(d, n);
        cout << "#" << k + 1<<" " << Answer << "\n";
    }
}
#include <iostream>
using namespace std;

int num[100];

int main(void) {
	int test_case = 10;

	for (int k = 1; k <= test_case; k++) {
		int N = 0;
		cin >> N;
		int max = 0, min = 100;
		int max_idx = 0, min_idx = 0;
		int Answer = 0;
		for (int i = 0; i < 100; i++) {
			cin >> num[i];
		}
		for (int i = 0; i <N ; i++) {
			max = 0;
			min = 100;
			int min_c = 1;
			for (int j = 0; j < 100; j++) {
				if (num[j] > max) {
					max = num[j];
					max_idx = j;
				}
				if (num[j] < min) {
					min = num[j];
					min_idx = j;
				}
				else if (num[j] == min) {
					min_c++;
				}
			}
			if (min_c == 99)
				break;
			else {
				num[max_idx] --;
				num[min_idx] ++;
			}
			}
		int max_idx = 0;
		int min_idx = 0;
		for (int j = 0; j < 100; j++) {
			if (num[j] > num[max_idx])
				max_idx = j;
			if (num[j] < num[min_idx])
				min_idx = j;
		}
		Answer = num[max_idx] - num[min_idx];
		cout << "#" << k << " " << Answer<<"\n";
	}
}
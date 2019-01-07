#include <iostream>
using namespace std;

int arr[1001];

int main() {
	int Test_case = 10;

	for (int i = 1; i <= Test_case; i++) {
		int Answer = 0;
		int N;
		cin >> N;

		for (int i = 0; i < N; i++) {
			cin >> arr[i];
		}
		for (int i = 2; i < N - 1; i++) {
			int max1, max2;
			if (arr[i - 2] - arr[i - 1] < 0)
				max1 = arr[i - 1];
			else
				max1 = arr[i - 2];
			if (arr[i + 1] - arr[i + 2] < 0)
				max2 = arr[i + 2];
			else
				max2 = arr[i + 1];

			if (arr[i] - max1 >= 1 && arr[i] - max2 >= 1) {
				if (arr[i] - max1 < arr[i] - max2)
					Answer += arr[i] - max1;
				else
					Answer += arr[i] - max2;
			}
		}

		cout << "#" << i << " " << Answer << "\n";
	}
	return 0;
}
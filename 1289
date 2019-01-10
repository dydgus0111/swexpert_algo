#include <iostream>
#include <string>
using namespace std;
 
int main(void) {
    int tc;
    cin >> tc;
    for (int k = 0; k < tc; k++) {
        string ans_num;
        string num;
        bool flag = true;
        cin >> ans_num;
        int len = ans_num.length();
 
        for (int i = 0; i <len; i++) {
            num += '0';
        }//ans_num 길이 만큼 0으로 초기화
        int idx = 0;
        int cnt = 1;
        for (int i = 0; i < len; i++) {
            if (ans_num[i] == '1') {
                idx = i;
                for (int j = i; j < len; j++)
                    num[j] = '1';
                break;
            }
        }
        idx++;
        for(int i = idx; i < len; i++) {
            if (ans_num.compare(num) != 0) {
                if (ans_num[i] == '1'&&flag == false) {
                    cnt++;
                    idx = i;
                    flag = true;
                    for (int j = i; j < len; j++)
                        num[j] = '1';
 
                }
                else if (ans_num[i] == '0'&&flag==true) {
                    cnt++;
                    idx = i;
                    flag = false;
                    for (int j = i; j < len; j++)
                        num[j] = '0';
                }
            }
            else
                break;
            idx++;
        }
        cout << "#"<< k + 1 <<" "<< cnt << "\n";
    }
}
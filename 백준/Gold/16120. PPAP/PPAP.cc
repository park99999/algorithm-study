#include <iostream>
#include<stack>
using namespace std;
stack<char> s;

int main() {
    string str;
    cin >> str;
    int p_count = 0;
    int a_count = 0;
    for (int i = 0; i < str.size(); i++)
    {
        s.push(str[i]);
    }
    while (!s.empty())
    {
        if (s.top() == 'A')
        {
            if (p_count == 0)//A가 마지막인 경우
            {
                cout << "NP";
                return 0;
            }
            else {
                a_count++;
                p_count =0 ;
                s.pop();
            }
        }
        else//P가 나온 경우
        {
            p_count++;
            s.pop();
            if (p_count > 1 && a_count >= 1)//PPAP인 경우
            {
                s.push('P');
                p_count =p_count -2;
                a_count = a_count -1;
            }
                
        }
            


    }
    if (p_count == 1 && a_count == 0)
        cout << "PPAP";
    else
        cout << "NP";
    return 0;
}
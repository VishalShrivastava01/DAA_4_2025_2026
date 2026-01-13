#include <bits/stdc++.h>
using namespace std::chrono;
using namespace std;

long long operationCount = 0;
int maxDepth = 0;

void complexRec(int n, int depth = 1) {
    maxDepth = max(maxDepth, depth);
    if (n <= 2) {
        operationCount++;
        return;
    }
    int p = n;
    while (p > 0) {
        vector<int> temp(n);
        for (int i = 0; i < n; i++) {
            temp[i] = i ^ p;
            operationCount++;
        }
        p >>= 1;
        operationCount++;
    }
    vector<int> small(n);
    for (int i = 0; i < n; i++) {
        small[i] = i * i;
        operationCount++;
    }
    reverse(small.begin(), small.end());
    operationCount += n;
    complexRec(n / 2, depth + 1);
    complexRec(n / 2, depth + 1);
    complexRec(n / 2, depth + 1);
}




int main() {
    int n = 16;
   auto start = high_resolution_clock::now(); complexRec(n);
   auto end = high_resolution_clock::now(); 
   auto duration = duration_cast<milliseconds>(end - start).count();
    cout << "Total operations: " << operationCount << "\n";
    cout << "Max recursion depth: " << maxDepth << "\n";
    cout<< "Time taken: " << duration;
    return 0;
}






/*using master theorem recurrence relation is 
3T(n/2) + n*(log(n))

it comes under case 1  (a>b^k)

And answer is 
n^log3 base2.
*/
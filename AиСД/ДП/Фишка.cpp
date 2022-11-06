#include <iostream>
#include <fstream>
#include <vector>

using namespace std;

struct n_k {
	long long n;
	long long k;
	n_k() : n(0), k(0) {}
};

long long count_paths(n_k& data) {

	vector<long long> dp(data.n, 1);
	for (long long i = 2; i < data.n; i++) {
		long long elemNK = 0;
		if ((i - data.k - 1) >= 0) {
			elemNK = dp[i - data.k - 1];
		}
		dp[i] = ((dp[i - 1] * 2) % 1000000007 - (elemNK % 1000000007) + 1000000007) % 1000000007;
	}
	return dp[data.n - 1];
}

int main() {
	ifstream in("input.txt");
	ofstream out("output.txt");
	long long size = 0;
	in >> size;
	vector<n_k> array(size, n_k());
	for (long long i = 0; i < size; i++) {
		in >> array[i].n;
		in >> array[i].k;
	}
	for (size_t i = 0; i < size; i++) {
		out << count_paths(array[i]) << endl;
	}
}
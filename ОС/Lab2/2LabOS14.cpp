#include <iostream>
#include <Windows.h>

struct Array {
	int size;
	int* p;
	Array(int _size) {
		p = new int[_size];
		size = _size;
	}
	~Array() {
		delete[] p;
	}
};

int indexOfMin;
int indexOfMax;
int average_num;

DWORD WINAPI min_max(LPVOID lpParameters) {
	std::cout << "min_max thread is started.\n";
	Array* arr = (Array*)lpParameters;

	int max = arr->p[0];
	int min = arr->p[0];

	for (int i = 0; i < arr->size; i++) {
		if (arr->p[i] > max) {
			max = arr->p[i];
			indexOfMax = i;
			Sleep(7);
		} else if (arr->p[i] < max) {
			min = arr->p[i];
			indexOfMin = i;
			Sleep(7);
		}
	}
	std::cout << "Max number in array: " << max << std::endl;
	std::cout << "Min number in array: " << min << std::endl;

	return 0;
}

DWORD WINAPI Average(LPVOID lpParameters) {
	std::cout << "Average thread is started.\n";
	Array* arr = (Array*)lpParameters;

	for (int i = 0; i < arr->size; i++) {
		average_num += arr->p[i];
		Sleep(12);
	}
	average_num /= arr->size;
	std::cout << "Average number in array: " << average_num << std::endl;
	return 0;
}

DWORD WINAPI Main(LPVOID lpParameters) {
	std::cout << "Main thread is started." << std::endl;
	std::cout << "Enter the size of array: ";
	int size = 0;
	std::cin >> size;
	Array* array = new Array(size);
	std::cout << "Enter " << size << " elements: ";
	for (int i = 0; i < size; i++) {
		std::cin >> array->p[i];
	}
	HANDLE hThread1;
	DWORD IDThread1;
	hThread1 = CreateThread(NULL, 0, min_max, array, 0, &IDThread1);
	if (hThread1 == NULL) {
		return GetLastError();
	}

	HANDLE hThread2;
	DWORD IDThread2;
	hThread2 = CreateThread(NULL, 0, Average, array, 0, &IDThread2);
	if (hThread2 == NULL) {
		return GetLastError();
	}

	WaitForSingleObject(hThread1, INFINITE);
	WaitForSingleObject(hThread2, INFINITE);
	CloseHandle(hThread1);
	CloseHandle(hThread2);
	array->p[indexOfMin] = average_num;
	array->p[indexOfMax] = average_num;

	for (int i = 0; i < size; i++) {
		std::cout << array->p[i] << ' ';
	}
	return 0;
}

int main() {
	HANDLE hThread;
	DWORD IDThread;
	hThread = CreateThread(NULL, 0, Main, NULL, 0, &IDThread);

	if (hThread == NULL) {
		return GetLastError();
	}

	WaitForSingleObject(hThread, INFINITE);
	CloseHandle(hThread);

	return 0;
}
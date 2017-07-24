package com.mingyangdai;

/**
 * Created by daimingyang on 15/8/5.
 */


public class QuickSort {
	public static void main(String[] args) {
		int array[] = {1, 3, 5, 2, 6, 2, 6, 8, 8, 3, 2, 3, 5, 4, 1};
		QuickSort quickSort = new QuickSort();
		quickSort.quickSort(array, 0, array.length - 1);
		
		for (int n : array) {
			System.out.println(n);
		}
	}
	
	public int getMiddle(int[] list, int low, int high) {
		int tmp = list[low];    //数组的第一个作为中轴
		while (low < high) {
			while (low < high && list[high] > tmp) {
				high--;
			}
			list[low] = list[high];   //比中轴小的记录移到低端
			while (low < high && list[low] < tmp) {
				low++;
			}
			list[high] = list[low];   //比中轴大的记录移到高端
		}
		list[low] = tmp;              //中轴记录到尾
		return low;                   //返回中轴的位置
	}
	
	int missingNumber(int[] A) {
		quickSort(A, 0, A.length - 1);
		int i;
		for (i = 1; i < A.length; i++) {
			if (i != A[i - 1]) {
				break;
			}
		}
		return i;
	}
	
	public void quickSort(int[] list, int low, int high) {
		if (low < high) {
			int middle = partition(list, low, high);  //将list数组进行一分为二
			quickSort(list, low, middle - 1);        //对低字表进行递归排序
			quickSort(list, middle + 1, high);       //对高字表进行递归排序
		}
	}
	
	private int partition(int[] arr, int left, int right) {
		int q = left;
		for (int i = left; i <= right - 1; i++) {
			if (arr[i] <= arr[right]) {
				swap(arr, i, q++);
			}
		}
		swap(arr, right, q);
		return q;
	}
	
	private void swap(int[] nums, int first, int second) {
		int temp = nums[first];
		nums[first] = nums[second];
		nums[second] = temp;
	}
}




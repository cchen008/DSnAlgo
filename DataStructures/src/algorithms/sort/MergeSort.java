package algorithms.sort;

public class MergeSort {
	public void sort(int arr[], int left, int right) {
		if(left < right) {
			int mid = left + (right - left) / 2;
			
			sort(arr, left, mid);
			sort(arr, mid + 1, right);
			
			merge(arr, left, mid, right);
		}
	}
	
	public void merge(int arr[], int left, int mid, int right) {
		//Find the size of the two subarrys
		int lLength = mid - left + 1;
		int rLength = right - mid;
		
		//Create temp arrays equal to the size of the two subarrays
		int lArr[] = new int[lLength];
		int rArr[] = new int[rLength];
		
		//Copy data to the temp arrays
		for(int i = 0; i < lLength; i++) {
			lArr[i] = arr[left + i];
		}
		for(int i = 0; i < rLength; i++) {
			rArr[i] = arr[mid + i + 1];
		}
		
		int l = 0;
		int r = 0;
		int curIndex = left;
		
		//Do the merge by comparing the two values and putting the smaller one in first
		while(l < lLength && r < rLength) {
			if(lArr[l] < rArr[r]) {
				arr[curIndex] = lArr[l];
				l++;
			}
			else {
				arr[curIndex] = rArr[r];
				r++;
			}
			curIndex++;
		}
		
		//Put the remaining elements from the left or right subarray back in
		while(l < lLength) {
			arr[curIndex] = lArr[l];
			l++;
			curIndex++;
		}
		
		while(r < rLength) {
			arr[curIndex] = rArr[r];
			r++;
			curIndex++;
		}
	}
	
	public static void printArr(int[] arr) {
		for(int i: arr) {
			System.out.print(i + " ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {5,8,11,12,1,3,2};
		int[] arr2 = new int[] {5,8,11,12,1,3};
		
		MergeSort mergeSort = new MergeSort();
		
		mergeSort.sort(arr, 0, arr.length - 1);
		mergeSort.sort(arr2, 0, arr2.length - 1);
		
		printArr(arr);
		System.out.println();
		printArr(arr2);
	}

}

package algorithms.search;

public class BinarySearch {
	public static int binarySearch(int []arr, int value) {
		int left = 0;
		int right = arr.length - 1;
		
		while(left <= right) {
			int mid = left + (right - left) / 2;
			if(arr[mid] == value) {
				return mid;
			}
			else if(arr[mid] < value) {
				left = mid + 1;
			}
			else if(arr[mid] > value) {
				right = mid - 1;
			}
		}
		
		return -1;
	}
	
	public static int binarySearchRecur(int[] arr, int left, int right, int target) {
		if(left <= right && left <= arr.length - 1) {
			int mid = left + (right - left) / 2;
			System.out.println(mid);
			if(arr[mid] == target) {
				System.out.println(arr[mid]);
				return mid;
			}
			else if(arr[mid] < target) {
				binarySearchRecur(arr, mid + 1, right, target);
			}
			else if(arr[mid] > target) {
				binarySearchRecur(arr, left, mid - 1, target);
			}
			
		}
		return -1;
	}

	public static void main(String[] args) {
		int arr[] = new int[]{1,3,5,7,12,14,35,74,86};
		
		//System.out.println(binarySearch(arr, 74));
		
		System.out.println(binarySearchRecur(arr, 0, arr.length - 1, 74));
	}

}

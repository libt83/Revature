package question1;
/**
 * @author Brandon Semba
 * 
 * Performs a bubble sort on the following integer array:  
 * 1,0,5,6,3,2,3,7,9,8,4
 */
public class BubbleSort {
	
	public int[] bubbleSort(int[] arr) {
		for(int i = 0; i < arr.length - 1; i++) {
			for(int j = 0; j < arr.length - i - 1; j++) {
				if(arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		return arr;
	}
}

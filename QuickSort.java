package application;
import java.util.Arrays;
import java.util.Random;

public class QuickSort 
{
	public static void main(String[] args) 
	{
		int[] numbers = new int[10000000];
		Random random = new Random();
		
		for (int i = 0; i < numbers.length; i++)
		{
			numbers[i] = random.nextInt(10000);
		}
		
		System.out.println("Before: " + Arrays.toString(numbers));
		
		quickSort(numbers);
		
		System.out.println("After: " + Arrays.toString(numbers));

	}
	//I've overloaded this method to call quickSort more naturally in the main method;
	private static void quickSort(int[] array)
	{
		quickSort(array, 0, array.length - 1);
	}
	
	private static void quickSort(int[] array, int lowIndex, int highIndex)
	{
		if (lowIndex >= highIndex) 
		{
			return;
		}
		
		//First step: choose a pivot
		int pivot = array[highIndex];
		
		//Second step (Partition):put every number less than the pivot to the left of it, and every number higher than the pivot to the right of it;
		int leftPointer = partition(array, lowIndex, highIndex, pivot);
		
		//Third step: recursively quicksorting the left and right sub Arrays;
		quickSort(array, lowIndex, leftPointer - 1);
		quickSort(array, leftPointer + 1, highIndex);
	}

	private static int partition(int[] array, int lowIndex, int highIndex, int pivot) 
	{
		int leftPointer = lowIndex;
		int rightPointer = highIndex;
		
		while (leftPointer < rightPointer)
		{
			while (array[leftPointer] <= pivot && leftPointer < rightPointer) {
				leftPointer++;
			}
			
			while (array[rightPointer] >= pivot && leftPointer < rightPointer) {
				rightPointer--;
			}
			
			swap(array, leftPointer, rightPointer);
		}
		//When the leftPointer and rightPointer meet, we need to swap the pivot = array[highIndex] with the element that the leftPointer is pointing to: array[leftPointer];
		swap(array, leftPointer, highIndex);
		return leftPointer;
	}
	
	private static void swap(int[] array, int index1, int index2)
	{
		int temp;
		temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}

}

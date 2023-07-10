package application;
import java.util.Arrays;
import java.util.Random;

public class MergeSort 
{
	public static void main(String[] args) 
	{
		int[] numbers = new int[15];
		Random random = new Random();
		
		for (int i = 0; i < numbers.length; i++)
		{
			numbers[i] = random.nextInt(100);
		}
		
		System.out.println(Arrays.toString(numbers));
		
		mergeSort(numbers);
		
		System.out.println(Arrays.toString(numbers));

	}

	private static void mergeSort(int[] inputArray) 
	{
		int length = inputArray.length;
		
		if (length < 2)
		{
			return;
		}
		
		int midIndex = length / 2;
		int[] leftHalf = new int[midIndex];
		int[] rightHalf = new int[length - midIndex];
		
		for (int i = 0; i < midIndex; i++)  
		{
			leftHalf[i] = inputArray[i];
		}
		
		for (int i = midIndex; i < length; i++) 
		{
			rightHalf[i - midIndex] = inputArray[i];
		}
		
		mergeSort(leftHalf);	
		mergeSort(rightHalf);
		
		merge(inputArray, leftHalf, rightHalf);
	}
	
	private static void merge(int[] inputArray, int[] leftHalf, int[] rightHalf)
	{
		int leftSize = leftHalf.length;
		int rightSize = rightHalf.length;
		int i = 0, j = 0, k = 0;
		
		while (i < leftSize && j < rightSize)
		{
			if (leftHalf[i] <= rightHalf[j])
			{
				inputArray[k] = leftHalf[i];
				i++;
			}
			else
			{
				inputArray[k] = rightHalf[j];
				j++;
			}
			k++;
		}
		
		while (i < leftSize)
		{
			inputArray[k] = leftHalf[i];
			i++;
			k++;
		}
		
		while (j < rightSize)
		{
			inputArray[k] = rightHalf[j];
			j++;
			k++;
		}
		
	}
	
}

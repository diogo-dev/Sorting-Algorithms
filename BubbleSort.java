package application;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort 
{
	public static void main(String[] args) 
	{
		int[] numbers = new int[100];
		Random random = new Random();
		
		for (int i = 0; i < numbers.length; i++)
		{
			numbers[i] = random.nextInt(100);
		}
		
		System.out.println(Arrays.toString(numbers));
		
		bubbleSort(numbers);
		
		System.out.println(Arrays.toString(numbers));

	}

	private static void bubbleSort(int[] inputArray) 
	{
		//We set this boolean variable to true, firstly to enter the while loop
		//Here I could have used instead of a 'while' loop, a 'do while' loop, but I'd rather do this way in this case
		boolean keptOnSwapping = true;
		
		while(keptOnSwapping)
		{
			//Now we set to false to check whether the algorithm are already sorted or not
			//Because if the algorithm isn't sorted, it will enter the 'if' statement and keep on swapping elements
			keptOnSwapping = false;
			
			for (int i = 0; i < inputArray.length - 1; i++)
			{
				if (inputArray[i] > inputArray[i + 1])
				{
					 keptOnSwapping = true;
					swap(inputArray, i , i + 1);
				}
			}
		}
	}

	private static void swap(int[] inputArray, int a, int b)
	{
		int temp = inputArray[a];
		inputArray[a] = inputArray[b];
		inputArray[b] =  temp;
	}

}

public class QuickSort
{
	private static void quickSort(int[] array, int start, int end)
	{
		int pivotIndex = partition(array, start, end);

		if(pivotIndex > 1)
		{
			quickSort(array, start, pivotIndex - 1);
		}

		if(pivotIndex + 1 < end)
		{
			quickSort(array, pivotIndex + 1, end);
		}
	}

	private static int partition(int[] array, int start, int end)
	{
		int pivot = array[start];

		while(true)
		{
			while(array[start] < pivot)
			{
				start++;
			}

			while(array[end] > pivot)
			{
				end--;
			}

			if(start < end)
			{
				int temp = array[start];
				array[start] = array[end];
				array[end] = temp;
			}
			else
			{
				return end;
			}
		}
	}

	public static void main(String[] args)
	{
		int[] unsortedArray = {10, 80, 30, 90, 40, 50, 70}; // example data

		quickSort(unsortedArray, 0, unsortedArray.length - 1);

		for(int item : unsortedArray)
		{
			System.out.println(item);
		}
	}
}
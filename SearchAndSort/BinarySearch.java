public class BinarySearch
{
	private static int binarySearch(int[] sortedArray, int searchFor, int startIndex, int endIndex)
	{
		int halfArrayIndex = (endIndex + startIndex) / 2;

		if(sortedArray[halfArrayIndex] == searchFor)
		{
			return halfArrayIndex;
		}

		if(sortedArray[halfArrayIndex] > searchFor)
		{
			return binarySearch(sortedArray, searchFor, startIndex, halfArrayIndex);
		}

		if(sortedArray[halfArrayIndex] < searchFor)
		{
			return binarySearch(sortedArray, searchFor, halfArrayIndex, endIndex);
		}

		return -1;
	}

	public static void main(String[] args)
	{
		int[] sortedArray = {1, 7, 9, 14, 18, 21, 222, 901, 140981}; // example data

		int binarySearchResult = binarySearch(sortedArray, 222, 0, sortedArray.length - 1);

		System.out.println(binarySearchResult);
	}
}
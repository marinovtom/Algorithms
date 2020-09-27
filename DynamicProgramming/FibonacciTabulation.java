import java.util.HashMap;

class FibonacciTabulation
{
	private HashMap<Integer, Integer> dataStorage = new HashMap<Integer, Integer>();

	private void initialize()
	{
		dataStorage.put(0, 0);
		dataStorage.put(1, 1);
	}

	public FibonacciTabulation()
	{
		initialize();
	}

	public int fibonacci(int index)
	{
		for(int i = 2; i <= index; i++)
		{
			dataStorage.put(i, dataStorage.get(i - 1) + dataStorage.get(i - 2));
		}

		return dataStorage.get(index);
	}

	public static void main(String[] args)
	{
		FibonacciTabulation fibonacciTabulation = new FibonacciTabulation();

		System.out.println(fibonacciTabulation.fibonacci(60));
	}
}
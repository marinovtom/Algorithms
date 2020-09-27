import java.util.HashMap;

public class FibonacciMemorization
{
	private HashMap<Integer, Integer> dataStorage = new HashMap<Integer, Integer>();

	private void initialize()
	{
		dataStorage.put(0, 0);
		dataStorage.put(1, 1);
	}

	public FibonacciMemorization()
	{
		initialize();
	}

	public int fibonacci(int index)
	{
		if(!dataStorage.containsKey(index))
		{
			int newValue;

			newValue = fibonacci(index - 1) + fibonacci(index - 2);
			dataStorage.put(index, newValue);

			return newValue;
		}

		return dataStorage.get(index);
	}

	public static void main(String[] args)
	{
		FibonacciMemorization fibonacciMemorization = new FibonacciMemorization();

		System.out.println(fibonacciMemorization.fibonacci(60));
	}
}
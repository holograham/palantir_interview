
public class DigitCount 
{
	/*
	 * Returns the number of digits from a 32 bit integer
	 * 0 is considered 1 digit
	 */
	
	public static void main(String[] args)
	{
		//warm up JVM
		// seeing weird functionality on log function when I run this loop more than 1 time (time goes to 0ms)
		for(int x = 0; x < 1; x++)
		{
			testStringMethod();
			testBruteForceMethod();
			testLogMethod();
			testOptimizedMethod();
			testOneLineOptimizedMethod();
		}
		
		long startTime = System.currentTimeMillis();
		testStringMethod();
		long endTime = System.currentTimeMillis();
		
		System.out.println("Total elapsed time in execution of String method is: "+ (endTime-startTime)+"ms");
		
		startTime = System.currentTimeMillis();
		testBruteForceMethod();
		endTime = System.currentTimeMillis();
		
		System.out.println("Total elapsed time in execution of brute force method is: "+ (endTime-startTime)+"ms");
		
		
		startTime = System.currentTimeMillis();
		testLogMethod();
		endTime = System.currentTimeMillis();
		
		System.out.println("Total elapsed time in execution of log method is: "+ (endTime-startTime)+"ms");
		
		startTime = System.currentTimeMillis();
		testOptimizedMethod();
		endTime = System.currentTimeMillis();
		
		System.out.println("Total elapsed time in execution of optimized method is: "+ (endTime-startTime)+"ms");
		
		startTime = System.currentTimeMillis();
		testOneLineOptimizedMethod();
		endTime = System.currentTimeMillis();
		
		System.out.println("Total elapsed time in execution of one line optimized method is: "+ (endTime-startTime)+"ms");
		
	}

	// brute force method
	private static int getNumDigitsBruteForceMethod(int x)
	{
		int digits = 1;
		
		//if(x < 0) digits = -1; //if less than zero return -1
		
		while(x > 10)
		{
			x /= 10;
			digits++;
		}
		return digits;
	}
	
	//Math.log method
	private static int getNumDigitsLogMethod(int x)
	{
		int digits = 1;
		
		if(x < 0) digits = -1;  //if less than zero return -1
		
		if(x > 0) digits += (int)Math.log10(x);
		
		return digits;
	}
	
	private static int getNumDigitsOptimized(int x)
	{
		if (x < 100000)
		{
			if (x < 100)
			{
				return (x < 10) ? 1 : 2;
			}
			else
			{
				if (x < 1000)
					return 3;
				else
				{
					return (x < 10000) ? 4 : 5;
				}
			}
		}
		else
		{
			if (x < 10000000)
			{
				return (x < 1000000) ? 6 : 7;
			}
			else
			{
				if (x < 100000000)
					return 8;
				else
				{
					return (x < 1000000000) ? 9 : 10;
				}
			}
		}
	}
	
	private static int getNumDigitsOneLineOptimized(int x)
	{
		return (x >= 1000000000) ? 9 : (x >= 100000000) ? 8 : (x >= 10000000) ? 7 : 
		    (x >= 1000000) ? 6 : (x >= 100000) ? 5 : (x >= 10000) ? 4 : 
		    (x >= 1000) ? 3 : (x >= 100) ? 2 : (x >= 10) ? 1 : 0;
	}
	
	private static int getNumDigitsStringMethod(int x)
	{
		return String.valueOf(x).length();
	}
	
	private static int testStringMethod()
	{
		int x = 0;
		for (int i = 0; i < 1000; i++)
			x = getNumDigitsStringMethod(i);
		for (int i = 1000; i < 100000; i += 10)
			x = getNumDigitsStringMethod(i);
		for (int i = 100000; i < 1000000; i += 100)
			x = getNumDigitsStringMethod(i);
		for (int i = 1000000; i < 2000000000; i += 200)
			x = getNumDigitsStringMethod(i);

		return x;
	}
	
	private static int testBruteForceMethod()
	{
		int x = 0;
		for (int i = 0; i < 1000; i++)
			x = getNumDigitsBruteForceMethod(i);
		for (int i = 1000; i < 100000; i += 10)
			x = getNumDigitsBruteForceMethod(i);
		for (int i = 100000; i < 1000000; i += 100)
			x = getNumDigitsBruteForceMethod(i);
		for (int i = 1000000; i < 2000000000; i += 200)
			x = getNumDigitsBruteForceMethod(i);

		return x;
	}
	
	private static int testLogMethod()
	{
		int x = 0;
		for (int i = 0; i < 1000; i++)
			x = getNumDigitsLogMethod(i);
		for (int i = 1000; i < 100000; i += 10)
			x = getNumDigitsLogMethod(i);
		for (int i = 100000; i < 1000000; i += 100)
			x = getNumDigitsLogMethod(i);
		for (int i = 1000000; i < 2000000000; i += 200)
			x = getNumDigitsLogMethod(i);
		
		return x;
	}	
	
	
	private static int testOptimizedMethod()
	{
		int x = 0;
		for (int i = 0; i < 1000; i++)
			x = getNumDigitsOptimized(i);
		for (int i = 1000; i < 100000; i += 10)
			x = getNumDigitsOptimized(i);
		for (int i = 100000; i < 1000000; i += 100)
			x = getNumDigitsOptimized(i);
		for (int i = 1000000; i < 2000000000; i += 200)
			x = getNumDigitsOptimized(i);

		return x;
	}
	
	private static int testOneLineOptimizedMethod()
	{
		int x = 0;
		for (int i = 0; i < 1000; i++)
			x = getNumDigitsOneLineOptimized(i);
		for (int i = 1000; i < 100000; i += 10)
			x = getNumDigitsOneLineOptimized(i);
		for (int i = 100000; i < 1000000; i += 100)
			x = getNumDigitsOneLineOptimized(i);
		for (int i = 1000000; i < 2000000000; i += 200)
			x = getNumDigitsOneLineOptimized(i);

		return x;
	}
	
}

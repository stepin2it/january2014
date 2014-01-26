
public class MathEngine
{
	public int add(int a, int b)
	{
		return a + b;
		
	}
	public int subtract (int a, int b)
	{
		return a - b;
	}
	
	public int multiply (int a, int b)
	{
		return a * b;
	}
	
	public int divide (int a, int b)
	{
		int c = 0;
		try
		{
			c = a / b;
		}
		catch (Exception e)
		{
			System.out.println("Divide by zero");
			
		}
		return c;
	}

}

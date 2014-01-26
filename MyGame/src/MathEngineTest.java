import static org.junit.Assert.*;

import org.junit.Test;


public class MathEngineTest
{

	@Test
	public void testAdd()
	{
		MathEngine mathEngine = new MathEngine();
		assertEquals("Testing add method", 15, mathEngine.add(10, 5));
	}

	@Test
	public void testSubtract()
	{
		MathEngine mathEngine = new MathEngine();
		assertEquals("Testing subtract method", 5, mathEngine.subtract(10, 5));
	}

	@Test
	public void testMultiply()
	{
		MathEngine mathEngine = new MathEngine();
		assertEquals("Testing multiply method", 50, mathEngine.multiply(10, 5));
		
		
	}

	@Test
	public void testDivide()
	{
		MathEngine mathEngine = new MathEngine();
		assertEquals("Testing add method", 2, mathEngine.divide(10, 5));
	}

}

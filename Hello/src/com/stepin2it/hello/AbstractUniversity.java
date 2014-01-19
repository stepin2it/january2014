package com.stepin2it.hello;

public abstract class AbstractUniversity
{
	public void doCreateReports()
	{
		System.out.println("Genering reports...");
		for (int i=0; i<100; i++)
		{
			System.out.print("Working on report number: " + i);
		}
	}
	
	 public  int doComputeAverageScore()
	{
		 System.out.println("doComputeAverageScore was called");
		 return 0;
	}
}

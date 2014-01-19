package com.stepin2it.hello;

public class University extends AbstractUniversity
{
	public University()
	{
		System.out.println("Initializing University");
		
		 System.out.print("Average Score is : " + this.doComputeAverageScore() );
	}
	/*
	public  int doComputeAverageScore()
	{
		int average = 0;
		int sum = 0;
		System.out.println("Starting average score calculation");
		for (int i=0; i<10; i++)
		{
			sum += i;
		
		}
		average = sum/10;
		
		return average;
	}
	*/
}

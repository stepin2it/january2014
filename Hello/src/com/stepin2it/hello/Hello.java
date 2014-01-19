package com.stepin2it.hello;

import java.util.ArrayList;
import java.util.List;

import com.stepin2it.hello.Person;

public class Hello
{
	public static List<Person> mListOfPersons = new ArrayList<Person>();

	public static void main(String[] args)
	{
		System.out.println("Welcome to Java Course");
		System.out
				.println("Let's create a program to find out the sum of ages of 10 people");

		Person p1 = new Person("John", 30, "Toronto");

		for (int i = 0; i < 10; i++)
		{
			Person p = new Person("John" + i, 30 + i, "Toronto");

			mListOfPersons.add(p);

		}
		int sum = 0;

		for (Person p : mListOfPersons)
		{
			sum += p.getAge();
		}

		System.out.println("The sum of ages of all persons is" + sum);
		
		University u = new University();
		System.out.println(u.doComputeAverageScore());

	}
}

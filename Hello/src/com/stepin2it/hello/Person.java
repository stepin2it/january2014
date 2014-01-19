package com.stepin2it.hello;

/**
 * Person represents a person in the real world 
 *
 */
public class Person
{
	private String name;
	
	private int age;
	
	private String address;
	/**
	 * Person constructor
	 * @param aName
	 * @param aAge
	 * @param aAddress
	 */
	public Person(String aName, int aAge, String aAddress)
	{
		name = aName;
		age = aAge;
		address = aAddress; 
	}
	
	
	public String getName()
	{
		return name;
	}

	/**
	 * getAge() returns the age of the Person
	 * @return
	 */
	public int getAge()
	{
		return age;
	}


	public String getAddress()
	{
		return address;
	}


	public void setName(String name)
	{
		this.name = name;
	}


	public void setAge(int age)
	{
		this.age = age;
	}


	public void setAddress(String address)
	{
		this.address = address;
	}


	/**
	 * describePerson prints the details of the Person
	 * @return
	 */
	public String describePerson()
	{
		return "Person [name=" + name + ", age=" + age + ", address=" + address
				+ "]";
	}

		
}

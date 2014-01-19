public class HelloWorld
{

    public static void main(String[] args)
    {
     System.out.println("Hello World");   
     System.out.println("Printing age :");
     Person p1 = new Person("John", "Toronto", 30);
     System.out.println(p1.age);
    }

}
class Person
{


    public String name;

    public String address;

    public int age;

    public Person(String aName, String aAddress, int aAge)
    {   
        this.name = aName;
        this.address = aAddress;
        this.age = aAge;

    }   

    public void doWork()
    {   
     System.out.println("Programming in java right now...");
    }   


}

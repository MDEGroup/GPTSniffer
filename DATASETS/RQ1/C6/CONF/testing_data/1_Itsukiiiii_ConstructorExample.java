


class ParentClass
{
	
	ParentClass()
	{
		System.out.println("Constructor of ParentClass is called");
	}
}


public class ConstructorExample extends ParentClass{
	
	
	String name;
	String street;
	String city;

	
	
	
	
	
	ConstructorExample() 
	{
		
		
		
		name = "John";
	}
	
	
	ConstructorExample(String pName) 
	{
		
		
		
		name = pName;
	}
	
	ConstructorExample(int pId, String pName)
	{
		
		
		
		
		
		this("Street 1", "Coimbatore");
		
		name = pName;
		
		
		
	}
	
	ConstructorExample(String pStreet, String pCity)
	{
		
		
		
		street = pStreet;
		city = pCity;
	}
	
	
	ConstructorExample(ConstructorExample pObj)
	{
		
		
		
		name = pObj.name;
		street = pObj.street;
		city = pObj.city;
	}
	
	
	
	public static void main(String[] args) {
		
		
		
		ConstructorExample obj1 = new ConstructorExample(); 
		
		System.out.println(obj1.name);
		
		
		ConstructorExample obj2 = new ConstructorExample("Peter");
		System.out.println(obj2.name);
		
		
		ConstructorExample obj3 = new ConstructorExample(1, "Kennady");
		System.out.println("\n*** Display obj3 values ***");
		obj3.display();
		
		
		ConstructorExample obj4 = new ConstructorExample(obj3);
		System.out.println("\n*** Display obj4 values ***");
		obj4.display();
	}
	
	void display()
	{
		System.out.println(name);
		System.out.println(street);
		System.out.println(city);
	}

}


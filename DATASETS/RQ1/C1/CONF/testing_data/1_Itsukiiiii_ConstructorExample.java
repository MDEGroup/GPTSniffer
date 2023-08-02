package package1;

// parent class
class ParentClass
{
	// Whenever a child class constructor gets invoked, it implicitly invokes the constructor of parent class. 
	ParentClass()
	{
		System.out.println("Constructor of ParentClass is called");
	}
}

// child class
public class ConstructorExample extends ParentClass{
	
	// Instance variables
	String name;
	String street;
	String city;

	// Constructor initializes the newly created object.
	// Constructor does not have return type
	// Constructor has same name as class
	// If you do not implement constructor in the class, Java compiler inserts a default constructor.
	// Constructors with no arguments are called no-arg constructors.
	ConstructorExample() // this is no-arg constructor
	{
		/* Compiler implicitly adds the "super()" keyword here as the first statement which invokes the default constructor of parent class */
		/* Constructor of parent class is invoked when new object is created for child class */
		
		name = "John";
	}
	
	// Constructors with arguments (parameters) are called Parameterized constructors
	ConstructorExample(String pName) // this is parameterized constructor
	{
		/* Compiler implicitly adds the "super()" keyword here as the first statement which invokes the default constructor of parent class */
		/* Constructor of parent class is invoked when new object is created for child class */
		
		name = pName;
	}
	
	ConstructorExample(int pId, String pName)
	{
		/* Compiler implicitly adds the "super()" keyword here as the first statement which invokes the default constructor of parent class */
		/* Constructor of parent class is invoked when new object is created for child class */
		
		// When a constructor calls another constructor of the same class, it is called "Constructor Chaining".
		// Constructor call, if used, must be the first statement in a constructor
		this("Street 1", "Coimbatore");
		
		name = pName;
		
		//System.out.println("Street: " + street);
		//System.out.println("City: " + city);
	}
	
	ConstructorExample(String pStreet, String pCity)
	{
		/* Compiler implicitly adds the "super()" keyword here as the first statement which invokes the default constructor of parent class */
		/* Constructor of parent class is invoked when new object is created for child class */
		
		street = pStreet;
		city = pCity;
	}
	
	// copy constructor
	ConstructorExample(ConstructorExample pObj)
	{
		/* Compiler implicitly adds the "super()" keyword here as the first statement which invokes the default constructor of parent class */
		/* Constructor of parent class is invoked when new object is created for child class */
		
		name = pObj.name;
		street = pObj.street;
		city = pObj.city;
	}
	
	/* Having more than one constructor with different parameters is known as Constructor Overloading */
	
	public static void main(String[] args) {
		
		// new keyword creates an object of class ConstructorExample and
		// invokes the constructor to initialize the newly created object
		ConstructorExample obj1 = new ConstructorExample(); // no-arg constructor is invoked
		
		System.out.println(obj1.name);
		
		// Parameterized constructor with String parameter is invoked
		ConstructorExample obj2 = new ConstructorExample("Peter");
		System.out.println(obj2.name);
		
		// Parameterized constructor with two arguments (int, String) is invoked
		ConstructorExample obj3 = new ConstructorExample(1, "Kennady");
		System.out.println("\n*** Display obj3 values ***");
		obj3.display();
		
		// Parameterized constructor with object as argument is invoked
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

/************
1) Every class has a constructor whether it’s a normal class or a abstract class.
2) Constructors are not methods and they don’t have any return type.
3) Constructor name should match with class name .
4) Constructor can use any access specifier, they can be declared as private also. Private constructors are possible in java but their scope is within the class only.
5) Like constructors, method can also have name same as class name, but still they have return type, through which we can identify them that they are methods and not constructors.
6) If you don’t implement any constructor within the class, compiler will do it for.
7) super() should be the first statement in the constructor code. If you don’t mention them, compiler does it for you accordingly.
8) Constructor overloading is possible but overriding is not possible. We can have overloaded constructor in our class but we can’t override a constructor.
9) Constructors can not be inherited.
10) If Super class doesn’t have a no-arg (default) constructor, then compiler would not insert a default constructor in child class as it does in normal scenario.
11) Interfaces do not have constructors.
12) Abstract class can have constructor and it gets invoked when a class, which implements interface, is instantiated. (i.e. object creation of concrete class).
13) A constructor can also invoke another constructor of the same class – By using this(). If you want to invoke a parameterized constructor then do it like this: this(parameter list).

14) The purpose of constructor is to initialize the object of a class while the purpose of a method is to perform a task by executing java code.
15) Constructors cannot be abstract, final, static and synchronized while methods can be.
16) Constructors do not have return types while methods do.
*************/
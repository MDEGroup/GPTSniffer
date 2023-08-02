



public class MyStringBuilder2{
    public static void main(String[] args) {
        
        MyStringBuilder2 myStringBuilder2 = new MyStringBuilder2("SuperCalifradolistic");
        System.out.print("Start MyStringBuilder2 values: ");
        System.out.println(myStringBuilder2.toString());
        System.out.print("ToUpperCase: ");
        System.out.println(myStringBuilder2.toUpperCase().toString());
        System.out.print("Insert: ");
        myStringBuilder2.insert(3, new MyStringBuilder2("TESTinsertTEST"));
        System.out.println(myStringBuilder2.toString());
        System.out.print("Reverse: ");
        System.out.println(myStringBuilder2.reverse().toString());
        System.out.println("subString: " + myStringBuilder2.substring(5).toString());
    }

}


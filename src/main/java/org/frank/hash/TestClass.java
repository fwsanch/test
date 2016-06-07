
public class TestClass {

	public static void main(String[] args) {
		HashTable<Integer,String> table = new HashTable<Integer,String>();
		//inserting random object into table
		System.out.println("We will insert a few objects whose hash codes collide and are handled using open addressing");
		table.put(21, "twenty one");
		table.put(10, "ten");
		table.put(0, "zero");
		table.put(11, "eleven");
		//replacing the value for key ll with "new eleven"
		table.put(11, "new eleven");
		System.out.println(table.toString());
		System.out.print("Size: ");
		System.out.println(table.size());
		System.out.print("Capacity: ");
		System.out.println(table.capacity());
		System.out.println();
		
		
		
		System.out.println("Now we will delete 21 and search for 10 which is mapped to the same position");
		table.remove(21);
		System.out.println(table.get(10)+" is the value associated with key 10");
		System.out.println(table.toString());
		System.out.print("Size: ");
		System.out.println(table.size());
		System.out.print("Capacity: ");
		System.out.println(table.capacity());
		System.out.println();
		
		
		
		System.out.println("Now we will insert more objects to make the table resize");
		table.put(21, "twenty one");
		table.put(22, "twenty two");
		table.put(15, "fifteen");
		table.put(5, "five");
		System.out.println(table.toString());
		System.out.print("Size: ");
		System.out.println(table.size());
		System.out.print("Capacity: ");
		System.out.println(table.capacity());
		System.out.println();
		
		
		
		System.out.println("Now we will clear the table");
		table.clear();
		System.out.println(table.toString());
		System.out.print("Size: ");
		System.out.println(table.size());
		System.out.print("Capacity: ");
		System.out.println(table.capacity());
		

	}

}

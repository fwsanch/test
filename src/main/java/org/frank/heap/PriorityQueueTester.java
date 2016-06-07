import java.util.Arrays;
import java.util.Random;

public class PriorityQueueTester {
	/* main
	 * dataIn: none
	 * dataOut: none
	 * The main method will be used to test the functionality of PriortiyQueue
	 */
	public static void main(String[] args) {
		
		PriorityQueue<Integer> intData = new PriorityQueue<Integer>();
		PriorityQueue<String> strData = new PriorityQueue<String>();
		Random rand = new Random();
		int maxInt;
		String maxStr;
		
	
		for(int i = 0; i < 20; i++) {//insert 20 random integers into our integer Priority queue
			intData.insert(rand.nextInt(100)+1);
		}
		System.out.println("Here is our Priority Queue with integers: "); 
		intData.print();
		System.out.println("Max: " + intData.maximum()); 
		maxInt = intData.maximum(); 
		System.out.println("Capacity: " + intData.capacity());
		System.out.println("Queue size: " + intData.size());
		System.out.println("");
		
		System.out.println("Max will now be extracted");
		maxInt = intData.extractMax();
		System.out.println("element " + maxInt + " has been extracted!"); 
		intData.print();
		System.out.println("Capacity: " + intData.capacity());
		System.out.println("Queue size: " + intData.size());
		System.out.println("");
		
		System.out.println("Max will now be extracted");
		maxInt = intData.extractMax();
		System.out.println("element " + maxInt + " has been extracted!"); 
		intData.print();
		System.out.println("Capacity: " + intData.capacity());
		System.out.println("Queue size: " + intData.size());
		System.out.println("");
		
		intData.insert(87); 
		System.out.println("We will now insert 87");	
		intData.print();
		System.out.println("Capacity: " + intData.capacity());
		System.out.println("Queue size: " + intData.size());
		System.out.println("");
		
		intData.insert(1); 
		System.out.println("We will now insert 1");	
		intData.print();
		System.out.println("Capacity: " + intData.capacity());
		System.out.println("Queue size: " + intData.size());

		System.out.println(" ");
		System.out.println(" ");
		
		//insert 10 strings into our string Priority queue
		strData.insert("Z");
		strData.insert("T");
		strData.insert("E");
		strData.insert("G");
		strData.insert("L");
		strData.insert("J");
		strData.insert("M");
		strData.insert("H");
		strData.insert("A");
		strData.insert("Q");
		
		System.out.println("Here is our Priority queue with strings:");
		strData.print();
		System.out.println("Max: " + strData.maximum()); 
		System.out.println("Capacity: " + strData.capacity());
		System.out.println("Queue size: " + strData.size());
		System.out.println("");
		
		maxStr = strData.extractMax(); 
		System.out.println("Max will now be extracted"); 
		strData.print();
		System.out.println("element " + maxStr + " has been extracted!");
		System.out.println("Capacity: " + strData.capacity());
		System.out.println("Queue size: " + strData.size());
		System.out.println("");
		
		maxStr = strData.extractMax(); 
		System.out.println("Max will now be extracted"); 
		strData.print();
		System.out.println("element " + maxStr + " has been extracted!");
		System.out.println("Capacity: " + strData.capacity());
		System.out.println("Queue size: " + strData.size());
		System.out.println("");
		
		
		strData.insert("V"); 
		System.out.println("We will now insert V");
		strData.print();
		System.out.println("Capacity: " + strData.capacity());
		System.out.println("Queue size: " + strData.size());
		System.out.println("");
		
		strData.insert("K"); 
		System.out.println("We will now insert K");
		strData.print();
		System.out.println("Capacity: " + strData.capacity());
		System.out.println("Queue size: " + strData.size());
		System.out.println("");

	}

}

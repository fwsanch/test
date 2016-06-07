import java.util.Arrays;
import java.util.Random;

public class HeapsortTester <T extends Comparable<T>> {
	/* main
	 * dataIn: none
	 * dataOut: none
	 * The main method will be used to test the functionality of HeapsortClass
	 */
	public static <T extends Comparable<T>> void main(String[] args) {
		
		Random random = new Random();
		Integer[] intArray = new Integer[10];	
		for(int i = 0; i < intArray.length; i++){//insert 10 random integers into our array
			intArray[i] = random.nextInt(20)+1; 
		}
		
		System.out.println("Unsorted integer array: " + Arrays.toString(intArray));
		HeapsortClass.buildMaxHeap(intArray);
		System.out.println("Heap integer array: " + Arrays.toString(intArray));
		HeapsortClass.heapSort(intArray);
		System.out.println("Sorted integer array: " + Arrays.toString(intArray));
		System.out.println("");
		
		String[] strArray = {"Z","B","E","Y","T","X","R","A","E","U"};//insert 10 strings into our array
		System.out.println("Unsorted string array: " + Arrays.toString(strArray));
		HeapsortClass.buildMaxHeap(strArray);
		System.out.println("Heap string array: " + Arrays.toString(strArray));
		HeapsortClass.heapSort(strArray);
		System.out.println("Sorted string array: " + Arrays.toString(strArray));
		
	}

}

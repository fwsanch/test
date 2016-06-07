import java.util.Arrays;

public class PriorityQueue <T extends Comparable>{
	private int queuesize; 
	private int capacity; 
	private Comparable[] array;
	
	/* PriorityQueue
	 * dataIn: none
	 * dataOut: none
	 * sets the queuesize and capacity as well as creating the array
	 */
	PriorityQueue(){
		queuesize = 0;
		capacity = 8;
		array = new Comparable[queuesize];
	}
	
	/* insert
	 * dataIn: T x
	 * dataOut: none
	 * This function inserts a new dataType into the heap
	 */
	public void insert(T x){
		if(x == null) {
			throw new NullPointerException("Not a valid item");
		}
		else{	
			if(queuesize == capacity){
				capacity= capacity * 2; 
			}
			queuesize++;

			Comparable temp[] = array; 
			array = new Comparable[queuesize]; 
			for(int i = 0; i < temp.length; i++){
				array[i] = temp[i];
			}
		
			int i = queuesize-1;
			while(i > 0 && x.compareTo(array[HeapsortClass.parent(i)]) > 0){
				array[i] = array[HeapsortClass.parent(i)];
				i = HeapsortClass.parent(i);
			}
			array[i] = x; 
		}
	}
	
	/* maximum
	 * dataIn: none
	 * dataOut: T
	 * This function returns the maximum value in the heap
	 */
	public T maximum(){
		if(queuesize == 0){
			return null;
		}
		else {
			HeapsortClass.buildMaxHeap(array); 
			return (T)array[0];
		}
	}
	
	/* extractMax
	 * dataIn: none
	 * dataOut: none
	 * This function extracts the maximum value in the heap
	 */
	public T extractMax(){
		if(queuesize == 0){
			return null;
		}
		else{
			T max = maximum(); 
			array[0] = array[queuesize-1];
			queuesize--;
			Comparable temp[] = array;
			array = new Comparable[queuesize];
			for(int i = 0; i < array.length; i++){
				array[i] = temp[i]; 
			}
			HeapsortClass.maxHeapify(0,array);
			return max; 
		}
	}
	
	/* size
	 * dataIn: none
	 * dataOut: int
	 * return the size of the queue
	 */
	public int size(){
		return queuesize; 
	}
	
	/* capacity
	 * dataIn: none
	 * dataOut: int 
	 * returns the capacity of the queue
	 */
	public int capacity(){
		return capacity; 
	}
	
	/* printHeap
	 * dataIn: none
	 * dataOut: none
	 * This function prints out the queue
	 */
	public void print(){
		for(int i = 0; i < queuesize; i++){
		if(i == queuesize-1)
		System.out.print(array[i]+" ");
		else
		System.out.print(array[i]+", ");
		}
		System.out.println("");
	}
}

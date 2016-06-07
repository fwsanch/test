
public class HeapsortClass {
	private static int heapsize;
	
	/* parent
	 * dataIn: int i
	 * dataOut: result of (i-1)/2 or i/2
	 * This funtion finds the parent of a certain integer by using its index number
	 */
	public static int parent(int i){
	    if(i%2 == 0){
	        return ((i-1)/2);
	    }
	    else{
	        return (i/2);
	    }
	}
	
	/* leftChild
	 * dataIn: int i
	 * dataOut: the result of (2*i)+1
	 * This function finds the left child of a certain index number
	 */
	public static int leftChild(int i){
	    return ((2*i)+1);
	}
	
	/* rightChild
	 * dataIn: int i
	 * dataOut: the result of (2*i)+2
	 * This function finds the right child of a certain index number
	 */
	public static int rightChild(int i){
	    return ((2*i)+2);
	}
	
	/* buildMaxHeap
	 * dataIn: T[] array
	 * dataOut: none
	 * This function creates a heap from an unordered array
	 */
	public static <T extends Comparable>
	void buildMaxHeap(T[] array){
		heapsize = array.length-1;
	    for(int i = ((array.length-1)/2); i >= 0;i--){
	        maxHeapify(i, array);
	    }
	}
	
	/* maxHeapify
	 * dataIn: int i, T[] array
	 * dataOut: none
	 * This function maintains the heap property of the array
	 */
	public static <T extends Comparable>
	void maxHeapify(int i, T[] array){
	    int left = leftChild(i);
	    int right = rightChild(i);
	    int largest;
	    
	    if (left < heapsize && array[left].compareTo(array[i]) > 0){
	        largest = left;
	    }
	    else{
	        largest = i;
	    }
	    if(right < heapsize && array[right].compareTo(array[largest]) > 0){
	        largest = right;
	    }
	    if(largest != i){
	        T temp = array[i];
	        array[i] = array[largest];
	        array[largest] = temp;
	        
	        maxHeapify(largest, array);
	    }
	}
	
	/* heapSort
	 * dataIn: T[] array
	 * dataOut: none 
	 * This function sorts the array using the heap property
	 */
	public static <T extends Comparable> 
	void heapSort(T[] array){
	    heapsize = array.length;
		buildMaxHeap(array);
	    int size = heapsize;
	    for(int i = size-1; i >= 1; i--){
	        T temp = array[i];
	        array[i] = array[0];
	        array[0] = temp;
	        heapsize = heapsize - 1;
	        if(i != 1){
	            maxHeapify(0, array);
	        }
	    }
	}
	
}


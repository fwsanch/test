
public class Key<K,V> {
	private K key;
	private V value;
	public boolean deleted;
	
	Key(){
		K key = null;
		V value = null;
		deleted = false;
	}
	void setKey(K k){
		key = k;
	}
	
	void setValue(V val){
		value = val;
	}
	
	K getKey(){
		return key;
	}
	
	V getValue(){
		return value;
	}

	void hello(){
		System.out.println("Hello world");
	}
}

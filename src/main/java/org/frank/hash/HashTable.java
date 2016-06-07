package org.frank.hash;

public class HashTable<K, V> extends Key<K, V> {

    private int cap;//the size of the table
    private double load;//the load factor
    private int size;//the amount of inserted objects
    Key<K, V> arr[];//an array of Key objects that acts as our table

    /* HashTable()
     * dataIn: none
     * dataOut: none
     * This constructor creates our table with default parameters
     */
    HashTable() {
        cap = 11;
        arr = new Key[cap];
        for (int i = 0; i < cap; i++) {
            arr[i] = null;
        }
        load = .75;
    }

    /* HashTable(int,double)
     * dataIn: int capacity, double loadFactor
     * dataOut: none
     * This constructor creates our table with user defined parameters
     */
    HashTable(int capacity, double loadFactor) {
        cap = capacity;
        load = loadFactor;
        arr = new Key[cap];
        for (int i = 0; i < cap; i++) {
            arr[i] = null;
        }
    }

    /* capacity()
     * dataIn: none
     * dataOut: in
     * This method returns the capacity of the table
     */
    public int capacity() {
        int capacity = cap;
        return capacity;
    }

    /* size()
     * dataIn: none
     * dataOut: int
     * This method returns the current amount of inserted objects in the table
     */
    public int size() {
        int sz = size;
        return sz;
    }

    /* clear()
     * dataIn: none
     * dataOut: none
     * This method returns all the objects in our table back to null
     */
    public void clear() {
        for (int i = 0; i < cap; i++) {
            arr[i] = null;
        }
        size = 0;
    }

    /* containsKey(K)
     * dataIn: K key
     * dataOut: boolean
     * This method returns true if the table contains the input key and false if it does not
     */
    public boolean containsKey(K key) {
        int j = hash(key), i = 1;
        boolean end = false, reset = false;
        if (arr[j] == null) {//checks to see if the key is mapped to a null value
            return false;
        } else if (arr[j].getKey() == key) {//if the key is the first one inserted with its' hash code
            return true;
        } else if (arr[j].deleted == true || arr[j].getKey() != key) {
            do {
                if (j + i == cap) {//if the sum of the index is equal to the cap then start at index 0
                    j = 0;
                    i = 0;
                }
                if (arr[j + i] == null) {
                    return false;
                } else if (arr[j + i].deleted || arr[j + i].getKey() != key) {//if we keep hitting none null objects then increment index
                    i++;
                } else if (arr[j + i].getKey() == key) {
                    return true;
                }
            } while (end != true);
        } else {
            return false;
        }
        return false;

    }

    /* get(K)
     * dataIn: K key
     * dataOut: V
     * this method returns the value of the key object for a specified key
     */
    public V get(K key) {
        int j = hash(key), i = 1;
        boolean end = false;
        if (arr[j] == null) {
            return null;
        } else if (arr[j].getKey() == key) {
            return arr[j].getValue();
        } else {
            do {
                if (j + i == cap) {
                    j = 0;
                    i = 0;
                }
                if (arr[j + i] == null) {
                    return null;
                } else if (arr[j + i].deleted || arr[j + i].getKey() != key) {
                    i++;
                } else if (arr[j + i].getKey() == key) {
                    return arr[j + i].getValue();
                }
            } while (end != true);
        }
        return null;
    }

    /* remove(K)
     * dataIn: K key
     * dataOut: V
     * This method deletes a key object from the table and return the value of the deleted key object
     */
    public V remove(K key) {
        int j = hash(key), i = 1;
        boolean end = false;
        V temp;
        if (arr[j] == null) {
            return null;
        } else if (arr[j].getKey() == key) {
            temp = arr[j].getValue();
            arr[j].deleted = true;
            arr[j].setValue(null);
            arr[j].setKey(null);
            return temp;
        } else if (arr[j].deleted == true || arr[j + i] != null) {
            do {
                if (arr[j + i] == null) {
                    return null;
                } else if (arr[j + i].getKey() == key) {
                    temp = arr[j + i].getValue();
                    arr[j + i].deleted = true;
                    arr[j + i].setValue(null);
                    arr[j + i].setKey(null);
                    return temp;
                } else if (j + i > cap) {
                    i = 0;
                    j = 0;
                } else {
                    i++;
                }
            } while (end != true);
        }
        return null;
    }

    /* put(K,V)
     * dataIn:K key, V value
     * dataOut: none
     * This method inserts a new Key object into our hash table based on the hashcode of its' key
     */
    public void put(K key, V value) {
        int i = 0, j = hash(key);
        boolean bool = containsKey(key);
        boolean end = false;
        Key<K, V> insert = new Key<K, V>();
        insert.setKey(key);
        insert.setValue(value);
        if ((size + 1) > (cap * load) && bool != true) {
            resize();
        }
        j = hash(key);
        do {
            if (i + j == cap) {
                i = 0;
                j = 0;
            } else if (arr[j + i] == null || arr[j + i].deleted == true || arr[j + i].getKey() == key) {
                arr[j + i] = insert;
                if (bool == false || arr[j + i].deleted != true) {
                    size++;
                }
                end = true;
            } else {
                i++;
            }

        } while (end != true);

    }

    /* resize()
     * dataIn: none
     * dataOut: none
     * This method creates a new table with the size doubled and all of the keys rehashed to their new positions
     */
    public void resize() {
        int oldCap = cap;
        cap = cap * 2;
        Key<K, V> temp[];
        temp = arr;
        arr = new Key[cap];
        for (int i = 0; i < cap; i++) {
            arr[i] = null;
        }
        size = 0;
        for (int i = 0; i < oldCap; i++) {//this loop rehashes all the objects that were in the old array into the new array
            if (temp[i] != null && temp[i].deleted != true) {
                put(temp[i].getKey(), temp[i].getValue());
            }
        }

    }

    /* hash(K)
     * dataIn: K key
     * dataOut: int
     * This method returns the index in the table the key is mapped to
     */
    public int hash(K key) {
        return (Math.abs(key.hashCode())) % cap;
    }
    /* toString()
     * dataIn: none
     * dataOut: String
     * This method returns the string output of the entire hash table
     */

    public String toString() {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < cap) {
            if (arr[i] == null) {
                result.append("[" + arr[i] + ", " + arr[i] + "]");
            } else if (arr[i].deleted == true) {
                result.append("[deleted, deleted]");
            } else {
                result.append("[" + arr[i].getKey() + ", " + arr[i].getValue() + "]");
            }
            i++;
        }
        return result.toString();
    }
}

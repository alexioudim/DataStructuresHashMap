package org.hua;
import static java.lang.Integer.toBinaryString;
import java.lang.Math;
import java.util.Iterator;

public class UniversalHashTable<K, V> implements Dictionary<K, V> {
private static final int u = 32; // u = 32 bits
private static int b = 4; // Starting with 4 
private static int[][] M; // Matrix
private static int iContains; //Counter for contains method to use it for the get(K key) method
private static int[] h_x; //Array for the hash function calculation
private static int sum = 0; //Needed for h_x
private static int sizeOfArray = (int) Math.pow(2,b); //Size of the array that holds the keys which is 2^b
private Entry<K, V>[] T; //Array that holds the keys and their values
        public UniversalHashTable() //Constructor that calls these methods when it's called
            {
                 arraysCreation();  
                   
            }
        
        private void arraysCreation() //Creates the Matrix 
        {                              
                    M = new int[b][u];
                    matrixFill(M); 
                    T = (Entry<K,V>[])new Entry[sizeOfArray];
                                    
        }
       public void printT() 
       {
           for (int i =0; i < sizeOfArray; i++) 
           {
               if (T[i] != null) {System.out.println(T[i].getKey() + " value " + T[i].getValue());
               System.out.println(" j " + i);}
               
           }
       }
        public void printM() //DELETE IN THE END
        {
         for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                System.out.print(M[i][j] + " ");
            }
             System.out.print("\n");
        }
        }
        
    
    private void matrixFill(int[][] M) //Fills the array with 0 and 1
    {
    for (int[] M1 : M) {
        for (int j = 0; j < M1.length; j++) {
            M1[j] = (int)(Math.random()*2); //*2 to get either 0 or 1
        }
    }
    }
    
    private int HashFunction(K key) 
    {
        
        String binaryKey = toBinaryString(key.hashCode());
        int[] X = new int[u]; //Create array with the key
        for (int i = 0;i<X.length;i++) //Fill it with 0 so we can fix it later
        {
            X[i] = 0;
        }
        
        int[] tempX = new int[binaryKey.length()];  //Create array with the digits of the key (binary)
        for (int i = 0; i < binaryKey.length(); i++) {
        tempX[i] = binaryKey.charAt(i) - '0'; // This returns the ASCII value of the character.
        }
        for (int i = 0; i<tempX.length; i++) 
        {
            if (tempX[i] == 1) //If the value is 1 find the right place in the array and replace the 0 with 1 so we can have exactly 32 bits
            {
                X[(X.length - tempX.length) + i] = tempX[i];
            }
            
        }
        h_x = new int[b];
        for (int i = b-1; i >= 0; i--) 
        {           
            for (int j = 0; j < u; j++) 
            {
                int calc = M[i][j]*X[j];
                if (sum == 0 && calc == 0) 
                {
                    sum = 0;
                }
                else if(sum == 0 && calc == 1) 
                {
                    sum = 1;
                }
                else if (sum == 1 && calc == 0) 
                {
                    sum = 1;
                }
                else if (sum == 1 && calc == 1)
                {
                    sum = 0;
                }
            }
            h_x[i] = sum;
            sum = 0;
        }
         int res=0;
         for(int i=h_x.length-1,exp=h_x.length-1;i>=0;i--,exp--)
         {
             res+=h_x[i]*Math.pow(10, exp); //Convert the array to an int
         }
         String res_str = Integer.toString(res); //Convert the result to string
         res = Integer.parseInt(res_str,2); //Convert the string to int
         return res;
    }
    
    private void insert (K key, V value) 
    {
        int calc = HashFunction(key);
        if (T[calc] == null) 
        {
            T[calc] = new EntryImpl<>(key,value);
        }
        else 
        {
            for (int i = calc; i <sizeOfArray; i++) 
            {
                if (T[i] == null) 
            {
                T[i] = new EntryImpl<>(key,value);
                break;
            }
                else 
                {
                    for (int j =0; j < calc; i++) 
                    {
                        if (T[j] == null) 
                        {
                            T[j] = new EntryImpl<>(key,value);
                            break;
                        }                     
                    }
                }
            }
        }
        
        
    }
    private void delete (K key) 
    {
        
        if (!contains(key)) 
        {
            System.err.println("The key that you gave doesn't exist!");
           
        }
        else 
        {
            while (true) //Check the array and if it matches the conditions end the loop with return;
            {
                int  j = iContains + 1;
            if (iContains == size() - 1) 
            {
                j = 0;
            }
            
            if (T[j] == null)  
            {
                T[iContains] = null;
                return;
            }
            else if (HashFunction(T[j].getKey()) > iContains)
            {
                j++;
            }
            else 
            {
                T[iContains] = null;                
                if (j == 0 ) 
                {
                    Entry <K,V> temp = T[j];
                    T[j] = T[iContains];
                    T[iContains] = temp;
                    if (T[j+1] == null) 
                    {
                        return;
                    }
                    for (int i = 0; i < size() - 1; i++) 
                {
                    j = i+1;
                    Entry <K,V> temp2 = T[j];
                    T[j] = T[iContains];
                    T[iContains] = temp2;
                    if (T[j+1] == null) 
                    {
                        return;
                    }
                    
                }
                     
                }
                else 
                {
                    for (int i = iContains; i < size() - 1; i++) 
                    {
                        j = i + 1;
                        Entry <K,V> temp3 = T[j];
                        T[j] = T[i];
                        T[i] = temp3;
                        if (T[j+1] == null) 
                        {
                            return;
                        }
                    }
                    Entry <K,V> temp4 = T[j];
                    T[j] = T[j-1];
                    T[j-1] = temp4;
                    if (T[j+1] == null) 
                    {
                        return;
                    }
                    for (int i = 0; i < size() - 1; i++) 
                {
                    j = i+1;
                    Entry <K,V> temp5 = T[j];
                    T[j] = T[i];
                    T[i] = temp5;
                    if (T[j+1] == null) 
                    {
                        return;
                    }
                    
                }
                   
                    
                }  
                
               
            }
            }
            
            
            
        }
        
    }
    private void rehashIfNeeded() 
    {
        int size = 0;
        for (int i =0;i<size();i++) 
        {
            if (T[i] != null) 
            {
                size++;
            }           
        }      
        if (size() - size <= 5) //If there are only 5 spots left in the HashMap 
        {
            b++; //Double the length of the array                  
        }
        else if (size < size() * 1/4) //If the size of the elements in the array are less than 25% of the size of the array 
        {
            b--; //Half the length of the array          
        }
        else 
        {
            return; //Do nothing
        }
        Entry<K, V>[] tempT = (Entry<K,V>[])new Entry[size()]; //Create this temporary array to hold the values of the old array
        for (int i = 0;i<size(); i++) 
        {
            if (T[i]!= null) 
            {
                tempT[i] = T[i];
            }
        }
        sizeOfArray = (int) Math.pow(2,b); //Update the size of the array
        arraysCreation(); //Create the arrays
        
        for (int i =0;i<tempT.length;i++) 
        {
            if (tempT[i] != null) 
            {
                insert(tempT[i].getKey(),tempT[i].getValue()); //Insert the data to the new array 
            }
        }
        tempT = null; //Clearing the temporary array
    }
    @Override
    public void put(K key, V value) {      
        
        insert(key,value);   
        rehashIfNeeded();
    }

    @Override
    public V remove(K key) {
        V value = get(key);
        delete(key);
        rehashIfNeeded();
        return value;
    }

    @Override
    public V get(K key) {
        if (contains(key)) 
        {
            return T[iContains].getValue();
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        
        for ( iContains = 0; iContains < size(); iContains ++) 
        {
            if (T[iContains].getKey().equals(key)) 
            {
                return true;              
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        int size = 0;
        for (int i =0;i<size();i++) 
        {
            if (T[i] == null) 
            {
                size++;
            }
        }
        return size == size();
     
    }

    @Override
    public int size() {
        return sizeOfArray;
    }

    @Override
    public void clear() {
        this.T = null; //Clear the array
    }

    @Override
    public Iterator<Entry<K, V>> iterator() {
        return new HashIterator();
    }

    
    public static class EntryImpl<K,V> implements Dictionary.Entry<K,V>{
        
        private V value;
        private K key;

        public EntryImpl(K key, V value) {
            this.value = value;
            this.key = key;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

    }
    private class HashIterator implements Iterator<Entry<K,V>> 
    {

        @Override
        public boolean hasNext() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public Entry<K, V> next() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
        
    }
}

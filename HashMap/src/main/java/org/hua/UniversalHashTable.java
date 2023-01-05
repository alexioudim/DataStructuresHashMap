package org.hua;
import static java.lang.Integer.toBinaryString;
import java.lang.Math;
import java.util.Iterator;

public class UniversalHashTable<K, V> implements Dictionary<K, V> {
private static final int u = 32; // u = 32 bits
private static int b = 4; // Starting with 4 
private static int[][] M; // Matrix
private static int sizeOfKeys = (int) Math.pow(2,b); //Size of the array that holds the keys which is 2^b
private static String[] keys = new String[sizeOfKeys]; //Array that holds the keys
    public UniversalHashTable() //Constructor that calls these methods when it's called
            {
                 MatrixCreation(b);    
                 HashFunction();
                 
            }
        private void MatrixCreation(int b) //Creates the Matrix 
        {           
                    
                    M = new int[b][u];
                    arrayFill(M); 
                    
        }
        public void printM(int[][] M) //DELETE IN THE END
        {
         for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                System.out.print(M[i][j] + " ");
            }
             System.out.print("\n");
        }
        }
  
    private void arrayFill(int[][] M) //Fills the array with 0 and 1
    {
        for (int i = 0; i < M.length; i++) {
            
            for (int j = 0; j < M[i].length; j++) {
                M[i][j] = (int)(Math.random()*2); //*2 to get either 0 or 1
            }
        }
    }
    
    private void HashFunction() 
    {
        String key = "car";
        String binaryKey = toBinaryString(key.hashCode());
        System.out.println(binaryKey);
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
        for (int i = 0;i<X.length;i++) //Fill it with 0 so we can fix it later
        {
          System.out.print(X[i] + " ");
        }

    }

    @Override
    public void put(K key, V value) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public V get(K key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean contains(K key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Iterator<Entry<K, V>> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

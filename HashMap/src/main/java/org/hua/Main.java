package org.hua;


import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.File;
import java.io.FileNotFoundException;
import org.hua.Dictionary.Entry;

public class Main {

    public static void main(String args[]) {

       Dictionary<String, Integer> dict = new UniversalHashTable<>();
      
       
        /*try {
            File fi = new File(args[0]);
            Scanner scanner = new Scanner(fi);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                StringTokenizer st = new StringTokenizer(line);
                while (st.hasMoreTokens()) {
                    String word = st.nextToken();
                    Integer curFreq = dict.get(word);
                    if (curFreq == null) {
                        curFreq = 1;
                    } else {
                        curFreq++;
                    }
                    dict.put(word, curFreq);
                }
            }
        } catch (FileNotFoundException e)
        {
            System.err.println("File "+ args[0] + " not found");
        }

        for(Entry<String, Integer> e: dict) {
            System.out.println("Word " + e.getKey() + " appeared " + e.getValue() + " times");
        }*/
        
        
    }

}

package org.hua;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.File;
import java.io.FileNotFoundException;
import org.hua.Dictionary.Entry;

public class Main {

  public static void main(String args[]) {
    String fileName = "data.txt";
    Dictionary < String, Integer > dict = new UniversalHashTable < > ();
    try {
      File fi = new File(fileName);
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
    } catch (FileNotFoundException e) {
      System.err.println("File " + fileName + " not found");
      System.exit(0);
    }
    for (Entry < String, Integer > e: dict) {
      System.out.println("Word " + e.getKey() + " appeared " + e.getValue() + " times");
    }

  }

}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.hua;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author invis
 */
public class UniversalHashTableTest {

  /**
   * Test of put method, of class UniversalHashTable.
   */
  @Test
  public void testPut() {

    UniversalHashTable instance = new UniversalHashTable();
    for (int i = 0; i < 6; i++) {
      Object key = "hello" + i;
      Object value = "hello" + i;
      instance.put(key, value);
    }

  }

  /**
   * Test of remove method, of class UniversalHashTable.
   */
  @Test
  public void testRemove() {
    UniversalHashTable instance = new UniversalHashTable();

    for (int i = 0; i < 5; i++) {
      Object key = "cookie" + (i + 1);
      Object value = i;
      instance.put(key, value);
    }
    Object key = "cookie1";
    Object expResult = 0;
    Object result = instance.remove(key);
    assertEquals(expResult, result);
  }

  /**
   * Test of get method, of class UniversalHashTable.
   */
  @Test
  public void testGet() {
    UniversalHashTable instance = new UniversalHashTable();
    for (int i = 0; i < 5; i++) {
      Object key = "cookie" + (i + 1);
      Object value = i;
      instance.put(key, value);
    }
    Object key = "cookie7";
    Object expResult = null;
    Object result = instance.get(key);
    assertEquals(expResult, result);
  }

  /**
   * Test of contains method, of class UniversalHashTable.
   */
  @Test
  public void testContains() {
    UniversalHashTable instance = new UniversalHashTable();
    for (int i = 0; i < 5; i++) {
      Object key = "cookie" + (i + 1);
      Object value = i;
      instance.put(key, value);
    }
    Object key = "cookie5";
    boolean expResult = true;
    boolean result = instance.contains(key);
    assertEquals(expResult, result);
  }

  /**
   * Test of isEmpty method, of class UniversalHashTable.
   */
  @Test
  public void testIsEmpty() {
    UniversalHashTable instance = new UniversalHashTable();
    boolean expResult = true;
    boolean result = instance.isEmpty();
    assertEquals(expResult, result);
  }

  /**
   * Test of size method, of class UniversalHashTable.
   */
  @Test
  public void testSize() {
    UniversalHashTable instance = new UniversalHashTable();
    for (int i = 0; i < 5; i++) {
      Object key = "cookie" + (i + 1);
      Object value = i;
      instance.put(key, value);
    }
    int expResult = 5;
    int result = instance.size();
    assertEquals(expResult, result);

  }

  /**
   * Test of clear method, of class UniversalHashTable.
   */
  @Test
  public void testClear() {
    UniversalHashTable instance = new UniversalHashTable();
    for (int i = 0; i < 5; i++) {
      Object key = "cookie" + (i + 1);
      Object value = i;
      instance.put(key, value);
    }
    instance.clear();

  }

}
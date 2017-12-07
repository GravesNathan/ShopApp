/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Nathan
 */
import static com.mchange.v2.util.CollectionUtils.size;
import java.util.*;

public class JCollectionView {
//    import java.util.*;
//public class Ran {
    public JCollectionView(){
        this.demo();
        this.setdemo();
        this.mapdemo();
        this.treedemo();
        this.queuedemo();
    }

//demo source (slightly adjustged) from here
//https://docs.oracle.com/javase/tutorial/collections/interfaces/QandE/answers.html    
    public void demo() {
        String args[]=new String[]{"one", "two", "three", "four", "five", "six"};
        // Get and shuffle the list of arguments
        List<String> argList = Arrays.asList(args);
        //Made use of Collections.suffle
        Collections.shuffle(argList);

        // Print out the elements using JDK 8 Streams
        argList.stream()
        .forEach(e->System.out.format("%s ",e));
        System.out.println();
        // Print out the elements using for-each
        for (String arg: argList) {
            System.out.format("%s ", arg);
        }

        System.out.println();
        
        
    }

    private void setdemo() {
        int numbers[] = {11, 11, 22, 22, 8, 5, 5};
        Set<Integer> mySet = new HashSet<>();
        try {
            for (int i=0; i<6; i++){
                mySet.add(numbers[i]);
            }
            System.out.println("In my demo I included 3 duplicate numbers, 11, 22, and 5."
                    + "\nYou'll see below the set only contains each number once.");
            System.out.println(mySet);
        }
        catch (Exception e) {}
    }

    private void mapdemo() {
      Map m1 = new HashMap(); 
      //object.put("Key", Value);
      m1.put("Zara", "8");
      m1.put("Mahnaz", "31");
      m1.put("Ayan", "12");
      m1.put("Daisy", "14");

      System.out.println();
      System.out.println("My Map has " + size(m1) +" Elements.  It contains the below elements.");
      System.out.print("\t" + m1 + "\n");
    }

    private void treedemo() {
      // Create a tree set
      TreeSet ts = new TreeSet();
     
      // Add elements to the tree set
      ts.add("C");
      ts.add("A");
      ts.add("B");
      ts.add("E");
      ts.add("F");
      ts.add("D");
      System.out.println("\nBelow is a TreeSet");
      System.out.println(ts);
      ts.clear();
      System.out.println("The tree will print here -> " + ts + "  As you can see it's empty"
              + "due to the clear method.\n");
}

    private void queuedemo() {
        //Create a queue instance
        Queue queueA = new LinkedList();
        queueA.add("Bill");
        queueA.add("Joe");
        queueA.add("James");
        //View first element without removing it from queue
        Object firstElement = queueA.element();
        System.out.println("The first element of the queue is " + firstElement);
        
        //access via Iterator
        System.out.println("\nIteration using iterator");
        Iterator iterator = queueA.iterator();
        while(iterator.hasNext()){
          String element = (String) iterator.next();
          System.out.println(element);
        }

        //access via new for-loop
        System.out.println("\nIteration using for-loop");
        for(Object object : queueA) {
            String element = (String) object;
            System.out.println(element);
        }
    }
}


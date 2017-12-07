/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.ThreadsEtc;

import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NathanG
 */
public class MyCallable implements Callable{
    
    public MyCallable(){
        try {
            call();
        } catch (Exception ex) {
            Logger.getLogger(MyCallable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public Object call() throws Exception {
        try {
            //System.out.println("\nCurrent Callable Thread number is " + Thread.currentThread().getId());
            return 2+2+2*5;
        } catch (Exception e) {
            throw new UnsupportedOperationException("Something went wrong."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
//  Lambda expression , same as below example.
//    void doSomething() {
//        Callable<Integer> task;
//        task = () -> 123;
//    }
//    
//    void doSomething() {
//        Callable<Integer> task;
//        task = new Callable<Integer>() {
//            @Override
//            public Integer call() throws Exception {
//                return 123;
//            }
//        };
//    }


}

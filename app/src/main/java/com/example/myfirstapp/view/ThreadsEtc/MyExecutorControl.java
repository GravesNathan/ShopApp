/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.ThreadsEtc;


import static java.lang.Thread.sleep;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NathanG
 */
public final class MyExecutorControl {
    
    public MyExecutorControl (){
        try {
            goToWork();
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(MyExecutorControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void goToWork() throws InterruptedException, ExecutionException{
        //Create local executor object of pool size 4
        ExecutorService executor = Executors.newFixedThreadPool(4);
        Future<Integer> future;
        MyCallable callInstance;
        MyRunnable runnableInstance;
        MyThread threadInstance;
        System.out.println("\n\n\nMy Stuff below.");
        executor.execute(runnableInstance = new MyRunnable());
        executor.execute(threadInstance = new MyThread());
        future = executor.submit(callInstance = new MyCallable());
        sleep (1000);
        System.out.print("\nMy callable returned " + future.get() + "\n");
        executor.shutdown();
        sleep(200);
    }
    

}

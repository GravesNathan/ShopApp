/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.ThreadsEtc;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NathanG
 */
public class MyThread extends Thread{
    
    public MyThread(){
        try {
            run();
        } catch (Exception ex) {
            Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        try {
            for (int i=0; i<5; i++){
                System.out.println("Current Thread number is " + Thread.currentThread().getId());
                sleep(100);
            }
        } catch (Exception e) {
        throw new UnsupportedOperationException("Something went wrong."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}

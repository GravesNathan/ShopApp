/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.ThreadsEtc;

/**
 *
 * @author Nathan
 */
public class RunMyRunnable {
//    public static void main(String a[]){
    public RunMyRunnable(){
        this.runthis();
    }
        
    public void runthis(){
        System.out.println("Starting Main Runnable Start...");
        ImplementRunnable mrt = new ImplementRunnable();
        Thread t = new Thread(mrt);
        t.start();
        while(ImplementRunnable.myCount <= 10){
            try{
                System.out.println("Main Thread: "+(++ImplementRunnable.myCount));
                Thread.sleep(100);
            } catch (InterruptedException iex){
                System.out.println("Exception in main thread: "+iex.getMessage());
            }
        }
        System.out.println("End of Main Thread...");
        ImplementRunnable.myCount = 0;
    }
}



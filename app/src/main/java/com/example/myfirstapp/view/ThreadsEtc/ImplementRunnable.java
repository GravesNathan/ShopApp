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
public class ImplementRunnable implements Runnable{

 
    public static int myCount = 0;
    public ImplementRunnable(){
         
    }
    @Override
    public void run() {
        while(ImplementRunnable.myCount <= 10){
            try{
                System.out.println("Expl Runnable Thread: "+(++ImplementRunnable.myCount));
                Thread.sleep(100);
            } catch (InterruptedException iex) {
                System.out.println("Exception in thread: "+iex.getMessage());
            }
        }
    } 
}

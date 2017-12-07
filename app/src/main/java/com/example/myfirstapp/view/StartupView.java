/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import view.ThreadsEtc.RunThread;
import view.ThreadsEtc.RunMyRunnable;
import Exceptions.CharInputException;
import control.MemberControl;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.ThreadsEtc.MyExecutorControl;

/**
 *
 * @author Nathan
 */
public class StartupView extends View{

    public StartupView(){
        super(" "
                + "\nPlease select the technology you want to see demonstraighted or explained next"
                + "\n A - Java Collections"
                + "\n B - Threads, Executors, and Runnables"
                + "\n C - MVC"
                + "\n D - JavaBeans"
                + "\n E - Hibernate"
                + "\n F - JSON"
                + "\n G - Android HttpUrlConnection"
                + "\n H - Servlets"
                + "\n I - JUnit Tests"
                + "\n J - System Level Tests"
                + "\n K - Use Case Diagrams"
                + "\n L - Use Case Documents"
                + "\n M - State Diagrams"
                + "\n N - Sequence Diagrams"
                + "\n Q - Quit");
    }

    @Override
    public boolean doAction(char entry){
        char value = entry;
        try{
        switch (value) {
            //note on return.  return false keeps the program running in the same view
            //return true exits the view and returns to the previous view
            //if there is no previous view to return to the program closes.
            case 'A':
		JCollectionView jCollectDemo = new JCollectionView();
		return false;
            case 'B':
                //RunMyRunnable runRunnable = new RunMyRunnable();
                //RunThread runThread = new RunThread();
                MyExecutorControl mainExecutor = new MyExecutorControl();
        {//Sleep for a bit while threads finish.
            try {
                sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(StartupView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
		return false;
            case 'C':
		this.console.println("Choice stub");
		return false;
            case 'D':
                this.console.println("Choice stub");
                return false;
            case 'E':
                MemberControl membersControl = new MemberControl();
                this.console.println("\n");
                this.console.println("A member has been added.");
                this.console.println("Member 1 has name " + membersControl.getName());
		return false;
            case 'F':
                JsonUsageExample testJson = new JsonUsageExample();
		return false;
            case 'G':
                HttpUrlConnectionDemo httpUrl = new HttpUrlConnectionDemo();
		return false;
            case 'H':
                this.console.println("Choice stub");
		return false;
            case 'I':
                this.console.println("Choice stub");
		return false;
            case 'J':
                this.console.println("Choice stub");
		return false;
            case 'K':
                this.console.println("Choice stub");
		return false;
            case 'L':
                this.console.println("Choice stub");
		return false;
            case 'M':
                this.console.println("Choice stub");
            return false;
            case 'N':
                this.console.println("Choice stub");
            return false;
            case 'Q':
                this.console.println("Quit App");
                return true;
            default:
                throw new CharInputException("\n\n" +entry + " is an invalid input at this time \n"
                        + "Please provide acceptable input from the menu below.\n");
                //this.console.println("\n Invalid choice. Please try again.");
                //return false;
        }
        }catch (CharInputException cie){
                ErrorView.display(this.getClass().getName(),cie.getMessage());
                return false;
        } catch (Exception ex) {
            ErrorView.display(this.getClass().getName(),ex.getMessage());
            //Logger.getLogger(StartupView.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}

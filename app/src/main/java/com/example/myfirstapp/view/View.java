/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.BufferedReader;
import java.io.PrintWriter;
import mvcproject.MVCProject;

/**
 *
 * @author Nathan
 */
public abstract class View implements ViewInterface{
    
    protected InputView tempInput = new InputView();
    private String promptMessage;
    protected final BufferedReader keyboard = MVCProject.getInFile();
    protected final PrintWriter console = MVCProject.getOutFile();
    
    public View(String promptMessage){
        this.console.println("\n");
        this.promptMessage = promptMessage;
        this.display();
    }
    
    @Override
    public void display(){
        boolean done = false;
        char value = ' ';
        do {
                this.console.println(this.promptMessage);
		value = this.getInput();
		done = this.doAction(value);
                //note on return.  return false keeps the program running in the same view
                //return true exits the view and returns to the previous view
                //if there is no previous view to return to the program closes.
        }while (!done);
    }//Repeat until the player chooses to close the menu or quit the game.
    

    
    @Override
    public char getInput(){
        //Scanner keyboard = new Scanner(System.in);
        char value = ' ';
        try {
        value = Character.toUpperCase(this.keyboard.readLine().charAt(0));      
        //try {value = this.keyboard.readLine().charAt(0);
        //We need to add a throw here for invalid input.  Character class I created!
            //Something like detecting if input is NOT NAN should do.
        }catch (Exception e) {
            ErrorView.display(this.getClass().getName(),"Error reading input: " + e.getMessage());
        }
        return value;  //return the user input.
    }

    public String getPromptMessage() {
        return promptMessage;
    }

    public void setPromptMessage(String promptMessage) {
        this.promptMessage = promptMessage;
    }
    
    public void nextInput() {
        this.console.println("\n");
        this.promptMessage = promptMessage;
        this.display();//This calls doAction which is overridden...How can I get it to detect... I can next the switches within a for/switch in doAction
        //This can have 0 be 1st input, 1 second, and so on.  If they hit close at any time it closes
        //If they select to cancel...can I call the default constructor again...
    }
}


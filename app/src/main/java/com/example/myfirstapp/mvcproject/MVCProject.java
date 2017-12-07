/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvcproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import view.ErrorView;
import view.StartupView;

/**
 *
 * @author Nathan
 */
public class MVCProject {

    /**
     * @param args the command line arguments
     */
    private static PrintWriter outFile = null;//for Console
    private static BufferedReader inFile = null;
    private static PrintWriter errorLog = null;
    private static File errorFile = new File("ErrorsLog.txt");//specify name and path of file here
    private static PrintWriter statusReport = null;
    
    public static void main(String[] args) {
        // TODO code application logic here

    StartupView startupView = null;
    
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date = new Date();
    
    try {
        //These lines open a stream for input and output for the console.
        //They are created in main so as to be referencable throughout the remainder
        //of the program
        MVCProject.inFile = new BufferedReader(new InputStreamReader(System.in));
        MVCProject.outFile = new PrintWriter(System.out, true);
    //*******Error Log Creation**********
        if (!errorFile.exists())//Checks if errorFile exists.  Creates it if it does not.
            errorFile.createNewFile();
        errorLog = new PrintWriter(new BufferedWriter(new FileWriter(errorFile, true)));      
        //true tells it to append to what exits instead of creating new one.
        //May create if does not exists, but of that I'm unsure.

        String filePath = "errorLog.txt";
        MVCProject.errorLog = new PrintWriter(filePath);    
        
        //MVCProject.statusReport = new PrintWriter(System.out, true);
        String reportPath = "statusReport.txt";       
        MVCProject.statusReport = new PrintWriter(new BufferedWriter(new FileWriter (reportPath, true)));
        statusReport.println("\r\n ****PLAYER STATUS REPORT**** \r\n " + dateFormat.format(date) + " is your game start time. \r\n");
//                statusReport.write("\n ************ \n");
                statusReport.close();
                /**********************Missing try catch to start the app ****/
        //Initialize Controllers as needed here, they'll be passed through each view
        //By initializing controllers the models are used and default items are created.
        
        
        //Start the Program
        startupView = new StartupView();        
    } catch (Throwable ex){ 

            ErrorView.display("SecretsOfTheSea_RPG", "Invalid Entry, please try again.");
            startupView.display();
            
            
        }
        finally {
            try{
                if (MVCProject.inFile != null)
                    MVCProject.inFile.close();
                
                if (MVCProject.outFile != null)
                    MVCProject.outFile.close();
                
                if (MVCProject.errorLog != null)
                    MVCProject.errorLog.close();
            } catch (IOException ex) {
                ErrorView.display("SecretsOfTheSea_RPG","Error closing a stream.");
            }
        }
    }
    
    
    public static PrintWriter getOutFile() {
        return outFile;
    }

    public static void setOutFile(PrintWriter outFile) {
        MVCProject.outFile = outFile;
    }

    public static BufferedReader getInFile() {
        return inFile;
    }

    public static void setInFile(BufferedReader inFile) {
        MVCProject.inFile = inFile;
    }

    public static PrintWriter getErrorLog() {
        return errorLog;
    }

    public static void setErrorLog(PrintWriter errorLog) {
        MVCProject.errorLog = errorLog;
    }

    public static File getErrorFile() {
        return errorFile;
    }

    public static void setErrorFile(File errorFile) {
        MVCProject.errorFile = errorFile;
    }
    public static PrintWriter getStatusReport() {
        return statusReport;
    }

    public static void setStatusReport(PrintWriter statusReport) {
        MVCProject.statusReport = statusReport;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import mvcproject.MVCProject;

/**
 *
 * @author Nathan
 */
public class ErrorView {
    //Added for console output
    private static final PrintWriter errorConsole = MVCProject.getOutFile();
    //assigns the console out stream memory to errorFile
    private static final PrintWriter errorFile = MVCProject.getOutFile();
    //assigns the errorLog steam to local errorLog
    
    //******Error File, local reference*******
    private static PrintWriter localErrorLog = MVCProject.getErrorLog();
    private static File localErrorFile = MVCProject.getErrorFile();
    //For the re-opening of errorLog and setting to the main errorLog.
    //private static PrintWriter tempErrorLog = null;
    
    //write to the errorlog
    public static void display (String className, String errorMessage){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        
        errorFile.println("------------------------------"
                + "\n- ERROR - " + errorMessage
                + "\n--------------------------------------");
    
    //log the error to errorLog
        
    localErrorLog.println(date + " - " + className + " - " + errorMessage);
    //close (to save) and then re-open for future error
    try{   
        if (localErrorLog != null)
            localErrorLog.close();
        } catch (Exception ex1) {
            errorConsole.println("ErrorView - "+ ex1.getMessage() + "Error saving errorLog file");
        } finally {
        //Attempting to re-open...
        try {
            if (!MVCProject.getErrorFile().exists())//Checks if errorFile exists.  Creates it if it does not.
                localErrorFile.createNewFile();
            localErrorLog = new PrintWriter(new BufferedWriter(new FileWriter(localErrorFile, true)));
            //With resource would be taking this lineand addingit within () next to try before the {
            MVCProject.setErrorLog(localErrorLog);
        } catch (Exception ex2){
            errorConsole.println("Error re-opening errorLog for future writing." + ex2.getMessage());
        }
        }
   }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import control.MemberControl;


/**
 *
 * @author Nathan
 */
public class JunitMain {
    
    int[] userArray = {1,2,3};
    Double userDouble = 3.14;
    Boolean userFalse = false;
    Boolean userTrue = true;
    MemberControl user1 = new MemberControl("user1");
    MemberControl blank;
    
    public JunitMain(){
    }
    
    public int[] getArray(){
        return userArray;
    }
    
    public Double getDouble(){
        return userDouble;
    }
    
    public Boolean getFalse(){
        return false;
    }
    
    public Boolean getTrue(){
        return true;
    }
    
    public MemberControl getTempMember(){
        return user1;
    }
    
    public MemberControl getTempMember2(){
        return user1;
    }
    
    public MemberControl getEmptyMember(){
        return blank;
    }
}

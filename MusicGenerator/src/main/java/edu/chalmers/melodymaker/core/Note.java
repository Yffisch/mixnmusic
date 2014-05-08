/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.chalmers.melodymaker.core;

/**
 *
 * @author Yff
 */
public class Note {
    
    String note;
    public Note(String s){
        note = s;
    }
   
    @Override
    public String toString(){
        return note;
    }
    
    public void setNote(String s){
        note = s;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autocompletion;

import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 *
 * @author Student
 */
public class AutoCompletion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       String[] words = {"dog","dark","cat","door","doge"};
       
       String Search = "do";
       
       int length = Search.length();
       
       ArrayList<String> results = new  ArrayList<>();
       
        for (int i = 0; i < words.length; i++) {
            if (words[i].substring(0, length).equals(Search)) {
                results.add(words[i]);
            }
        }
       char [] c = {'a','b','c'};
       String s = new String(c);
        System.out.println(s);
    }
    
}

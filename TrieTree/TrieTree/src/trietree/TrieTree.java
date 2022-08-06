/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trietree;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Student
 */
public class TrieTree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Node Trie = new Node();
        Trie.Add("aaaa", 0);
        Trie.Add("bb", 0);
        Trie.Add("aabb", 0);
        Trie.Add("abbb", 0);
        System.out.println(Trie.Find("aaaa", 0));
        System.out.println(Trie.Find("b", 0));
        System.out.println(Trie.Find("bbb", 0));
        System.out.println(Trie.Find("aab", 0));
    }
    
    private static class Node {
          Map<Character,Node> Children = new HashMap<>();
         
          public void Add(String s, int index){
              
                    if(index >= s.length()){
                        return;
                    }
              
                  if(!Children.containsKey(s.charAt(index))){
                      Children.put(s.charAt(index), new Node());
                  }
                  Children.get(s.charAt(index)).Add(s, index+1);
              
          
          }
          
          private boolean Find(String s, int index){
                if(index == s.length()){
                    return true;
                }
                if(Children.containsKey(s.charAt(index))){
                    
                    return Children.get(s.charAt(index)).Find(s, index + 1);
                }
                return false;
          }
    }
    
}

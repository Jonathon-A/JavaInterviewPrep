package balancedbrackets;

import java.util.Stack;

public class BalancedBrackets {

    public static void main(String[] args) {
        System.out.println(IsBalacedBrackets("("));
        System.out.println(IsBalacedBrackets("()"));
        System.out.println(IsBalacedBrackets("[a(AVX)][[[]]]"));
        System.out.println(IsBalacedBrackets("())"));
        System.out.println(IsBalacedBrackets("(((A)A)A)"));
        System.out.println(IsBalacedBrackets(""));
        System.out.println(IsBalacedBrackets("}{"));
        System.out.println(IsBalacedBrackets("}"));
    }

    
    public static boolean IsBalacedBrackets(String str) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++){
        
        if(str.charAt(i) == '(' || str.charAt(i) == '[' || str.charAt(i) == '{'){
            stack.push(str.charAt(i));
         
        }
        
        if(str.charAt(i) == ')'){
            
            if(!stack.isEmpty() && stack.peek() == '('){
                stack.pop();
            }else{
            return false;
            }
            
        }
        
        if(str.charAt(i) == ']'){
            
            if(!stack.isEmpty() && stack.peek() == '['){
                stack.pop();
            }else{
            return false;
            }
            
        }
        
        if(str.charAt(i) == '}'){
            
            if(!stack.isEmpty() && stack.peek() == '{'){
                stack.pop();
            }else{
            return false;
            }
            
        }
            
        
        }
        
        if(!stack.isEmpty()){
            return false;
        }
        
        
        return true;
    }
}

package queuefromstacks;

import java.util.Stack;

public class QueueFromStacks {

    public static void main(String[] args) {
        StackQueue<Integer> StackQueue = new StackQueue<>();
        StackQueue.Add(1);
        StackQueue.Add(2);
        StackQueue.Add(3);
        System.out.println(StackQueue.Peek());
        System.out.println(StackQueue.Poll());
        System.out.println(StackQueue.Poll());
    }
    
    public static class  StackQueue<T>{
        
        private final Stack<T> Newest = new Stack<>();
        private final Stack<T> Oldest = new Stack<>();
        
        public void Add(T value){
            Newest.push(value);
        }

        public T Peek(){
            ShiftElements();
            T value = Oldest.peek();
           
            return value;
        }
        
        public T Poll(){
            ShiftElements();
            T value = Oldest.pop();
            
            return value;
        }
        
        private void ShiftElements(){
            if(Oldest.isEmpty()){
                while(!Newest.isEmpty()){
                    Oldest.push(Newest.pop());
                }
            }
        }
        
        
    }
}

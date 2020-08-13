package com.hackerrank.queue;

import java.util.Scanner;
import java.util.Stack;

public class QueueWith2Stack {
    public static class MyQueue<T> {
        Stack<T> stackNewestOnTop = new Stack<T>();
        Stack<T> stackOldestOnTop = new Stack<T>();

        void push(Stack<T> top_ref, T new_data) 
            { 
                
                top_ref.push(new_data); 
            } 
  
  T peek(Stack<T> top_ref) 
    {

        if (top_ref.isEmpty()) { 
            System.out.println("Stack Underflow"); 
            System.exit(0); 
        } 
  
        // pop the data from the stack 
        return top_ref.peek();
    }
   
    T pop(Stack<T> top_ref) 
    { 
        
        if (top_ref.isEmpty()) { 
            System.out.println("Stack Underflow"); 
            System.exit(0); 
        } 
  
        // pop the data from the stack 
        return top_ref.pop(); 
    } 
        public void enqueue(T value) { // Push onto newest stack
            
            push(stackNewestOnTop, value);

        }

        public T peek() {
             T x; 
             if(stackNewestOnTop.isEmpty() && stackOldestOnTop.isEmpty()) { 
                 //System.out.println("Q is Empty");  
                    System.exit(0); return null;
             }
              if (stackOldestOnTop.isEmpty()) { 
            while (!stackNewestOnTop.isEmpty()) { 
                x = pop(stackNewestOnTop); 
                push(stackOldestOnTop, x); 
            } 
        } 

            x = peek(stackOldestOnTop); 
            return x; 
        }
        public T dequeue() {
           T x; 
        if (stackNewestOnTop.isEmpty() && stackOldestOnTop.isEmpty()) { 
            // System.out.println("Q is empty"); 
            System.exit(0); 
        } 
        if (stackOldestOnTop.isEmpty()) { 
            while (!stackNewestOnTop.isEmpty()) { 
                x = pop(stackNewestOnTop); 
                push(stackOldestOnTop, x); 
            } 
        } 
        x = pop(stackOldestOnTop); 
        return x; 
        }
    }

    
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();
        
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        
        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}
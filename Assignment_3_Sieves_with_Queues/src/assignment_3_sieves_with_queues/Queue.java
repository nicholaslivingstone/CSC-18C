/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_3_sieves_with_queues;

/**
 *
 * @author freez
 */
public class Queue {
    class Node{
        int data; 
        Node next; 
        
        public Node(int _data){
            this.data = _data; 
            next = null; 
        }
    }
    
    Node head; 
    Node tail; 
    int size; 
    
    public Queue(){
        head = null;
        tail = null; 
        size = 0; 
    }
    
    public int getSize(){
        return size; 
    }
    
    public void enqueue(int _input){
        
        if(size == 0){
            head = new Node(_input);
            tail = head;
        }
        else{
            Node temp = new Node(_input); 
            tail.next = temp; 
            tail = temp;
        }
        size++;
    }
    
    public int dequeue(){
        int data = 0; 
        if(size == 0){
            return data; 
        }
        if(size == 1){
            size--; 
            data = head.data; 
            head = null; 
            return data; 
        }
        size--; 
        data = head.data; 
        Node temp = head; 
        head = head.next; 
        temp = null; 
        return data; 
    }
    
    public int front(){
        if(size == 0)
            return 0; 
        return head.data;
    }
    
    public int back(){
        if(size == 0)
            return 0;
        return tail.data; 
    }
    
    public boolean isEmpty(){
        return size == 0; 
    }
}

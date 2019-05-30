/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_2_in_balance;

/**
 *
 * @author freez
 */
class Node{
    public char data;
    public Node next; 
}

public class CharStack {
    private Node head;
    private Node tail;
    private int size; 
    
    public CharStack(){
        head = null;
        tail = null; 
        size = 0; 
    }
    
    public void push(char _chr){
        if(size == 0){
            head = new Node(); 
            head.data = _chr;
            head.next = null; 
            tail = head;
        }
        else{
            Node temp = new Node(); 
            temp.data = _chr; 
            temp.next = head; 
            head = temp;
        }
        size++; 
    }
    
    public void pop(){
        switch(size){
            case 0:
                break; 
            case 1:
                size--; 
                head = null; 
                break; 
            default:
                size--; 
                Node temp = head; 
                head = temp.next;
        }
    }
    
    public char peek(){
        if(size == 0)
            return '0';
        return head.data; 
    }
    
    public boolean isEmpty(){
        return size == 0; 
    }
    
    public int getSize(){
        return size; 
    }
}




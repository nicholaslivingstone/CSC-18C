/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorted.linked.lists.testing;


class Node <T extends Comparable<T>>{
    private T data;
    private Node<T> next; 

    //null custructor
    Node(){
        data = null;
        next = null; 
    }

    Node(T data){
        this.data = data;
        next = null;
    }
    
    Node(T data, Node<T> next){
         this.data = data;
         this.next = next; 
    }

    T getData(){
        return data; 
    }

    void setData(T data){
        this.data = data; 
    }

    Node<T> getNext(){
        return next; 
    }

    void setNext(Node<T> next){
        this.next = next;
    }
    
    public int compareTo(T data){
        
        if(this.data.compareTo(data) < 0)
            return 1; 
        else if(this.data.compareTo(data) > 0) 
            return -1;
        else 
            return 0;
        
    }
}

public class sortedList<T extends Comparable<T>>{
    private Node<T> head; 
    private Node<T> tail; 
    private Node<T> mid; 
    private int size; //number of elements 
    
    //null custructor
    public sortedList(){
        head = tail = mid = null; 
        size = 0; 
    }

    //custructor with one element
    public sortedList(T data){
        head = tail = mid = new Node(data);
        size = 1; 
    }


    //inserts node to list
    public void insert(T data){
        Node temp = new Node(); 

        if (!isEmpty()){
            if (head.getData().compareTo(data) > 0){
                temp = head; 
                head = new Node(data, temp);
            }
            else if (tail.getData().compareTo(data) < 0){
                temp = tail; 
                tail = new Node(data);
            }
            
        }
        else{
            head = tail = mid = new Node(data);
        }
    }
    public boolean isEmpty(){
        return head == null; 
    }
    
    public void print(){
        if (isEmpty()){
            System.out.println("List is empty");
            return; 
        }
        
        Node<T> current = head; 
        
        while (current != null){
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        
    }
}

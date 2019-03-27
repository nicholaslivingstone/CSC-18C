/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorted.linked.lists.testing;

//node class
class Node <T extends Comparable<T>>{
    private T data;
    private Node<T> next; 

    //null custructor
    Node(){
        data = null;
        next = null; 
    }

    //custructor with given data (sets next to null)
    Node(T data){
        this.data = data;
        next = null;
    }
    
    //custructor with given data and next
    Node(T data, Node<T> next){
         this.data = data;
         this.next = next; 
    }
    
    //return data of node
    T getData(){
        return data; 
    }

    //set node's data
    void setData(T data){
        this.data = data; 
    }
    
    //return node's next
    Node<T> getNext(){
        return next; 
    }
    
    //set node's next
    void setNext(Node<T> next){
        this.next = next;
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

    //custructor with one given element
    public sortedList(T data){
        head = tail = mid = new Node(data);
        size = 1; 
    }


    //inserts node to list
    public void insert(T data){
        Node temp = new Node(); 
        
        //if the node is not empty
        if (!isEmpty()){
            //if the data is smaller than the head
            if (head.getData().compareTo(data) > 0){
                temp = head; 
                head = new Node(data, temp);
                setMid(); 
                size++;
            }
            //if the data is larger than the tail
            else if (tail.getData().compareTo(data) < 0){
                temp = tail; 
                tail = new Node(data);
                temp.setNext(tail);
                setMid(); 
                size++;
            }
            //otherwise compare it to the mid
            else{
                //if the mid is larger than the data
                if(mid.getData().compareTo(data) > 0){
                    boolean set = false; 
                    Node current = head; 
                    //traverse from head to mid until the next value is larger than the data to insert
                    do{
                       if (current.getNext().getData().compareTo(data) > 0){
                           current.setNext(new Node(data, current.getNext()));
                           set = true; 
                       }
                       else{
                           current = current.getNext(); //iterate to next node
                       }
                    }while(!set);
                }
                //if the mid is smaller than the data
                else if(mid.getData().compareTo(data) < 0){
                    boolean set = false; 
                    Node current = mid;
                    //traverse from mid to tail until the next value is larger than the data to insert
                    do{
                       if (current.getNext().getData().compareTo(data) > 0){
                           current.setNext(new Node(data, current.getNext()));
                           set = true; 
                       }
                       else{
                           current = current.getNext(); //iterate to next node
                       }
                    }while(!set);
                }
                //if the mid is equal to the data to be inserted, insert it after the mid
                else if(mid.getData().compareTo(data) == 0){
                    mid.setNext(new Node(data, mid.getNext()));
                }
            }
            
        }//otherwise set node as head, mid, and, tail
        else{
            head = tail = mid = new Node(data);
            size++;
        }
    }

    //delete front
    public void deleteFront(){
        if (isEmpty()){
            System.out.println("\nCannot delete...List is Empty");
            return;
        }
        else{
            System.out.println("\nDeleting from front...");
            if(head == tail){
                head = tail = null; 
            }
            else{
                Node temp = head; 
                head = temp.getNext();
                temp.setNext(null);
                setMid(); 
            }
        }
    }

    //delete back
    public void deleteBack(){
        if (isEmpty()){
            System.out.println("\nCannot delete...List is Empty");
            return;
        }
        else{
            System.out.println("\nDeleting from back...");
            if(head == tail){
                head = tail = null; 
            }
            else{
                Node current = head;
                while(current.getNext() != tail){
                    current = current.getNext();
                }
                tail = current; 
                current.setNext(null);
                setMid(); 
            }
        }
    }
    
    //check if the list is empty
    public boolean isEmpty(){
        return head == null; 
    }
    
    //set the current mid node 
    void setMid(){
        mid = head;  
        for(int i = 0; i < size/2; i++){
            mid = mid.getNext();
        }
    }
    
    //print the list
    public void print(){
        
        //check if the list is empty first
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

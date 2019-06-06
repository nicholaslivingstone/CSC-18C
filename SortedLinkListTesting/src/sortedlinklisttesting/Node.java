package sortedlinklisttesting;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author freez
 */
public class Node<T> {
    private T data;
    private Node<T> next; 
    private Node<T> prev;

    public Node(){
        this.prev = null;
        this.data = null; 
        this.next = null;
    }

    public Node(T data){
        this.prev = null;
        this.data = data; 
        this.next = null;
    }

    public Node(T data, Node<T> prev, Node<T> next){
        this.prev = prev;
        this.data = data; 
        this.next = next;
    }


    public T getData(){
        return data; 
    }

    public Node<T> getNext(){
        return next; 
    }

    public void setNext(Node<T> next){
        this.next = next; 
    }

    public Node<T> getPrev(){
        return prev; 
    }

    public void setPrev(Node<T> prev){
        this.prev = prev; 
    }
}

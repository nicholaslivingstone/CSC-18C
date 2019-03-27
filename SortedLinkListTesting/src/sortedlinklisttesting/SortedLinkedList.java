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
public class SortedLinkedList<T> {
    private Node head;
    private int numNodes;

    public SortedLinkedList(Node<T> node){
        this.head = node; 
    }

    public void addNode(Node<T> newNode){
        boolean cont = true; 
        Node tmp = head; 

        do{
            if(newNode.getData() < tmp.getData()){
                newNode.setNext(tmp);
                newNode.setPrev(tmp.getPrev());
                tmp.setPrev(newNode);
                cont = false; 
            }
            else if(tmp.getNext() == null){
                tmp.setNext(newNode);
                newNode.setPrev(tmp);
                cont = false; 
            }
            else{
                tmp = head.getNext();
            }
        }while(cont); 
        
    }
}

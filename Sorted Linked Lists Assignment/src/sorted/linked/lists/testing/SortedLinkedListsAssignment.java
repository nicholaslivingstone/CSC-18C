/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorted.linked.lists.testing;

/**
 *
 * @author freez
 */

import sorted.linked.lists.testing.sortedList;

public class SortedLinkedListsAssignment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        sortedList<Integer> myList = new sortedList<>(); 
        
        myList.insert(5);
        myList.insert(6);
        
        myList.print(); 
    }
}

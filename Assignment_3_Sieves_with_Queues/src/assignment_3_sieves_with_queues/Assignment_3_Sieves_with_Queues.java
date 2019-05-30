/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_3_sieves_with_queues;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Assignment_3_Sieves_with_Queues {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Main Variables
        Queue ints = new Queue();       //Queues for algorithm
        Queue primes = new Queue();
        int p, n, num = 0;
        boolean error, print = false; 
        Scanner keyb = new Scanner(System.in); //scanner for keyboard input
        
        
        //check if command line argument was entered
        for(String s : args){
            if("--verbose".equals(s))   //--verbose prints content of the Queues as the program is running
                print = true; 
            else
                System.err.println("Invalid command line argument entered. Program will run with default options.");
        }
        
        
        do{
            error = false; 
            try{    //get user input
                System.out.print("Enter a number find all the primes:");
                num = keyb.nextInt();
            }
            catch(InputMismatchException e){    //catch any input errors
                keyb.nextLine();
                System.err.println("Input error.");
                error = true; 
            }
        }while(error);  //continue to get input if there is an error
        
        //fill integer queue with all numbers to input
        for(int i = 2; i <= num; i++){
            ints.enqueue(i);
        }
        
        /*
        BEGIN ERATOSTHENES ALGORITHM
        */
        do{
            p = ints.dequeue();
            primes.enqueue(p);
            
            //adds functionality for --verbose command line argument
            if(print){  
                System.out.println("Dequeing a prime number: " + p);
                System.out.print("Content of Queue of Primes: ");
                for(int i = 0; i < primes.getSize(); i++){
                    n = primes.dequeue();
                    System.out.print(n + " ");
                    primes.enqueue(n);
                }
                System.out.print("\nContent of Queue of Integers: ");
                for(int i = 0; i < ints.getSize(); i++){
                    n = ints.dequeue();
                    System.out.print(n + " ");
                    ints.enqueue(n);
                }
                System.out.println();
            }
            
            Queue temp = new Queue();   //create a temporary queue
            while(!ints.isEmpty()){
                if(ints.front() % p != 0){
                    temp.enqueue(ints.dequeue());
                }
                else
                    ints.dequeue();
            }
            ints = temp; 
        }while(p < java.lang.Math.sqrt(num));
        
        //Move remaining integers to queue of primes
        while(!ints.isEmpty()){
            primes.enqueue(ints.dequeue());
        }
        
        //print queue of primes
        System.out.print("Queue of Primes: ");
        while (!primes.isEmpty()){
            System.out.print(primes.front() + " ");
            primes.dequeue();
        }
        System.out.println();
    }
    
}

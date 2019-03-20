/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package big_o_1;

/**
 *
 * @author freez
 */
public class Big_O_1 {

    public static void main(String[] args) {
        int s1_steps = 0;
        int N;
        
        System.out.print("Enter integer value for N:");
        N = new java.util.Scanner(System.in).nextInt();
        int s = 0;
        s1_steps++;
        System.out.printf("S1 executed %d%n" , s1_steps);
    }
}

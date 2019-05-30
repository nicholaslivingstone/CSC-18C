/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_2_in_balance;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Assignment_2_In_Balance {

    
    public static void main(String[] args) {
        Scanner keyb = new Scanner(System.in);
        String expression;
        
        System.out.println("Enter an expression to test if balanced:");
        expression = keyb.nextLine();
        System.out.println(isBalanced(expression));
    }
    
    public static boolean isBalanced(String exp){
        CharStack bracketStack = new CharStack(); 
        Matcher match = Pattern.compile("[\\{\\}\\(\\)\\[\\]]").matcher(exp);
        char check; 
        while(match.find()){
            check = match.group().charAt(0);
            if((bracketStack.peek() == ')' && check == '(') || (bracketStack.peek() == '(' && check == ')') || (bracketStack.peek() == '{' && check == '}') || (bracketStack.peek() == '}' && check == '{') || (bracketStack.peek() == '[' && check == ']') || (bracketStack.peek() == ']' && check == '[')){
                bracketStack.pop();
            }
            else
                bracketStack.push(check);
        }
        return bracketStack.isEmpty();
    }
    
}
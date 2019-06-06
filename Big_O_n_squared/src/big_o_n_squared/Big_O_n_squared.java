package big_o_n_squared;

public class Big_O_n_squared {


    public static void main(String[] args) {
        int s1_steps = 0, s2_steps = 0, s3_steps  = 0, s4_steps = 0; 
        int N;
        
        System.out.print("Enter integer value for N:");
        N = new java.util.Scanner(System.in).nextInt();
        int s = 0;
        
        s1_steps++;
        for(int i = 1; i <= N; i++){
            s2_steps++; 
            for(int j = 1; j <= N; j++){
                s3_steps++;
                s = s + 1;
                s4_steps++;
                
            }
            s3_steps++;
        }
        s2_steps++;
        
        System.out.printf("S1 executed %d%n" , s1_steps);
        System.out.printf("S2 executed %d%n" , s2_steps);
        System.out.printf("S3 executed %d%n" , s3_steps);
        System.out.printf("S4 executed %d%n" , s4_steps);
        System.out.printf("S = %d%n" , s);
    }
    
}

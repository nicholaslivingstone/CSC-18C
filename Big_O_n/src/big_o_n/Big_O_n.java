package big_o_n;

public class Big_O_n {


    public static void main(String[] args) {
        int s1_steps = 0, s2_steps = 0, s3_steps  = 0;
        int N;
        
        System.out.print("Enter integer value for N:");
        N = new java.util.Scanner(System.in).nextInt();
        int s = 0;
        
        s1_steps++;
        for(int i = 1; i <= N; i++){
            s2_steps++; 
            s = s + 1; 
            s3_steps++;
        }
        s2_steps++;
        
        System.out.printf("S1 executed %d%n" , s1_steps);
        System.out.printf("S2 executed %d%n" , s2_steps);
        System.out.printf("S3 executed %d%n" , s3_steps);
    }
    
}

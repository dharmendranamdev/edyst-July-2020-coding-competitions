import java.util.*;
public class Fourth {
    static int mymaximum(int a[])
    {
        int ind = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < a.length; i++)
        {
            if(max < a[i])
            {
                max = a[i];
                ind = i;
            }
        }
        return ind;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int t = sc.nextInt();
        
        int can[][] = new int[n][t+1];
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < t+1; j++)
            {
                can[i][j] = sc.nextInt();
            }
        }
       // System.out.println();
        /*for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < t+1; j++)
            {
                System.out.print(can[i][j] + " ");
            }
            System.out.println();
        }
        */
        int count[] = new int[n];
        int prev_value[] = new int[n];
        for(int i = 1; i < t; i+=2)//at 2,4,6........
        {
            for(int j = 0; j < n; j++)
            {
                prev_value[j] += can[j][i] * can[j][t] + can[j][i-1] * can[j][t];
                //System.out.println("prev value of "+j+" -"+ prev_value[j]);
            }
            int index = mymaximum(prev_value);
            count[index] += 1;
        }
        int ind = mymaximum(count);
        System.out.println((ind+1));
    }
}

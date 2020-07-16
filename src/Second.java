import java.util.*;
public class Second {
    static int sum(int a[]){
        int s = 0;
        for(int i = 0; i < a.length; i++)
            s += a[i];
        return s;
    }
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        
        String slabsLine = sc.nextLine();
        String text_rateLine = sc.nextLine();
        int rebate = sc.nextInt();
        sc.nextLine();
        String tax_paid_Line = sc.nextLine();
        
        String slabs[] = slabsLine.split(" ");
        String tax_rate[] = text_rateLine.split(" ");
        String tax_paid[] = tax_paid_Line.split(" ");
        int num_employees = tax_paid.length;
        int salaries[] = new int[num_employees];
        
        for(int i = 0; i < num_employees; i++)
        {
            int paid_by_curr_employee = Integer.valueOf(tax_paid[i]);
            System.out.println("paid by "+ i +" th employees : "+paid_by_curr_employee);
            salaries[i] += Integer.valueOf(slabs[0]);
            
            for(int j = 1; j < slabs.length; j++)
            {
                int max_curr_slab = Integer.valueOf(tax_rate[j-1]) * (Integer.valueOf(slabs[j]) - Integer.valueOf(slabs[j-1])) / 100;
                
                if(max_curr_slab <= paid_by_curr_employee)
                {
                    salaries[i] += ( Integer.valueOf(slabs[j]) - Integer.valueOf(slabs[j-1]) );
                    paid_by_curr_employee -= max_curr_slab;
                }
                else
                {
                    int paid_in_slab = ( (paid_by_curr_employee * 100) / Integer.valueOf(tax_rate[j-1]) );
                    salaries[i] = salaries[i] + paid_in_slab;
                    paid_by_curr_employee = paid_by_curr_employee - paid_in_slab;
                    break;
                }
            }
            if(paid_by_curr_employee > 0)
                   salaries[i] = salaries[i] + ((paid_by_curr_employee*100)/ Integer.valueOf(tax_rate[tax_rate.length - 1]));
            salaries[i] = salaries[i] + rebate;
            System.out.println("salary of "+i+" employee is " + salaries[i]+"\n");
        }
        int ans = sum(salaries);
        System.out.println(ans);
    }
}

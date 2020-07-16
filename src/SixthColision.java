import java.util.*;

public class SixthColision {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
       
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0; i < n; i++)
        {
            long x = sc.nextLong();
            long y = sc.nextLong();
            long v = sc.nextLong();
            int val = (int)((Math.sqrt(x * x + y * y)) / v);
            //System.out.print("-->"+a[i]);
            if(hm.containsKey(val))
            {
                //int key = hm.get(val);
                hm.replace(val, hm.get(val) + 1);
            }
            else{
                hm.put(val, 1);
            }
            
        }
        
        int count = 0;
        /*
        for(int i = 0; i < n ; i++)
        {
            for(int j = i + 1; j < n; j++)
            {
                if(a[i] == a[j])
                    count++;
            }
        }
        System.out.println(count);
        */
        
        for (Map.Entry<Integer, Integer> e : hm.entrySet())   //System.out.println(e.getKey() + " " + e.getValue());
        {
            //System.out.println(e.getKey() + " " + e.getValue());
            int val = e.getValue();
            if( val != 1)
                count += ( val * (val - 1)) / 2;
        }
        System.out.println(count);
    }
    
}

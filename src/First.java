import java.util.*;
public class First {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        float rr1 = sc.nextFloat();
        int firstBat = sc.nextInt();
        int secondBat = sc.nextInt();
        
        sc.nextLine();
        String timeline = sc.nextLine(); //Time line
        
        float rr2 = sc.nextFloat();
        
        String[] arrOfStr = timeline.split(" "); 
        int d = arrOfStr.length; //no of deliveries
      
        int r1 = 0; //run scored in d deliveries
        for (String a : arrOfStr)
            if(!a.equals("W"))
	      r1 += Integer.valueOf(a);
        
        //System.out.println(d + " == "+ r1);
        
        int b = Math.round(((rr2 * d) - (6 * r1)) / (rr1 - rr2));
        int r = (int)(( rr1 * b ) / 6 );
        
        //System.out.println("b : "+b + "r: "+r + " \n\n");
        
        int totalRun = r + r1; //total run
        
        //int overfinish[] = {3, 9, 15, 21, 27, 33, 39, 45};
        
        int player = 0;
        int counter = b + 1;
        for(int i = 0; i < d; i++)
        {
            String str = arrOfStr[i];
            //System.out.println("player : " + player + "str : "+str+" first :"+firstBat+" second : "+secondBat);
            if(player == 0)
            {
                if(str.equals("W"))
                    firstBat = 0;
                else
                    firstBat += Integer.valueOf(str);
            }
            else
            {
                if(str.equals("W"))
                    secondBat = 0;
                else
                    secondBat += Integer.valueOf(str);
            }
            
            boolean val;
            if(counter % 6 == 0)
                val = true;
            else
                val = false;
            if(!str.equals("W") && val){
                if((str.equals("1") || str.equals("3") || str.equals("5")))
                    player = player; //player will keep strike
                else
                    player = 1 - player; //player will changed
            }
            else if(str.equals("W") && val){ //if "W" is found and over is completed then player will be changed
                    player = 1 - player;
            }
            
            
            if(val == false && (str.equals("1") || str.equals("3") || str.equals("5"))) //over not finished yet and we take 1,3,5,then player will change
            {
                player = 1 - player;
            }
            
            counter++;
        }
        
        if(player == 0)
           System.out.println(Math.abs(totalRun) + " " + firstBat + " "+ secondBat);
        else
           System.out.println(Math.abs(totalRun) + " " + secondBat + " " + firstBat); 
        
    }
}

import java.util.*;
public class Third {
    //listBase = [];
    static List list = Arrays.asList('0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z' );
         
   //List 2
   static ArrayList<Character> nps = new ArrayList<>(list); //number place system
   
    static String dcToRoman(long num)
    {
        String str = "";
        while(num != 0)
        {
            if (num >= 1000)       // 1000 - m
            {
               str += "M";
               num -= 1000;
            }
            else if (num >= 900)   // 900 -  cm
            {
               str += "CM";
               num -= 900;
            }        
            else if (num >= 500)   // 500 - d
            {           
               str += "D";
               num -= 500;
            }

            else if (num >= 400)   // 400 -  cd
            {
               str += "CD";
               num -= 400;
            }
            else if (num >= 100)   // 100 - c
            {
               str += "C";
               num -= 100;                       
            }
            else if (num >= 90)    // 90 - xc
            {
               str += "XC";
               num -= 90;                                              
            }
            else if (num >= 50)    // 50 - l
            {
               str += "L";
               num -= 50;                                                                     
            }

            else if (num >= 40)    // 40 - xl
            {
               str += "XL";           
               num -= 40;
            }
            else if (num >= 10)    // 10 - x
            {
               str += "X";
               num -= 10;           
            }
            else if (num >= 9)     // 9 - ix
            {
               str += "IX";
               num -= 9;                         
            }
            else if (num >= 5)     // 5 - v
            {
               str += "V";
               num -= 5;                                     
            }
            else if (num >= 4)     // 4 - iv
            {
               str += "IV";
               num -= 4;                                                            
            }
            else if (num >= 1)     // 1 - i
            {
               str += "I";
               num -= 1;                                                                                   
            }
        }
        return str;
    }
    static int findMaxBase(String roman)
    {
        int max = 0;
        for(int i = 0; i < roman.length(); i++)
        {
            for(int j = 0; j < nps.size(); j++)
            {
                if(nps.get(j) == roman.charAt(i) && max < j)
                    max = j;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        
        System.out.println(nps);
        
        if(n >= 1 && n <= 3999){
        //System.out.println(dcToRoman(n));
        HashMap<Character, Integer> hm = new HashMap<>();
        hm.put('I', 18);
        hm.put('V', 31);
        hm.put('X', 33);
        hm.put('L', 21);
        hm.put('C', 12);
        hm.put('L', 21);
        hm.put('D', 13);
        hm.put('M', 22);
        while( n >= 1 && n <= 3999)
        {
            String roman_string = dcToRoman(n);
            System.out.println("Roman String of "+ n + " is :" + roman_string);
            //int base =  hm.get(roman_string.charAt(0)) + 1; //X = 34
            int base = findMaxBase(roman_string) + 1;
            long mult = 1;
            long sum = 0;
            System.out.println("Base : "+base);
            
            for(int i = roman_string.length() - 1; i >= 0; i--)
            {
                sum += hm.get(roman_string.charAt(i)) * mult;
                mult = mult * base;
                System.out.println("sum : "+sum + "Mult : "+mult);
            }
            n = sum;
        }
        System.out.println(n);
        }
        else
            System.out.println("Invalid Input.");
        
    }
}

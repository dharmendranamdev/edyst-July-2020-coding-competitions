import java.util.*;
class Fifth
{
    static boolean is_consonant(char ch)
    {
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
            return false;
        return true;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int noOfEmp = sc.nextInt();
        String str = sc.next();
        HashSet<String>  hs = new HashSet<>();
        int count = getCount(str,noOfEmp, hs);
        System.out.println(count);
    }

    static int getCount(String CurStr, int noOfEmp, HashSet<String> hs)
    {
        int ans = 0;
        if(CurStr.length() == 0 && noOfEmp == 0)
            return 1;
        if(CurStr.length() < 4)
            return 0;
        int start = 0;
        int end = start + 3;
        int result = 0; 
        for(int i = end; i < CurStr.length(); i++)
        {
            String cur_userId = CurStr.substring(start, i+1);
            //System.out.println("Outside : " + cur_userId);
            if(is_consonant(CurStr.charAt(start)) && is_consonant(CurStr.charAt(i)) &&  !(hs.contains(cur_userId)))
            {
                hs.add(cur_userId);
                //System.out.println("Inside : "+cur_userId);
                result = result + getCount(CurStr.substring(i + 1, CurStr.length()), noOfEmp - 1, hs);
                hs.remove(cur_userId);
            }
        }
        return result;
    }
}
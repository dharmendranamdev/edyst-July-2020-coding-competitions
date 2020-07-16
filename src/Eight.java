import java.util.*;

public class Eight {
    static class Queen{
        public int i;
        public int j;
        public String str;
        public Queen(int x, int y , String s)
        {i = x; j = y; str = s;}
    }
    static void printMat(int a[][], int n)
    {
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
    static boolean isSafe(int n, int x, int y)
    {
        if(x >= 0 && x < n && y >= 0 && y < n)
            return true;
        return false;
    }
    static int cal(int board[][], int n , int x, int y)
    {
        
        /////1
        int i = x - 1;
        int j = y;
        int max = Integer.MIN_VALUE;
        int val = -10;
        while(isSafe(n, i, j)){
            
                if(board[i][j] == 1){
                   board[x][y] = 0;
                  //System.out.println("board val : "+ " i : "+ i + " j : "+ j +" -->"+val);
                   val = 1 + cal(board, n, i, j);
                  //System.out.println("After val function val : "+ " i : "+ i + " j : "+ j +" -->"+val);
                   board[x][y] = 1;
                   break;
                }
                i--;
         
        }
        if(val != -10){
            if(max < val){max = val;}
        }
        //////2////////////////////////
        i = x + 1;
        j = y;
      
        val = -10;
        while(isSafe(n, i, j)){
           
                if(board[i][j] == 1){
                   board[x][y] = 0;
                   // System.out.println("board val : "+ " i : "+ i + " j : "+ j +" -->"+val);
                   val = 1 + cal(board, n, i, j);
                 // System.out.println("After val function val : "+ " i : "+ i + " j : "+ j +" -->"+val);
                   board[x][y] = 1;break;
                }
                i++;
           
        }
        if(val != -10){
            if(max < val){max = val;}
        }
        ///////3///////////////////////
        i = x ;
        j = y-1;
       
        val = -10;
        while(isSafe(n, i, j)){
            if(board[i][j] == 1){
              
                   board[x][y] = 0;
                    //System.out.println("board val : "+ " i : "+ i + " j : "+ j +" -->"+val);
                   val = 1 + cal(board, n, i, j);
                  //System.out.println("After val function val : "+ " i : "+ i + " j : "+ j +" -->"+val);
                   board[x][y] = 1;break;
            }
             j--;
          
        }
        if(val != -10){
            if(max < val){max = val;}
        }
        ////////4//////////////////////
        i = x;
        j = y+1;
  
        val = -10;
        while(isSafe(n, i, j)){
            
                if(board[i][j] == 1){
                   board[x][y] = 0;
                   //System.out.println("board val : "+ " i : "+ i + " j : "+ j +" -->"+val);
                   val = 1 + cal(board, n, i, j);
                 // System.out.println("After val function val : "+ " i : "+ i + " j : "+ j +" -->"+val);
                   board[x][y] = 1;break;
                }
                j++;
               
        }
        if(val != -10){
            if(max < val){max = val;}
        }
        /////////5/////////////////////
        i = x - 1;
        j = y - 1;
   
        val = -10;
        while(isSafe(n, i, j)){
           
                if(board[i][j] == 1){
                   board[x][y] = 0;
                    //System.out.println("board val : "+ " i : "+ i + " j : "+ j +" -->"+val);
                   val = 1 + cal(board, n, i, j);
                 /// System.out.println("After val function val : "+ " i : "+ i + " j : "+ j +" -->"+val);
                   board[x][y] = 1;break;
                }
                i--;j--;
            
        }
        if(val != -10){
            if(max < val){max = val;}
        }
        //////////6////////////////////
        i = x + 1;
        j = y + 1;
    
        val = -10;
        while(isSafe(n, i, j)){
          
                if(board[i][j] == 1){
                   board[x][y] = 0;
                   // System.out.println("board val : "+ " i : "+ i + " j : "+ j +" -->"+val);
                   val = 1 + cal(board, n, i, j);
                 // System.out.println("After val function val : "+ " i : "+ i + " j : "+ j +" -->"+val);
                   board[x][y] = 1;break;
                }
                i++;j++;
      
        }
        if(val != -10){
            if(max < val){max = val;}
        }
        ///////////7///////////////////
        i = x - 1;
        j = y + 1;
  
        val = -10;
        while(isSafe(n, i, j)){
            
                if(board[i][j] == 1){
                   board[x][y] = 0;
                    //System.out.println("board val : "+ " i : "+ i + " j : "+ j +" -->"+val);
                   val = 1 + cal(board, n, i, j);
                 // System.out.println("After val function val : "+ " i : "+ i + " j : "+ j +" -->"+val);
                   board[x][y] = 1;break;
                }
                i--;j++;
          
        }
        if(val != -10){
            if(max < val){max = val;}
        }
        ////////////8//////////////////
        i = x + 1;
        j = y - 1;
        
        val = -10;
        while(isSafe(n, i, j)){
           
                if(board[i][j] == 1){
                   board[x][y] = 0;
                    //System.out.println("board val : "+ " i : "+ i + " j : "+ j +" -->"+val);
                   val = 1 + cal(board, n, i, j);
                 // System.out.println("After val function val : "+ " i : "+ i + " j : "+ j +" -->"+val);
                   board[x][y] = 1;
                }
                i++;j--;
       
        }
        if(val != -10){
            if(max < val){max = val;}
        }
        
        if(max == Integer.MIN_VALUE)
            return 0;
        else
            return max;
        
    }
    static int rec(int board[][], int n, Queen[] q, int m)
    {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++)
        {
            int x = q[i].i;
            int y = q[i].j;
            
            int val = cal(board, n, x, y);
            //System.out.println("x : "+x + " y : "+y + "  val:"+val);
            if(min > (m - val))
                min = m - val;
        }
        return min;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String inp = sc.next();
        String st[] = inp.split(",");
        int n = Integer.valueOf(st[0]);
        int m = Integer.valueOf(st[1]);
        
        int board[][] = new int[n][n];
        Queen queens[] = new Queen[m];
        
        for(int i = 0; i < m; i++)
        {
            String str1 = sc.next();
            String strArray[] = str1.split(",");
            //System.out.println(strArray[0] + " " + strArray[1] + " " + strArray[2] +"  ");
            int x = Integer.valueOf(strArray[0]);
            int y = Integer.valueOf(strArray[1]);
            //System.out.println("x : "+x+ "  y^  :" + y);
          
            board[x-1][y-1] = 1;
            String s = strArray[2];
            queens[i] = new Queen(x-1,y-1,s);
            
            //System.out.println("i : "+ queens[i].i+ "  j  :" + queens[i].j);
        }
        
        //printMat(board,n);
        
        System.out.println(rec(board, n, queens, m));
        
        
    }
}

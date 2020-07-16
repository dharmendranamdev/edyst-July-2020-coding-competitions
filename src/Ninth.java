import java.util.*;

class Fraction {
 
    int numerator;
    int denominator;
    public Fraction(int numr, int denr) {
	numerator = numr;
	denominator = denr;
	reduce();
    }
    public Fraction(int num)
    {
        numerator = num;
        denominator = 1;
        reduce();
    }
 
    public int getNumerator() {
	return numerator;
    }
 
    public void setNumerator(int numerator) {
	this.numerator = numerator;
    }
 
    public int getDenominator() {
	return denominator;
    }
 
    public void setDenominator(int denominator) {
	this.denominator = denominator;
    }

    public int calculateGCD(int numerator, int denominator) {
	if (numerator % denominator == 0) {
             return denominator;
        }
	return calculateGCD(denominator, numerator % denominator);
    }
 

    void reduce() {
	int gcd = calculateGCD(numerator, denominator);
	numerator /= gcd;
	denominator /= gcd;
    }
 
    public Fraction add(Fraction fractionTwo) {
	int numer = (numerator * fractionTwo.getDenominator()) + 
                            (fractionTwo.getNumerator() * denominator);
	int denr = denominator * fractionTwo.getDenominator();
	return new Fraction(numer, denr);
    }
 
    //No Need ...
    public Fraction subtract(Fraction fractionTwo) {
        int newNumerator = (numerator * fractionTwo.denominator) - 
                                 (fractionTwo.numerator * denominator);
	int newDenominator = denominator * fractionTwo.denominator;
	Fraction result = new Fraction(newNumerator, newDenominator);
	return result;
    }
    public Fraction multiply(Fraction fractionTwo) {
	int newNumerator = numerator * fractionTwo.numerator;
	int newDenominator = denominator * fractionTwo.denominator;
	Fraction result = new Fraction(newNumerator, newDenominator);
	return result;
    }
    //No Need in this Program
    public Fraction divide(Fraction fractionTwo) {
	int newNumerator = numerator * fractionTwo.getDenominator();
	int newDenominator = denominator * fractionTwo.numerator;
	Fraction result = new Fraction(newNumerator, newDenominator);
	return result;
    }
    public String toString() {
	return this.numerator + "/" + this.denominator;
    }
 
}
public class Ninth {
    static int factorial(int n) {
      int fact = 1;
      int i = 1;
      while(i <= n) {
         fact *= i;
         i++;
      }
      return fact;
   }
     
    static int gcd(int a, int b)  
    {  
        if (b == 0)  
            return a;  
        return gcd(b, a % b);  
    } 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 0; t < T; t++)
        {
            int a = sc.nextInt();
            int h = sc.nextInt();
            int l1 = sc.nextInt();
            int l2 = sc.nextInt();
            int m = sc.nextInt();
            int c = sc.nextInt();
            
            
            int special_needed = (int)Math.ceil(((h - m * a) * 1.0 / c));
            //System.out.println(count);
            
            Fraction f1;
            Fraction count =new Fraction(0);
            //
            //
            //        count +=  ncr(m,k) * L^k * (1-L)^(m-k)
            //                  3  * (7/10)^2 * (3/10)^1   +  1 * (7 / 10)^3 * (3 / 10)^0
            //                  441/100 + 343/1000 
            //                  overall = 98/125
            for(int k = special_needed; k <= m; k++)
            {
               int comb = factorial(m) / (factorial(k) * factorial(m - k)); 
               Fraction ncr = new Fraction(comb);
               
               Fraction noOfSuccessAttempt = new Fraction((int)Math.pow(l1, k) , (int)Math.pow(l2, k));
               
               Fraction noOfFailAttempt = new Fraction((int)Math.pow(l2 - l1 , m - k) , (int)Math.pow(l2, m - k));
               
               f1 = (ncr.multiply(noOfSuccessAttempt)).multiply(noOfFailAttempt);
               
               count = count.add(f1);
            }
            if(count.numerator != 0 && gcd(count.numerator, count.denominator) == 1)
                System.out.println(count);
            else
                System.out.println("RIP");
        }
    }
}

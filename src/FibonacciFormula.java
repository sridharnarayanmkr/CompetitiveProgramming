import java.util.Scanner;
//Find the nth fibonacci number using the formula
//Formula referred from the link : http://www.maths.surrey.ac.uk/hosted-sites/R.Knott/Fibonacci/fibFormula.html#section1
public class FibonacciFormula {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int number;
        System.out.println("Enter the nth index to find the fibonacci number: ");
        number=scan.nextInt();
        fibonacci(number);
    }
    private static void fibonacci(int number) {
        double numerator = Math.pow(1.61803,number)-(Math.pow(-0.61803,number));
        int value =(int)Math.round(numerator/2.23606);
        System.out.println("Fibonacci Number: "+value);
    }
}

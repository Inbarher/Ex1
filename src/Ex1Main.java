//ID: 214450371
import java.util.Scanner;

/**
 * Intro2CS, Ex1 - very basic "main template"
 * Make sure your implementation of this main performs as the Ex1Sol.jar solution implement all needed functions.
 *
 */
public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2="", quit = "quit";

        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println();
            System.out.println("Ex1 class solution:");

            //input 1 - num1
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.next();

            //check if num1 is in the format <num><b><base>
            //calculate the value of num1: Convert num1 in base 2-16 to base 10
            // print true/false and num2 in base 10
            if (!num1.equals("quit")) {
                boolean A = Ex1.isNumber(num1);
                System.out.println("num1 = " + num1 + " is number: " + A + " , value: " + Ex1.number2Int(num1));
                if (Ex1.number2Int(num1)==-1){
                    System.out.println("ERR: num1 is in the wrong format! ("+num1+")");
                    continue;
                }
            }
            else break;

            //input 2 - num2
            System.out.println("Enter a string as number#2 (or \"quit\" to end the program)");
            num2 = sc.next();

            //check if num2 is in the format <num><b><base>
            //calculate the value of num2: Convert num1 in base 2-16 to base 10
            // print true/false and num2 in base 10
            if (!num2.equals("quit")) {
                boolean B = Ex1.isNumber(num2);
                System.out.println("num2 = " + num2 + " is number: " + B + " , value: " + Ex1.number2Int(num2));
                if (Ex1.number2Int(num2) == -1){
                        System.out.println("ERR: num2 is in the wrong format! ("+num2+")");
                        continue;
                    }
                }
            else break;

            //input 3 - base
            System.out.println("Enter a base for output: (a number [2,16]");
            int b = sc.nextInt();

            //check if b is in the correct format of [2,16]
            if (2 > b || b > 16){
                System.out.println("ERR: wrong base, should be [2,16], got ("+b+")");
                        continue;
            }
            //Calculate the sum of the values of num1, num2 and print.
            int sum = Ex1.number2Int(num1) + Ex1.number2Int(num2);

            //Calculate the multiplication of the values of num1, num2 and print.
            int mult = Ex1.number2Int(num1) * Ex1.number2Int(num2);

            System.out.println(num1 + " + " + num2 + " = " + Ex1.int2Number(sum, b));
            System.out.println(num1 + " * " + num2 + " = " + Ex1.int2Number(mult, b));

            //print array with num1, num2, sum, mult.
            // Indicate the number with the largest value.
            System.out.print("Max number over ["+num1+","+num2+","+Ex1.int2Number(sum, b)+","+Ex1.int2Number(mult, b) + "] is:");
            String[] arr1 = {num1, num2, Ex1.int2Number(sum, b), Ex1.int2Number(mult, b)};
            System.out.println(Ex1.maxIndex(arr1));


        }
        System.out.println("quiting now...");
    }
}

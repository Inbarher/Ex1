//package assignments.ex1;
/**
 * This class represents a simple solution for Ex1.
 * As defined here: https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit
 * In this assignment, we will design a number formatting converter and calculator.
 * In general, we will use Strings as numbers over basis of binary till Hexa.
 * [2-16], 10-16 are represented by A,B,..G.
 * The general representation of the numbers is as a String with the following format:
 * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base), “100111b2”, “12345b6”,”012b5”, “123bG”, “EFbG”.
 * The following are NOT in the format (not a valid number):
 * “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, "", null,
 * You should implement the following static functions:
 */
public class Ex1 {
    /**
     * Convert the given number (num) to a decimal representation (as int).
     * It the given number is not in a valid format returns -1.
     *
     * @param num a String representing a number in basis [2,16]
     * @return
     */


    public static int number2Int(String num) {
        int ans = -1;
        //check if num is in the correct format
        if (isNumber(num)) {
            if (num.indexOf("b") == -1){
                num = num + "bA";
            }

            // first we split the string to num and base
            String[] parts = num.split("b", 2);
            String number = parts[0];
            String base = parts[1];

            //loop over all index in number and sum the power
            String topString = "0123456789ABCDEFG";
            int sum = 0;
            int g = 0;
            for (int i = number.length() - 1; i >= 0; i--) {
                sum += (topString.indexOf(number.charAt(i)) * ((int) (Math.pow(topString.indexOf(base.charAt(0)), g))));
                g++;
            }

            return sum;
        } else {
            return ans;
        }
    }

    /**
     * This static function checks if the given String (g) is in a valid "number" format.
     *
     * @param a a String representing a number
     * @return true iff the given String is in a number format
     */

    public static boolean isNumber(String a) {
        boolean ans = true;
        String topString = "0123456789ABCDEF";
        String topString2 = "23456789ABCDEFG";
        //define default base 10
        if (a.indexOf("b") == -1) {
            String[] parts = topString.split("A", 2);
            String newTopSrt = parts[0];
            for (int i = 0; i < a.length(); i++) {
                if (newTopSrt.indexOf(a.charAt(i)) == -1) {
                    ans = false;
                }
            }
        }
        //when b find in a
        if (a.indexOf("b") != -1) {
            String[] parts = a.split("b", 2);
            String number = parts[0];
            String base = parts[1];

            if (number == ""){
                ans = false;
            }

            //check the base is in the format

            if (topString2.indexOf(base) == -1 || base.length()!=1) {
                ans = false;
            } else {
                String [] newTop = topString.split(base, 2);
                String newTopSrt = newTop[0];
                for (int i = 0; i < number.length(); i++) {
                    if (newTopSrt.indexOf(number.charAt(i)) == -1) {
                        ans = false;
                    }
                }
            }
        }
        return ans;
    }


    /**
     * Calculate the number representation (in basis base)
     * of the given natural number (represented as an integer).
     * If num<0 or base is not in [2,16] the function should return "" (the empty String).
     *
     * @param num  the natural number (include 0).
     * @param base the basis [2,16]
     * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
     */
    public static String int2Number(int num, int base) {
        String ans = "";
        // first convert the decimal number to the required base
        String topString = "0123456789ABCDEFG";

        while (num > 0) {
            ans += topString.charAt(num % base);
            num /= base;
        }
        //revers ans
        String reversedAns = new StringBuilder(ans).reverse().toString();
        String Ans = reversedAns + "b" + topString.charAt(base);
        return Ans;
    }

    public static boolean isnum(String num) {
        boolean ans = true;
        String topString = "0123456789";
        for (int i = 0; i < num.length(); i++) {
            if (topString.indexOf(num.charAt(i)) == -1) {
                ans = false;
            }
        }
        return ans;
    }

    public static boolean isbase(int num) {
        boolean ans = true;
        if (2 <= num && num <= 16) ;

        return ans;
    }


        /**
         * Checks if the two numbers have the same value.
         * @param n1 first number
         * @param n2 second number
         * @return true iff the two numbers have the same values.
         */
        public static boolean equals(String n1, String n2) {
            boolean ans = false;
            if (number2Int(n1)==number2Int(n2)){
                ans = true;
            }
            return ans;
        }

        /**
         * This static function search for the array index with the largest number (in value).
         * In case there are more than one maximum - returns the first index.
         * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
         * @param arr an array of numbers
         * @return the index in the array in with the largest number (in value).
         *
         */
        public static String maxIndex(String[] arr) {
            String ans = arr[0];
            int max = number2Int(arr[0]);
            for (int i = 0; i < arr.length; i++) {
                if (number2Int(arr[i]) > max) {
                    max = number2Int(arr[i]);
                    ans = arr[i];
                }
            }
            return ans;
        }
}

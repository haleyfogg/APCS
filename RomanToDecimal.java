/** Class RomanToDecimal converts Roman numerals to Arabic numbers.
 * @version 10/03/2021
 * @author haleyfogg
 */
public class RomanToDecimal {
    //method that accepts a single Roman numeral and returns its decimal equivalent.
    public static int romanToDecimal(String roman) {
        int decimal = 0;
        int correctDecimal = 0;

        roman = roman.toUpperCase();
        for (int i = 0; i < roman.length(); i++)
            //System.out.print(roman.substring(i, i+1).toUpperCase());
            if (roman.substring(i, i + 1).equals("I")) {
                decimal += 1;
            } else if (roman.substring(i, i + 1).equals("V")) {
                decimal += 5;
            } else if (roman.substring(i, i + 1).equals("X")) {
                decimal += 10;
            } else if (roman.substring(i, i + 1).equals("L")) {
                decimal += 50;
            } else if (roman.substring(i, i + 1).equals("C")) {
                decimal += 100;
            } else if (roman.substring(i, i + 1).equals("D")) {
                decimal += 500;
            } else if (roman.substring(i, i + 1).equals("M")) {
                decimal += 1000;
            } else {
                //the program encountered an invalid character
                return -1;

        }

        //at this point, decimal contains the raw point value of this number.
        //time to find and deduct points for invariants.
        if (roman.indexOf("IV") != -1) {
            decimal -= 2; }
        if (roman.indexOf("IX") != -1) {
            decimal -= 2; }
        if (roman.indexOf("XL") != -1) {
            decimal -= 20; }
        if (roman.indexOf("XC") != -1)
            decimal -= 20;
        if (roman.indexOf("CD") != -1) {
            decimal -= 200; }
        if (roman.indexOf("CM") != -1) {
            decimal -= 200; }

//finding logically incorrect input value.
//define Roman digits as characters.
        String S = "";
        char m = 'M';
        char d = 'D';
        char c = 'C';
        char l = 'L';
        char x = 'X';
        char v = 'V';
        char j = 'I';
        correctDecimal = decimal;

//while the input is greater than 1000, add M to roman numeral string and subtract 1000.
//repeat accordingly with all roman digits (CM, D, CD, etc.)
        while (correctDecimal >= 1000) {
            S = S + m;
            correctDecimal -= 1000; }

        while (correctDecimal >= 900) {
            S = S + c + m;
            correctDecimal -= 900; }

        while (correctDecimal >= 500) {
            S = S + d;
            correctDecimal -= 500;}

        while (correctDecimal >= 400) {
            S = S + c + d;
            correctDecimal -= 400;}

        while (correctDecimal >= 100) {
            S = S + c;
            correctDecimal -= 100;}

        while (correctDecimal >= 90) {
            S = S + x + c;
            correctDecimal -= 90;}

        while (correctDecimal >= 50) {
            S = S + l;
            correctDecimal -= 50;}

        while (correctDecimal >= 40) {
            S = S + x + l;
            correctDecimal -= 40;}

        while (correctDecimal >= 10) {
            S = S + x;
            correctDecimal -= 10;}

        while (correctDecimal >= 9) {
            S = S + j + x;
            correctDecimal -= 9;}

        while (correctDecimal >= 5) {
            S = S + v;
            correctDecimal -= 5;}

        while (correctDecimal >= 4) {
            S = S + j + v;
            correctDecimal -= 4;}

            while (correctDecimal >= 1) {
                S = S + j;
                correctDecimal -= 1;}

//find if the input is equal to the Roman numeral String based on the decimal found previously.
            if (!roman.equals(S))
                return -2;
            else return decimal;}


//print decimal output.
public static void main(String[] args) {
        for(String temp : args) {
            int val = romanToDecimal(temp);
            if(val == -1)
                System.out.println("Input: " + temp + " => output: invalid");
            else if (val == -2)
               System.out.println("Input: " + temp + " => output: logically incorrect");
            else
                System.out.println("Input: " + temp + " => output: " + romanToDecimal(temp));
        }

    }
}

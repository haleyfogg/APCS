import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

/**
 * BaseConverter opens a data file, converts numbers, prints
 * @version Thursday 11/18/2021
 * @author haleyfogg
 */

public class BaseConverter {
    // Constructor for class.
    public BaseConverter() {
    }

    // Convert a String num in fromBase to base-10 int.(works for any fromBase)
    public int strToInt(String num, String fromBase) {
        int base = Integer.parseInt(fromBase);
        String alpha = "0123456789ABCDEF";
        int sum = 0, exp = 0;
        for (int i = num.length() - 1; i >= 0; i--) {
            sum += alpha.indexOf(num.charAt(i)) * Math.pow(base, exp);
            exp++;
        }
        return sum;
    }

    // Convert a base-10 int to a String number of base toBase.
    public String intToStr(int num, int toBase) {
        String alpha = "0123456789ABCDEF";
        String toNum = "";

        while (num > 0) {
            toNum = alpha.charAt(num % toBase) + toNum;
            num /= toBase;
        }

        if (toNum.equals(""))
            return "0";
        return toNum;
    }
        /** Opens the file stream, inputs data one line at a time, converts,
         * prints the result to the console window and writes data to the output stream.
         */
        public void inputConvertPrintWrite () {
            // create a Scanner that opens values10.dat
            // print each line to the screen
            Scanner sc = null;
            PrintWriter pw = null;
            try {
                sc = new Scanner(new File("datafiles/values30.dat"));
                pw = new PrintWriter(new File("datafiles/converted.dat"));
                while (sc.hasNext()) {
                    String[] line = sc.nextLine().split("\t"); // splitting around tab key
                    //line = {"24A4B56", "13", "6"};
                    // items to test: line[1] and line[2]
                    int fromBase = Integer.parseInt(line[1]);
                    int toBase = Integer.parseInt(line[2]);
                    if (fromBase < 2 || fromBase > 16) {
                        System.out.println("Invalid input base " + fromBase);
                    } else if (toBase < 2 || toBase > 16) {
                        System.out.println("Invalid output base " + toBase);

                    } else {
                        //print statement to console
                        System.out.println(line[0] + " base " + fromBase + " = " + intToStr(strToInt(line[0], line[1]), toBase) + " base " + toBase);
                        pw.println(line[0] + "\t" + fromBase + "\t" + intToStr(strToInt(line[0], line[1]), toBase) + "\t" + toBase);

                        for (String temp : line) {
                           // System.out.print(temp + "\t");
                            pw.println(temp + "\t");
                        }
                        pw.println();
                        pw.close();
              /*  System.out.println(Arrays.toString(line));
                pw.println(Arrays.toString(line));
                System.out.println();
                pw.println();

               */

                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (sc != null)
                sc.close(); // VERY IMPORTANT
            if (pw != null)
                pw.close();

        }

        /**
         * Main method for class BaseConverter
         * @param args command line argument
         */
        public static void main(String[]args){
            BaseConverter app = new BaseConverter();
            app.inputConvertPrintWrite();
            //System.out.println(app.strToInt("11201221", "3"));
           // System.out.println(app.intToStr(5789324, 16));


        }

    }



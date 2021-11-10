import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Class BMICalculator computes the user's BMI based on height and weight input.
 *  * @version 11/09/2021
 *  * @author haleyfogg
 */
public class BMICalculator {
    public static double computeBMI(int inches, int pounds) {
        if (inches <= 0 || pounds < 0) {
            return 0;
        }
        return pounds * 0.454 / Math.pow(inches * 0.0254, 2);
    }

    /**
     * public static int extractInches parses the user's input and finds their height in inches.
     * @param height
     * @return
     */
        public static int extractInches(String height) {

            int qtPos = height.indexOf("'");
            int dblQtPos = height.indexOf("\"");
            if (qtPos == -1 || dblQtPos == -1) {
                return -1;
            }

            int feet = Integer.parseInt(height.substring(0, qtPos));
            int inches = Integer.parseInt(height.substring(qtPos+ 1, dblQtPos));
            if (inches < 0 || inches > 11 || feet < 0) {
                return -1;
            }
            return (feet * 12 + inches == 0) ? -1 : feet * 12 + inches;

        }

    /**
     * public static void main collects the user's height and weight, prints their BMI (or an error message),
     * and asks the user if they would like to continue.
     * @param args
     */
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            DecimalFormat df = new DecimalFormat("0.00");
            int inches, weight;
            while (true) {
                System.out.print("Enter your height in feet and inches (Ex 6'1\"): ");
                inches = extractInches(in.nextLine()); //collects user's height
                System.out.print("Enter your weight in pounds: ");
                weight = in.nextInt(); //collects user's weight
                if (!df.format(computeBMI(inches, weight)).equals("0.00"))
                    System.out.println("Your BMI, expressed as weight(kg)/height(m)^2: " + df.format(computeBMI(inches, weight)) + " kg/m^2");
                //prints BMI
                else System.out.println("Please enter valid height and weight");
                //prints error message if height and/or weight is not in proper format.
                in.nextLine();  //scanners are weird, this handles the nextInt buffer.
                System.out.print("Continue (Y/N): ");
                String cont = in.nextLine();
                if (!cont.toLowerCase().equals("y"))
                    break;
            }

            System.out.println("End of program!");
            }

        }



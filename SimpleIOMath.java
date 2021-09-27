import java.util.Scanner;

/**
 * Class HolyGrail is a basic IO program.
 * @version Monday, September 27, 2021
 * @author haleyfogg
 */
public class SimpleIOMath {
    private String name;
    private int age;
    private int favNumber;

    private int smallestPrime(int num) {
        for (int i = 2; i <= (int) (Math.sqrt(num)) + 1; i++) {
            if (num % i == 0)
                return i;
        }
        return num;
    }
//This method prompts the user to answer three questions.
    public void promptUser() {
        Scanner in = new Scanner(System.in);
        System.out.print("Question 1: What is your name? ");
        name = in.nextLine();
        System.out.print("Question 2: How old are you? ");
        age = in.nextInt();
        System.out.print("Question 3: What is your favorite number? ");
        favNumber = in.nextInt();
    }
//This method prints the lyrics, user responses, and answers to math manipulations performed on user's integer responses.
    public void printInfo() {
        System.out.println("I'm gonna teach you how to sing it out");
        System.out.println("Come on, come on, come on");
        System.out.println("Let me tell you what it's all about");
        System.out.println("Reading, writing, arithmetic");
        System.out.println("Are the branches of the learning tree");
        System.out.println("Your name is: " + name);
        System.out.println("Your age is: " + age);
        System.out.println("At your next birthday, you will turn " + (age + 1) + ".");
        System.out.println("The first prime factor of " + age + " is: " + smallestPrime(age));
        System.out.println("Your favorite number is: " + favNumber);
        System.out.println("Your favorite number squared is: " + favNumber*favNumber);
        System.out.println("The square root of your favorite number is: " + Math.sqrt(favNumber) + ".");
        System.out.println("* end of program *");
    }
//This method welcomes the user and instructs the objects above to prompt and print, respectively.
    public static void main(String[] args) {
        System.out.println("* Sit yourself down, take a seat *");
        System.out.println("* All you gotta do is repeat after me *");
        SimpleIOMath obj = new SimpleIOMath();
        obj.promptUser();
        obj.printInfo();
    }
}


//Original code using main instead of private methods:
// (I know age + 1 and first prime factor aren't correct, they were placeholders.)
/** public class SimpleIOMath {
 public static void main(String [] args) {
 Scanner input = new Scanner(System.in);

 System.out.println("* Sit yourself down, take a seat *");
 System.out.println("* All you gotta do is repeat after me *");
 System.out.print("Question 1: What is your name? ");
 String name = input.nextLine();

 System.out.print("Question 2: How old are you? ");
 int age = input.nextInt();

 System.out.print("Question 3: What is your favorite number? ");
 int number = input.nextInt();

 System.out.println("I'm gonna teach you how to sing it out");
 System.out.println("Reading, writing, arithmetic");
 System.out.println("Are the branches of the learning tree");

 System.out.println("Your name is: " + name);
 System.out.println("Your age is: " + age);
 System.out.println("At your next birthday, you will turn " + age + ".");
 System.out.println("The first prime factor of " + age + " is: " + age);
 System.out.println("Your favorite number is: " + number);
 System.out.println("Your favorite number squared is: " + number*number );

 System.out.println("* end of program *");

 }
 }
 */
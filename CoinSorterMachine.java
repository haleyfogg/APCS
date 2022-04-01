import java.text.DecimalFormat;
import java.util.*;
import java.io.*;

/**
 * The CoinSorterMachine class reads a data file, assigns the integer values to coins, counts and values the coins, and
 * prints a deposit summary
 * @version 03/31/2022
 * @author haleyfogg
 */
public class CoinSorterMachine {
    private ArrayList<Coin> coins;
    int dollarCount, halfDollarCount, quarterCount, dimeCount, nickelCount, pennyCount;
    double total;
    DecimalFormat df = new DecimalFormat("$0.00");

    /**
     * initializes the coins arrayList
     */
    public CoinSorterMachine() {
        coins = new ArrayList<>();
    }

    /**
     * prompts user for the appropriate file name and imports the data from filename; adds Coin objects to coins arrayList
     */
    public void depositCoins() {
        Scanner input = new Scanner(System.in);
        try {
            System.out.print("Enter the name of the data file for coin deposit: ");
            String file = input.nextLine();
            Scanner in = new Scanner(new File(file));
            while (in.hasNext()) {
                int value = (in.nextInt());
                if (value == 100) {
                    coins.add(new Dollar());
                    dollarCount ++; }
                else if(value == 50) {
                    coins.add(new HalfDollar());
                    halfDollarCount ++; }
               else if(value == 25) {
                    coins.add(new Quarter());
                    quarterCount ++; }
                else if(value == 10) {
                    coins.add(new Dime());
                    dimeCount++;  }
               else if(value == 5) {
                    coins.add(new Nickel());
                    nickelCount++; }
                else if(value == 1) {
                    coins.add(new Penny());
                    pennyCount ++; }
                else
                    System.out.println("Coin value " + value + " not recognized");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Depositing coins...");
        }
    }

    /**
     * prints deposit summary using a DecimalFormat object (see output section)
     */
    public void printDepositSummary() {
        System.out.println("Summary of deposit:");
        Coin penny = new Penny();
        Coin nickel = new Nickel();
        Coin dime = new Dime();
        Coin quarter = new Quarter();
        Coin halfDollar = new HalfDollar();
        Coin dollar = new Dollar();

        System.out.println("\t" + pennyCount + " " + ((pennyCount == 1) ? penny.getName() : penny.getPluralName() + " " + df.format(pennyCount * penny.getValue())));
        System.out.println("\t" + nickelCount + " " + ((nickelCount == 1) ? nickel.getName() : nickel.getPluralName() + " " + df.format(nickelCount * nickel.getValue())));
        System.out.println("\t" + dimeCount + " " + ((dimeCount == 1) ? dime.getName() : dime.getPluralName() + " " + df.format(dimeCount * dime.getValue())));
        System.out.println("\t" + quarterCount + " " + ((quarterCount == 1) ? quarter.getName() : quarter.getPluralName() + " " + df.format(quarterCount * quarter.getValue())));
        System.out.println("\t" + halfDollarCount + " " + ((halfDollarCount == 1) ? halfDollar.getName() : halfDollar.getPluralName() + " " + df.format(halfDollarCount * halfDollar.getValue())));
        System.out.println("\t" + dollarCount + " " + ((dollarCount == 1) ? dollar.getName() : dollar.getPluralName() + " " + df.format(dollarCount * dollar.getValue())));

        System.out.println("\tTOTAL DEPOSIT: " + df.format(getTotalValue()));

    }

    /**
     * calculates total value of all coins in data set
     * @return the total value of all Coin objects stored in coins as a double
     */
    public double getTotalValue() {
        total = (pennyCount*0.01 + nickelCount*.05 + dimeCount*.1 + quarterCount*.25 + halfDollarCount*.5 + dollarCount);
                return total;
    }

    /**
     * prompts user for file name and prints deposit summary
     * @param args command line argument
     */
    public static void main(String[] args) {
        CoinSorterMachine app = new CoinSorterMachine();
        app.depositCoins();
        app.printDepositSummary();
    }
}

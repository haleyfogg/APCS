/**
 * Coin is the parent class of Dollar, HalfDollar, Quarter, Dime, Nickel, and Penny
 * @version 03/31/2022
 * @author haleyfogg
 */
public abstract class Coin {

    /**
     * calculates total value of all coins in data set
     * @return the total value of all Coin objects stored in coins as a double
     */
    public abstract double getValue();

    /**
     * @return the name of a the coin
     */
    public abstract String getName();

    /**
     * converts coin name to its plural form
     * @return the name of a given coin in plural form
     */
    public String getPluralName() {
        if(getName().equals("penny"))
            return "pennies";
        else
            return getName() + "s";
    }
}
/**
 * Nickel class represents a 5¢ coin
 * @version 03/31/2022
 * @author haleyfogg
 */
public class Nickel extends Coin {
    /**
     * @return the value of this coin as a double
     */
    public double getValue() {
        return 0.05;
    }
    /**
     * @return String version of this coin's name
     */
    public String getName() {
        return "nickel";
    }
}

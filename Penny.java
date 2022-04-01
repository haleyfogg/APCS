/**
 * Penny class represents a 1¢ coin
 * @version 03/31/2022
 * @author haleyfogg
 */
public class Penny extends Coin {
    /**
     * @return the value of this coin as a double
     */
    public double getValue() {
        return 0.01;
    }
    /**
     * @return String version of this coin's name
     */
    public String getName() {
        return "penny";
    }
}

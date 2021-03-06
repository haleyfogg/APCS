/**
 * HalfDollar class represents a 50¢ coin
 * @version 03/31/2022
 * @author haleyfogg
 */
public class HalfDollar extends Coin {
    /**
     * @return the value of this coin as a double
     */
    public double getValue() {
        return 0.5;
    }
    /**
     * @return String version of this coin's name
     */
    public String getName() {
        return "half dollar";
    }
}

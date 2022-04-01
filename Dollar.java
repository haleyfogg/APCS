/**
 * Dollar class represents a $1 coin
 * @version 03/31/2022
 * @author haleyfogg
 */
public class Dollar extends Coin {
    /**
     * @return the value of this coin as a double
     */
    public double getValue() {
        return 1.0;
    }

    /**
     * @return String version of this coin's name
     */
    public String getName() {
        return "dollar";
    }
}

/**
 * the Waypoint class contains the overloaded and default Waypoint constructors and all accessor methods.
 * @author haleyfogg
 * @version 4/29/2022
 */
public class Waypoint {
    private String type, name, state;
    private double toSpringer, toKatahdin;
    private int elevation;

    /**
     * overloaded Waypoint constructor
     * @param t
     * @param n
     * @param s
     * @param ts
     * @param tk
     * @param e
     */
    public Waypoint(String t, String n, String s, double ts, double tk, int e) {
        type = t;
        name = n;
        state = s;
        toSpringer = ts;
        toKatahdin = tk;
        elevation = e;
    }

    /**
     * default Waypoint constructor
     */
    public Waypoint()   {
        type = "";
        name = "";
        state = "";
        toSpringer = 0;
        toKatahdin = 0;
        elevation = 0;
    }

    /**
     * accessor method that returns the Waypoint's type
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * accessor method that returns the Waypoint's name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * accessor method that returns the Waypoint's state
     * @return state
     */
    public String getState() {
        return state;
    }
    /**
     * accessor method that returns the Waypoint's distance to Springer
     * @return toSpringer
     */
    public double getToSpringer() {
        return toSpringer;
    }

    /**
     * accessor method that returns the Waypoint's distance to Katahdin
     * @return toKatahdin
     */
    public double getToKatahdin() {
        return toKatahdin;
    }

    /**
     * accessor method that returns the Waypoint's elevation
     * @return elevation
     */
    public int getElevation() {
        return elevation;
    }

    @Override
    /**
     * toString method that returns information in user-friendly format
     */
    public String toString() {
        return "Waypoint" +
                "type = " + type +
                ", name = " + name +
                ", state = " + state +
                ", distance to Springer = " + toSpringer +
                ", distance to Katahdin = " + toKatahdin +
                ", elevation = " + elevation;
    }
}


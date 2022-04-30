import java.util.Comparator;

/**
 * the WaypointComparator class compares Waypoints based on the user chosen search term
 * @author haleyfogg
 * @version 4/29/2022
 */
public class WaypointComparator implements Comparator<Waypoint> {
    private int category;
    private boolean asc;

    /**
     * overloaded WaypointComparator constructor
     * @param c
     * @param a
     */
    public WaypointComparator(int c, boolean a) {
        category = c;
        asc = a;
    }

    /**
     * compares each Waypoint based for each possible search term and arranges in ascending or desceding order
     * @param one the first object to be compared.
     * @param two the second object to be compared.
     * @return
     */
    public int compare(Waypoint one, Waypoint two) {
        int diff = 0;
        if(category == 1)  //TYPE
            diff = one.getType().compareTo(two.getType());
        else if(category == 2) //NAME
            diff = one.getName().compareTo(two.getName());
        else if(category == 3) //STATE
            diff = one.getState().compareTo(two.getState());
        else if(category == 4) { //DTS
            Double d1 = one.getToSpringer();
            Double d2 = two.getToSpringer();
            diff = d1.compareTo(d2);    }
        else if(category == 5) { //DTK
            Double d1 = one.getToKatahdin();
            Double d2 = two.getToKatahdin();
            diff = d1.compareTo(d2);    }
        else if(category == 6) //ELEVATION
            diff = one.getElevation() - two.getElevation();

        return (asc) ? diff : -diff;
    }
}

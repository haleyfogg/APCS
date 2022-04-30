import org.w3c.dom.ls.LSOutput;

import javax.swing.undo.AbstractUndoableEdit;
import java.util.ArrayList;
import java.util.Collections;
import java.io.File;
import java.util.Scanner;

/**
 * The TrailDatabase class creates a database of locations on the AT, sorts the list based on user selections,
 * and prints the sorted database.
 * @author haleyfogg
 * @version 4/29/2022
 */
public class TrailDatabase {
        private ArrayList<Waypoint> database;
        private int searchTerm;
        private boolean asc;
        public TrailDatabase() {
            database = new ArrayList<>();
            populateDatabase();
        }

    /**
     * Imports all of the data out of the apptrailDB.txt file
     */
    public void populateDatabase() {
        try {
            Scanner in = new Scanner(new File("apptrailDB.txt"));
            while(in.hasNext()) {
                String[] line = in.nextLine().split("\t");
                database.add(new Waypoint(line[0], line[1], line[2], Double.parseDouble(line[5]),
                        Double.parseDouble(line[6]), Integer.parseInt(line[7])));
            }
            in.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        }

    /**
     * prompts the user to choose the search term for sorting the Waypoints in the database and whether to sort
     * in ascending or descending order
     */
        public void getSearchTerm() {
            System.out.println("+ Menu of search terms to use for sorting waypoints +\n" +
                    "\tTY: by type\n" +
                    "\tNA: by name\n" +
                    "\tST: by state \n" +
                    "\tDS: by distance to Springer\n" +
                    "\tDK: by distance to Katahdin\n" +
                    "\tEL: by elevation\n");
            Scanner in = new Scanner(System.in);
            System.out.print("Enter your preferred sort by term or 'Q' to quit: ");
            String term = in.nextLine();
            if (term.equals("TY"))
                searchTerm = 1;
            else if (term.equals("NA"))
                searchTerm = 2;
            else if (term.equals("ST"))
                searchTerm = 3;
            else if (term.equals("DS"))
                searchTerm = 4;
            else if (term.equals("DK"))
                searchTerm = 5;
            else if (term.equals("EL"))
                searchTerm = 6;
            else
                searchTerm = 0; //quit th eloop running in main if user enters invalid stuff
            if (searchTerm != 0) {
                System.out.print("Enter 'A' to sort in ascending order or 'D' to sort in descending order: ");
                term = in.nextLine();
                asc = term.toLowerCase().equals("a") ? true : false;
            }
        }

    /**
     * prints all Waypoints and info in database
     */
    public void printDatabase() {
            for(Waypoint w: database)
                System.out.println(w);
        }

    /**
     * calls MergeSort to sort the database according to the user chosen search term
     */
    public void sortDB() {
            MergeSort.sort(database, new WaypointComparator(searchTerm, asc));
        }

    /**
     *  welcomes the user, prints search term and ascending/descending prompts, prints sorted database
     * @param args
     */
    public static void main(String[] args) {
        TrailDatabase db = new TrailDatabase();
        System.out.println("*** Welcome to the Appalachian Trail Database ***\n");
        while (true) {
            db.getSearchTerm();
            if (db.searchTerm == 0)
                break;
            db.sortDB();
            db.printDatabase();
        }
        System.out.println("End of program");
    }

}

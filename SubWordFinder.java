import java.util.*;
import java.io.*;

/**
 * The SubWordFinder class finds root words that are made up of two sub words contained within a text file
 * and outputs in the format root = sub1 + sub2 by building a jagged list dictionary and
 * using the binary search method
 * @author haleyfogg
 * @version 02/02/2022
 */
public class SubWordFinder implements WordFinder {
    private ArrayList<ArrayList<String>> dictionary;    // jagged list
    private String alpha = "abcdefghijklmnopqrstuvwxyz";

    /**
     * The SubWordFinder method creates and populates the dictionary
     */
    public SubWordFinder() {
        dictionary = new ArrayList<>();
        // 26 empty buckets
        for(int i = 0; i < alpha.length(); i++) {
            dictionary.add(new ArrayList<String>());
        }
        populateDictionary();
    }

    /**
     * The populateDictionary method contains the instructions for adding the words from the text file to the dictionary
     */
    public void populateDictionary() {
        try {
            Scanner in = new Scanner(new File("words_all_os.txt"));
            while (in.hasNext()) {
                String word = in.nextLine();
                dictionary.get(alpha.indexOf(word.charAt(0))).add(word);
            }
            in.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int indexOf(String word) {
        int low = 0;
        ArrayList<String> bucket = dictionary.get(alpha.indexOf(word.charAt(0)));
        int high = bucket.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (bucket.get(mid).compareTo(word) == 0)
                return mid;
            else if(bucket.get(mid).compareTo(word) < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    /**
     * The inDictionary method determines whether a word is in the dictionary
     * @param word The item to be searched for in dictionary
     * @return boolean inDictionary
     */
    public boolean inDictionary(String word) {
       // System.out.println(word);
        int index = alpha.indexOf(word.charAt(0));
        ArrayList<String> bucket = dictionary.get(index);
        return indexOf(word) >= 0;
    }

  /*  public ArrayList<String> findShortestWords() {
        ArrayList<String> shorts = new ArrayList<>();
        for (ArrayList<String> bucket : dictionary) {
            for (String word : bucket) {
                if (word.length() == 3)
                    shorts.add(word);
            }
        }
        System.out.println("There are " + shorts.size() + " three-letter words");
        return shorts;
    }
   */

    /**
     * The getSubWords method tests every combination of two sub words within a root word
     * @return ArrayList subwords
     */
        public ArrayList<SubWord> getSubWords () {
            ArrayList<SubWord> subwords = new ArrayList<>();
            for(ArrayList<String> bucket : dictionary) {
                for(String word : bucket) {
                    for(int i = 3; i < word.length() - 2; i++) {
                        String sub1 = word.substring(0, i);
                        String sub2 = word.substring(i);
                        if(inDictionary(sub1) & inDictionary(sub2)) {
                            SubWord subword = new SubWord(word, sub1, sub2);
                            subwords.add(subword);
                        }
                    }
                }
            }
            return subwords;
        }

   /*
    public void printDictionary() {
            for (ArrayList<String> bucket : dictionary)
                System.out.println(bucket);
            int MAXLEN = dictionary.get(0).size();
            int MAXINDEX = 0;
            for (int i = 1; i < dictionary.size(); i++) {
                if (dictionary.get(i).size() > MAXLEN) {
                    MAXLEN = dictionary.get(i).size();
                    MAXINDEX = i;
                }
            }
            System.out.println("The longest sublist is at index " + MAXINDEX + " starting with the letter " + alpha.charAt(MAXINDEX));
        }
    */
            /**
             * The main method prints the words containing two sub words in the format root = sub1 + sub2
             * @param args command line argument
             */
            public static void main (String[]args){
                SubWordFinder app = new SubWordFinder();
                ArrayList<SubWord> subs = app.getSubWords();
                for (SubWord word : subs)
                    System.out.println(word);
              //  System.out.println("There are " + subs.size() + " sub words.");
                // app.printDictionary();
                // System.out.println(app.findShortestWords());
            }
        }
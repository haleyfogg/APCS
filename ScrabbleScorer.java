import java.util.*;
import java.io.*;

/**
 * The ScrabbleScorer class builds a dictionary, detects invalid words, and scores valid scrabble words (excluding point bonuses)
 * @version 01/24/2022
 * @author haleyfogg
 */
public class ScrabbleScorer {
    private ArrayList<String> dictionary;
    private int[] points = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};
    private String alpha;

    /**
     * the ScrabbleScorer method builds the dictionary
     */
    public ScrabbleScorer() {
        dictionary = new ArrayList<>();
        alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        buildDictionary();
    }

    /**
     * the buildDictionary instructs the program how to build the dictionary and sorts all of the dictionary
     * entries using Collections.sort
     */
    public void buildDictionary() {
        try {
            Scanner in = new Scanner(new File("SCRABBLE_WORDS.txt"));
            while (in.hasNext()) {
                dictionary.add(in.nextLine().strip());
            }
            in.close();
            Collections.sort(dictionary);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * the isValidWord boolean method finds whether the user input is contained in the dictionary
     * @param word
     * @return isValidWord
     */
    public boolean isValidWord(String word) {
        return Collections.binarySearch(dictionary, word) >= 0;
    }

    /**
     * The getWordScore method calculates the score of the user input word
     * @param word
     * @return sum
     */
    public int getWordScore(String word) {
        int sum = 0;
        for(int i = 0; i < word.length(); i++)
          sum += points[alpha.indexOf(word.charAt(i))];
            return sum;
    }

    /**
     * Main method for class ScrabbleScorer; asks user for word, prints word score or invalid word message
     * @param args command line argument
     */
    public static void main(String[] args) {
        ScrabbleScorer app = new ScrabbleScorer();
        System.out.println("* Welcome to the Scrabble Word Scorer app *");
        String userWord;
        Scanner userIn = new Scanner(System.in);
        try {
            while (true) {
                System.out.print("Enter a word to score or 0 to quit: ");
                userWord = userIn.nextLine();
                if(userWord.equals("0"))
                    break;
                else {
                 if(app.isValidWord(userWord.toUpperCase()))
                     System.out.println(userWord + " = " + app.getWordScore(userWord.toUpperCase()) + " points");
                  else
             System.out.println(userWord + " is not a valid word in the dictionary");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Exiting the program thanks for playing");
    }

}

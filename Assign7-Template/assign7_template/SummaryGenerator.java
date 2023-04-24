//This class generates the data summary based on the data in the file purchases.csv
// and show such summaries. 
//Currently it only counts how many times each country appears. 

package assign7_template;


import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.List;
import java.util.Map;
import java.util.regex.PatternSyntaxException;

public class SummaryGenerator {

    //the delimiter comma in the data file: purchases.csv
    private final String COMMA_DELIMITER = ",";
    
    //----Assign 7 BEGIN ------------//    
    //add your code:  define a data field named countsByCountryMap, which must be a Map data structure.
    // (country-name, count)
        //Hint on Map
        //* It’s very similar to frequencies in the class CharacterCount in the package hashmap_use posted for Lec#21.
    private HashMap<String, Integer> countsByCountryMap;

    //add your code: define a no-argument constructor, 
    //  where you create a new HashMap or TreeMap for the data summary. 
    //  You must add the code for creating each type of Map.
    //  Then you comment the code for one type, use the other type at a time.
    public SummaryGenerator() {
        //add your code        
        
        //create a Map using each catory: TreeMap or HashMap for the data field: countsByCountryMap, 
        //  You must add the code for creating each type of Map.
        //  Then you comment the code for one type, use the other type at a time.
        //HashMap<String,String> invoiceNO  new HashMap<>();
        countsByCountryMap = new HashMap<>();
        //HashMap<String,String> description = new HashMap<>();
       // HashMap<String,String> quantity = new HashMap<>();
       // HashMap<String,String> invoiceDate = new HashMap<>();
       // HashMap<String,String> unitPrice = new HashMap<>();
       // HashMap<String,String> customerID = new HashMap<>();
       // HashMap<String,String> country = new HashMap<>();


        //Hints:
        // HashMap
        //  * It’s very similar to frequencies in the class CharacterCount in the package hashmap_use posted for Lec#21.
	// TreeMap
	//  * Similar to the code in the class SimpleMapTest in the package set_map_use posted for the folder: Lec19-Code-Synch-AsynchLearn-WithDetailedComment.
        

    }      
    
    //takes in a BufferedReader object that is already associated with
    //   the file purchases.csv, read the data line by line,
    //   create the country summary and save the summary entries in the summary map.
    public void createCountsByCountry(BufferedReader br) {      
        //build country summary
        List<String> purchase = new ArrayList<>();
        try {
            String line;
            //read the first line (column heading), and do not do anything with it.
            br.readLine();
            //read line by line until file reading is completed            
            while ((line = br.readLine()) != null) {
                //split values in each line using the delimiter comma,
                //  store values as String in a String array.
                String[] fields = line.split(COMMA_DELIMITER);
                //convert the array to an ArrayList
                purchase = Arrays.asList(fields);
                //System.out.println(purchase);
                //----Assign 7  Continues  ------------//

                //Add your code:
                if(!countsByCountryMap.containsKey(purchase.get(7))) {
                    countsByCountryMap.put(purchase.get(7),1 );

                }
                else {
                    int currentCount = countsByCountryMap.get(purchase.get(7));
                    currentCount++;
                    countsByCountryMap.put(purchase.get(7),currentCount);

                }
                //get the country from the ArrayList: purchase
                //if the country is already in the data summary
                //    get the country's count, increase the count by 1,
                //    write the new summary: country, updated-count into the data summary map: countsByCountry.
                //otherwise,
                //    add the new summary entry: country, 1 into the data summary map: countsByCountry.
                
                //Hint
                //* It’s very similar to buildCharacterCount() in the class CharacterCount in the package hashmap_use posted for Lec#21.
                //* The difference is in handling the map entry type (stored format).
                
                //----Assign 7------------//                
                
            }
        } catch (IOException ioe) { 
            System.out.println("file input error.");
            ioe.printStackTrace();
            System.exit(1);
        } catch (PatternSyntaxException pse) {
            System.out.println("pattern specification error.");            
            pse.printStackTrace();
            System.exit(1);            
        }
    }
    
    //---- Assign 7 Continues ------------//
    
    //print the content of the data summary map in the format given in the sample output
    public void showCountsByCountry(){
        //print the heading
        System.out.printf("%-24s %-10s\n", "Country", "Count");
        //print a number of dashes
        System.out.println("-".repeat(35));
        //add your code
        for(String current : countsByCountryMap.keySet()) {
            int currentCount = countsByCountryMap.get(current);
            //System.out.printf("%-10s%51%n", current, currentCount);

            System.out.printf("%-25s", current);
            printNChars('*',currentCount);
        }

        //use a foreach loop
        //   do the following in each loop run
        //      get the curernt data summary entry: country, count
        //      print the country
        //      call printNChars to print the count as a sequence of stars.
        //           count of 5 means 5 stars.
        
        //Hints:
	//* Display data summary entry information in the format similar to the sample output
	//* You can use System.out.printf(…) method.
	//* See the class CharacterCountTest in the package hashmap_use posted for Lec#21.
        
    }
    
    //print the character ch count number of times in one line
    private void printNChars(char ch, int count) {
        
        //add your own code
        for(int i = 1; i <= count; ++i ) {
            System.out.print(ch);
        }
        System.out.println();
        //Hint: use a counter-controlled loop
 
    }

    //----Assign 7  End------------//    
    
}
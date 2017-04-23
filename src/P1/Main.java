
package P1;

import java.io.*; //needed for input/output

public class Main {
    public static void main (String[ ] args) throws IOException {

        FileInputStream fis1 = new FileInputStream("Presidents.txt");                // uses Presidents.txt as parse file
        BufferedReader br1 = new BufferedReader(new InputStreamReader(fis1));    // for an input file to be read//
        String inputString;  
	int  presNumber; // presidents number
        String presName; // presidents name
        String presCode; // presidents code
        int presYears;   // presin office
        String presParty; //presidents party
        String presHomeState; //presidents home state
        int maxSize=44; // max number of records
        String searchKey; // The value being read from compare parse
        PresidentsMDrvr presidentsdrvr;
        presidentsdrvr = new PresidentsMDrvr(maxSize);
        String inputString2;
        //---------------------------------------------------------------------------------------------------------------------------parser
        inputString = br1.readLine();   //reads one complete line (record) from the input file into inputString.
          //System.out.println("got to here");
          //System.out.println ("input line is: " + inputString);
          // Now you need to get to the parts of the inputString.  We call this ‘parsing’ the input.  
         while (inputString != null)        // looks at entire string you just read into inputString 
         {
                            presNumber = Integer.parseInt(inputString.substring(0, 2).trim()); //read president number
                            //System.out.println ("number is" + presNumber);
                            presName = inputString.substring(2, 24).trim();   //read president name
                            //System.out.println("name is" + presName);
                            presCode = inputString.substring(25,26).trim(); //read presidents code
                            //System.out.println("code is" + presCode);
                            presYears = Integer.parseInt(inputString.substring(27, 29).trim()); //read presidents years in office
                            //System.out.println("Year is" + presYears);
                            presParty = inputString.substring(29,48).trim(); //read presidents party
                            //System.out.println("name is" + presParty);
                            presHomeState = inputString.substring(49, 62); //read presidents home state 
                            //System.out.println("State is" + presHomeState);
                            //System.out.println(presNumber + presName + presCode + presYears + presParty + presHomeState); //test the parse
                            presidentsdrvr.insert(presNumber, presName, presCode, presYears, presParty, presHomeState); //inserts into array           
                            inputString = br1.readLine();    // read next input line.
         }  //end while loop
        br1.close();     //Close input file being read
        //------------------------------------------------------------------------------------------------------------------------ Sorted Array
        presidentsdrvr.bubbleSort();
        presidentsdrvr.bubbleSortHeader();
        presidentsdrvr.display(); //print the array
        //-------------------------------------------------------------------------------------------------------------------------- Seq Search 
        presidentsdrvr.seqSearchHeader(); // prints the sequential search header
        FileInputStream fis2 = new FileInputStream("PresidentsSearch.txt");                // uses PresidentsSearch.txt as parse file
        BufferedReader br2 = new BufferedReader(new InputStreamReader(fis2));    // for an input file to be read//
        inputString2 = br2.readLine();   //reads one complete line (record) from the input file into inputString
        while (inputString2 != null)        // looks at entire string you just read into inputString 
        {
        searchKey = inputString2.substring(0);
        //System.out.println("Search key is" + searchKey);
        presidentsdrvr.seqSearch(searchKey);
        inputString2 = br2.readLine();    // read next input line.     
        }// end while loop
         br2.close();     //Close input file being read
         //-------------------------------------------------------------------------------------------------------------------------Binary Search
         presidentsdrvr.binSearchTerms(); // runs the  bin search
         //System.out.println(presidentsdrvr);
} //end main
} //end class

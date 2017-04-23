/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P1;

import java.util.Arrays;

/**
 *
 * @author jerrad
 */
public class PresidentsMDrvr {
    
   private Presidents[] myPresidents; // ref to array presidents array
   private int nElems; // number of data items
   private String [] presidentTerms  = {"Andrew Jackson", "Abraham Lincoln", "Billy Bob", "George Patton", "Harry Truman", "XXX"};
   
 public PresidentsMDrvr(int max) 
    /**
     * constructor
     * @param  int max
     * @returns  void
     */
 {
     myPresidents = new Presidents[max];
     nElems = 0;
 } //end constructor
public void insert (int number, String name, String code, int years, String party, String homeState)
     /**
     * inserts data from parse into myPresidents array
     * @param   (int number, String name, String code, int years, String party, String homeState
     * @returns  void
     */
{
    myPresidents[nElems] = new Presidents(number, name, code, years, party, homeState);
    nElems++; // increment size 
}// end insert method
public void display()
        /**
     * displays data from the myPresidents array
     * @param none
     * @returns  void
     */
{
    for (int j= 0; j<nElems; j++)
      myPresidents[j].displayPresidents();
}// end display method
public void bubbleSort() 	
    /**
     * bubble sorts the myPresidents array
     * /@param   none
     * @returns  void
     */
{
    int out, in;			

    for(out=nElems-1; out>1; out--)   // outer loop (backward)
        for(in=0; in<out; in++)        // inner loop (forward)
            if( myPresidents[in].getNumber() > myPresidents[in+1].getNumber() )       
               swap(in, in+1);          // swap them
}  // end bubbleSort method
public void bubbleSortHeader()
    /**
     * prints the header for the bubble sort
     * /@param   none
     * @returns  void
     */
{
    System.out.printf("%2s\n%2s\t%-21s%-12s\n\n","\tSorted Presidents Array\n","Number", "Name","Party");//prints header for bubblesort  
}// end bubblesortHeader method

private void swap(int one, int two)
    /**
     * used to swap one index to another (used in bubble sort)
     * /@param int one, int two
     * @returns  void
     */
      {
      Presidents temp = myPresidents[one];
      myPresidents[one] = myPresidents[two];
      myPresidents[two] = temp;
      }//end swap method
public void seqSearch(String searchKey)  
    /**
     * performs a sequential search of the myPresidents array and prints the results
     * /@param  String searchKey
     * @returns  void
     */
{
    int hits;
    String result;
    hits = 0;
    
    for (int i=0; i<nElems; i++)
        if ((myPresidents[i].getParty()).compareTo(searchKey)==0)
            hits++;
    if (hits <1)
    result = "Not Found";
    else
    result = "Found";

    System.out.printf("%-22s\t", searchKey);//prints search srgument
    System.out.printf("%-12s\t\t", result);//prints result
    System.out.printf("%2s\n",hits); //prints number of hits       
}//end seqSearch method
public void seqSearchHeader() 
    /**
     * prints the header for the seq search
     * /@param  none
     * @returns  void
     */
{
    System.out.println("\n\t Results of Sequential Search on Party\n");  
    System.out.printf("%-22s\t", "Search Argument");
    System.out.printf("%-12s\t", "Result");
    System.out.printf("%2s\n\n","Number of Hits");
}//end seqSearchHeader method
private void bubbleSortName()
    /**
     * performs a bubble sort on the name field in the myPresidents array
     * /@param  none
     * @returns  void
     */
{
int out, in;			

    for(out=nElems-1; out>1; out--)   // outer loop (backward)
        for(in=0; in<out; in++)        // inner loop (forward)
            if(( myPresidents[in].getName()).compareTo(myPresidents[in+1].getName()) >0  )       
               swap(in, in+1);          // swap them
}  // end bubbleSortName method
public String binSearchTerms()
    /**
     * performs a binary search of myPresidents array
     * /@param  none
     * @returns  binaryKey
     */
{
String binaryKey="";
//System.out.print(Arrays.toString(presidentTerms)); test print array
displayBinSearchHeader();
for (int j=0; j<presidentTerms.length; j++)
    {   
    binaryKey = presidentTerms[j];
    binSearch(binaryKey);
    }
    return binaryKey;
}
private int binSearch(String binaryKey)
    /**
     * performs the search for each loop of the binSearchTerms and prints each result
     * /@param  String binaryKey
     * @returns  curIn, nElems, 
     */
{
    int lowerBound = 0;
    int upperBound = nElems-1;
    int curIn;
    int probe =0;
    String foundCode;
  
    bubbleSortName(); //Sorts to name collum to set up binary search for name
    //display(); //displays bubbleSortName to check sort
    //System.out.println("upper bound is" +upperBound);
    //System.out.println("lowerBound is" +lowerBound);
    //System.out.print("Binary key is "+ binaryKey +"");
    while(true)
    {
    curIn = (lowerBound + upperBound) /2;
    if((myPresidents[curIn].getName()).compareTo(binaryKey)==0)
    {   //System.out.println("curIn is: "  + curIn + "\n");
        foundCode = "Found";
        probe++;
        displayBinSearch(binaryKey, foundCode, probe);
        return curIn;  
    }// end if
    else if (lowerBound > upperBound)
    {
        foundCode = "Not Found";
        displayBinSearch(binaryKey, foundCode, probe);
        //System.out.print("Not Found" + nElems);
        return nElems;
    }//end else if   
    else
        {
            if((myPresidents[curIn].getName()).compareTo(binaryKey) < 0)
            {
                lowerBound = curIn +1;
                //System.out.print("curIn +1 is" + curIn + "\n");
                probe++;
            }//end else if    
            else
            {   
                upperBound = curIn -1;
                //System.out.print("curIn -1 is" + curIn + "\n");
                probe++;
            }// end else
        }//end else
    }//end while
}//end binarySearch method 
private void displayBinSearchHeader()
    /**
     * prints the header for the binary search
     * /@param  none
     * @returns  void
     */
{
System.out.println("\n\t Results of Binary Search\n");  
System.out.printf("%-22s\t", "Search Argument");
System.out.printf("%-12s\t", "Found or not Found");
System.out.printf("%2s\n\n","Number of Probes");
}
private void displayBinSearch(String binaryKey, String foundCode, int probe)
    /**
     * prints the data for the seq search
     * /@param  tring binaryKey, String foundCode, int probe
     * @returns  void
     */
{
System.out.printf("%-22s\t", binaryKey);
System.out.printf("%-12s\t\t\t", foundCode);
System.out.printf("%s\n", probe);
}
}//end PrsidentMDrvrv class

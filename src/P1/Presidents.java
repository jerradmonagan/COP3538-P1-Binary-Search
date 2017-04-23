

package P1;


public class Presidents
{
private int number;
private String name;
private String code;
private int years;
private String party;
private String homeState;
 //-------------------------------------------------------
public Presidents(int numberIn, String nameIn, String codeIn, int yearsIn, String partyIn, String homeStateIn)
{  
    number = numberIn;
    name = nameIn;
    code= codeIn;
    years = yearsIn;
    party =partyIn;
    homeState = homeStateIn;
    
}//end constructor
public void displayPresidents()
      /**
     * displays data from the myPresidents array
     * @param none
     * @returns  void
     */
{  
    System.out.printf("%2d\t%-21s%-12s\t\n", number, name,party);
}// end display method
 public int getNumber()
        /**
     * gets number from the myPresidents array
     * @param none
     * @returns number
     */
 {
    return number;
 }// end number getter
 public String getName()
     /**
     * gets name from the myPresidents array
     * @param none
     * @returns name
     */
 {
    return name;
 }// end name getter
 public String getCode()
       /**
     * gets code from the myPresidents array
     * @param none
     * @returns code
     */
 {
    return code;
 }// end code getter
 public int getYears()
       /**
     * gets years from the myPresidents array
     * @param none
     * @returns years
     */
 {
    return years;
 }//end years getter
 public String getParty()
        /**
     * gets party from the myPresidents array
     * @param none
     * @returns party
     */
 {
    return party;
 }// end party getter
 public String getHomeState()
       /**
     * gets state from the myPresidents array
     * @param none
     * @returns state
     */
 {
    return homeState;
 }// end homeState getter
 public String toString()
       /**
     * prints string for president object
     * @param none
     * @returns String
     */
 {
     return String.format("%2d\t%-21s%-12s\t\n", number, name, party);
  
 }//end toString method
}//end class
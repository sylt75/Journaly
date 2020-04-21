/*
 * Sylvia Tang
 * Due date: Friday January 18, 2018
 * ICS4U1 Mr.Fernandes
 * Program Name: Journaly
 * 
 * This program acts as a diary or journal for users to type whatever they choose in an entry, meant to help users be relieved of the
 * stress or anxiety they may feel at that moment. The application will display a recommendation to the user once they've 
 * finished writing their entry.
 * 
 * Features: user login, saving the entries you've written along with the date they were written, searching for keywords to give a
 * score to the entire entry, give the user a recommendation to help them feel better after writing their entry that's tailored
 * to the keywords found in their entry, buttons enlarge when mouse hovers over them
 * 
 * Major Skills: recursion, writing into a file, GUI features, using a timer, 
 * OOP-Object Oriented Programming(User and Score object), using mouse listener for special effects on buttons and action listener,
 * splitting string in separate components and reading them in from text area, comparing elements of an array to split string
 * 
 * 
 * Areas of Concern: Login screen does not save user's information after the program is closed, if no field is completed during
 * login the user will still be able to continue using the program, not able to create a log for users to look at their 
 * previously written journals due to time constraint, not enough time to include keyword search that incorporates searching for
 * adverbs that accompany the keywords
 */
public class Test {

	public static void main(String[] args) {
		
		//creates a new window for subsequent panels to be placed on
		new Window();
		
	}
	
}

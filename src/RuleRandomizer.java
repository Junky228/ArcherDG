/**This file will contain the Archer Drinking Game Rules in three seperate arrays.
 * It will also use the math module to create a random number, selecting rules from
 * each of the arrays.
 * @author Chris
 * @version 1.1
 */
import java.math.*;

public class RuleRandomizer {
	
	private String[] oneDrinkRules = {"Archer says do you not?", "Archer references his turtleneck", "Anyone has a drink in their hand", 
			"Lana says Yuuup or Nooope", "Cheryl doesn't understand what is being spoken about", "Cyril is shown being clingy", 
			"Anyone uses Archer's full name \"Sterling Malory Archer\"", "Lana’s large hands are referenced", "Cheryl (Carol, Carina, and Cristal) is thirsty", 
			"Lana's breasts jiggle (if you want to die of alcohol poisoning)", "Archer says \"phrasing\"", "Archer Drinks", "A gun is fired","Archer is shot" 
			"A Non-Bleeped \"Curse Word\"", "Ms. Archer's Horrible Parenting is mentioned", "Archer is called by his first name", "Malory breaks a glass",
			"Archer abuses pills and or other drugs", "A bleeped \"Curse Word\""};
	private String[] twoDrinkRules = {"Cheryl says anything BDSM related", "Pam says anything lesbian", "Brett gets injured(Or is referenced if later seasons)", 
			"Archer says \"I swear I had something for this...\"", "Archer references Burt Reynolds \"Gator\" \"White Lightening\" or any of Burt Reynold's films",
			"Cheryl is shown with bruise marks around her neck", "When Archer's butler Woodhouse first appears during an episode", "Krieger conducts an experiment",
			"Anyone says \"Hostile work environment\"", "either Archer or Lana ignore the other calling their name", "Archer says literally", 
			"Archer scolds Woodhouse", "Someone has sex", "Something explodes", "Archer goes \"wooooooooooooooooo\"", "Rival intelligence agencies are referenced",
			"Archer passes out","Archer says \"thats so classic her\"", "Someone is drinking a bloody-mary"};
	private String[] threeDrinkRules = {"Whenever Archer is referenced doing anything with his mom that's borderline incestual", "Archer says \"Dangerzone!\"", 
			"Pam has some form of sexual encounter", "Someone gets fired", "You hear Archers voicemail", "Lana loses an article of clothing", 
			"Archer doesn't understand something", "Archer hits a co-worker"};
	
	public void printRules(){
		/* Prints out the rules for the week. Uses the method below
		 * to ensure that there are no collisions.
		 */
		System.out.println("Tonight's rules are...\n");
		//Rule 1 set
		int r1RandomNumOne = (int)(Math.random()*oneDrinkRules.length);
		int r1RandomNumTwo = (int)(Math.random()*oneDrinkRules.length);
		r1RandomNumTwo = this.ensureNoCollision(r1RandomNumOne, -1, r1RandomNumTwo, true);
		int r1RandomNumThree = (int)(Math.random()*oneDrinkRules.length);
		r1RandomNumThree = this.ensureNoCollision(r1RandomNumOne, r1RandomNumTwo, r1RandomNumThree, true);
		
		//Rule 2 set
		int r2RandomNumOne = (int)(Math.random()*twoDrinkRules.length);
		int r2RandomNumTwo = (int)(Math.random()*twoDrinkRules.length);
		r2RandomNumTwo = this.ensureNoCollision(r2RandomNumOne, -1, r2RandomNumTwo, false);
		
		//Rule 3 set
		int r3RandomNum = (int)(Math.random()*threeDrinkRules.length);
		
		System.out.println("One Drink First Rule: "+ oneDrinkRules[r1RandomNumOne]);
		System.out.println("One Drink Second Rule: "+ oneDrinkRules[r1RandomNumTwo]);
		System.out.println("One Drink Third Rule: "+ oneDrinkRules[r1RandomNumThree]);
		
		System.out.println("Two Drinks First Rule: "+ twoDrinkRules[r2RandomNumOne]);
		System.out.println("Two Drinks Second Rule: "+ twoDrinkRules[r2RandomNumTwo]);
		
		System.out.println("Three Drinks Rule: "+ threeDrinkRules[r3RandomNum]);
		System.out.println();
		
		System.out.println("And always remember it's only a half an hour, stay away from Northside Men's if you go \n"
				+ "too hard, and at most you're only half as drunk as anyone in the show. Have fun, Dont die!");
	}
	public int ensureNoCollision(int checkOne, int checkTwo, int newNum, boolean isOneDrink){
		/* Checks that a new randomly generated number isn't the same as on preiously chosen.
		 * If being used to generate the second number checkTwo is set to -1(Acts as a null argument).
		 * If being used for the third number the previous two nubmers are entered.
		 * checkOne, checkTwo - The nubmers which a new number cannot be.
		 * newNum - The newly generated number which cannot be checkOne or checkTwo
		 * isOneDrink - If it is a one drink rule, set true, else false
		 */
		if(newNum == checkOne || newNum == checkTwo){
			if (isOneDrink){
				newNum = (int)(Math.random()*oneDrinkRules.length);
				return ensureNoCollision(checkOne, checkTwo, newNum, isOneDrink);
			}
			else{
				newNum = (int)(Math.random()*twoDrinkRules.length);
				return ensureNoCollision(checkOne, checkTwo, newNum, isOneDrink);
			}
			}
		else{
			return newNum;
		}
	}
	public static void main(String[] args){
		RuleRandomizer myRules = new RuleRandomizer();
		myRules.printRules();
	}
}
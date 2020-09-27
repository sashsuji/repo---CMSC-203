import java.util.Scanner;

public class RandomNumberGuesser {

//public attributes
	
	//RNG object named rando
	public static RNG rando = new RNG();
	//variables that hold the user's current/next guess, their highest guess,
	//and lowest guess.
	public static int nextGuess;
	public static int highGuess=100;
	public static int lowGuess=0;
	//basic scanner input variable
	public static Scanner input = new Scanner(System.in);
	//counter for invalid guesses
	public static int invalidGuesses=0;
	//counts the number of total guesses - number of invalid guesses
	public static int realGuesses=0;
	//char variable stores whether or not the user wants to play again
	public static char replay='y';
	
	public static void main(String[] args)
	{
		//print header
		System.out.println("Hello, this program is a number guessing game.");
		System.out.println("");
		//following while loop only executes during the first turn and when
		//the user wants to play again. it resets many public attributes and 
		//assigns a random number to the integer variable randNum
		//each time the user plays
		while (replay=='y') {
			rando.resetCount();
			int randNum=rando.rand();
			highGuess=100;
			lowGuess=0;
			invalidGuesses=0;
			realGuesses=0;
			//ask is the method used to prompt the user for guesses. more
			//explanation to follow.
			ask(randNum);
		}
		//when the user no longer wants to play, the following message is
		// printed and the program terminates
		System.out.println("Thanks for playing.\nProgrammer: Sash Sujith");
		System.exit(0);
	}
	
	// this method asks the user to input a guess. it then uses the utility
	//class's method to validate the input.
	//it then prints the number of guesses by subtracting the number of invalid
	//guesses from the total number of guesses.
	//to compare the guess to the number, it passes the random integer variable
	//to another method called compare()
	public static void ask(int random) 
	{
		// boolean that is true when the user's guessed # equals the random #
		boolean done = false;
//////////System.out.println(random);
		while(!done) {
			System.out.println("Enter a guess between " + lowGuess + " and " + highGuess);
			nextGuess = input.nextInt();
			//input validation
			while(!(rando.inputValidation(nextGuess, lowGuess, highGuess))) 
				{
					System.out.println("Enter a guess between " + lowGuess + " and " + highGuess);
					nextGuess = input.nextInt();
					invalidGuesses++;
				}
			//prints number of guesses
			realGuesses = rando.getCount() - invalidGuesses;
			System.out.println("Number of guesses: "+realGuesses);
			done = compare(random);
		}
		//when the user guesses correctly, the following message is displayed
		//and they are asked if they want to play again.
		System.out.println("Congratulations, you guessed correctly\nTry again? (y or n)");
		replay = input.next().charAt(0);		
		return;
	}
	
	//this method compares the user's guess to the random #
	//it returns a boolean value to ask() that is true when the
	//guess and random # are equivalent and false otherwise
	public static boolean compare(int randomNum) {
		if (nextGuess == randomNum)
		{
			return true;
		}
		//if the user's guess is higher than randomNum,
		//highGuess is assigned the user's latest guess
		if (nextGuess>randomNum)
		{
			highGuess=nextGuess;
			System.out.println("Your guess is too high.");
			return false;
		} 
		//if the user's guess is lower than randomNum,
		//it is assigned to lowGuess
		else 
		{
			lowGuess=nextGuess;
			System.out.println("Your guess is too low.");
			return false;
		}
	}
}

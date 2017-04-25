/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wordguess;
import java.util.Scanner;
/**
 *
 * @author brdin1728
 */
public class WordGuess {

    public static void main(String[] args) {
	final String SECRET_WORD = "BRAIN";
	final String FLAG = "!";
	String wordSoFar = "", updatedWord = "";
	String letterGuess, wordGuess = "";
        int numGuesses = 0;
        int playerScore = 100;
	Scanner input = new Scanner(System.in);
		
	
	System.out.println("WordGuess game.\n");
	for (int i = 0; i < SECRET_WORD.length(); i++) {
		wordSoFar += "-";								//word as dashes
		}
		System.out.println(wordSoFar + "\n");				//display dashes
	
		
		do {
			System.out.println("Enter a letter (" + FLAG + " to guess entire word): ");
			System.out.println("Player Score:" + playerScore);
                        letterGuess = input.nextLine();
			letterGuess = letterGuess.toUpperCase();			
			numGuesses += 1;
			playerScore -= 10;
			if (playerScore == 0) {
                            System.out.println("Player Score: 0 Sorry. You lose");
                            System.exit(0);
                        }	     
			if (SECRET_WORD.indexOf(letterGuess) >= 0) {
				updatedWord = wordSoFar.substring(0, SECRET_WORD.indexOf(letterGuess)); 
				updatedWord += letterGuess;												
				updatedWord += wordSoFar.substring(SECRET_WORD.indexOf(letterGuess)+1, wordSoFar.length());
				wordSoFar = updatedWord;
			}
                           
			System.out.println(wordSoFar + "\n");
		} while (!letterGuess.equals(FLAG) && !wordSoFar.equals(SECRET_WORD));
		if (letterGuess.equals(FLAG)) {
			System.out.println("What is your guess? ");
			wordGuess = input.nextLine();
			wordGuess = wordGuess.toUpperCase();
		}
		if (wordGuess.equals(SECRET_WORD) || wordSoFar.equals(SECRET_WORD)) {
			System.out.println("You won!");		
		} else {
                            System.out.println("Sorry. You lose");
                            
                        	
		}
		System.out.println("The secret word is " + SECRET_WORD);
		System.out.println("You made " + numGuesses + " guesses.");				
	}
}

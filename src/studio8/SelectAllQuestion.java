package studio8;

import support.cse131.NotYetImplementedException;

public class SelectAllQuestion extends MultipleChoiceQuestion {
	private String prompt;
	private String answer;
	private int points;
	private String[] choices;

	/**
	 * Constructor
	 * 
	 * @param prompt
	 * @param answer
	 * @param choices
	 */
	public SelectAllQuestion(String prompt, String answer, String[] choices) {
		super(prompt, answer, choices.length, choices);
	}
	
	/**
	 * Returns the amount of points scored by a provided givenAnswer
	 * @param String givenAnswer to check for points
	 */
	public int checkAnswer(String givenAnswer) {
		int pointsEarned = this.getPoints();
		for (int i = 0; i < super.getChoices().length; i++) {
			if (super.getAnswer().contains(super.getChoices()[i])) { //Choice is correct
				if (givenAnswer.contains(super.getChoices()[i]) == false) { //Correct choice was not chosen
					pointsEarned -= 1;
				}
			} else { // Choice is incorrect
				if (givenAnswer.contains(super.getChoices()[i])) { //Incorrect choice was chosen
					pointsEarned -= 1;
				}
			}
		}
		return pointsEarned;
	}

	/**
	 * Count the amount of correct answers that are not in the provided givenAnswer
	 * @param givenAnswer
	 * @return int amount of missed correct answers
	 */
	private int findMissingCorrectAnswers(String givenAnswer) {
		String answer = this.getAnswer();
		//how many letters are in the correct answer but not the given answer?
		int incorrectValues = findMissingCharacters(givenAnswer, answer);
		return incorrectValues;
	}
	
	/**
	 * Count the amount of present answers that are not correct
	 * @param givenAnswer
	 * @return int amount of incorrect answers
	 */
	private int findIncorrectGivenAnswers(String givenAnswer) {
		String answer = this.getAnswer();
		//how many letters are in the given answer but not the correct answer?
		int incorrectValues = findMissingCharacters(answer, givenAnswer);
		return incorrectValues;
	}

	/**
	 * Returns the number of characters in toCheck that are missing from the
	 * baseString. For example findMissingValues("hi", "hoi") would return 1,
	 * 'o' is not in the baseString.
	 * 
	 * This method is marked static as it does not depend upon any instance variables
	 */
	private static int findMissingCharacters(String baseString, String toCheck) {
		int missingValues = 0;
		for(int i = 0; i < toCheck.length(); i++) {
			char characterToLocate = toCheck.charAt(i);
			if(baseString.indexOf(characterToLocate) == -1) { //not in baseString
				missingValues++;
			}
		}
		return missingValues;
	}	
	
	public static void main(String[] args) {	
		String[] testChoices = {"Bread", "Cake", "Apple", "Banana"};
		Question testQ = new SelectAllQuestion("What has gluten?", "Bread, Cake", testChoices);
		testQ.displayPrompt();
		System.out.println(testQ.checkAnswer("Banana, Apple"));
		System.out.println(testQ.checkAnswer("Apple"));
		System.out.println(testQ.checkAnswer("Cake"));
		System.out.println(testQ.checkAnswer("Cake, Bread"));
	}
	}

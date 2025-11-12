package studio8;

import support.cse131.NotYetImplementedException;

public class MultipleChoiceQuestion extends Question {
	private String prompt;
	private String answer;
	private int points;
	private String[] choices;

	/**
	 * Constructor
	 * @param prompt
	 * @param answer
	 * @param points
	 * @param choices
	 */
	public MultipleChoiceQuestion(String prompt, String answer, int points, String[] choices) {
		super(prompt, answer, points);
		this.choices = choices;
	}
	
	/**
	 * Display the prompt for the question in addition to 
	 * the choices present for the question.
	 */
	public void displayPrompt() {
		super.displayPrompt();
		for (int i = 0; i < choices.length; i++) {
			System.out.println((i + 1) + ". " + choices[i]);
		}
	}
	
	/**
	 * Getter method for the available choices
	 * @return String[] of choices
	 */
	public String[] getChoices() {
		return this.choices;
	}
	
	
	public static void main(String[] args) {
		String[] testChoices = {"One", "Two", "Three"};
		Question testQ = new MultipleChoiceQuestion("What is one plus one?", "Two", 1, testChoices);
		testQ.displayPrompt();
		System.out.println(testQ.checkAnswer("Two"));
		System.out.println(testQ.checkAnswer("Three"));
	}

}

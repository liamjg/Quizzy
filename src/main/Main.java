package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class Main {
	
	public static void main(String args[]) throws IOException {
		
		//open file containing questions
		File file = new File("test.txt");
		
		//parse the file of questions into objects
		Vector<Question> questions = parseQuestions(file);
		
		//start the user test
		startTest(questions);
	}
	
	//user test
	public static void startTest(Vector<Question> questions) {
		
		Vector<Question> shuffQuestions = questions;
		//randomize the order of the questions
		Collections.shuffle(shuffQuestions);
		
		//create scanner to get users answer
		Scanner scanner = new Scanner(System.in);
		
		//create variable to hold the score
		int score = 0;
		
		//for loop to iterate through the questions
		for(int i = 0; i < shuffQuestions.size(); i++) {
			
			//get the current question
			Question currQuestion = shuffQuestions.elementAt(i);
			
			//print the current question
			System.out.println(currQuestion.getQuestion());
			
			//check user's input against the answer
			//if the answer is correct print a message and increment the score
			if(currQuestion.checkAnswer(scanner.nextLine())) {
				System.out.println("Correct!" + '\n');
				score++;
			}else {
				System.out.println("INCORRECT" + '\n');
			}
			
			String scorePrint = "Score: " + score + "/" + shuffQuestions.size() + '\n';

			//print the current score. Give the user a message based on how many answers are correct
			if(i == shuffQuestions.size()-1) {
				System.out.println("Final " + scorePrint);
				if(score >= shuffQuestions.size()*0.6) {
					System.out.println("Good Job!");
				}else {
					System.out.println("Better luck next time...");
				}
			}else{
				System.out.println(scorePrint);
			}
		}
		
		scanner.close();
		
	}
	
	//question parsing method
	public static Vector<Question> parseQuestions(File file) throws IOException {
		//create vector to hold question objects
		Vector<Question> questions = new Vector<Question>();
		
		//parse the file passed into method. Use markers in the file to determine if there is a question or answer
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		       if(line.equals("~")) {
		    	   questions.add(new Question());
		       }else if(line.substring(0,2).equals("..")) {
		    	   questions.lastElement().setAnswer(line.substring(2));
		       }else {
		    	   questions.lastElement().setQuestion(line);
		       }
		       
		    }
		}
		return questions;
		
	}
	
}

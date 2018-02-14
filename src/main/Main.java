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
		
		File file = new File("test.txt");
		
		Vector<Question> questions = parseQuestions(file);
		
		startTest(questions);
	}
	
	public static void startTest(Vector<Question> questions) {
		
		Vector<Question> shuffQuestions = questions;
		Collections.shuffle(shuffQuestions);
		
		Scanner scanner = new Scanner(System.in);
		
		int score = 0;
		
		
		for(int i = 0; i < shuffQuestions.size(); i++) {
			
			Question currQuestion = shuffQuestions.elementAt(i);
			
			System.out.println(currQuestion.getQuestion());
			
			if(currQuestion.checkAnswer(scanner.nextLine())) {
				System.out.println("Correct!" + '\n');
				score++;
			}else {
				System.out.println("INCORRECT" + '\n');
			}
			
			String scorePrint = "Score: " + score + "/" + shuffQuestions.size() + '\n';

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
	
	public static Vector<Question> parseQuestions(File file) throws IOException {
		Vector<Question> questions = new Vector<Question>();
		
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

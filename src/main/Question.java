package main;

public class Question {
	
	private String quest;
	private String answer;

	//check the players answer against the given answer
	public boolean checkAnswer(String playerAns) {
		if(playerAns.toLowerCase().equals(answer.toLowerCase())){
			return true;
		}
		return false;
	}
	
	//set the question
	public void setQuestion(String x) {
		if(quest == null) {
			quest = x;
		}else {
			quest = quest + '\n' + x;
		}
		
	}
	
	//get the question
	public String getQuestion() {
		return quest;
	}
	
	//set the answer
	public void setAnswer(String x) {
		answer = x;
	}
	
	//get the answer
	public String getAnswer() {
		return answer;
	}
	
}

package main;

public class Question {
	
	private String quest;
	private String answer;

	public boolean checkAnswer(String playerAns) {
		if(playerAns.toLowerCase().equals(answer.toLowerCase())){
			return true;
		}
		return false;
	}
	
	public void setQuestion(String x) {
		if(quest == null) {
			quest = x;
		}else {
			quest = quest + '\n' + x;
		}
		
	}
	
	public String getQuestion() {
		return quest;
	}
	
	public void setAnswer(String x) {
		answer = x;
	}
	
	public String getAnswer() {
		return answer;
	}
	
}

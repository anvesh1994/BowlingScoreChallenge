
public class Bowling {

	private int index;
	private int firstRoll;
	private int secondRoll;
	private int thirdRoll;
	private int score;
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getFirstRoll() {
		return firstRoll;
	}
	public void setFirstRoll(int firstRoll) {
		this.firstRoll = firstRoll;
	}
	public int getSecondRoll() {
		return secondRoll;
	}
	public void setSecondRoll(int secondRoll) {
		this.secondRoll = secondRoll;
	}
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getThirdRoll() {
		return thirdRoll;
	}
	public void setThirdRoll(int thirdRoll) {
		this.thirdRoll = thirdRoll;
	}
	@Override
	public String toString() {
		return "Bowling [index=" + index + ", firstRoll=" + firstRoll + ", secondRoll=" + secondRoll + ", thirdRoll="
				+ thirdRoll + ", score=" + score + "]";
	}
}

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BowlingScoreCalculator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int noOfFrames = 10;

		List<Bowling> lst = new ArrayList<>();

		try {
			for (int i = 1; i <= noOfFrames; i++) {

				Bowling bowling = new Bowling();
				bowling.setIndex(i);
				System.out.printf("%n*** Frame %d ***", i);
				System.out.print("\nEnter result first  bowl: ");
				int firstRoll = scanner.nextInt();
				if (firstRoll >= 10) {
					bowling.setFirstRoll(firstRoll);
					bowling.setScore(firstRoll);
					handlingException(bowling);
				} else {
					System.out.print("Enter result second bowl: ");
					int secondRoll = scanner.nextInt();
					bowling.setFirstRoll(firstRoll);
					bowling.setSecondRoll(secondRoll);
					bowling.setScore(firstRoll + secondRoll);
					handlingException(bowling);
				}
				lst.add(bowling);

				if (i == 10 && lst.get(i - 1).getScore() == 10) {
					Bowling tenth_bowling = lst.get(i - 1);
					if (tenth_bowling.getFirstRoll() == 10) {
						System.out.print("\nEnter result second bowl: ");
						int tenth_second_roll = scanner.nextInt();
						System.out.print("\nEnter result third bowl: ");
						bowling.setSecondRoll(tenth_second_roll);
						int tenth_third_roll = scanner.nextInt();
						bowling.setThirdRoll(tenth_third_roll);
						bowling.setScore(tenth_bowling.getFirstRoll() + tenth_second_roll + tenth_third_roll);
					} else {
						System.out.print("\nEnter result third bowl: ");
						int tenth_third_roll = scanner.nextInt();
						int score = tenth_bowling.getScore();
						bowling.setThirdRoll(tenth_third_roll);
						bowling.setScore(score + tenth_third_roll);
					}
					lst.remove(i - 1);
					lst.add(bowling);
				}
			}

			int finalScore = calculateScore(lst);
			System.out.println("Total score is = " + finalScore);
			scanner.close();
		} catch (InputMismatchException exception) {
			throw new RuntimeException("invalid input");
		} catch (RuntimeException exception) {
			throw exception;
		} catch (Exception exception) {
			throw new RuntimeException("execution faild due to " + exception.getMessage());
		}
	}

	public static void handlingException(Bowling bowling) {
		if (bowling.getFirstRoll() > 10) {
			throw new RuntimeException("invalid first ball entry");
		} else if (bowling.getSecondRoll() > 10) {
			throw new RuntimeException("invalid second ball entry");
		} else if (bowling.getThirdRoll() > 10) {
			throw new RuntimeException("invalid third ball entry");
		} else if (bowling.getFirstRoll() + bowling.getSecondRoll() > 10) {
			throw new RuntimeException("invalid inputs");
		}
	}

	public static int calculateScore(List<Bowling> lst) {
		int finalScore = 0;
		for (int i = 0; i < lst.size(); i++) {
			Bowling bowling = lst.get(i);
			if (bowling.getFirstRoll() == 10) {
				finalScore += bowling.getFirstRoll();
				if ((i + 1) >= 10) {
					Bowling lastBowling = lst.get(lst.size() - 1);
					if (lastBowling.getFirstRoll() == 10) {
						finalScore += lastBowling.getFirstRoll();
						finalScore += lastBowling.getSecondRoll();
					}
				} else {
					Bowling firstNextBowling = lst.get(i + 1);
					if (firstNextBowling.getFirstRoll() == 10) {
						finalScore += firstNextBowling.getFirstRoll();
					} else {
						finalScore += firstNextBowling.getFirstRoll();
						finalScore += firstNextBowling.getSecondRoll();
					}
					if ((i + 1) == 10) {
						finalScore += firstNextBowling.getSecondRoll();
						finalScore += firstNextBowling.getThirdRoll();
					} else {
						Bowling secondNextBowling = lst.get((i + 2) - 1);
						if (secondNextBowling.getFirstRoll() == 10)
							finalScore += secondNextBowling.getFirstRoll();
					}
				}
			} else {
				if ((bowling.getFirstRoll() + bowling.getSecondRoll()) == 10) {
					if ((i + 1) == 10) {
						finalScore += bowling.getFirstRoll() + bowling.getSecondRoll() + bowling.getThirdRoll();
					} else {
						Bowling firstNextBowling = lst.get(i + 1);
						finalScore += bowling.getFirstRoll() + bowling.getSecondRoll()
								+ firstNextBowling.getFirstRoll();
					}
				} else {
					finalScore += bowling.getFirstRoll() + bowling.getSecondRoll();
				}
			}
		}
		return finalScore;
	}
}

package day1.problem1;

public class Problem1 {

	public static void main(String[] args) {
		int score=90;
		if (0<=score && score <=100) {
		score=score/10;
		switch (score) {
		case 9:
			System.out.println("Score is A");
			break;
		case 8:
			System.out.println("Score is B");
			
			break;
		case 7:
			System.out.println("Score is C");
			
			break;
		case 6:
			System.out.println("Score is D");
			
			break;
		case 5:
			System.out.println("Score is E");
			
			break;
		case 4,3,2,1:
			System.out.println("Score is F");
			
			break;

		default:
			break;
		}
		}
		else {
			System.out.println("score is invalid");
		}
	}

}
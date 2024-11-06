package day0.problem6;

public class Problem6 {

	public static void main(String[] args) {
		//brnmeyi bnvisid ke yek araye az nomarat students dashte bshe va done done
		//bege in student folan grade ro dare va bege ke balatrin nomre chi bude 
		int[] scores= {10,20,99,88,30,40,50,33,60,80,90};
		int best=0;
        for (int i=0;i<scores.length;i++) {
        	int score=scores[i];
        	best=max(score,best);
            String grade = switch (score / 10) {
                case 10, 9 -> "A";
                case 8 ->  "B";
                case 7 ->  "C";
                case 6 ->  "D";
                default ->  "F";
            };
			System.out.println("student " + i +" score is: " +score+" and grade is "+ grade);
			}
        System.out.println("best student score is "+best);
		}
		
	


	public static int max(int a, int b) {
		int max=0;
		if (max<a) {
			max=a;
		}
		return max;
		}
	
		
	}






public class StudentRanker{

	public static void main(String[] args) {
		
		char[][] answers = { { 'A', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D' },
				{ 'D', 'B', 'A', 'B', 'C', 'A', 'E', 'E', 'A', 'D' },
				{ 'E', 'D', 'D', 'A', 'C', 'B', 'E', 'E', 'A', 'D' },
				{ 'C', 'B', 'A', 'E', 'D', 'C', 'E', 'E', 'A', 'D' },
				{ 'A', 'B', 'D', 'C', 'C', 'D', 'E', 'E', 'A', 'D' },
				{ 'B', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D' },
				{ 'B', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D' },
				{ 'E', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D' } };
		
		char[] keys = { 'D', 'B', 'D', 'C', 'C', 'D', 'A', 'E', 'A', 'D' };

		
		int[][] stuScores = new int[answers.length][2];

		for (int i = 0; i < answers.length; i++) {
			int ptsCount = 0;

			for (int j = 0; j < answers[i].length; j++) {
				if (answers[i][j] == keys[j]) {
					ptsCount++;
				}

				stuScores[i][0] = ptsCount;
				stuScores[i][1] = i; 
			}
		}

		
		for (int i = 0; i < stuScores.length - 1; i++) {
		
			for (int j = i + 1; j < stuScores.length; j++) {
				if (stuScores[j][0] < stuScores[i][0]) {
					int[] temp = stuScores[i];
					stuScores[i] = stuScores[j];
					stuScores[j] = temp;
				}
			}

		}

		for (int a = 0; a < stuScores.length; a++) {
			System.out.println("Student " + stuScores[a][1] + ": " + stuScores[a][0]);
		}

	}

}

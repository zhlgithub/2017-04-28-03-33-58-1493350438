public class BowlingGame {
    public int getBowlingScore(String bowlingCode) {
       String res = bowlingCode.replaceAll("\\|", " ");
       cores = res.split("\\s+");
      int sum = 0;

		int len = cores.length;
		int[][] scores = createFrame(len, cores);

		for (int m = 0; m < (len == 10 ? len : len - 1); m++) {
			if (cores[m].length() == 1) {
				if (scores[m + 1][0] == 10 && m + 2 < len)
					sum += 10 + scores[m + 1][0] + scores[m + 2][0];
				else if (m + 1 < len)
					sum += 10 + scores[m + 1][0] + scores[m + 1][1];
			} else {
				if (scores[m][0] + scores[m][1] == 10 && m + 1 < len) {
					sum += 10 + scores[m + 1][0];
				} else {
					sum += scores[m][0] + scores[m][1];
				}
			}
		}

		return sum;
	}
    public static int[][] createFrame(int len, String[] cores) {
		int[][] frame = new int[len][2];

		for (int i = 0; i < len; i++) {
			for (int j = 0; j < 2; j++) {
				frame[i][j] = 0;
			}
		}

		for (int i = 0; i < len; i++) {
			if (cores[i].length() == 2) {
				frame[i][0] = resever(0, cores[i].charAt(0));
				frame[i][1] = resever(frame[i][0], cores[i].charAt(1));
			} else {
				frame[i][0] = resever(0, cores[i].charAt(0));
			}
		}
		return frame;
	}

	// 字符转换int
	public static int resever(int num, char ch) {
		int res = 0;
		switch (ch) {
		case 'X':
			res = 10;
			break;
		case '/':
			res = 10 - num;
			break;
		case '-':
			res = 0;
			break;
		default:
			res = Integer.parseInt(String.valueOf(ch));
		}
		return res;
	}
}

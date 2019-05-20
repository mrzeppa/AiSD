import java.util.List;

public class Naive {
    public String pattern;
    public String text;

    public Naive(String pattern, String text) {
        this.pattern = pattern;
        this.text = text;
    }

    public void findPattern(){
        int M = pattern.length();
        int N = text.length();
        for (int i = 0; i <= N - M; i++) {

            int j;

            /* For current index i, check for pattern
              match */
            for (j = 0; j < M; j++)
                if (text.charAt(i + j) != pattern.charAt(j))
                    break;

            if (j == M) // if pat[0...M-1] = txt[i, i+1, ...i+M-1]
                System.out.println("Pattern found at index " + (i + 1));
        }
    }
}

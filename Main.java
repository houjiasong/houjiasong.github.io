import java.util.*;

public class Main {
    public static int n, m, k;
    public static int[] w, v;
    public static boolean[][] excl;
    public static int maxVal = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        w = new int[n];
        v = new int[n];
        excl = new boolean[n][n];

        for (int i = 0;i < n; i++) {
            w[i] = scanner.nextInt();
            v[i] = scanner.nextInt();
        }

        for (int i = 0;i < k; i++) {
            int a = scanner.nextInt() - 1;
            int b = scanner.nextInt() - 1;
            excl[a][b] = true;
            excl[b][a] = true;
        }

        dfs(0,0,0, new boolean[n]);
        System.out.println(maxVal);
    }

    public static void dfs(int i, int curW, int curVal, boolean[] picked) {
        if (i == n) {
            maxVal = Math.max(maxVal, curVal);
            return;
        }
        dfs(i+1, curW, curVal, picked);
        if (curW + w[i] <= m && !ban(i,picked)) {
            picked[i] = true;
            dfs(i+1, curW + w[i], curVal + v[i], picked);
            picked[i] = false;
        }

    }

    public static boolean ban(int item, boolean[] picked) {
        for (int i = 0; i < n; i++) {
            if (picked[i] && excl[item][i]) {
                return true;
            }
        }
        return false;
    }
}
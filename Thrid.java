import java.util.Scanner;

public class Thrid {
    private static final int N = 100010;
    private static long[] a = new long[N];
    private static long[] s = new long[N];
    private static long[] cc = new long[2];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextLong();
            if (a[i] == 1) {
                a[i] = 1;
            }
            if (a[i] == 0) {
                a[i] = -1;
            }
            s[i] = s[i - 1] + a[i];
        }

        long t = cc[0] - cc[1];
        
        long v = 0, vv = 0, kk = 0, k = 0;
        for (int i = 1; i <= n; i++) {
            kk = Math.max(kk, s[i] - v);
            v = Math.min(v, s[i]);
            k = Math.min(k, s[i] - vv);
            vv = Math.max(vv, s[i]);
        }
        
        long y = s[n] - k * 2;
        long x = s[n] - kk * 2;
        long res;
        if (x >= 0) {
            res = (x - y) / 2 + 1;
        } else if (y <= 0) {
            res = (x - y) / 2 + 1;
        } else {
            long z = Math.max(Math.abs(x), Math.abs(y));
            if (y % 2 == 1) {
                res = (z + 1) / 2;
            } else {
                res = z / 2 + 1;
            }
        }
        
        System.out.println(res);
    }
}


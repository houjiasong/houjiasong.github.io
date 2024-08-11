import java.util.*;

public class One {
    static final int N = 100010;
    static int n;
    static Ai[] q = new Ai[N];

    static class Ai {
        long p, x, d;

        Ai(long p, long x, long d) {
            this.p = p;
            this.x = x;
            this.d = d;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            long p = sc.nextLong();
            long x = sc.nextLong();
            long d = sc.nextLong();
            q[i] = new Ai(p, x, d);
        }

        Arrays.sort(q, 1, n + 1, Comparator.comparingLong(a -> a.p));

        long last = 0;
        long res = 0;

        for (int i = 1; i <= n; i++) {
            long x = q[i].x;
            long d = q[i].d;
            long l = 0;
            long r = 1000000000;

            while (l < r) {
                long mid = (l + r) / 2;
                if (x + mid * d > last) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }

            last = x + l * d;
            res = Math.max(res, last);
        }

        System.out.println(res);
    }
}


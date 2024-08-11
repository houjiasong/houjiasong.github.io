import java.util.*;

public class Two {
    static final int N = 100010;
    static int n;

    static class Ai {
        int t, w;

        Ai(int t, int w) {
            this.t = t;
            this.w = w;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        Ai[] q = new Ai[n + 1];

        for (int i = 1; i <= n; i++) {
            q[i] = new Ai(sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(q, 1, n + 1, new Comparator<Ai>() {
            @Override
            public int compare(Ai x, Ai y) {
                if (x.t == y.t) return Integer.compare(x.w, y.w);
                return Integer.compare(x.t, y.t);
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int cc = 0, res = 0, id = 1;

        while (id <= n || !pq.isEmpty()) {
            while (id <= n && q[id].t <= cc) {
                pq.add(q[id].w);
                id++;
            }

            if (pq.isEmpty()) {
                if (id <= n) {
                    cc = q[id].t;
                    continue;
                }
                break;
            }

            int t = pq.poll();
            cc += t;
            res += (cc - q[id - 1].t);
        }

        System.out.println(res);
    }
}


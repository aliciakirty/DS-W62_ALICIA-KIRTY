import java.util.*;

class Letter {
    String name;
    int priority;
    int remaining;

    public Letter(String name, int duration, int priority) {
        this.name = name;
        this.priority = priority;
        this.remaining = duration;
    }
}

public class Queue1 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            if (!sc.hasNextInt()) return;
            int n = sc.nextInt();

            List<Letter> all = new ArrayList<>();
            int minPriority = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                Letter l = new Letter(sc.next(), sc.nextInt(), sc.nextInt());
                all.add(l);
                if (l.priority < minPriority) minPriority = l.priority;
            }

            List<Letter> pending = new ArrayList<>();
            List<Letter> queued = new ArrayList<>();
            List<Letter> sent = new ArrayList<>();

            for (Letter l : all) {
                if (l.priority == minPriority) queued.add(l);
                else pending.add(l);
            }

            int time = 1;
            while (true) {
                printStatus(time, pending, queued, sent);
                
                if (sent.size() == n) break;
                
                List<Letter> toMove = new ArrayList<>();
                for (Letter l : queued) {
                    l.remaining--;
                    if (l.remaining <= 0) {
                        toMove.add(l);
                    }
                }
                
                boolean anyFinished = !toMove.isEmpty();
                for (Letter finished : toMove) {
                    queued.remove(finished);
                    sent.add(finished);
                }

                if (anyFinished && !pending.isEmpty()) {
                    queued.addAll(pending);
                    pending.clear();
                }

                time++;
                if (time > 100) break;
            }
        }
    }

    private static void printStatus(int time, List<Letter> pending, List<Letter> queued, List<Letter> sent) {
        StringBuilder sb = new StringBuilder();
        sb.append(time).append(" ");

        for (Letter l : pending) sb.append(l.name).append(" ");
        sb.append("| ");

        List<Letter> sortedQueued = new ArrayList<>(queued);
        sortedQueued.sort(Comparator.comparing(l -> l.name));
        for (Letter l : sortedQueued) sb.append(l.name).append(" ");
        sb.append("| ");

        List<Letter> sortedSent = new ArrayList<>(sent);
        sortedSent.sort(Comparator.comparing(l -> l.name));
        for (Letter l : sortedSent) sb.append(l.name).append(" ");

        System.out.println(sb.toString().trim());
    }
}
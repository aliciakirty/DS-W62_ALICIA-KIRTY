import java.util.*;

class Visitor {
    String name;
    int money;

    Visitor(String name, int money) {
        this.name = name;
        this.money = money;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class Queue4 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = Integer.parseInt(sc.nextLine());

            String[] namesInput = sc.nextLine().split(", ");
            String[] moneyInput = sc.nextLine().split(", ");
            
            List<Visitor> queue = new ArrayList<>();
            
            for (int i = 0; i < n; i++) {
                String name = namesInput[i].trim();
                int money = Integer.parseInt(moneyInput[i].trim());
                
                if (name.equalsIgnoreCase("Jeff")) {
                    continue;
                }
                queue.add(new Visitor(name, money));
            }

            Collections.sort(queue, (v1, v2) -> Integer.compare(v2.money, v1.money));

            System.out.println(queue);
        }
    }
}
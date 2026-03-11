import java.util.*;

class Student {
    String name;
    int chances;

    Student(String name, int chances) {
        this.name = name;
        this.chances = chances;
    }
}

public class Queue3 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            if (!sc.hasNextInt()) return;
            int n = sc.nextInt();
            sc.nextLine();
            
            String[] names = sc.nextLine().split(" ");
            
            int[] chances = new int[n];
            for (int i = 0; i < n; i++) {
                chances[i] = sc.nextInt();
            }
            
            Queue<Student> queue = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                queue.add(new Student(names[i], chances[i]));
            }
            
            while (!queue.isEmpty()) {
                Student current = queue.poll();
                current.chances--;
                
                if (current.chances > 0) {
                    System.out.println(current.name + "|Try Again|" + current.chances);
                    queue.add(current);
                } else {
                    System.out.println(current.name + "|Get Out|0");
                }
            }
        }
    }
}
import java.util.*;

public class todolist {
    static Scanner sc = new Scanner(System.in);
    static String tasks[] = new String[100];
    static boolean done[] = new boolean[100];
    static int count = 0;

    public static void addtask() {
        System.out.println("Add your Task here:-");
        sc.nextLine(); // consume leftover newline
        tasks[count] = sc.nextLine();
        done[count] = false;
        count++;
        System.out.println("Task added!");
    }

    public static void viewtask() {
        if (count == 0) {
            System.out.println("No task Added.");
        } else {
            for (int i = 0; i < count; i++) {
                String status = done[i] ? "[Done]" : "[Pending]";
                System.out.println((i + 1) + ". " + tasks[i] + " " + status);
            }
        }
    }

    public static void deletetask() {
        if (count == 0) {
            System.out.println("No tasks to delete.");
            return;
        }
        viewtask();
        System.out.println("Enter task number to delete:");
        int num = sc.nextInt();
        if (num < 1 || num > count) {
            System.out.println("Invalid task number.");
            return;
        }
        for (int i = num - 1; i < count - 1; i++) {
            tasks[i] = tasks[i + 1];
            done[i] = done[i + 1];
        }
        count--;
        System.out.println("Task deleted!");
    }

    public static void taskdone() {
        if (count == 0) {
            System.out.println("No tasks available.");
            return;
        }
        viewtask();
        System.out.println("Enter task number to mark as done:");
        int num = sc.nextInt();
        if (num < 1 || num > count) {
            System.out.println("Invalid task number.");
            return;
        }
        done[num - 1] = true;
        System.out.println("Task marked as done!");
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nSelect from Menu:- ");
            System.out.println("1. Add task");
            System.out.println("2. View task");
            System.out.println("3. Delete task");
            System.out.println("4. Completed Task");
            System.out.println("5. Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> addtask();
                case 2 -> viewtask();
                case 3 -> deletetask();
                case 4 -> taskdone();
                case 5 -> {
                    System.out.println("Goodbye!");
                    sc.close();
                    return;
                }
                default -> System.out.println("INVALID CHOICE");
            }
        }
    }
}
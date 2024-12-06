/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package taskmanager;
import java.util.Scanner;


/**
 *
 * @author BaranNarravula
 */
public class TaskManagerApp {
    private static Scanner scanner = new Scanner(System.in);
    private static TaskManager taskManager = new TaskManager();

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    markTaskAsCompleted();
                    break;
                case 4:
                    removeTask();
                    break;
                case 5:
                    System.out.println("Exiting Task Manager. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n--- Task Manager ---");
        System.out.println("1. Add Task");
        System.out.println("2. View Tasks");
        System.out.println("3. Mark Task as Completed");
        System.out.println("4. Remove Task");
        System.out.println("5. Exit");
    }

    private static int getUserChoice() {
        System.out.print("Enter your choice (1-5): ");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void addTask() {
        System.out.print("Enter task name: ");
        String taskName = scanner.nextLine();

        System.out.print("Do you want to add a deadline? (y/n): ");
        String deadlineChoice = scanner.nextLine().toLowerCase();

        String deadline = null;
        if (deadlineChoice.equals("y")) {
            System.out.print("Enter deadline: ");
            deadline = scanner.nextLine();
        }

        taskManager.addTask(taskName, deadline);
    }

    private static void viewTasks() {
        taskManager.viewTasks();
    }

    private static void markTaskAsCompleted() {
        taskManager.viewTasks();
        System.out.print("Enter the task number to mark as completed: ");
        try {
            int taskNumber = Integer.parseInt(scanner.nextLine());
            taskManager.markTaskAsCompleted(taskNumber);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }

    private static void removeTask() {
        taskManager.viewTasks();
        System.out.print("Enter the task number to remove: ");
        try {
            int taskNumber = Integer.parseInt(scanner.nextLine());
            taskManager.removeTask(taskNumber);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }
}
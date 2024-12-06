/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskmanager;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BaranNarravula
 */

public class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(String taskName, String deadline) {
        Task task = (deadline != null && !deadline.trim().isEmpty()) 
            ? new Task(taskName, deadline) 
            : new Task(taskName);
        tasks.add(task);
        System.out.println("Task '" + taskName + "' added successfully!");
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found. Add a task to get started!");
            return;
        }

        System.out.println("\n--- Current Tasks ---");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    public void markTaskAsCompleted(int taskNumber) {
        try {
            Task task = tasks.get(taskNumber - 1);
            task.markAsCompleted();
            System.out.println("Task '" + task.getTaskName() + "' marked as completed!");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid task number. Please try again.");
        }
    }

    public void removeTask(int taskNumber) {
        try {
            Task removedTask = tasks.remove(taskNumber - 1);
            System.out.println("Task '" + removedTask.getTaskName() + "' removed successfully!");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid task number. Please try again.");
        }
    }
}

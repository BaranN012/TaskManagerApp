/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskmanager;

/**
 *
 * @author BaranNarravula
 */
public class Task {
    private String taskName;
    private String deadline;
    private String status;

    public Task(String taskName, String deadline) {
        this.taskName = taskName;
        this.deadline = deadline;
        this.status = "pending";
    }

    public Task(String taskName) {
        this(taskName, null);
    }

    public String getTaskName() {
        return taskName;
    }

    public String getDeadline() {
        return deadline;
    }

    public String getStatus() {
        return status;
    }

    public void markAsCompleted() {
        this.status = "completed";
    }

    @Override
    public String toString() {
        String deadlineInfo = (deadline != null) ? " (Deadline: " + deadline + ")" : "";
        return taskName + deadlineInfo + " - Status: " + status;
    }
}

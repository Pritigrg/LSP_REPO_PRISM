package org.howard.edu.lspfinal.question2;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * TaskManager class to manage tasks.
 * It allows adding, retrieving, updating, and printing tasks grouped by their status.
 */
public class TaskManager {
    private static final List<String> STATUS = List.of("TODO", "IN_PROGRESS", "DONE");


    private Map<String, Task> tasks = new HashMap<>();


    /**
     * Default constructor
     * */
    public TaskManager() {
    }


    /**
     * Constructor with a map of tasks
     * @param tasks Map of tasks where the key is the task name and the value is the Task object
     */
    public TaskManager(Map<String, Task> tasks) {
        this.tasks = tasks;
    }


    /**
     * Adds a task to the task manager
     * @param name
     * @param priority
     * @param status
     * @throws DuplicateTaskException if a task with the same name already exists
     */
    public void addTask(String name, int priority, String status) throws DuplicateTaskException {
        if (tasks.containsKey(name)) {
            throw new DuplicateTaskException("Task '" + name + "' already exists.");
        }
        if (!STATUS.contains(status)) {
            throw new IllegalArgumentException("Invalid status. Allowed values are: " + STATUS);
        }
        Task task = new Task(name, priority, status);
        tasks.put(name, task);
    }


    /**
     * Retrieves a task by its name
     * @param name
     * @return Task object
     * @throws TaskNotFoundException if the task is not found
     */
    public Task getTaskByName(String name) throws TaskNotFoundException {
        if (!tasks.containsKey(name)) {
            throw new TaskNotFoundException("Task '" + name + "' not found.");
        }


        return tasks.get(name);
    }




    /**
     * Updates the status of a task
     * @param name
     * @param newStatus
     * @throws TaskNotFoundException if the task is not found
     */
    public void updateStatus(String name, String newStatus) throws TaskNotFoundException {
        if (!STATUS.contains(newStatus)) {
            throw new IllegalArgumentException("Invalid status. Allowed values are: " + STATUS);
        }
        Task task = getTaskByName(name);
        task.setStatus(newStatus);
    }


    /**
     * Prints all tasks grouped by their status
     */
    public void printTasksGroupedByStatus() {
        Map<String, List<Task>> groupedTasks = new HashMap<>();
        for (String s : STATUS) {
            groupedTasks.put(s, new ArrayList<>());
        }
        for (Task task : tasks.values()) {
            groupedTasks.get(task.getStatus()).add(task);
        }
        System.out.println("Tasks grouped by status:");
        for (String s : STATUS) {
            System.out.println(s + ":");
            for (Task task : groupedTasks.get(s)) {
                System.out.println(task);
            }
        }
    }
}

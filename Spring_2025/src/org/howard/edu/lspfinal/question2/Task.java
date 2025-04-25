package org.howard.edu.lspfinal.question2;


public class Task {
    private String name;
    private int priority;
    private String status;


    /**
     * Constructor for Task
     * @param name
     * @param priority
     * @param status
     */
    public Task(String name, int priority, String status) {
        this.name = name;
        this.priority = priority;
        this.status = status;
    }


    /**
     * Setters the name of the task
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Setters the priority of the task
     * @param priority
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }


    /**
     * Setters the status of the task
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }


    /**
     * Getters the name of the task
     * @return name
     */
    public String getName() {
        return name;
    }


    /**
     * Getters the priority of the task
     * @return priority
     */
    public int getPriority() {
        return priority;
    }


    /**
     * Getters the status of the task
     * @return status
     */
    public String getStatus() {
        return status;
    }


    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", priority=" + priority +
                ", status='" + status + '\'' +
                '}';
    }
}

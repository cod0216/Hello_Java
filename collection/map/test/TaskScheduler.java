package collection.map.test;

import java.util.*;

public class TaskScheduler {
    private Queue<Task> tasks = new ArrayDeque<>();

    public void addTask(Task task){
        tasks.offer(task);
    }
    public int getRemainingTasks(){
        return tasks.size();
    }
    public void processNextTask(){
        Task task = tasks.poll();
        task.execute();
    }
}

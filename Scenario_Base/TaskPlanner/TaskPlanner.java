import java.util.LinkedList;

public class TaskPlanner {
    LinkedList<Task> taskList = new LinkedList<>();

    public void addTask(Task task) {
        taskList.add(task);
    }

    public void showTasks() {
        for (Task task : taskList) {
            task.execute();
        }
    }

    public void search(String keyword) {
        boolean found = false;
        for (Task t : taskList) {
            if (t.getDescription().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println("Found: " + t.getDescription());
                found = true;
            }
        }
        if (!found) System.out.println("Task not found.");
    }
}

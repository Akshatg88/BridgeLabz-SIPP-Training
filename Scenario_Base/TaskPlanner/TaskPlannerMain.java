public class TaskPlannerMain {
    public static void main(String[] args) {
        TaskPlanner planner = new TaskPlanner();

        planner.addTask(new Meeting("Project Sync at 10 AM"));
        planner.addTask(new Workout("Morning Yoga"));
        planner.addTask(new CodingSession("Java OOP Practice"));

        planner.showTasks();
        planner.search("java");
        planner.search("lunch");
    }
}

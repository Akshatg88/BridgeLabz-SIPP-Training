interface MealPlan {
    String getPlan();
}

class VegetarianMeal implements MealPlan {
    public String getPlan() { return "Vegetarian Plan"; }
}

class VeganMeal implements MealPlan {
    public String getPlan() { return "Vegan Plan"; }
}

class KetoMeal implements MealPlan {
    public String getPlan() { return "Keto Plan"; }
}

class Meal<T extends MealPlan> {
    T plan;
    Meal(T plan) { this.plan = plan; }
    public void show() {
        System.out.println("Meal Plan: " + plan.getPlan());
    }

    public static <T extends MealPlan> void validateAndGenerate(T plan) {
        System.out.println("Generating valid plan: " + plan.getPlan());
    }
}

public class MealPlanMain {
    public static void main(String[] args) {
        Meal<VegetarianMeal> vegMeal = new Meal<>(new VegetarianMeal());
        vegMeal.show();
        Meal.validateAndGenerate(new KetoMeal());
    }
}

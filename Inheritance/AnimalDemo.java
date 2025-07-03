// Animal.java
public class Animal {
    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void makeSound() {                     // will be overridden
        System.out.println("<generic animal sound>");
    }
}

// Dog.java
public class Dog extends Animal {
    public Dog(String name, int age) { super(name, age); }

    @Override
    public void makeSound() { System.out.println("Woof!"); }
}

// Cat.java
public class Cat extends Animal {
    public Cat(String name, int age) { super(name, age); }

    @Override
    public void makeSound() { System.out.println("Meow!"); }
}

// Bird.java
public class Bird extends Animal {
    public Bird(String name, int age) { super(name, age); }

    @Override
    public void makeSound() { System.out.println("Tweet!"); }
}

// AnimalDemo.java
public class AnimalDemo {
    public static void main(String[] args) {
        Animal[] zoo = {
            new Dog("Buddy", 3),
            new Cat("Misty", 2),
            new Bird("Tweety", 1)
        };

        for (Animal a : zoo) {
            System.out.print(a.getClass().getSimpleName() + " → ");
            a.makeSound();                         // polymorphic call
        }
    }
}

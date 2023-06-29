package com.ayokoding.cookbook.methods_basics;

public class JavaMethods {
  // 1. Method declaration and syntax
  public void makeSound() {
    System.out.println("Animal makes a sound");
  }

  // 2. Method parameters and arguments
  public void printName(String name) {
    System.out.println("Animal name: " + name);
  }

  // 3. Return types and the "void" keyword
  public String getSpecies() {
    return "Unknown";
  }

  // 4. Method overloading
  public void makeSound(String sound) {
    System.out.println("Animal makes sound: " + sound);
  }

  // 5. Access modifiers (public, private, protected) for methods
  public void publicMethod() {
    System.out.println("This is a public method");
  }

  private void privateMethod() {
    // Accessible only within the same class
    System.out.println("This is a private method");
  }

  protected void protectedMethod() {
    // Accessible within the same class and subclasses
  }

  // 6. Method scope and local variables
  public void printMessage() {
    String message = "Hello";
    System.out.println(message);
  }

  // 7. Recursion and recursive methods
  public int factorial(int n) {
    if (n == 0) {
      return 1;
    } else {
      return n * factorial(n - 1);
    }
  }

  // 8. Static methods and instance methods
  public static void staticMethod() {
    // Accessible without creating an instance
    System.out.println("This is a static method");
  }

  public void instanceMethod() {
    // Accessible on instances of the class
    System.out.println("This is an instance method");
  }

  // 9. Constructors and their role in method invocation
  public class Dog extends Animal {
    public Dog(String name) {
      super("Dog", name);
    }
  }

  // 10. Method references and functional interfaces
  public interface AnimalSound {
    void makeSound();
  }

  // 11. Lambda expressions and functional programming with methods
  AnimalSound animalSound = () -> System.out.println("Animal makes a sound");

  // 12. Exception handling within methods
  public void divide(int a, int b) {
    try {
      int result = a / b;
      System.out.println("Result: " + result);
    } catch (ArithmeticException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  // 13. Method documentation and Javadoc comments
  /**
   * Adds two numbers and returns the result.
   *
   * @param a the first number
   * @param b the second number
   * @return the sum of the two numbers
   */
  public int addNumbers(int a, int b) {
    return a + b;
  }

  public static void main(String[] args) {
    JavaMethods examples = new JavaMethods();

    // Example usage of methods
    examples.makeSound(); // Output: Animal makes a sound
    examples.printName("Lion"); // Output: Animal name: Lion

    String species = examples.getSpecies();
    System.out.println("Species: " + species); // Output: Species: Unknown

    examples.makeSound("Meow"); // Output: Animal makes sound: Meow

    examples.publicMethod(); // Output: This is a public method
    examples.printMessage(); // Output: Hello

    int factorialResult = examples.factorial(5);
    System.out.println("Factorial: " + factorialResult); // Output: Factorial: 120

    JavaMethods.staticMethod(); // Output: This is a static method

    examples.instanceMethod(); // Output: This is an instance method
    examples.privateMethod(); // Output: This is a private method

    AnimalBuilder builder = new AnimalBuilder();
    Animal animal = builder.setSpecies("Cat").setName("Tom").build();
    System.out.println("Animal name: " + animal.getName()); // Output: Animal name: Tom

    Animal dog = examples.new Dog("Buddy");
    dog.makeSound(); // Output: Dog makes a sound

    examples.divide(10, 2); // Output: Result: 5
    examples.divide(10, 0); // Output: Error: / by zero

    int sumResult = examples.addNumbers(2, 3); // You can see the documentation by hovering over the method in your IDE
    System.out.println("Sum: " + sumResult); // Output: Sum: 5
  }
}

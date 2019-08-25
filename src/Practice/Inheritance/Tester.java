package Practice.Inheritance;

public class Tester {

    /**
     * Exploring class inheritance permissions
     */
    public static void permissionsTest(){
        Child user = new Child(); // This will call Parent empty constructor first, then Child constructor
        user.name = "x";  // <OK> since Child inherits its 'name' from Parent (Public)
        user.title = "a"; // <OK > since Child inherits its 'name' from Parent (Protected)
        // user.age = 5;  // <COMPILATION error> since it's a private of Child
        // user.id = 0; // <COMPILATION error> since it's from Parent and it's Private
        Parent user2 = new Parent("userName");  // <OK> since it's calling Protected constructor of Parent
        // Parent user3 = new Parent(1); // <COMPILATION error> since it's calling Private constructor of Parent
    }

    /**
     * Exploring overridden methods
     */
    public static void overridingTest(){
        Child user = new Child(8);
        user.printName();
        user.printParentName(); // Will NOT work (child name will be printed) since the parent method is overridden
        user.printParentId(); // Will work since parent method was not overridden
        user.nickName = "ch"; // <OK> since we've overridden Parent private nickname
        Child user2 = new Child("user2");  // Will use Parent constructor
    }

    public static void abstractTest(){
        // Human user = new Human(); raises <COMPILATION error> since Human class is Abstract
        Man user = new Man(); // <OK> since we inherited the abstract class Human
        user.doNothing();
        user.doSomething();
    }

    public static void polymorphismTest (){
        Parent poly = new Child();
        // poly.play();  raises <COMPILATION error> since play method is only in Child class but not in Parent

        if(poly instanceof Child){
            System.out.println("Yes");
            // poly.play();  raises <COMPILATION error> even after if to verify it's a Child instance
        }
        ((Child) poly).play(); // <OK> this will work due the DownCasting
        poly.work();  // <OK> this method is only in Parent
        poly.speak(); // <OK> this method is on both, so Child method will be called

        try {
            Parent tmp = new Parent();
            ((Child)tmp).play(); // <RUNTIME error> the casting prevent the compiler to raise an error
            // Child inherits Parent but tmp is Parent object without polymorphism
        }
        catch (ClassCastException e){
            System.out.println("This line will raise Runtime Error");
        }
    }

    public static void castingTest() {
        Parent parent = new Parent();
        Child child = new Child();

        parent = child; // upCasting works

        // child = parent; // downCasting gets compilation errors
        child = (Child)(parent); // this will work since downCasting from parent to child allows, if you pass the compiler

        Human human = new Man();
        // child = (Child)(human); // this will get compilation error even with casting because classes are not related in inheritance
    }

    /**
     * You may want to run this with debugger to see how it works step by step
     */
    public static void main(String[] args){
        permissionsTest();
        overridingTest();
        abstractTest();
        polymorphismTest();
        castingTest();
    }
}


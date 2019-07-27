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
        Child user = new Child();
        user.printName();
        user.printParentName(); // Will NOT work (child name will be printed) since the parent method is overridden
        user.printParentId(); // Will work since parent method was not overridden
        user.nickName = "ch"; // <OK> since we've overridden Parent private nickname
    }


    public static void main(String[] args){
        permissionsTest();
        overridingTest();
    }
}


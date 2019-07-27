package Practice.Inheritance;

public abstract class Human {
    private String name;

    /**
     * <OK> although it's an abstract class, but it will never use
     */
    public Human(){
        name = "Human";
    }

    /**
     * Abstract method should be without body
     */
    public abstract void doNothing();

    /**
     * Abstract class can have methods
     */
    public void doSomething(){
        System.out.println("Human doing something");
    }
}

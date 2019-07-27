package Practice.Inheritance;


public class Man extends Human {

    /**
     * This method must either override Human abstract method or the Man class should also be declared as abstract
     */
    public void doNothing(){
    }

    public void doSomething() {
        super.doSomething();  // We call the parent method if we wish to use its implementation
    }

    /**
     * <COMPILATION error> - since it's not an abstract class
     */
//
//    public abstract void nothing(){
//
//    }
}

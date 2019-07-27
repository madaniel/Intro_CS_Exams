package Practice.Inheritance;

public class Child extends Parent {
    private double age;
    private int id;
    public String nickName;

    public Child() {
        System.out.println("Child empty constructor called");
        name = "ChildName";
        age = 10;
        id = 222;
    }

    public Child(int childAge) {
        super(); // <OK> but redundant
        age = childAge;
        // super(); Will raise <COMPILATION error> since it's should be in first line
    }

    public Child(String childName) {
        super(childName);  // Will use Parent constructor
    }

    public void printName() {
        System.out.println(this.name);
    }

    public void printParentName() {
        System.out.println("Calling printName method from child");
        super.printName();
    }

    public void printParentId() {
        System.out.println("Calling printId method from child");
        super.printId();
    }

    /**
     * <COMPILATION error> Public -> Protect permission, we can't hidden method from parent
     */
//    protected void doNothingInPublic(){
//        System.out.println("Parent do nothing in public");
//    }

    /**
     * <COMPILATION error> Public -> Private permission, we can't hidden method from parent
     */
//    private void doNothingInPublic(){
//        System.out.println("Parent do nothing in public");
//    }

    /**
     * <OK> Private -> Protected permission, we can expose methods from parent
     */
    protected void doNothingInPrivate(){
        System.out.println("Parent do nothing in private");
    }

    /**
     * <OK> Protected -> Public permission, we can expose methods from parent
     */
    public void doNothingInProtected(){
        System.out.println("Parent do nothing in protected");
    }

    public void play(){
        System.out.println("Child is playing");
    }

    public void speak(){
        System.out.println("Child is speaking");
    }
}





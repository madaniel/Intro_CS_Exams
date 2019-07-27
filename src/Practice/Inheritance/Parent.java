package Practice.Inheritance;

public class Parent {
    public String name;
    protected String title;
    private String nickName;
    private int id;

    /**
     * Removing the empty constructor will cause a *COMPILATION ERROR*
     * Since we've override the default constructor and made a child class
     * The child class will try to call the empty constructor and will fail
     */
    public Parent(){
        System.out.println("Parent empty constructor called");
        name = "ParentName";
        title = "Mr.";
        id = 111;
        nickName = "p";
    }

    /**
     * Constructor with argument, overrides the empty Constructor
     * @param personName name of Parent
     */
    protected Parent(String personName){
        System.out.println("Parent second constructor called");
        name = personName;
        id = 111;
    }

    /**
     * Constructor with argument, overrides the empty Constructor
     * @param id id of Parent
     */
    private Parent(int id){
        System.out.println("Parent third constructor called");
        id = 111;
    }

    public void printName(){
        System.out.println(this.name);
    }

    public void printId(){
        System.out.println(this.id);
    }

    public void doNothingInPublic(){
        System.out.println("Parent do nothing in public");
    }

    protected void doNothingInProtected(){
        System.out.println("Parent do nothing in protected");
    }

    private void doNothingInPrivate(){
        System.out.println("Parent do nothing in private");
    }




}

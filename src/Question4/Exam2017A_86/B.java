package Question4.Exam2017A_86;

public class B extends A {
    private int y;

    public B(){
        super(4);
        y = getX() + 2;
    }

    public B(int y){
        super();
        this.y = y;
        System.out.println(toString());
    }

    public void h(){
        System.out.println("In b's h");
    }

    public void f() {
        System.out.println("In B's f");
        g();
        h();
    }

    public String toSring(){
        return super.toString() + " Y: " + y;
    }



}

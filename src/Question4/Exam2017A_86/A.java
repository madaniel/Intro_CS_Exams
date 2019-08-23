package Question4.Exam2017A_86;

public class A {
    private int x;

    public A(){
        this.x = 3;
    }

    public A(int x){
        this.x = x;
        System.out.println(toString());
    }

    public int getX(){
        return x;
    }

    public void f(){
        if(x % 2 == 0)
            System.out.println("Even");
        System.out.println("In A's f");
        g();
    }

    public void g(){
        System.out.println("In A's g");
    }

    public String toString(){
        return "X: " + this.x;
    }
}

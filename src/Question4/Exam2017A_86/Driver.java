package Question4.Exam2017A_86;

public class Driver {

    public static void main(String [] args){
        // Question 1
        A a1 = new A ();
        a1.f();
        // Result:
        // In A's f
        // In A's g

        // Question 2
//      A a2 = new B(5);
//      a2.h();
        // Result: Compilation error.
        // Cause: There's no h() method in A class

        // Question 3
        A a3 = new B(2);
        B b1 = (B)a3;
        b1.f();
        // Result:
        // X: 3 (toString of class A called)
        // In B's f
        // In A's g
        // In b's h

        // Question 4
        A a4 = new B();
        a4.f();
        System.out.println(a4.toString());

        // Question 5
//      B b2 = (B)(new A(6));
//      System.out.println(b2.toString());
        // Result:
        // X: 6
        // <Runtime error>
        // Cause: new A(6) succeeded and print the toString
        // Next, we try to insert A instance to B class which is illegal - parent instance can't be in a child class
        // The casting to B silent the compiler so it won't fail but it is will fail in running

        // Question 6
        // B b3 = (A)(new B());
        // System.out.println(b3.toString());
        // Result:
        // <Compilation error>
        // Cause: We try to cast from different classes
    }
}

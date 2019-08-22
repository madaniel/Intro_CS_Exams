package Question4.Exam2018A_87;

public class Driver {

    public static void main (String [] args)
    {
        AAA a1 = new AAA(5);
        AAA a2 = new AAA(5);
        AAA ab = new BBB();
        BBB b1 = new BBB();
        BBB b2 = new BBB();

        // Question 1
        if (a1.equals(b1)) System.out.println(1);
        // Result - nothing printed.
        // Cause: equals() doesn't exist in AAA class - equals() inherited from Object and returned false

        // Question 2
        if (b1.equals(a1)) System.out.println(2);
        // Result - AAA
        // Cause: equals() of BBB called and "other" (a1) is AAA instance so "AAA" is printed

        // Question 3
        if (a1.equals(ab)) System.out.println(3);
        // Result - Nothing printed
        // Cause: equals() doesn't exist in AAA class - equals() inherited from Object and returned false

        // Question 4
        if (ab.equals(a1)) System.out.println(4);
        // Result - Object
        // Cause: equals() doesn't exist in AAA class BUT overridden in BBB class using same signature as Object class

        // Question 5
        if (b1.equals(ab)) System.out.println(5);
        // Result - AAA 5
        // Cause: equals() of BBB called and since ab is defined as AAA object (polymorphism) it use the one with (other AAA) and return true - hence the 5

        // Question 6
        if (ab.equals(b1)) System.out.println(6);
        // Result - Object 6
        // Cause - same as in Question 3, but this time b1 (other) is instance of BBB so it enter the if and returns true - hence the 6

        // Question 7
        if (a1.equals(a2)) System.out.println(7);
        // Result - Nothing printed
        // Cause - equals() doesn't exist in AAA class and a1 is not polymorphism of BBB so it's ignores it and uses Object equals() and returns false

        // Question 8
        if (b1.equals(b2)) System.out.println(8);
        // Result - BBB 8
        // Cause - equals() of BBB called and since b2 is a BBB instance it uses the one with (other BBB) and return true - hence the 8
    }
}

package Question4.Exam2018A_87;

public class BBB extends AAA {

    private String _st;
    public BBB ()
    {
        _st="bbb";
    }
    public BBB(String st, int val)
    {
        super(val);
        _st=st;
    }

    public String getSt()
    {
        return _st;
    }

    public boolean equals (Object other)
    {
        System.out.print("Object ");
        if (other instanceof BBB)
            return (_st.equals(((BBB)other)._st) &&
                    (getVal()==((BBB)other).getVal()));
        return false;
    }

    public boolean equals (AAA other)
    {
        System.out.print("AAA ");
        if (other instanceof BBB)
            return (_st.equals(((BBB)other)._st) &&
                    (getVal()==((BBB)other).getVal()));
        return false;
    }

    public boolean equals (BBB other)
    {
        System.out.print("BBB ");
        return (_st.equals(other._st)) &&
                (getVal()== other.getVal());
    }
}



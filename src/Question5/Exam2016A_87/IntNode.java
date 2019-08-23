package Question5.Exam2016A_87;

public class IntNode {
    private int _value;
    private IntNode _next;

    public IntNode(int val, IntNode n){
        _value = val;
        _next = n;
    }

    public int getValue(){
        return _value;
    }

    public IntNode getNext(){
        return _next;
    }

    public void setValue(int v){
        _value = v;
    }

    public void setNext(IntNode node){
        _next = node;
    }
}

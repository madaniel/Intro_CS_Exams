package Question5.Exam2016A_87;

public class IntList {

    private IntNode _head;

    public IntList(){
        _head = null;
    }

    public void what1(){
        IntNode newHead = null;
        IntNode cur;
        IntNode curNew;
        IntNode temp;

        for(cur=_head; cur != null; cur=cur.getNext()){
            temp = new IntNode(cur.getValue(), null);
            if(newHead == null)
                newHead = temp;
            else {
                for(curNew = newHead; curNew.getNext() != null; curNew = curNew.getNext())
                    if(curNew.getValue()%2 != curNew.getNext().getValue()%2)
                        break;
                temp.setNext(curNew.getNext());
                curNew.setNext(temp);
            }
        }
        _head = newHead;
    }

    public void what2(){
        IntNode newHead = null;
        IntNode cur, temp, last = null;
        for(cur=_head; cur!=null;cur=cur.getNext())
        {
            temp = new IntNode(cur.getValue(), null);
            if(newHead == null){
                newHead = temp;
                last = temp;
            }
            else {
                temp.setNext(last.getNext());
                last.setNext(temp);
                if(last.getValue()%2 == temp.getValue()%2)
                    last = temp;
            }
        }
        _head = newHead;
    }

    public static void main(String[] args){
        IntList lst = new IntList();
        IntNode n5 = new IntNode(5, null);
        IntNode n22 = new IntNode(2, n5);
        IntNode n3 = new IntNode(3, n22);
        IntNode n1 = new IntNode(1, n3);
        IntNode n2 = new IntNode(2, n1);
        lst._head = new IntNode(4, n2);

        lst.what1();









    }
}

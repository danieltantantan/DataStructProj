import java.util.*;

public class Node{    
    Object element;    
    Node next;    
        
    public Node(Object data) {    
        this.element = data;    
        this.next = null;    
    }
    public void  setNext(Node nextNode){
        this.next = nextNode;
    }
    public Node  getNext(){
        return next;
    }

    public Object getElement(){
        return element;
    }
}    

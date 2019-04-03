public class LinkListLab<T> {

    private Node<T> top;
    private Node<T> tail;
    private int size;

    public LinkListLab() {
        top = null;
        size = 0;
    }

    public int getLen() {
        return this.size;
    }

    public void insertBefore(int index, T data) {

        Node<T> temp;
        Node<T> newNode = new Node<>();
        newNode.setData(data);

        if (size == 0) {
            top = newNode;
        }
        if(size == 1 && index <= 1){
            newNode.setNext(top);
            top = newNode;
        }

        else {

            temp = top;
            for (int i = 0; i < index-1; i++) {
                temp = temp.getNext();
            }

            Node<T> oldNext=temp.getNext();
            temp.setNext(newNode);
            newNode.setNext(oldNext);
        }

        size++;
        setTail();
    }

    public void insertAfter(int index, T data) {
        Node<T> temp;
        Node<T> newNode = new Node<>();
        newNode.setData(data);

        if (size == 0) {
            top = newNode;
        }
        else if(size == 1 && index ==0){
            newNode.setNext(top);
            top = newNode;
        }
        else {

            temp = top;
            for (int i = 0; i < index; i++) {
                temp = temp.getNext();
            }
            Node<T> oldNext=temp.getNext();
            temp.setNext(newNode);
            newNode.setNext(oldNext);
        }

        size++;
        setTail();
    }

    public void setTail() {
        
        // Move to end of list
        Node<T> temp = this.top;
        while(true) {

            if(temp.getNext() != null) {
                temp = temp.getNext();
            }
            else {
                break;
            }
        }

        this.tail = temp;
    }

    public boolean removeTop() {

        if(this.size < 0) {
            return false;
        }

        this.top = this.top.getNext();
        --this.size;
        setTail();
        return true;
    }

    public boolean delAt(int index) throws IllegalArgumentException {
    
        if(index >= this.size || index < 0) {
            throw new IllegalArgumentException();
        }
    
        Node<T> temp = this.top;
        
        // Move to node before the one being removed
        for(int i=0; i < index-1; ++i) {

            if(temp != null) {
                temp = temp.getNext();
            }
            else {
                return false;
            }
        }

        Node<T> toRemove = temp.getNext();    
        temp.setNext(toRemove.getNext());

        --this.size;
        setTail();
        return true;
    }

    public void display() {
        Node<T> temp = top;

        System.out.println("_____List______");
        while(temp != null) {
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }

    public static void main(String[] args) {
        
        LinkListLab<String> list = new LinkListLab<String>();

        list.display();
        System.out.println("Current length = " + list.getLen());

        list.insertBefore(0, "apple");
        list.insertBefore(0, "pear");
        list.insertBefore(1, "peach");
        list.insertBefore(1, "cherry");
        list.insertBefore(3, "donut");
 
        list.insertAfter(0, "apple");
        list.insertAfter(0, "pear");
        list.insertAfter(1, "peach");
        list.insertAfter(1, "cherry");
        list.insertAfter(3, "donut");
        list.display();

        list.removeTop();
        list.delAt(4);
        list.delAt(2);
        list.delAt(0);
        list.removeTop();
        list.removeTop();
        list.display();

    }
}


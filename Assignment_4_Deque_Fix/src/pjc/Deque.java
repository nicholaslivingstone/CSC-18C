package pjc;

public class Deque<T> implements DequeInterface<T>
{
    // linked list containing the items in the deque
    private Node<T> head=null, tail=null;

    // current number of items in deque
    private int numberOfItems;

    // Queue constructor that starts with empty deque.
    public Deque()
    {
        numberOfItems=0; // no items yet!
    }
	
    // displays current contents of the deque
    public void display()
    {
        Node current=head;
        for(int i=0;i<numberOfItems;i++)
        {
            System.out.print(current.getValue()+" ");
            current=current.getNext();
        }
    }
	
    // ----- functions/methods in the interface that must be implemented -----

    // returns true if the deque is empty (no items in deque) 
    // false if deque is (has at least one or more items in deque)
    public boolean isEmpty()
    {
        return numberOfItems==0;
    }
	
	// return the number of items currently in the deque
    public int size()
    {
        return numberOfItems;
    }
 
    // returns the value of the item currently at front of deque
    public T front()
    {
        if ( head==null ) return null;
        return head.getValue(); // return item stored at head node
    }
	
    // returns the value of the item currently at the end of the deque
    public T back()
    {
        if ( tail==null ) return null;
        return tail.getValue(); // return item stored at tail node
    }
	
    // places parameter item onto the end of the deque
    public void push_back(T newItem)
    {
        // if head node is null, make head and tail node contain the first node
        if ( head == null)
        {
            head = new Node(newItem);
            tail=head; // when first item is enqueued, head and tail are the same
            numberOfItems++; // increment the number of items in the deque
        }
        else
        {
            Node<T> newNode = new Node(newItem);
            tail.setNext(newNode);
            newNode.setPrevious(tail);
            tail=newNode;
            numberOfItems++;
        }
    }
	
    public void enqueue_back(T newItem) // this is the same concept as push_back
    {
        this.push_back(newItem); // since it's the same as push_back, just call push_back
    }

    // returns and removes the current item at the front of the deque
    // the item that is in the deque behind the item becomes the new front item
    public T pop_front()
    {
	T headDataValue = null;
        if (numberOfItems == 1){
            headDataValue = head.getValue();
            head = tail = null; 
            numberOfItems = 0;
        }
        else if ( numberOfItems > 0 )
	{
            headDataValue = head.getValue();
            Node<T> oldHead=head;
            head=head.getNext();
            oldHead.setNext(null);
            oldHead.setPrevious(null);

            numberOfItems--;
        }
        return headDataValue;  // returns the data value from the popped head, null if deque empty
    }
	
    // returns and removes the current item at the back of the deque
    // the item that is in the deque in front of the item being removed becomes the new back item
    public T pop_back()
    {
	T tailDataValue = null;
        if (numberOfItems == 1){
            tailDataValue = tail.getValue();
            head = tail = null; 
            numberOfItems = 0;
        }
        else if ( numberOfItems > 0 )
	{
            tailDataValue = tail.getValue();
            Node<T> oldTail=tail;
            tail=tail.getPrevious();
            tail.setNext(null);
            oldTail.setPrevious(null);
            numberOfItems--;
        }
        return tailDataValue;  // returns the data value from the popped tail, null if deque empty
    }
    
    public T dequeue_back() // this is the same as pop_back
    {
        return this.pop_back();
    }
    
    public T dequeue_front() // this is the same concept as pop_front
    {
        return this.pop_front(); // since it's the same as pop_front, just call pop_front
    }
	
    public void enqueue_front(T newItem) // this is the same concept as push_front
    {
        this.push_front(newItem); // since it's the same as push_front, just call push_front
    }
    
    // places parameter item onto the end of the deque
    public void push_front(T newItem)
    {
        // if head node is null, make head and tail node contain the first node
        if ( head == null)
        {
            head = new Node(newItem);
            tail=head; // when first item is enqueued, head and tail are the same
            numberOfItems++; // increment the number of items in the deque
        }
        else
        {
            Node<T> newNode = new Node(newItem);
            newNode.setNext(head);
            head=newNode;
            head.getNext().setPrevious(head);
            numberOfItems++;
        }
    }
    
    // Node Inner Class
    private class Node<T> {
        private T value;
        private Node _previous, _next;

        public Node(T data) {
            value = data;
            _previous = null;
            _next = null;
        }
    
        protected Node(T data, Node previousNode, Node nextNode) {
            value = data;
            _previous = previousNode;
            _next = nextNode;
        }
		
        public Node getNext() {
            return _next;
        }

        public Node getPrevious() {
            return _previous;
        }

        public void setValue(T newValue)
        {
            value=newValue;
        }

        public T getValue() {
            return value;
        }

        public void setNext(Node newNextNode) {
            _next = newNextNode;
        }
		
        public void setPrevious(Node newPreviousNode) {
            _previous = newPreviousNode;
        }
    }
}
package scv1702.medium;

public class DesignLinkedList {
    class MyLinkedList {
        class Node {
            int val;
            Node prev;
            Node next;
            
            public Node(int val) {
                this.val = val;
            }
            
            public Node(int val, Node prev, Node next) {
                this.val = val;
                this.prev = prev;
                this.next = next;
            }
        }
        
        Node head;
        Node tail;
        int size;
        
        public MyLinkedList() {
                
        }
        
        public int get(int index) {
            if (head == null || index < 0) return -1;
            Node curr = head;
            for (int i = 0; i < index; i++) {
                curr = curr.next;
                if (curr == null) return -1;
            }
            return curr.val;
        }
        
        public void addAtHead(int val) {
            if (head == null) {
                head = new Node(val);
                tail = head;
                size += 1;
                return ;
            }
            Node newNode = new Node(val, null, head);
            head.prev = newNode;
            head = newNode;
            size += 1;
        }
        
        public void addAtTail(int val) {
            if (tail == null) {
                addAtHead(val);
                return ;
            }
            Node newNode = new Node(val, tail, null);
            tail.next = newNode;
            tail = newNode;
            size += 1;
        }
        
        public void addAtIndex(int index, int val) {
            if (index >= size+1) return ;
            if (index == 0) {
                addAtHead(val);
                return ;
            }
            if (index == size) {
                addAtTail(val);
                return ;
            }
            Node curr = head;
            for (int i = 0; i < index-1; i++) {
                curr = curr.next;
                if (curr == null) return ;
            }
            Node newNode = new Node(val, curr, curr.next);
            Node next = curr.next;
            curr.next = newNode;
            next.prev = newNode;
            size += 1;
        }
        
        public void deleteAtHead() {
            if (head == null) return ;
            head = head.next;
            if (head != null) head.prev = null;
            size -= 1;
        }
        
        public void deleteAtTail() {
            if (tail == null) return ;
            tail = tail.prev;
            if (tail != null) tail.next = null;
            size -= 1;
        }
        
        public void deleteAtIndex(int index) {
            if (index >= size) return ;
            if (index == 0) {
                deleteAtHead();
                return ;
            }
            if (index == size-1) {
                deleteAtTail();
                return ;
            }
            Node curr = head;
            for (int i = 0; i < index-1; i++) {
                curr = curr.next;
                if (curr == null) return ;
            }
            Node next = curr.next;
            curr.next = next.next;
            next.prev = curr;
            size -= 1;
        }
    }
}

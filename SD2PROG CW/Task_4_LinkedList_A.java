public class Task_4_LinkedList_A {

    Node head;
    public String data;

    public void insert(String data) {
        Node node = new Node();
        node.data = data;
        node.next = null;

        if (head == null) {
            head = node;
        } else {
            Node n = head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = node;
        }
    }

    public void delete() {
        head = head.next;

    }

}

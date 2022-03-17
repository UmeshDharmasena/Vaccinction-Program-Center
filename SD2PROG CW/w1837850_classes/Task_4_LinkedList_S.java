package w1837850_classes;
public class Task_4_LinkedList_S {

    Node head;
    public String data;

    public void insert(String data) {
        Node node = new Node();
        node.data = data;

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
        if (head.next != null) {
            head = head.next;
        }
    }

    public static String isEmpty() {
        String check = Task_4_LinkedList_S.isEmpty();
        return check;
    }
}

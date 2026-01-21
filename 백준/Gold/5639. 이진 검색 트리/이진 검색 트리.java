import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main {

    public static class Node {
        Node left;
        Node right;
        Integer value;

        public Node(Integer value) {
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String item;
        Node root = null;

        while ( (item = br.readLine()) != null ) {
            if (item.isEmpty()) break;
            Integer value = Integer.valueOf(item);
            Node ptr = search(root, value);
            if (ptr == null) {
                ptr = new Node(value);
                root = ptr;
            }
            else if (value < ptr.value) {
                ptr.left = new Node(value);
            } else {
                ptr.right = new Node(value);
            }
        }
        postOrder(root);
    }

    public static Node search(Node root, Integer item) {
        Node ptr = root;
        while (true) {
            if (root == null) return null;
            else if (item < ptr.value) {
                if (ptr.left == null)
                    return ptr;
                else
                    ptr = ptr.left;
            }
            else {
                if (ptr.right == null)
                    return ptr;
                else
                    ptr = ptr.right;
            }
        }
    }

    public static void postOrder(Node root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.value);
    }
}

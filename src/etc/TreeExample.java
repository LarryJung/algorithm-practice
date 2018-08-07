package etc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeExample {

    static class Node {
        String name;
        Node left;
        Node right;

        public Node(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println(root.name);
            inOrder(root.right);
        }
    }

    public void preOrder(Node root) {
        if (root != null) {
            System.out.println(root.name);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.name);
        }
    }

    public void levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            System.out.println("queue : " + queue);
            Node node = queue.poll();
            System.out.println(node.name);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public void levelOrderReverse(Node root) {
        Queue<Node> queue = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            stack.push(node);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        while(!stack.isEmpty()) {
            System.out.println(stack.pop().name);
        }
    }

    public static void main(String[] args) {
        TreeExample example = new TreeExample();
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");
        Node F = new Node("F");
        Node G = new Node("G");
        Node H = new Node("H");
        Node I = new Node("I");

        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        D.left = F;
        C.left = G;
        C.right = H;
        H.left = I;

        System.out.println("중위 순회");
        example.inOrder(A);
        System.out.println("전위 순회");
        example.preOrder(A);
        System.out.println("후위 순회");
        example.postOrder(A);
        System.out.println("레벨 순서");
        example.levelOrder(A);
        System.out.println("레벨 역순");
        example.levelOrderReverse(A);
    }

}

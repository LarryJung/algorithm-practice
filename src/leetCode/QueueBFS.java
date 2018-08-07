package leetCode;

import java.util.*;

public class QueueBFS {

    static class Node {
        char name;
        List<Node> subNodes = new ArrayList<>();
        Node(char name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(subNodes, node.subNodes);
        }
        @Override
        public int hashCode() {
            return Objects.hash(subNodes);
        }
    }

    static int BFS(Node root, Node target) {
        Queue<Node> queue = new LinkedList<>();
        int step = 0;       // number of steps neeeded from root to current node
        // initialize
        queue.add(root);

        // BFS
        while (!queue.isEmpty()) {
            step = step + 1;
            System.out.println("현재 스텝은 : " + step);
            // iterate the nodes which are already in the queue
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                Node cur = queue.poll();
                System.out.println("현재 노드는 " + cur.name);
                if (cur.equals(target)) {
                    System.out.println(target.name + " 노드를 찾았다");
                    return step;
                }
                for (Node next : cur.subNodes) {
                    System.out.println("스캔 " + next.name);
                    queue.add(next);
                }
            }
        }
        return -1;          // there is no path from root to target
    }

    public static void main(String[] args) {
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');

        A.subNodes.add(B);
        A.subNodes.add(C);
        A.subNodes.add(D);
        B.subNodes.add(E);
        C.subNodes.add(E);
        C.subNodes.add(F);
        F.subNodes.add(G);

        int minStep = QueueBFS.BFS(A, G);
        System.out.println("정답은 " + minStep + " 입니다.");

    }
}

package leetCode;

import java.util.*;

public class StackDFS {

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

    static boolean DFS(Node cur, Node target, Set<Node> visited) {
        System.out.println("탐색 노드 " +cur.name +", 타겟 노드 " + target.name);
        if (cur.equals(target)) {
            return true;
        }
        for (Node next : cur.subNodes) {
            System.out.println("next : " + next.name);
            if (!visited.contains(next)) {
                visited.add(next);
                return DFS(next, target, visited);
            }
        }
        return false;
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

        Set<Node> visited = new HashSet<>();
        System.out.println(DFS(A, G, visited));
    }

}

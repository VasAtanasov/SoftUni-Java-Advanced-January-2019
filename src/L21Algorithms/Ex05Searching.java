package L21Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex05Searching {
    private static BufferedReader reader;
    private static AVL<Integer> avl;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        avl = new AVL<>();
    }

    public static void main(String[] args) throws IOException {
        Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(avl::insert);

        int item = Integer.parseInt(reader.readLine());

        System.out.println(avl.indexOf(item));
    }

    private static class AVL<T extends Comparable<T>> {

        private int index = 0;
        private Node root;

        public boolean contains(T item) {
            Node node = this.search(this.root, item);
            return node != null;
        }

        public int indexOf(T item) {
            Node node = this.search(this.root, item);
            if (node != null) {
                return node.index;
            }
            return - 1;
        }

        public void insert(T item) {
            this.root = this.insert(this.root, item);
        }

        private Node insert(Node node, T item) {
            if (node == null) {
                return new Node(item, index++);
            }

            int cmp = item.compareTo(node.value);
            if (cmp < 0) {
                node.left = this.insert(node.left, item);
            } else if (cmp > 0) {
                node.right = this.insert(node.right, item);
            }

            this.updateHeight(node);
            return balance(node);
        }

        private Node balance(Node node) {
            int balance = this.balanceFactor(node);
            if (balance > 1) {
                int childBalance = this.balanceFactor(node.left);
                if (childBalance < 0) {
                    node.left = rotateLeft(node.left);
                }

                node = rotateRight(node);
            } else if (balance < - 1) {
                int childBalance = this.balanceFactor(node.right);
                if (childBalance > 0) {
                    node.right = rotateRight(node.right);
                }

                node = rotateLeft(node);
            }

            return node;
        }

        private Node rotateRight(Node node) {
            Node left = node.left;
            node.left = left.right;
            left.right = node;

            updateHeight(node);
            left.height = Math.max(this.height(node), this.height(left.left)) + 1;

            return left;
        }

        private Node rotateLeft(Node node) {
            Node right = node.right;
            node.right = right.left;
            right.left = node;

            updateHeight(node);
            right.height = Math.max(this.height(node), this.height(right.right)) + 1;

            return right;
        }

        private Node search(Node node, T item) {
            if (node == null) {
                return null;
            }

            int cmp = item.compareTo(node.value);
            if (cmp < 0) {
                return search(node.left, item);
            } else if (cmp > 0) {
                return search(node.right, item);
            }

            return node;
        }

        private int balanceFactor(Node node) {
            return height(node.left) - height(node.right);
        }

        private int height(Node node) {
            if (node == null) {
                return 0;
            }
            return node.height;
        }

        private void updateHeight(Node node) {
            node.height = Math.max(this.height(node.left), this.height(node.right)) + 1;
        }

        private class Node {

            private T value;
            private Node left;
            private Node right;

            private int height;
            private int index;

            Node(T value, int index) {
                this.value = value;
                this.height = 1;
                this.index = index;
            }

        }
    }


}

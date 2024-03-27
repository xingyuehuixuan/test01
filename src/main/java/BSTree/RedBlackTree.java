package BSTree;

import static BSTree.RedBlackTree.Color.BLACK;
import static BSTree.RedBlackTree.Color.RED;

public class RedBlackTree {
    enum Color {
        RED, BLACK;
    }

    private Node root;

    private static class Node {
        int key;
        Object value;
        Node left;
        Node right;
        Node parent;
        Color color = RED;

        boolean isLeftChild() {
            return parent != null && parent.left == this;
        }

        Node uncle() {
            if (parent == null || parent.parent == null) {
                return null;
            }
            if (parent.isLeftChild()) {
                return parent.parent.right;
            } else {
                return parent.parent.left;
            }
        }

        Node sibling() {
            if (parent == null) {
                return null;
            }
            if (this.isLeftChild()) {
                return parent.right;
            } else {
                return parent.left;
            }
        }

        public Node(int key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

    boolean isRed(Node node) {
        return node != null && node.color == RED;
    }

    boolean isBlack(Node node) {
        return !isRed(node);
    }

    private void rightRotate(Node node) {
        Node parent = node.parent;
        Node left = node.left;
        Node right = left.right;
        if (right != null) {
            right.parent = node;
        }
        node.left = right;
        left.right = node;
        left.parent = parent;
        node.parent = left;
        if (parent == null) {
            root = left;
        } else if (parent.left == node) {
            parent.left = left;
        } else {
            parent.right = left;
        }
    }

    private void leftRotate(Node node) {
        Node parent = node.parent;
        Node right = node.right;
        Node left = right.left;
        if (left != null) {
            left.parent = node;
        }
        node.right = left;
        right.left = node;
        right.parent = parent;
        node.parent = right;
        if (parent == null) {
            root = right;
        } else if (parent.left == node) {
            parent.left = right;
        } else {
            parent.right = right;
        }
    }

    public void put(int key, Object value) {
        Node p = root;
        Node parent = null;
        while (p != null) {
            parent = p;
            if (key < p.key) {
                p = p.left;
            } else if (key > p.key) {
                p = p.right;
            } else {
                p.value = value;
                return;
            }
        }
        Node inserted = new Node(key, value);
        if (parent == null) {
            root = inserted;
        } else if (key < parent.key) {
            parent.left = inserted;
            inserted.parent = parent;
        } else {
            parent.right = inserted;
            inserted.parent = parent;
        }
        fixRedRed(inserted);
    }

    void fixRedRed(Node x) {
        if (x == root) {
            x.color = BLACK;
            return;
        }
        if (isBlack(x.parent)) {
            return;
        }
        Node parent = x.parent;
        Node uncle = x.uncle();
        Node grandparent = parent.parent;
        if (isRed(uncle)) {
            parent.color = BLACK;
            uncle.color = BLACK;
            grandparent.color = RED;
            fixRedRed(grandparent);
            return;
        }
        if (parent.isLeftChild() && x.isLeftChild()) {
            parent.color = BLACK;
            grandparent.color = RED;
            rightRotate(grandparent);
        } else if (parent.isLeftChild()) {
            leftRotate(parent);
            x.color = BLACK;
            grandparent.color = RED;
            rightRotate(grandparent);
        } else if (!x.isLeftChild()) {
            parent.color = BLACK;
            grandparent.color = RED;
            leftRotate(grandparent);
        } else {
            rightRotate(parent);
            x.color = BLACK;
            grandparent.color = RED;
            leftRotate(grandparent);
        }
    }

    public void remove(int key) {
        Node removed = find(key);
        if (removed == null) {
            return;
        }
        doRemove(removed);
    }

    private void doRemove(Node removed) {
        Node remained = findRemained(removed);
        Node parent = removed.parent;
        if (remained == null) {
            if (removed == root) {
                root = null;
            } else {
                if (isBlack(removed)) {
                    fixDoubleBlack(removed);
                } else {
                }
                if (removed.isLeftChild()) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
                removed.parent = null;
            }
            return;
        }
        if (removed.left == null || removed.right == null) {
            if (removed == root) {
                root.key = remained.key;
                root.value = remained.value;
                root.left = root.right = null;
            } else {
                if (removed.isLeftChild()) {
                    parent.left = remained;
                } else {
                    parent.right = remained;
                }
                remained.parent = parent;
                removed.left = null;
                removed.right = null;
                removed.parent = null;
                if (isBlack(removed) && isBlack(remained)) {
                    fixDoubleBlack(remained);
                } else {
                    remained.color = BLACK;
                }
            }
            return;
        }
        int k = removed.key;
        removed.key = remained.key;
        remained.key = k;
        Object v = removed.value;
        removed.value = remained.value;
        remained.value = v;
        doRemove(remained);
    }

    private void fixDoubleBlack(Node node) {
        if (node == root) {
            return;
        }
        Node parent = node.parent;
        Node sibling = node.sibling();
        if (isRed(sibling)) {
            if (node.isLeftChild()) {
                leftRotate(parent);
            } else {
                rightRotate(parent);
            }
            parent.color = RED;
            sibling.color = BLACK;
            fixDoubleBlack(node);
            return;
        }
        if (sibling != null) {
            if (isBlack(sibling.left) && isBlack(sibling.right)) {
                sibling.color = RED;
                if (isRed(parent)) {
                    parent.color = BLACK;
                } else {
                    fixDoubleBlack(parent);
                }
            } else {
                if (sibling.isLeftChild() && isRed(sibling.left)) {
                    rightRotate(parent);
                    sibling.left.color = BLACK;
                    sibling.color = parent.color;
                } else if (sibling.isLeftChild() && isRed(sibling.right)) {
                    leftRotate(sibling);
                    rightRotate(parent);
                    sibling.right.color = parent.color;
                }
                parent.color = BLACK;
            }
        } else {
            fixDoubleBlack(parent);
        }

    }

    Node find(int key) {
        Node p = root;
        while (p != null) {
            if (key < p.key) {
                p = p.left;
            } else if (key > p.key) {
                p = p.right;
            } else {
                return p;
            }
        }
        return null;
    }

    Node findRemained(Node removed) {
        if (removed.left == null && removed.right == null) {
            return null;
        }
        if (removed.left == null) {
            return removed.right;
        }
        if (removed.right == null) {
            return removed.left;
        }
        Node s = removed.right;
        while (s.left != null) {
            s = s.left;
        }
        return s;
    }
}

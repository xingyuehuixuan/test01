package BSTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BSTree1<T extends Comparable<T>, V> {
    BSTNode<T, V> root;

    static class BSTNode<T, V> {
        T key;
        V value;
        BSTNode<T, V> left;
        BSTNode<T, V> right;

        public BSTNode(T key, V value, BSTNode<T, V> left, BSTNode<T, V> right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public BSTNode(T key, V value) {
            this.key = key;
            this.value = value;
        }

        public BSTNode(T key) {
            this.key = key;
        }
    }

    public V get1(T key) {
        if (key == null) {
            throw new NullPointerException();
        }
        return doGet(root, key);
    }

    private V doGet(BSTNode<T, V> node, T key) {
        if (node == null) {
            return null;
        }
        int result = key.compareTo(node.key);
        if (result < 0) {
            return doGet(node.left, key);
        } else if (result > 0) {
            return doGet(node.right, key);
        } else {
            return node.value;
        }
    }

    public V get2(T key) {
        if (key == null) {
            throw new NullPointerException();
        }
        BSTNode<T, V> node = root;
        while (node != null) {
            int result = key.compareTo(node.key);
            if (result < 0) {
                node = node.left;
            } else if (result > 0) {
                node = node.right;
            } else {
                return node.value;
            }
        }
        return null;
    }

    public V min1() {
        return doMin(root);
    }

    public V doMin(BSTNode<T, V> node) {
        if (node == null) {
            return null;
        }
        if (node.left == null) {
            return node.value;
        }
        return doMin(node.left);
    }

    public V min2() {
        return min(root);
    }

    private V min(BSTNode<T, V> node) {
        if (node == null) {
            return null;
        }
        BSTNode<T, V> p = node;
        while (p.left != null) {
            p = p.left;
        }
        return p.value;
    }

    public V max() {
        return max(root);
    }

    private V max(BSTNode<T, V> node) {
        if (node == null) {
            return null;
        }
        BSTNode<T, V> p = node;
        while (p.right != null) {
            p = p.right;
        }
        return p.value;
    }

    public void put(T key, V value) {
        if (root == null) {
            root = new BSTNode<T, V>(key, value);
        }
        BSTNode<T, V> node = root;
        BSTNode<T, V> parent = null;
        while (node != null) {
            parent = node;
            int result = key.compareTo(node.key);
            if (result < 0) {
                node = node.left;
            } else if (result > 0) {
                node = node.right;
            } else {
                node.value = value;
                return;
            }
        }
        if (key.compareTo(parent.key) < 0) {
            parent.left = new BSTNode<T, V>(key, value);
        } else if (key.compareTo(parent.key) > 0) {
            parent.right = new BSTNode<T, V>(key, value);
        }

    }

    public V successor(T key) {
        BSTNode<T, V> p = root;
        BSTNode<T, V> ancestorFromLeft = null;
        while (p != null) {
            if (key.compareTo(p.key) < 0) {
                p = p.left;
            } else if (key.compareTo(p.key) > 0) {
                ancestorFromLeft = p;
                p = p.right;
            } else {
                break;
            }
        }
        if (p == null) {
            return null;
        }
        if (p.left != null) {
            return max(p.left);
        }
        return ancestorFromLeft != null ? ancestorFromLeft.value : null;
    }

    public V predecessor(T key) {
        BSTNode<T, V> p = root;
        BSTNode<T, V> ancestorFromRight = null;
        while (p != null) {
            if (key.compareTo(p.key) < 0) {
                ancestorFromRight = p;
                p = p.left;
            } else if (key.compareTo(p.key) > 0) {
                p = p.right;
            } else {
                break;
            }
        }
        if (p == null) {
            return null;
        }
        if (p.right != null) {
            return min(p.right);
        }
        return ancestorFromRight != null ? ancestorFromRight.value : null;
    }

    public V delete1(T key) {
        BSTNode<T, V> p = root;
        BSTNode<T, V> parent = null;
        while (p != null) {
            if (key.compareTo(p.key) < 0) {
                parent = p;
                p = p.left;
            } else if (key.compareTo(p.key) > 0) {
                parent = p;
                p = p.right;
            } else {
                break;
            }
        }
        if (p == null) {
            return null;
        }
        if (p.left == null) {
            shift(parent, p, p.right);
        } else if (p.right == null) {
            shift(parent, p, p.left);
        } else {
            BSTNode<T, V> s = p.right;
            BSTNode<T, V> sParent = p;
            while (s.left != null) {
                sParent = s;
                s = s.left;
            }
            if (sParent != p) {
                shift(sParent, s, s.right);
                s.right = p.right;
            }
            shift(parent, p, s);
            s.left = p.left;
        }
        return p.value;
    }

    private void shift(BSTNode<T, V> parent, BSTNode<T, V> deleted, BSTNode<T, V> child) {
        if (parent == null) {
            root = child;
        } else if (deleted == parent.left) {
            parent.left = child;
        } else {
            parent.right = child;
        }

    }

    public V delete2(T key) {
        ArrayList<V> result = new ArrayList<>();
        root = doDelete(root, key, result);
        return result.isEmpty() ? null : result.get(0);
    }

    private BSTNode<T, V> doDelete(BSTNode<T, V> node, T key, ArrayList<V> result) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) < 0) {
            node.left = doDelete(node.left, key, result);
            return node;
        }
        if (key.compareTo(node.key) > 0) {
            node.right = doDelete(node.right, key, result);
            return node;
        }
        result.add(node.value);
        if (node.left == null) {
            return node.right;
        }
        if (node.right == null) {
            return node.left;
        }
        BSTNode<T, V> s = node.right;
        while (s != null) {
            s = s.left;
        }
        s.right = doDelete(node.right, s.key, new ArrayList<>());
        s.left = node.left;
        return s;
    }

    public List<V> less(T key) {
        ArrayList<V> result = new ArrayList<>();
        BSTNode<T, V> p = root;
        LinkedList<BSTNode<T, V>> stack = new LinkedList<>();
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                BSTNode<T, V> pop = stack.pop();
                if (key.compareTo(pop.key) > 0) {
                    result.add(pop.value);
                } else {
                    break;
                }
                p = pop.right;
            }
        }
        return result;
    }

    public List<V> greater(T key) {
        ArrayList<V> result = new ArrayList<>();
        BSTNode<T, V> p = root;
        LinkedList<BSTNode<T, V>> stack = new LinkedList<>();
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.right;
            } else {
                BSTNode<T, V> pop = stack.pop();
                if (key.compareTo(pop.key) < 0) {
                    result.add(pop.value);
                }else {
                    break;
                }
                p = pop.left;
            }
        }
        return result;
    }

    public List<V> between(T key1, T key2) {
        ArrayList<V> result = new ArrayList<>();
        BSTNode<T, V> p = root;
        LinkedList<BSTNode<T, V>> stack = new LinkedList<>();
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                BSTNode<T, V> pop = stack.pop();
                if (key1.compareTo(pop.key) < 0 && key2.compareTo(pop.key) > 0) {
                    result.add(pop.value);
                } else if (key2.compareTo(pop.key) < 0) {
                    break;
                }
                p = pop.right;
            }
        }
        return result;
    }
}

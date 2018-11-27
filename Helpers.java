class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }

    @Override
    public String toString() {
        return "" + this.start + " - " + this.end;
    }
}

interface NestedInteger {

    public boolean isInteger();

    public Integer getInteger();
    public void setInteger(int value);
    public void add(NestedInteger ni);
    public List<NestedInteger> getList();
}

class Nested implements NestedInteger {

    List<NestedInteger> list;
    Integer integer;


    public Nested(int integer) {
        this.integer = integer;
    }

    public Nested(List<NestedInteger> list) {
        this.list = list;
    }

    @Override
    public boolean isInteger() {
        return this.integer != null;
    }

    @Override
    public Integer getInteger() {
        return this.integer;
    }

    @Override
    public void setInteger(int value) {

    }

    @Override
    public void add(NestedInteger ni) {

    }

    @Override
    public List<NestedInteger> getList() {
        return this.list;
    }
}

public class Helpers {

    public static void print(Object... objects) {
        for (int j = 0; j < objects.length; j++) {
            Object o = objects[j];
            if (o != null && o.getClass().isArray()) {
                int length = Array.getLength(o);
                System.out.print("[");
                for (int i = 0; i < length; i ++) {
                    Object arrayElement = Array.get(o, i);
                    System.out.print(arrayElement);
                    if (i < length - 1) System.out.print(", ");
                }
                System.out.print("]");
                System.out.println();
            } else {
                if (j < objects.length - 1) System.out.print(o + ", ");
                else System.out.print(o);
            }
        }
        System.out.println();
    }

}

public class TreeNode {

    private final static String DELIMETER = ",";
    private final static String NULL = "null";

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(val);
        sb.append(" (");
        if (left != null) sb.append(left.val);
        else sb.append("-");
        sb.append(", ");
        if (right != null) sb.append(right.val);
        else sb.append("-");
        sb.append(")");
        return sb.toString();
    }

    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    TreeNode() {}

    public static String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current == null) {
                sb.append(NULL);
                sb.append(DELIMETER);
                continue;
            }
            sb.append(current.val);
            sb.append(DELIMETER);
            queue.offer(current.left);
            queue.offer(current.right);
        }
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (Character.isDigit(sb.charAt(i))) {
                return "[" + sb.substring(0, i + 1) + "]";
            }
        }
        return sb.toString();
    }

    public static TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        data = data.substring(1, data.length() - 1);
        String[] values = data.split(DELIMETER);
        if (values[0].equals(NULL)) return null;
        TreeNode root = new TreeNode(Integer.valueOf(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for (int i = 1; i < values.length; i++) {
            TreeNode parent = queue.poll();
            if (!values[i].equals(NULL)) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i].trim()));
                parent.left = left;
                queue.offer(left);
            }
            if (i < values.length - 1 && !values[++i].equals(NULL)) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i].trim()));
                parent.right = right;
                queue.offer(right);
            }
        }
        return root;
    }


    public static int treeHeight(TreeNode root) {
        if (root == null) return 0;
        int left = treeHeight(root.left);
        int right = treeHeight(root.right);
        return Math.max(left + 1, right + 1);
     }

}

public class ListNode {

    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    @Override
    public String toString() {
        return val + " -> " + next;
    }

    public static ListNode serialize(String s) {
        ListNode dummy = new ListNode(0);
        String[] values = s.substring(1, s.length() - 1).split(",");
        if (values.length == 0 || values[0].equals("") ) return null;
        ListNode current = dummy;
        for (String value : values) {
            current.next = new ListNode(Integer.valueOf(value.trim()));
            current = current.next;
        }
        return dummy.next;
    }
}


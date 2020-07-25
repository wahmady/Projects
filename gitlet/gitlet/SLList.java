public class SLList {
    private static class IntNode {
        private int item;
        private IntNode next;

        IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }

        @java.lang.Override
        public java.lang.String toString() {
            return "IntNode{" + "item=" + item
                    + ", next=" + next + '}';
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }

            if (object == null || getClass() != object.getClass()) {
                return false;
            }
            IntNode intNode = (IntNode) object;
            return item == intNode.item
                    && java.util.Objects.equals(next, intNode.next);
        }

    }

    /* The first item (if it exists) is at sentinel.next. */
    private IntNode sentinel;
    private int size;

    @java.lang.Override
    public java.lang.String toString() {
        return "SLList{" + "sentinel=" + sentinel
                + ", size=" + size + '}';
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        SLList slList = (SLList) object;
        return size == slList.size
                && java.util.Objects.equals(sentinel, slList.sentinel);
    }

    /** Creates an empty SLList. */
    public SLList() {
        sentinel = new IntNode(63, null);
        size = 0;
    }

    public SLList(int x) {
        sentinel = new IntNode(63, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    /** Returns an SLList consisting of the given values. */
    public static SLList of(int... values) {
        SLList list = new SLList();
        for (int i = values.length - 1; i >= 0; i -= 1) {
            list.addFirst(values[i]);
        }
        return list;
    }

    /** Returns the size of the list. */
    public int size() {
        return size;
    }

    /** Adds x to the front of the list. */
    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size += 1;
    }

    /** Returns the first item in the list. */
    public int getFirst() {
        return sentinel.next.item;
    }

    /** Return the value at the given index. */
    public int get(int index) {
        IntNode p = sentinel.next;
        while (index > 0) {
            p = p.next;
            index -= 1;
        }
        return p.item;
    }

    /** Adds x to the end of the list. */
    public void addLast(int x) {
        size += 1;
        IntNode p = sentinel;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
    }

    /** Adds x to the list at the specified index. */
    public void add(int index, int x) {

        IntNode p = sentinel;
        if (index >= size) {
            addLast(x);

        } else {
            for (int i = 0; i < index; i++) {
                p = p.next;
            }
            p.next = new IntNode(x, p.next);
            size += 1;
        }

    }

}
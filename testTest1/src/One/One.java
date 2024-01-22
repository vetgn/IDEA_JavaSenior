package One;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author ZJJ
 * #Description One.One
 * #Date: 2022/8/6 12:56
 */
public class One {

    @Test
    public void test(){
        System.out.println("1");
        return;

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

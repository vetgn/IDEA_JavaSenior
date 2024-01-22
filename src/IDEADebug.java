/**
 * @author ZJJ
 * #Description IdeaDebug
 * #Date: 2022/5/15 16:39
 */

import org.junit.Test;

public class IDEADebug {

    public void testStringBuffer() {
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);

        System.out.println(sb.length());

        System.out.println(sb);

        StringBuffer sb1 = new StringBuffer(str);
        System.out.println(sb1);
    }
}

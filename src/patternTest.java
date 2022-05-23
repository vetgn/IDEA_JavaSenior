import org.junit.Test;

import java.util.regex.Pattern;

/**
 * @author ZJJ
 * #Description patternTest
 * #Date: 2022/5/23 14:10
 */
public class patternTest {
    @Test
    public void test() {
        String regex = "[a-zA-Z]\\w{5,17}"; //正则规范
        boolean boo1 = Pattern.matches(regex, "jsu_456");
        System.out.println(boo1);

        String regex1 = "[0-9]+(\\.[0-9]{2}){1} ";
        boolean boo2 = Pattern.matches(regex, "5.12");
        System.out.println(boo2);
    }
}

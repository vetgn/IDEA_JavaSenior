import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 * @author ZJJ
 * #Description propertiesTest
 * #Date: 2022/7/18 17:21
 */
public class propertiesTest {
    //Properties:常用来处理配置文件。key和value都是String类型,例如IDEA的idea64.exe.vmoptions文件
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();

        FileInputStream fileOutputStream = new FileInputStream("jdbc.properties");
        properties.load(fileOutputStream);//加载流对应的文件

        String name = properties.getProperty("name");
        String password = properties.getProperty("password");

        System.out.println("name=" + name + "password=" + password);

    }
}

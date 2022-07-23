package One;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author ZJJ
 * #Description first
 * #Date: 2022/6/19 12:35
 */
public class first {
    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        ArrayList<String> arrayList = null;
        char[] buf = new char[0];
        try {
            arrayList = new ArrayList<>();
            bufferedReader = new BufferedReader(new FileReader("D:\\JavaCode\\School\\src\\Project_01\\text.txt"));
            int num;
            buf = new char[40];
            while ((num = bufferedReader.read(buf)) != -1) {

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null)
                    bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String temp = "";
        for (int i = 0; i < buf.length; i++) {
            if (buf[i] == '，') {//注意文件中的分隔符是中文还是英文字符
                arrayList.add(temp);
                temp = "";
            } else {
                temp += buf[i];
            }
        }

        for(int i=0;i<arrayList.size();i++){
            System.out.println(arrayList.get(i));
            System.out.println("***************");
        }
        System.out.println(temp);
        System.out.println("***************");

    }
}

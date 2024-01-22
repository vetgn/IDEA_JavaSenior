import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author ZJJ
 * #Description InetAddressTest
 * #Date: 2022/7/23 21:53
 */

/*
 * 一、网络编程中有两个主要的问题:
 * 1.如何准确地定位网络上一台或多台主机;定位主机上的特定的应用
 * 2,找到主机后如何可靠高效地进行数据传输
 *
 * 二、网络编程中的两个要素:
 * 1.对应问题一: IP和端口号
 * 2.对应问题二:提供网络通信协议：TCP/IP参考模型(应用层、传输层、网络层、物理+数据链路层)
 *
 *三、通信要素一: IP和端口号
 * 1. IP:唯一的标识Internet上的计算机(通信实体)
 * 2.在Java中使用InetAddress类代表IP
 * 3. IP分类: IPv4 和 IPv6 ; 万维网 和 局域网
 * 4,域名:    www.baidu.com       www.mi.com     www.sina.com
 *
 *
 * */
public class InetAddressTest {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress inet1 = InetAddress.getByName("");
    }
}

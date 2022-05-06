package socket;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * 聊天室服务端
 */
public class Server {
    /*
        java.net.ServerSocket
        运行在服务端上的，主要有两个职责:
        1:向系统申请服务端口，客户端就是通过该端口与服务端建立连接的
        2:监听该端口，一旦一个客户端建立连接，就会立即返回一个Socket实例，使用它就可以
          与该客户端交互了。
        ServerSocket比作"总机"
     */
    private ServerSocket serverSocket;

    public Server(){
        try {
            System.out.println("正在启动服务端...");
            /*
                实例化ServerSocket的同时指定服务端口，客户端就可以通过该端口与
                服务端建立连接了。
                注意，该端口不能与服务器计算机上其他程序申请的端口一致，否则会抛出
                异常:java.net.BindException:address already in use
                  即:地址被占用异常
                  解决办法:换一个端口，或者将占用8088端口的程序进程杀死。
                端口的选择:范围是0-65535之间的整数。但是实际开发中前6000不建议选取
                因为密集绑定了系统应用和流行的应用程序。建议8000以后的端口。
             */
            serverSocket = new ServerSocket(8088);
            System.out.println("服务端启动完毕");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void start(){

    }
    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }
}

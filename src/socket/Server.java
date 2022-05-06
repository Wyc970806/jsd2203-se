package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

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
        try {
            System.out.println("等待客户端连接...");
            /*
                ServerSocket的方法:
                Socket accept()
                该方法是一个阻塞方法，调用后开始等待客户端的连接，一旦一个客户端连接了
                accept方法会立即返回一个Socket实例，通过这个Socket可以与连接的客户
                端进行交互。
                多次调用accept可以接受多个客户端的连接。理解为是总机"接电话"的操作。
             */
            Socket socket = serverSocket.accept();
            System.out.println("一个客户端连接了");

            /*
                通过Socket的方法
                InputStream getInputStream()
                获取一个字节输入流，来读取远端计算机发送过来的字节
             */
            InputStream in = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(in, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);

            String message = br.readLine();
            System.out.println("客户端说:"+message);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }
}

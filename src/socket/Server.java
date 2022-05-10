package socket;

import java.io.*;
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
                  步骤:
                  1:ctrl+alt+del选择任务管理器。
                  2:在任务管理器窗口中点击【进程】
                  3:在进程中，找到IDEA进程，将其展开，杀死所有Java(TM)开头的进程即可

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
            while(true) {
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
                //启动一个线程来处理与该客户端的交互
                ClientHandler clientHandler = new ClientHandler(socket);
                Thread t = new Thread(clientHandler);
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }

    /**
     * 该线程任务负责与指定客户端交互
     */
    private class ClientHandler implements Runnable{
        private Socket socket;
        private String host;//记录客户端的地址信息

        public ClientHandler(Socket socket){
            this.socket = socket;
            //通过socket获取远端计算机地址信息
            host = socket.getInetAddress().getHostAddress();
        }

        public void run(){
            try{
                /*
                通过Socket的方法
                InputStream getInputStream()
                获取一个字节输入流，来读取远端计算机发送过来的字节
             */
                InputStream in = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(in, StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr);

                /*
                    通过socket获取输出流，用于将消息发送给客户端
                 */
                OutputStream out = socket.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(out, StandardCharsets.UTF_8);
                BufferedWriter bw = new BufferedWriter(osw);
                PrintWriter pw = new PrintWriter(bw,true);

                String message;
                /*
                    使用缓冲字符输入流读取客户端发送过来一行字符串的操作，可能会因为客户端
                    的异常断开而抛出异常:
                    java.net.SocketException: Connection reset
                 */
                while ((message = br.readLine()) != null) {
                    System.out.println(host + "说:" + message);
                    //将消息发送给客户端
                    pw.println(host + "说:" + message);
                }
            }catch(IOException e){
            }
        }
    }

}

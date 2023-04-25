import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class SoloDealer {
    static ServerSocket server;
    static final int port = 9876;
    static DataInputStream dis;
    static DataOutputStream dos;
    public  static void main(String[] args) throws IOException, InterruptedException {
        boolean run = true;
        server = new ServerSocket(port);
        System.out.println("Waiting for client...");
        Socket socket = server.accept();
        System.out.println("client accepted");
        try {TimeUnit.SECONDS.sleep(5);}
        catch (InterruptedException e){e.printStackTrace();}
        int playerMoney = 500;
        dos = new DataOutputStream(socket.getOutputStream());
        dis = new DataInputStream(socket.getInputStream());
        ArrayList<String> playerMsg;
        do{
            dos.writeUTF("login");
            playerMsg = new ArrayList<>(Arrays.asList(dis.readUTF().split(":")));
            System.out.println("Player " + playerMsg.get(1) + " as joined!");
            run = false;
        } while (run = true);

    }
}

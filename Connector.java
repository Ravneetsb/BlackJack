import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Connector{
    public final Socket socket;
    private final DataInputStream dis;
    private final DataOutputStream dos;
    public Connector(String ipAddress, String ipPort) throws IOException {
        this.socket = new Socket(ipAddress, Integer.parseInt(ipPort));
        this.dis = new DataInputStream(this.socket.getInputStream());
        this.dos = new DataOutputStream(this.socket.getOutputStream());
    }
    public void write(String info) throws IOException {
        this.dos.writeUTF(info);
        this.dos.flush();
    }
    public String read() throws IOException{
        return this.dis.readUTF();
    }
}
import java.net.*;
import java.io.*;

public class chatServer {
    public static void main(String args[]) throws Exception {
        ServerSocket ss = new ServerSocket(2000);
        Socket sk = ss.accept();
        PrintStream sout = new PrintStream(sk.getOutputStream());
        BufferedReader sin = new BufferedReader(new InputStreamReader(sk.getInputStream()));
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while (true) {
            s = sin.readLine();
            if (s.equals("END")) {
                sout.println("BYE");
                break;
            }
            System.out.print("Client : " + s + "\n");
            System.out.print("Server : ");
            s = stdin.readLine();
            sout.println(s);
        }
        ss.close();
        sk.close();
        sin.close();
        sout.close();
        stdin.close();
    }
}
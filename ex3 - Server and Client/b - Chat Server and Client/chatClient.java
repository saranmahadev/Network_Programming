import java.net.*;
import java.io.*;
public class chatClient {
    public static void main(String args[]) throws Exception {       
        Socket soc = new Socket("127.0.0.1", 2000);
        PrintStream sout = new PrintStream(soc.getOutputStream());
        BufferedReader sin = new BufferedReader(new InputStreamReader(soc.getInputStream()));            
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while (true) {
            System.out.print("Client : ");
            s = stdin.readLine();
            sout.println(s);
            s = sin.readLine();
            System.out.print("Server : " + s + "\n");
            if (s.equalsIgnoreCase("BYE"))
                break;
        }
        soc.close();
        sin.close();
        sout.close();
        stdin.close();
    }
}
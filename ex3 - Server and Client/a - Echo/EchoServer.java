import java.net.*;
import java.io.*;

class EchoServer {
 
    public static void main(String args[]) throws IOException {        
        ServerSocket ss = new ServerSocket(95);        
        Socket soc = ss.accept();
        System.out.println("Connection accepted at :" + soc);

        DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(soc.getInputStream()));
                
        System.out.println("Server waiting for message from the client");
        
        boolean run = true;
        do {
            String msg = "";
            String s = br.readLine();
            int len = s.length();
            if (s.equals("exit")) {
                run = false;
            }

            for (int i = 0; i < len; i++) {
                msg = msg + s.charAt(i);
                dos.write((byte) s.charAt(i));
            }
 
            System.out.println("From client :" + msg);
            dos.write(13);
            dos.write(10);
            dos.flush();
        } while (run);
        dos.close();
        soc.close();
 
    }
}
import java.net.*;
import java.io.*;
 
class EchoClient {
    public static void main(String args[]) throws IOException {        
        Socket soc = new Socket(InetAddress.getLocalHost(), 95);

        BufferedReader br = new BufferedReader(new InputStreamReader(soc.getInputStream()));
        BufferedReader kyrd = new BufferedReader(new InputStreamReader(System.in));

        DataOutputStream dos = new DataOutputStream(soc.getOutputStream());

        System.out.println(
            "To start the dialog type the message in this client window \n Type exit to end"
        );

        while(true) {
            String str = kyrd.readLine();
            dos.writeBytes(str);
            dos.write(13);
            dos.write(10);
            dos.flush();            
            String s = br.readLine();
            System.out.println("To server :" + s);
            if (s.equals("exit")) {
                break;
            }
        }
        br.close();
        dos.close();
        soc.close();
    }
}
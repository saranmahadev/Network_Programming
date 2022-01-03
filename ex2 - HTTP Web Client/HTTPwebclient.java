import java.io.*;
import java.net.*;
import java.util.Scanner;

public class HTTPwebclient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Host Name and Port Number: ");
        String hostName = sc.nextLine();
        int portNumber = sc.nextInt();
        try {
            Socket socket = new Socket(hostName, portNumber);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out.println("GET / HTTP/1.1\nHost:" + hostName + "\n\n");
            String inputLine = = in.readLine();
            while (inputLine  != null) {
                System.out.println(inputLine);
            }
        } catch (Exception e) {
            System.err.println("Error" + e.getMessage());
            System.exit(1);
        } finally {
            sc.close();
        }
    }
}
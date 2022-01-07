import java.io.*;
import java.net.*;
import java.util.Scanner;

public class SimpleFileClient {
    public static void main(String[] args) throws IOException {
        try {
            Socket sock = new Socket("127.0.0.1",13267);            
            InputStream in = sock.getInputStream();
            BufferedOutputStream bos = new BufferedOutputStream(
              new FileOutputStream("E:/downloaded.pdf")
            );
            
            byte[] mybytearray = new byte[6022386];
            int bytesRead = in.read(mybytearray, 0, mybytearray.length);
            int current = bytesRead;

            do {
                bytesRead = in.read(
                  mybytearray, current, (mybytearray.length - current)
                );
                if (bytesRead >= 0) {
                  current += bytesRead
                };
            } while (bytesRead > -1);

            bos.write(mybytearray, 0, current);
            bos.flush();
            System.out.println(
              "File " + FILE_TO_RECEIVED +" downloaded (" + current + " bytes read)"
            );
        } finally {
          fos.close();
          bos.close();
          sock.close();
        }
    }

}
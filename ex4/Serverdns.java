import java.io.*;
import java.net.*;
import java.util.*;

class Serverdns
{
            public static void main(String args[])
            {
            try
            {
                        DatagramSocket server=new DatagramSocket(1309);
                        while(true)
                        {
                                    byte[] sendbyte=new byte[1024];
                                    byte[] receivebyte=new byte[1024];
                                    DatagramPacket receiver=new DatagramPacket(receivebyte,receivebyte.length);
                                    server.receive(receiver);
                                    String str=new String(receiver.getData());
                                    String s=str.trim();
                                    //System.out.println(s);
                                    InetAddress addr=receiver.getAddress();
                                    int port=receiver.getPort();
                                    String ip[]={"163.53.78.87","176.13.69.63", "172.28.251.59", "172.217.11.5","172.217.11.14"};
                                    String name[]={"www.flipkart.com","www.facebook.com","www.zoho.com", "www.gmail.com","www.google.com"};
                                    for(int i=0;i<ip.length;i++)
                                    {
                                                if(s.equals(ip[i]))
                                                {
                                                            sendbyte=name[i].getBytes();
                                                            DatagramPacket sender=new DatagramPacket(sendbyte,sendbyte.length,addr,port);
                                                            server.send(sender);
                                                            break;
                                                }
                                                else if(s.equals(name[i]))
                                                {
                                                            sendbyte=ip[i].getBytes();
                                                            DatagramPacket sender=new DatagramPacket(sendbyte,sendbyte.length,addr,port);
                                                            server.send(sender);
                                                            break;
                                                }
                                               
                                    }         
                                    break;


                        }
            }
            catch(Exception e)
            {
                        System.out.println(e);
            }
        }
}
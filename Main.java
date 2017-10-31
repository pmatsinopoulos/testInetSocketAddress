import java.io.*;
import java.net.*;

public class Main {
  public static void main(String[] args) {
    System.out.println("Hello World!");
    try {
      byte[] ipAddr = new byte[]{127, 0, 0, 1};
      byte[] ip6Addr = new byte[]{0, 0, 0, 0,     0, 0, 0, 0,     0, 0, 0, 0,    0, 0, 0, 1} ;
      Inet4Address inet4Address = (Inet4Address)Inet4Address.getByAddress(ipAddr);
      Inet6Address inet6Address = (Inet6Address)Inet6Address.getByAddress(ip6Addr);
      //ServerSocket serverSocket = new ServerSocket(8343, 10, inet4Address); 
      //ServerSocket serverSocket = new ServerSocket(8343, 10, inet6Address); 
      ServerSocket serverSocket = new ServerSocket(8343); 
      while (true) {
        Socket connectionSocket = serverSocket.accept();
        BufferedReader inFromClient =
           new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
        String clientSentence = inFromClient.readLine();
        System.out.println("Client Sentence: " + clientSentence);
      }
    }
    catch(IOException e) {
      System.err.println(e);
    }
  }
}

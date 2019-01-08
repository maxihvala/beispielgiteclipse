import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServer {
	public static void main(String[] args) throws IOException {
		int portN=11111;
		byte[] inData = new byte[1024];
		byte[] outData = new byte[1024];
		
		String message;
		
		DatagramSocket socket = new DatagramSocket(portN);
		
		while(true) {
			DatagramPacket in = new DatagramPacket(inData,inData.length);
			socket.receive(in);
			//Informationen über Client sammeln
			InetAddress senderIP = in.getAddress();
			int senderProt = in.getPort();
			message=new String(in.getData(),0,in.getLength());
			System.out.println("Habe bekommen "+message+" von "+senderIP+" , "+senderProt);
			//Antwort schicken
			outData="Pong".getBytes();
			DatagramPacket out = new DatagramPacket(outData,outData.length,senderIP,senderProt);
			socket.send(out);
			
		}
		
		
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
	public static void main(String[] args) throws IOException {
		int portN=11111;
		byte[] inData = new byte[1024];
		byte[] outData = new byte[1024];
		String message;
		//Socket erzeugen
		DatagramSocket socket = new DatagramSocket();
		//Packet bauen und addressieren
		
		InetAddress serverIP = InetAddress.getByName("localhost");
		outData="Ping".getBytes();
		DatagramPacket out = new DatagramPacket(outData,outData.length,serverIP,portN);
		//Packet senden
		socket.send(out);
		//Antwort empfangen und ausgeben
		DatagramPacket in = new DatagramPacket(inData, inData.length);
		socket.receive(in);
		message=new String(in.getData(),0,in.getLength());
		System.out.println("Habe bekommen: "+message);
		
		//Socket schliessen
		socket.close();
;		
    }
	
	
}

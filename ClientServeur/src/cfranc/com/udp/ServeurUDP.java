package cfranc.com.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ServeurUDP {
	
	static byte[] receiveData = new byte[255];

	public static void main(String[] args){
		try {
			DatagramSocket socketServeur = new DatagramSocket(4567);
			DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
			
			
			try {
				socketServeur.receive(receivePacket);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			String line = new String(receivePacket.getData());
			InetAddress adresseIP = receivePacket.getAddress();
			
			int port = receivePacket.getPort();
			String upperCaseLine = line.toUpperCase();
			byte[] sendData = upperCaseLine.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length, adresseIP, port);
			
			try {
				socketServeur.send(sendPacket);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

package cfranc.com.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ClientUDP {
	
	static byte[] receiveData = new byte[255];
	
	public static void main(String[] args){
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader userInput = new BufferedReader(isr);
		DatagramSocket clientSocket;
		
		try {
			clientSocket = new DatagramSocket();
			InetAddress IPAd;
			
			try {
				IPAd = InetAddress.getByName("localhost");
				String line;
				
				try {
					line = userInput.readLine();
					byte[] sendData = line.getBytes();
					DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAd, 4567);
					clientSocket.send(sendPacket);
					
					DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
					clientSocket.receive(receivePacket);
					String modifiedSentence = new String(receiveData);
					System.out.println("FROM SERVER UDP:" + modifiedSentence);
					
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
			
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}

}

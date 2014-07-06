package com.leeandjosh.restauranttemplate;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import android.content.Intent;
import android.util.Log;

public class OrderPoster {
	private static final String URL = "134.193.112.95";
	private static final int port = 12345;
	private Socket socket;
	private OutputStream os;
	private DataOutputStream dos;
	private DataInputStream dis;
	private boolean connected=true;

	public OrderPoster() {
		try {
			socket = new Socket(URL, port);
			os = socket.getOutputStream();
			dos = new DataOutputStream(os);

			InputStream is = socket.getInputStream();
			dis = new DataInputStream(is);
		
		} catch (UnknownHostException e) {
			Log.d("error", "error");
			e.printStackTrace();
			connected=false;
		} catch (IOException e) {
			Log.d("error", "erorr");
			e.printStackTrace();
			connected=false;
		}
	}

	public Socket getSocket(){
		return socket;
	}

	public boolean sendItems() {
		if(!connected)
			return false;
		try {
			dos.writeInt(10); 	//Send order code
			int deviceRecognized = dis.readInt();
			dos.writeInt(10);
			dos.writeUTF(Order.myOrder.getTotalPrice() + "");
			dos.writeUTF(Order.myOrder.toString());
			dos.writeUTF(Order.myOrder.getDeliveryInfo("Name"));
			dos.writeUTF(Order.myOrder.getDeliveryInfo("Phone"));
			dos.writeUTF(Order.myOrder.getDeliveryInfo("Address"));
			dos.writeUTF(Order.myOrder.getDeliveryInfo("Email"));
			dos.writeUTF(Order.myOrder.getDeliveryInfo("Instructions"));
			dos.writeUTF(Order.myOrder.getDeliveryInfo("Delivery"));
			dos.writeUTF("done");
			int wroteToDatabase = dis.readInt();
			socket.close();
			return(deviceRecognized>=0 && wroteToDatabase>=0);
				

		} catch (IOException ioe) {
			Log.e("testes", "Failed to send items", ioe);
			return false;
		}
	}

}

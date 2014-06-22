package com.leeandjosh.restauranttemplate;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;

import android.net.Uri;
import android.util.Log;

public class OrderPoster {
	private static String URL = "134.193.112.95";
	private static final int port = 12345;
	Socket socket;
	OutputStream os;
	DataOutputStream dos;
	
	
	public OrderPoster() {
		try {
			socket = new Socket(URL, port);
			os = socket.getOutputStream();
			dos = new DataOutputStream(os);
		} catch (UnknownHostException e) {
			System.err.println("Could not find server");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Could not read/write to server");
			e.printStackTrace();
		}
	}
/*
	byte[] getUrlBytes(String urlSpec) throws IOException {
		URL url = new URL(urlSpec);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		try {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			InputStream in = connection.getInputStream();
			if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
				return null;
			}
			int bytesRead = 0;
			byte[] buffer = new byte[1024];
			while ((bytesRead = in.read(buffer)) > 0) {
				out.write(buffer, 0, bytesRead);
			}
			out.close();
			return out.toByteArray();
		} finally {
			connection.disconnect();
		}
	}

	public String getUrl(String urlSpec) throws IOException {
		return new String(getUrlBytes(urlSpec));
	}
*/
	public void sendItems() {
		try {
			dos.writeUTF(Order.myOrder.getTotalPrice() + "");
			dos.writeUTF(Order.myOrder.toString());
			dos.writeUTF(Order.myOrder.getDeliveryInfo("Name"));
			dos.writeUTF(Order.myOrder.getDeliveryInfo("Phone"));
			dos.writeUTF(Order.myOrder.getDeliveryInfo("Address"));
			dos.writeUTF(Order.myOrder.getDeliveryInfo("Instructions"));
			dos.writeUTF("done");
			
		} catch (IOException ioe) {
			Log.e("testes", "Failed to send items", ioe);
		}
	}

}

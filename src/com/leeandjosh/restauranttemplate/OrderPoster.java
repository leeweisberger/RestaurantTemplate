package com.leeandjosh.restauranttemplate;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.net.Uri;
import android.util.Log;

public class OrderPoster {
	private static String URL = "http://10.245.1.133:8080/Your_Restaurant/";

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

	public void fetchItems() {
		try {
			String url = Uri.parse(URL).buildUpon()
					.appendQueryParameter("price", "$"+Order.myOrder.getTotalPrice())
					.appendQueryParameter("order", Order.myOrder.toString())
					.appendQueryParameter("name",Order.myOrder.getDeliveryInfo("Name"))
					.appendQueryParameter("phone",Order.myOrder.getDeliveryInfo("Phone"))
					.appendQueryParameter("address",Order.myOrder.getDeliveryInfo("Address"))
					.appendQueryParameter("instructions",Order.myOrder.getDeliveryInfo("Instructions"))	
					.build().toString();

			String xmlString = getUrl(url);
		} catch (IOException ioe) {
			Log.e("testes", "Failed to fetch items", ioe);
		}
	}

}

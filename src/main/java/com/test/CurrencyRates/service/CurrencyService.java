package com.test.CurrencyRates.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

@Service
public class CurrencyService {

	public String getRates() {

	String	result= null;
		try {
		   // String apikey = "YOUR-APIKEY";
		    //String url = "https://freecurrencyapi.net/api/v2/latest?apikey=" + apikey + "&base_currency=USD";
		    String url = "https://jsonplaceholder.typicode.com/todos";
		    URL urlForGetRequest = new URL(url);
		    String readLine = null;
		    HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
		    conection.setRequestMethod("GET");
		    int responseCode = conection.getResponseCode();
		    
		    System.out.println(responseCode);
		    
		    if (responseCode == HttpURLConnection.HTTP_OK) {
		        BufferedReader in = new BufferedReader(new InputStreamReader(conection.getInputStream()));
		        StringBuffer response = new StringBuffer();
		        while ((readLine = in.readLine()) != null) {
		            response.append(readLine);
		           
		        }
		        in.close();
		        System.out.println(response.toString());
		        result = response.toString();
		    } else {
		        throw new Exception("Error in API Call");
		    }
		} catch (Exception ex) {
		    ex.printStackTrace();
		}

		return  result;
	}

}

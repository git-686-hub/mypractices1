package com.pagecge.practices.httpclient;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class IOUtils {

	public static String convertStreamToString(InputStream input,String encode) throws Exception{
		if(input==null){
			return null;
		}
		InputStreamReader reader = new InputStreamReader(input, encode);
		BufferedReader bufReader = new BufferedReader(reader);
		String tmp = null, html = "", splitStr = "";
		while ((tmp = bufReader.readLine()) != null) {
			tmp = splitStr + tmp;
			html += tmp;
			splitStr = "\n";
		}
		if (input != null) {
			input.close();
		}
		return html;
	}
	
}

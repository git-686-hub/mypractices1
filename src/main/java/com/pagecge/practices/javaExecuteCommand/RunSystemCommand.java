package com.pagecge.practices.javaExecuteCommand;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class RunSystemCommand {

	public static void main(String[] args) throws Exception {

		String command = "cmd /c dir";
		String[] commandSplit = command.split(" ");
		List<String> lcommand = new ArrayList<String>();
		for (int i = 0; i < commandSplit.length; i++) {
			lcommand.add(commandSplit[i]);
		}
		ProcessBuilder processBuilder = new ProcessBuilder(lcommand);
		processBuilder.redirectErrorStream(true);
		Process exec = processBuilder.start();

		InputStream inputStream = exec.getInputStream();
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "GBK");
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		exec.waitFor();
		String readLine;
		while((readLine = bufferedReader.readLine()) != null) {
			System.out.println(readLine);
		}
		if(bufferedReader != null)
			bufferedReader.close();
		if(inputStreamReader != null)
			inputStreamReader.close();
		if(inputStream != null)
			inputStream.close();
		if(exec != null) {
			exec.destroy();
		}



	}
}

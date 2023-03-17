package com.runpythonfromjava.wholescriptway;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

public class MainClass {
	
	public static void main(String[] args) {
		{
			try {
				String arg1 = "hello";
				String arg2 = "world";
				
				
				ProcessBuilder builder = new ProcessBuilder();
				Map env = builder.environment();
				env.put("PATH", env.get("PATH")+":/home/parth/miniconda3/bin");  //if you want to activate conda environment

				builder.command("/bin/bash", "-c", "python src/main/resources/pythonscriptwhole.py "+arg1+" "+arg2);
				
				Process process = builder.start();
				
				builder.redirectErrorStream(true);
				
				InputStream inputStream = process.getInputStream();
				BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
				String line;
				while ((line = reader.readLine()) != null) {
					System.out.println(line);
				}
				int exitCode = process.waitFor();
				System.out.println("Exited with code " + exitCode);

			} catch (Exception e) {
				
				System.out.println(e);

			}
		}
	}

}

package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class RedesController {

	//private static final String InputStreamReader leitor = null;
	public RedesController() {
	super();	
	}

	private String os() {

		return System.getProperty("os.name").split(" ")[0] ;
	}

	public void ip() {
		
		if(os().equals("Windows")) {
			try {
				Process p = Runtime.getRuntime().exec("ipconfig");
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				
				while(linha != null) {
					if(linha.contains("Adaptador")) {
						System.out.println(linha);
					}
					if(linha.contains("IPv4")) {
						System.out.println(linha);
					}
					linha= buffer.readLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		if(os().equals("Linux")) {
			try {
				Process p = Runtime.getRuntime().exec("ifconfig");
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				
				while(linha != null) {
					if(linha.contains("flags")) {
						System.out.println(linha);
					}
					if(linha.contains("inet") && !linha.contains("inet6")) {
						System.out.println(linha.split(" netmask")[0]);
					}
					linha = buffer.readLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	public void ping() {
		String process = os().equals("Windows") ? "PING -4 -n 10 www.google.com.br" : "PING -4 -c 10 www.google.com.br";

	try {
		Process p = Runtime.getRuntime().exec(process);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			
			while(linha != null) {
				if(linha.contains("dia")) {
					String vetor [] = linha.split(",");
					System.out.println(vetor[2]);
				}
				

				linha = buffer.readLine();
			}
			
			buffer.close();
			leitor.close();
			fluxo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
 



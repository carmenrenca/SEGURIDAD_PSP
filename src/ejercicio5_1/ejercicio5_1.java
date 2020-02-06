package ejercicio5_1;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.ws.spi.Provider;

import utiles.trycatch;

public class ejercicio5_1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		MessageDigest md;
		try {
			//ALGORITMO A UTILIZAR 
			
			md=MessageDigest.getInstance("MD5");
			String texto ="esto es un texto plano.";
			byte dataBytes[]= texto.getBytes();//TEXTO A BYTES
			md.update(dataBytes);//Texto a bytes a resumir
			byte resumen []= md.digest();
			
			System.out.println("Mensaje original: "+texto);
			System.out.println("Numero de bytes: "+md.getDigestLength());
			System.out.println("Algoritmo: "+md.getAlgorithm());
			System.out.println("Mensaje resumen: "+new String(resumen));
			System.out.println("Mensaje en hexadecimal: "+Hexadecimal(resumen));
			java.security.Provider proveedor = md.getProvider();
			System.out.println("Proveedor: "+proveedor.toString());
			
		}catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		//SEGUNDA PARTE
		System.out.println("SEGUNDA PARTE");
		try {
			trycatch t= new trycatch();
			
			//ALGORITMO A UTILIZAR 
			md=MessageDigest.getInstance("SHA-256");
			
			System.out.println("clave:");
		
			String clave =t.try_String();
			System.out.println("Introduce el texto 1");
			String texto =t.try_String();
			System.out.println("Introduce el texto 2");
			String texto2 =t.try_String();
			
			
			//PRIMER CASO
			System.out.println("-------CASO1---------");
		
			byte dataBytes[]= texto.getBytes();//TEXTO A BYTES
			md.update(dataBytes);//Texto a bytes a resumir
			byte resumen []= md.digest(clave.getBytes());
			
			System.out.println("Mensaje original: "+texto);
			System.out.println("Numero de bytes: "+md.getDigestLength());
			System.out.println("Algoritmo: "+md.getAlgorithm());
			System.out.println("Mensaje resumen: "+new String(resumen));
			System.out.println("Mensaje en hexadecimal: "+Hexadecimal(resumen));
			java.security.Provider proveedor = md.getProvider();
			System.out.println("Proveedor: "+proveedor.toString());
			
			
			//SEGUNDO CASO
			System.out.println("-------CASO2---------");

			 dataBytes= clave.getBytes();//TEXTO A BYTES
			md.update(dataBytes);//Texto a bytes a resumir
		    resumen = md.digest(clave.getBytes());
			
			System.out.println("Mensaje original: "+texto2);
			System.out.println("Numero de bytes: "+md.getDigestLength());
			System.out.println("Algoritmo: "+md.getAlgorithm());
			System.out.println("Mensaje resumen: "+new String(resumen));
			System.out.println("Mensaje en hexadecimal: "+Hexadecimal(resumen));
			 proveedor = md.getProvider();
			System.out.println("Proveedor: "+proveedor.toString());
			
		}catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
	}
	//NOS DEVUELVE SIEMPRE RESUMENES DIFERENTES
	
	//con este metodo convertimos un array de bytes a hexadecimal
	static String Hexadecimal(byte[]resumen) {
		String hex="";
		for(int i=0; i<resumen.length; i++) {
			String h= Integer.toHexString(resumen[i] &0xFF);
			if(h.length()==1) hex+="0";
			hex+=h;
		}
		return hex.toUpperCase();
	}

}

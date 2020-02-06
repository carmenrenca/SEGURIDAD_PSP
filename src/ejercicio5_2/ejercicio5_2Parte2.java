package ejercicio5_2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;

public class ejercicio5_2Parte2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileInputStream fileout = new FileInputStream("DATOS.DAT");
			ObjectInputStream dataOs= new ObjectInputStream(fileout);
			Object o = dataOs.readObject();
			
			//OBTENEMOS EL STRING
			String datos= (String) o;
			System.out.println("Datos: "+datos);
			
			//OBTENEMOS EL RESUMEN
			o= dataOs.readObject();
			byte resumenOriginal[]=(byte[])o;
			MessageDigest md= MessageDigest.getInstance("SHA-256");
			
			//calcula el resimen del string que hemos cogido del fichero
			
			md.update(datos.getBytes());
			byte resumenActual[]= md.digest(); //CALCULAMOS EL RESUMEN
			
			//comprobacion de los dos resumenes
			
			if(MessageDigest.isEqual(resumenActual, resumenOriginal)) System.out.println("DATOS VALIDOS");
			else System.out.println("DATOS NO VALIDOS");
			dataOs.close();
			fileout.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	//En la ejecucion del programa compruebo que cuando modifico el fichero me salta un
	//error 'invalid stream header'
}

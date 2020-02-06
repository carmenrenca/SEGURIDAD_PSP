package ejercicio5_2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ejercicio5_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			FileOutputStream fileout = new FileOutputStream("DATOS.DAT");
			ObjectOutputStream dataOs= new ObjectOutputStream(fileout);
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			String datos = "En un lugar de la mancha, "
					+"de cuyo nombre no quiero acordarme, no ha mucho tiempo"
					+"que vivía un hidalgo de los de lanza en astillero, "
					+"adarga antigua, rocin flaco y galgo corredor.";
			byte dataBytes[]=datos.getBytes();
			
			md.update(dataBytes);//TEXTO A RESUMIR
			byte resumen[]=md.digest();//SE CALCULA EL RESUMEN
			dataOs.writeObject(datos);
			dataOs.writeObject(resumen);
			
			dataOs.close();
			fileout.close();
			
				
		}catch(IOException e) {
			e.printStackTrace();
		}catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

}

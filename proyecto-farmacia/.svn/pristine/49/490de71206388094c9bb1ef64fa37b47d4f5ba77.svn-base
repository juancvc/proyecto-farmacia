package hnch.referencia.web.utilitarios.encrypt;

public class EncryptTest {
	
	public static void main(String[] args) {
				
		try {
			Encrypt.init("KEY_ENCRYPT_PASS");
			System.out.println("+Encrypt:");	
			System.out.println(Encrypt.encrypt("1"));
			System.out.println("-Decrypt:");
			System.out.println(Encrypt.decrypt("NZiDIMxQta2tVVn5rEdlG6Toj41GRve1"));
			
		} catch (EncryptException e) {
			e.printStackTrace();
		}
	}

}

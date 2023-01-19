package com.vinsys.security.encryption;

import java.io.FileInputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.util.Base64;

import javax.crypto.Cipher;

/**
 * Public Keys are used for Encryption Private Keys are used for Decryption
 * Public Keys dont have password (Public) Private Keys have password (Private)
 * Private Key are used to sign Public Key are used to verify the singnature JWT
 * Token (Signed using key)Private Key and Advantage is if some one modifies the
 * token the signature is invalid
 * 
 * @author Nilesh Devdas
 *
 */
public class EncryptionDemo {

	public static void main(String[] args) throws Exception {
		// Text you want encrypt
		String plainText = "mysecretmission";
//		 The KeyStore / The Certificate can be read (JKS)
		KeyStore keystore = KeyStore.getInstance("JKS");
		keystore.load(new FileInputStream("d:/Secret.jks"), "root123".toCharArray());

		Certificate certificate = keystore.getCertificate("xxxx");
		// from the certificate get the public key
		Key publicKey = certificate.getPublicKey();
		Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-1AndMGF1Padding");
		// Encrypt of Decrypt
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
		System.out.println(Base64.getEncoder().encodeToString(encryptedBytes));
		String encryptedData = "EiiqSdGctYvZcXv76vLbFjTj3zRC6tLMYczhqszxvCfSBS7h3WkC4GtDGOO8ZAAU0hC/h37LO7Y+rcV+YEAZQTZB0AGNCatLuUTtodKQjugO3u9FFlrYIrVrCDdI7k3iE9Qwb9UV4U4/7VTk77FFR9qrEOqON7IeXrVoQKM2m1x/T75+5DY8WCGf1hyMpG4nDp2PYG6dMViX3KS82vHiWXsiMU3o0Dc8/ibOD6Gbs8mTBvrYWxAMdy+uHJf1KDqPVMNuzjwXQMUS8+lKY24w6/1H9HsUx0gs3woDBpelPg4E/fuVwcBMr94pYiDyQwZNxX3NKfBYDPdRTr/fUuHvcg==";
		Key privateKey = keystore.getKey("xxxx", "root123".toCharArray());
		Cipher decryptCipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-1AndMGF1Padding");
		// Encrypt of Decrypt
		decryptCipher.init(Cipher.DECRYPT_MODE, privateKey);
		byte[] decryptedString = decryptCipher.doFinal(Base64.getDecoder().decode(encryptedData.getBytes()));
		System.out.println(new String(decryptedString));
	}
}

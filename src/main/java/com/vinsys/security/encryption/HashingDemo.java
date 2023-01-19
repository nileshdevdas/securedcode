package com.vinsys.security.encryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/*
 * Hashing /Non Reversible
 * Encryption / Decrypted 
 * Encrypt using Symettric (Same Key To Encrypt 
 * Same Key To Decrypt) 
 * Signing is different way of Authorizing 
 * and Verifying non repudiation
 * 1. Password should be hashed never should you keep plain 
 * text passwords in your database 
 * Registration --> User --> nilesh / password ---> Hashed and ---> DB 
 * If you asking that how will you check (Hash) The Same password sent by user
 * and compare the hashes to the stored hash :- 
 *
 */
public class HashingDemo {

	public static void main(String[] args) {

		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			String passwordInDB = "4Uy55cDu7g6jE6TgT70QqhesF6ozo8rUvf50uHyhjvg=";
			String passwordSentByUser = Base64.getEncoder().encodeToString(digest.digest("root123".getBytes()));
			if (passwordInDB.equals(passwordSentByUser)) {
				System.out.println("Authenticated..............");
			} else {
				System.out.println("BAD Credentials......");
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

package ca.kuroshfarsimadan.util;

import java.util.Scanner;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

public class PasswordEncrypter {

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		/*StandardPasswordEncoder spe = new StandardPasswordEncoder();

		String encrypted = spe.encode(password);*/
	
		System.out.print("Give password: ");
		String password = scanner.nextLine();
		String encoded = new BCryptPasswordEncoder().encode(password);
		System.out.println("Your password is encrypted with random salt: " + encoded);
	}

}

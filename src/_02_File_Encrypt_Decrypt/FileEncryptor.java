package _02_File_Encrypt_Decrypt;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileEncryptor {
	/*
	 * Encryption is the process of encoding a message or information
	 * in such a way that only authorized parties can access it and
	 * those who are not authorized cannot.
	 *
	 * A simple shift cipher works by shifting the letters of a message
	 * down based on a key. If our key is 4 then:
	 * 
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 * 
	 * becomes:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 * 
	 * "Hello World" changes to "Lipps Asvph"
	 *
	 * Create a program that takes a message and a key from the user.
	 * Use the key to shift each letter in the users input and save the final result to a file.
	 */
	
	public static void main(String[] args) {
		String input = JOptionPane.showInputDialog("Please input the message you would like to Encrypt.");
		int input1 = Integer.parseInt(JOptionPane.showInputDialog("Please input the amount of letters you would like to shift your message."));
		
		String encrypted = "";
		
		for (int i = 0; i < input.length(); i++) {
			char c = (char) (input.charAt(i) + input1);
					
			if (c > 'z') {
				encrypted += (char) (input.charAt(i) - (26 - input1));
			} else {
				encrypted += (char) (input.charAt(i) + input1);
			}
		}
		
		try {
			FileWriter fw = new FileWriter("src/_02_File_Encrypt_Decrypt/Encrypt.txt");
			
			fw.write(encrypted);
			
			fw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		JOptionPane.showMessageDialog(null, "Encrypted your message. Close this dialog to open the text file!");
		File document = new File("src/_02_File_Encrypt_Decrypt/Encrypt.txt");
		Desktop desktop = Desktop.getDesktop();
		
		try {
			desktop.open(document);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}

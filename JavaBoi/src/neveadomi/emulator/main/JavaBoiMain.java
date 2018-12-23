package neveadomi.emulator.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class JavaBoiMain {

	public static void main(String[] args) throws IOException {
		System.out.print("Enter the GB ROM file: ");
		Scanner in = new Scanner(System.in);
		String path = in.nextLine();
		FileInputStream ROM = new FileInputStream(path);
		
		byte[] codeBuffer = ROM.readAllBytes();
		for(byte operationCode : codeBuffer)
		{
			System.out.print(operationCode+" ");
		}
		
		for(byte operationCode : codeBuffer)
		{
			System.out.print((int)operationCode+" ");
		}
		
		for(byte operationCode : codeBuffer)
		{
			System.out.print((operationCode & 0xFF)+" ");
		}

	}

}

package neveadomi.emulator.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import neveadomi.emulator.cpu.Register;
import neveadomi.emulator.cpu.Register16Bit;
import neveadomi.emulator.memory.Cartridge;

public class JavaBoi {

        public static void main(String[] args) throws IOException {
//			System.out.print("Enter the GB ROM file: ");
//			Scanner in = new Scanner(System.in);
//			String path = in.nextLine();
//			
//			Cartridge cart = new Cartridge(path);
//			System.out.println("TITLE: "+cart.title);
//			System.out.println("Is GB Cartridge?: "+cart.isGB);
//			System.out.println("TYPE: "+cart.type.name());
//			System.out.println("DESTINATION: "+cart.destination.name());
//			System.out.println("RAM BANKS: "+cart.ramBanks);
//			System.out.println("ROM BANKS: "+cart.romBanks);
//			in.close();
			
			Register test = new Register16Bit();
			test.setBit(1, 1);
			System.out.println(test.value());
			Register test2 = new Register16Bit(16);
			System.out.println(test2.value());
			System.out.println(Integer.toBinaryString(16));
        }

}

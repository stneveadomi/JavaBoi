package neveadomi.emulator.main;

import java.io.IOException;
import java.util.Scanner;

import neveadomi.emulator.cpu.CPU;
import neveadomi.emulator.cpu.Register;
import neveadomi.emulator.cpu.Register16Bit;
import neveadomi.emulator.memory.Cartridge;

public class JavaBoi {

        public static void main(String[] args) throws IOException {
			System.out.print("Enter the GB ROM file: ");
			Scanner in = new Scanner(System.in);
			String path = in.nextLine();
			
			Cartridge cart = new Cartridge(path, true);
			/*System.out.println("TITLE: "+cart.title);
			System.out.println("Is GB Cartridge?: "+cart.isGB);
			System.out.println("TYPE: "+cart.type.name());
			System.out.println("DESTINATION: "+cart.destination.name());
			System.out.println("RAM BANKS: "+cart.ramBanks);
			System.out.println("ROM BANKS: "+cart.romBanks);*/
			CPU cpu = new CPU(cart);
			cpu.executeInstruction();
			in.close();
			
//			Register16Bit test = new Register16Bit();
//			test.setBit(1, 1);
//			test.setBit(9, 1);
//			System.out.println(test.value());
//			System.out.println(test.getMS8Bit().value());
//			System.out.println(test.getLS8Bit().value());
//			test.getLS8Bit().setValue(0xFF);
//			System.out.println(test.getMS8Bit().value());
//			System.out.println(test.getLS8Bit().value());
//			System.out.println(test.value());
//			Register test2 = new Register16Bit(0xFFFF);
//			System.out.println(test2.value());
//			System.out.println(Integer.toBinaryString(0xFFFF));
			
        }

}

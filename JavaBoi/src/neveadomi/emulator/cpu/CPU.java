package neveadomi.emulator.cpu;

import neveadomi.emulator.AddressSpace;
import neveadomi.emulator.cpu.opcode.OPCode;
import neveadomi.emulator.memory.Cartridge;

public class CPU {
	
	private AddressSpace CPU_ROM;
	
	private Register16Bit SP;
	
	private Register16Bit PC;
	
	private Register16Bit AF;
	
	private Register16Bit BC;
	
	private Register16Bit DE;
	
	private Register16Bit HL;
	
	public CPU(Cartridge cart)
	{
		AF = new Register16Bit(0x01);
		BC = new Register16Bit(0x0013);
		DE = new Register16Bit(0x00D8);
		HL = new Register16Bit(0x014D);
		PC = new Register16Bit();
		SP = new Register16Bit(0xFFFE);
		CPU_ROM = cart;
	}
	
	public void increasePC(OPCode opcode)
	{
		PC = new Register16Bit(PC.value()+opcode.getOPBytes());
	}
	
	public void executeInstruction()
	{
		while(CPU_ROM.accepts(PC.value()))
		{
			OPCode current = new OPCode(CPU_ROM.getByte(PC.value()));
			increasePC(current);
			System.out.println(current.getArgs());
		}
		
	}
	
	

}

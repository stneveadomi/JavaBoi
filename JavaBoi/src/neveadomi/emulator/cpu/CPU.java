package neveadomi.emulator.cpu;

import neveadomi.emulator.AddressSpace;

public class CPU {
	
	private AddressSpace CPU_ROM;
	
	private Register16Bit SP;
	
	private Register16Bit PC;
	
	private Register16Bit AF;
	
	private Register16Bit BC;
	
	private Register16Bit DE;
	
	private Register16Bit HL;
	
	public CPU()
	{
		AF = new Register16Bit(0x01);
		BC = new Register16Bit(0x0013);
		DE = new Register16Bit(0x00D8);
		HL = new Register16Bit(0x014D);
		PC = new Register16Bit();
		SP = new Register16Bit(0xFFFE);
		CPU_ROM = new MemoryMap();
		OPCode op = new OPCode(0x00);
	}
	
	public void executeInstruction(OPCode opCode)
	{
		switch(opCode.type)
		{
		case ALU:
			switch(opCode.getOPCode())
			{
			//TODO case 0x80: Instructions.ADD(AF.getMS8bits(), y, flags);
			}
			
			
			break;
		case BIT:
			break;
		case CONTROL:
			break;
		case JUMP:
			break;
		case NULL:
			break;
		case STORE:
			break;
		default:
			break;
		}
	}

}

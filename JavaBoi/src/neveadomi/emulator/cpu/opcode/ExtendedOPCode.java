package neveadomi.emulator.cpu.opcode;

import java.util.LinkedList;
import java.util.List;


public class ExtendedOPCode implements OperationCode {

private int opCode;
	
	private String label;
	
	private List<String> args;
	
	private int opBytes;
	
	public ExtendedOPCode(int opCode)
	{
		this.opCode = opCode;
		this.args = new LinkedList<String>();
		generateOpMembers();
	}
	
	public int getAddress()
	{
		return this.opCode;
	}
	
	public String getLabel()
	{
		return this.label;
	}
	
	public int getOPBytes()
	{
		return this.opBytes;
	}

	private void generateOpMembers() 
	{
		this.opBytes = 2;
		switch(opCode)
		{
			case 0x00: this.label = "RLC B"; break;
			case 0x01: this.label = "RLC C"; break;
			case 0x02: this.label = "RLC D"; break;
			case 0x03: this.label = "RLC E"; break;
			case 0x04: this.label = "RLC H"; break;
			case 0x05: this.label = "RLC L"; break;
			case 0x06: this.label = "RLC (HL)"; break;
			case 0x07: this.label = "RLC A"; break;
			case 0x08: this.label = "RRC B"; break;
			case 0x09: this.label = "RRC C"; break;
			case 0x0A: this.label = "RRC D"; break;
			case 0x0B: this.label = "RRC E"; break;
			case 0x0C: this.label = "RRC H"; break;
			case 0x0D: this.label = "RRC L"; break;
			case 0x0E: this.label = "RRC (HL)"; break;
			case 0x0F: this.label = "RRC A"; break;
			case 0x10: this.label = "RL B"; break;
			case 0x11: this.label = "RL C"; break;
			case 0x12: this.label = "RL D"; break;
			case 0x13: this.label = "RL E"; break;
			case 0x14: this.label = "RL H"; break;
			case 0x15: this.label = "RL L"; break;
			case 0x16: this.label = "RL (HL)"; break;
			case 0x17: this.label = "RL A"; break;
			case 0x18: this.label = "RR B"; break;
			case 0x19: this.label = "RR C"; break;
			case 0x1A: this.label = "RR D"; break;
			case 0x1B: this.label = "RR E"; break;
			case 0x1C: this.label = "RR H"; break;
			case 0x1D: this.label = "RR L"; break;
			case 0x1E: this.label = "RR (HL)"; break;
			case 0x1F: this.label = "RR A"; break;
			case 0x20: this.label = "SLA B"; break;
			case 0x21: this.label = "SLA C"; break;
			case 0x22: this.label = "SLA D"; break;
			case 0x23: this.label = "SLA E"; break;
			case 0x24: this.label = "SLA H"; break;
			case 0x25: this.label = "SLA L"; break;
			case 0x26: this.label = "SLA (HL)"; break;
			case 0x27: this.label = "SLA A"; break;
			case 0x28: this.label = "SRA B"; break;
			case 0x29: this.label = "SRA C"; break;
			case 0x2A: this.label = "SRA D"; break;
			case 0x2B: this.label = "SRA E"; break;
			case 0x2C: this.label = "SRA H"; break;
			case 0x2D: this.label = "SRA L"; break;
			case 0x2E: this.label = "SRA (HL)"; break;
			case 0x2F: this.label = "SRA A"; break;
			case 0x30: this.label = "SWAP B"; break;
			case 0x31: this.label = "SWAP C"; break;
			case 0x32: this.label = "SWAP D"; break;
			case 0x33: this.label = "SWAP E"; break;
			case 0x34: this.label = "SWAP H"; break;
			case 0x35: this.label = "SWAP L"; break;
			case 0x36: this.label = "SWAP (HL)"; break;
			case 0x37: this.label = "SWAP A"; break;
			case 0x38: this.label = "SRL B"; break;
			case 0x39: this.label = "SRL C"; break;
			case 0x3A: this.label = "SRL D"; break;
			case 0x3B: this.label = "SRL E"; break;
			case 0x3C: this.label = "SRL H"; break;
			case 0x3D: this.label = "SRL L"; break;
			case 0x3E: this.label = "SRL (HL)"; break;
			case 0x3F: this.label = "SRL A"; break;
			default: this.label = "Unknown Opcode: "+this.opCode; return;
		}
		
		generateArgs();
		
		
	}
	
	/**
	 * This method essentially disassembles the $this.label into arguments in order.
	 * e.g. this.opCode == 0x31, args = [LD, SP, d16]. args.get(0) => "LD"
	 */
	private void generateArgs()
	{
		String separators = " ,";
		
		int position = 0;
		while(position < this.label.length())
		{
			String token = "";
			while(separators.contains(""+this.label.charAt(position)))
				position++;
			while(position < this.label.length() && !separators.contains(""+this.label.charAt(position)))
			{
				token += this.label.charAt(position);
				position++;
			}
			args.add(token);
		}
		
		
	}

	public List<String> getArgs() {
		return this.args;
	}

	@Override
	public int getOPCycles() {
		//TODO ADD cases for (HL) being 16 cycles... maybe just an args.contains("(HL)")? idk.
		return 8;
	}

}

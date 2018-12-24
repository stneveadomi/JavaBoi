package neveadomi.emulator.cpu;

public class OPCode {
	
	private int opCode;
	
	private String label;
	
	private int opBytes;
	
	public OP_Type type;
	
	public enum OP_Type
	{
		CONTROL, JUMP, STORE, ALU, BIT, NULL;
	}
	
	public OPCode(int opCode)
	{
		this.opCode = opCode;
		generateOpCode();
	}
	
	public int getOPCode()
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

	private void generateOpCode() 
	{
		this.opBytes = 1;
		switch(opCode)
		{
			case 0x00: this.label = "NOP"; break;
			case 0x01: opBytes = 3; this.label = "LD BC, d16";break;
			case 0x02: this.label = "LD (BC), A"; break;
			case 0x03: this.label = "INC BC"; break;
			case 0x04: this.label = "INC B"; break;
			case 0x05: this.label = "DEC B"; break;
			case 0x06: opBytes = 2; this.label = "LD B, n"; break;
			case 0x07: this.label = "RLCA"; break;
			case 0x08: opBytes = 3; this.label = "LD (a16), SP"; break;
			case 0x09: this.label = "ADD HL, BC"; break;
			case 0x0A: this.label = "LD A, (BC)"; break;
			case 0x0B: this.label = "DEC BC"; break;
			case 0x0C: this.label = "INC C"; break;
			case 0x0D: this.label = "DEC C"; break;
			case 0x0E: opBytes = 2; this.label = "LD C, d8"; break;
			case 0x0F: this.label = "RRCA"; break;
			case 0x10: this.label = "STOP (Expected NOP to follow)"; break;
			case 0x11: opBytes = 3; this.label = "LD DE, d16"; break;
			case 0x12: this.label = "LD (DE), A"; break;
			case 0x13: this.label = "INC DE"; break;
			case 0x14: this.label = "INC D";  break;
			case 0x15: this.label = "DEC D"; break;
			case 0x16: opBytes = 2; this.label = "LD D, d8"; break;
			case 0x17: this.label = "RLA"; break;
			case 0x18: opBytes = 2; this.label = "JR r8"; break;
			case 0x19: this.label = "ADD HL, DE"; break;
			case 0x1A: this.label = "LD A, (DE)"; break;
			case 0x1B: this.label = "DEC DE"; break;
			case 0x1C: this.label = "INC E"; break;
			case 0x1D: this.label = "DEC E"; break;
			case 0x1E: opBytes = 2; this.label = "LD E, d8"; break;
			case 0x1F: this.label = "RRA"; break;
			case 0x20: opBytes = 2; this.label = "JR NZ, r8"; break;
			case 0x21: opBytes = 3; this.label = "LD HL, d16"; break;
			case 0x22: this.label = "LD (HL+), A"; break;
			case 0x23: this.label = "INC HL"; break;
			case 0x24: this.label = "INC H"; break;
			case 0x25: this.label = "DEC H"; break;
			case 0x26: opBytes = 2; this.label = "LD H, d8"; break;
			case 0x27: this.label = "DAA"; break;
			case 0x28: opBytes = 2; this.label = "JR Z, r8"; break;
			case 0x29: this.label = "ADD HL, HL"; break;
			case 0x2A: this.label = "LD A, (HL+)"; break;
			case 0x2B: this.label = "DEC HL"; break;
			case 0x2C: this.label = "INC L"; break;
			case 0x2D: this.label = "DEC L"; break;
			case 0x2E: opBytes = 2; this.label = "LD L, d8"; break;
			case 0x2F: this.label = "CPL"; break;
			case 0x30: opBytes = 2; this.label = "JR NC, r8"; break;
			case 0x31: opBytes = 3; this.label = "LD SP, d16"; break;
			case 0x32: this.label = "LD (HL-), A"; break;
			case 0x33: this.label = "INC SP"; break;
			case 0x34: this.label = "INC (HL)"; break;
			case 0x35: this.label = "DEC (HL)"; break;
			case 0x36: opBytes = 2; this.label = "LD (HL), d8"; break;
			case 0x37: this.label = "SCF"; break;
			case 0x38: opBytes = 2; this.label = "JR C, r8"; break;
			case 0x39: this.label = "ADD HL, SP"; break;
			case 0x3A: this.label = "LD A, (HL-)"; break;
			case 0x3B: this.label = "DEC SP"; break;
			case 0x3C: this.label = "INC A"; break;
			case 0x3D: this.label = "DEC A"; break;
			case 0x3E: opBytes = 2; this.label = "LD A, d8"; break;
			case 0x3F: this.label = "CCF"; break;
			case 0x40: this.label = "LD B, B"; break;
			case 0x41: this.label = "LD B, C"; break;
			case 0x42: this.label = "LD B, D"; break;
			case 0x43: this.label = "LD B, E"; break;
			case 0x44: this.label = "LD B, H"; break;
			case 0x45: this.label = "LD B, L"; break;
			case 0x46: this.label = "LD B, (HL)"; break;
			case 0x47: this.label = "LD B, A"; break;
			case 0x48: this.label = "LD C, B"; break;
			case 0x49: this.label = "LD C, C"; break;
			case 0x4A: this.label = "LD C, D"; break;
			case 0x4B: this.label = "LD C, E"; break;
			case 0x4C: this.label = "LD C, H"; break;
			case 0x4D: this.label = "LD C, L"; break;
			case 0x4E: this.label = "LD C, (HL)"; break;
			case 0x4F: this.label = "LD C, A"; break;
			case 0x50: this.label = "LD D, B"; break;
			case 0x51: this.label = "LD D, C"; break;
			case 0x52: this.label = "LD D, D"; break;
			case 0x53: this.label = "LD D, E"; break;
			case 0x54: this.label = "LD D, H"; break;
			case 0x55: this.label = "LD D, L"; break;
			case 0x56: this.label = "LD D, (HL)"; break;
			case 0x57: this.label = "LD D, A"; break;
			case 0x58: this.label = "LD E, B"; break;
			case 0x59: this.label = "LD E, C"; break;
			case 0x5A: this.label = "LD E, D"; break;
			case 0x5B: this.label = "LD E, E"; break;
			case 0x5C: this.label = "LD E, H"; break;
			case 0x5D: this.label = "LD E, L"; break;
			case 0x5E: this.label = "LD E, (HL)"; break;
			case 0x5F: this.label = "LD E, A"; break;
			case 0x60: this.label = "LD H, B"; break;
			case 0x61: this.label = "LD H, C"; break;
			case 0x62: this.label = "LD H, D"; break;
			case 0x63: this.label = "LD H, E"; break;
			case 0x64: this.label = "LD H, H"; break;
			case 0x65: this.label = "LD H, L"; break;
			case 0x66: this.label = "LD H, (HL)"; break;
			case 0x67: this.label = "LD H, A"; break;
			case 0x68: this.label = "LD L, B"; break;
			case 0x69: this.label = "LD L, C"; break;
			case 0x6A: this.label = "LD L, D"; break;
			case 0x6B: this.label = "LD L, E"; break;
			case 0x6C: this.label = "LD L, H"; break;
			case 0x6D: this.label = "LD L, L"; break;
			case 0x6E: this.label = "LD L, (HL)"; break;
			case 0x6F: this.label = "LD L, A"; break;
			case 0x70: this.label = "LD (HL), B"; break;
			case 0x71: this.label = "LD (HL), C"; break;
			case 0x72: this.label = "LD (HL), D"; break;
			case 0x73: this.label = "LD (HL), E"; break;
			case 0x74: this.label = "LD (HL), H"; break;
			case 0x75: this.label = "LD (HL), L"; break;
			case 0x76: this.label = "HALT"; break;
			case 0x77: this.label = "LD (HL), A"; break;
			case 0x78: this.label = "LD A, B"; break;
			case 0x79: this.label = "LD A, C"; break;
			case 0x7A: this.label = "LD A, D"; break;
			case 0x7B: this.label = "LD A, E"; break;
			case 0x7C: this.label = "LD A, H"; break;
			case 0x7D: this.label = "LD A, L"; break;
			case 0x7E: this.label = "LD A, (HL)"; break;
			case 0x7F: this.label = "LD A, A"; break;
			case 0x80: this.label = "ADD A, B"; break;
			case 0x81: this.label = "ADD A, C"; break;
			case 0x82: this.label = "ADD A, D"; break;
			case 0x83: this.label = "ADD A, E"; break;
			case 0x84: this.label = "ADD A, H"; break;
			case 0x85: this.label = "ADD A, L"; break;
			case 0x86: this.label = "ADD A, (HL)"; break;
			case 0x87: this.label = "ADD A, A"; break;
			case 0x88: this.label = "ADC A, B"; break;
			case 0x89: this.label = "ADC A, C"; break;
			case 0x8A: this.label = "ADC A, D"; break;
			case 0x8B: this.label = "ADC A, E"; break;
			case 0x8C: this.label = "ADC A, H"; break;
			case 0x8D: this.label = "ADC A, L"; break;
			case 0x8E: this.label = "ADC A, (HL)"; break;
			case 0x8F: this.label = "ADC A, A"; break;
			case 0x90: this.label = "SUB B"; break;
			case 0x91: this.label = "SUB C"; break;
			case 0x92: this.label = "SUB D"; break;
			case 0x93: this.label = "SUB E"; break;
			case 0x94: this.label = "SUB H"; break;
			case 0x95: this.label = "SUB L"; break;
			case 0x96: this.label = "SUB (HL)"; break;
			case 0x97: this.label = "SUB A"; break;
			case 0x98: this.label = "SBC A, B"; break;
			case 0x99: this.label = "SBC A, C"; break;
			case 0x9A: this.label = "SBC A, D"; break;
			case 0x9B: this.label = "SBC A, E"; break;
			case 0x9C: this.label = "SBC A, H"; break;
			case 0x9D: this.label = "SBC A, L"; break;
			case 0x9E: this.label = "SBC A, (HL)"; break;
			case 0x9F: this.label = "SBC A, A"; break;
			case 0xA0: this.label = "AND B"; break;
			case 0xA1: this.label = "AND C"; break;
			case 0xA2: this.label = "AND D"; break;
			case 0xA3: this.label = "AND E"; break;
			case 0xA4: this.label = "AND H"; break;
			case 0xA5: this.label = "AND L"; break;
			case 0xA6: this.label = "AND (HL)"; break;
			case 0xA7: this.label = "AND A"; break;
			case 0xA8: this.label = "XOR B"; break;
			case 0xA9: this.label = "XOR C"; break;
			case 0xAA: this.label = "XOR D"; break;
			case 0xAB: this.label = "XOR E"; break;
			case 0xAC: this.label = "XOR H"; break;
			case 0xAD: this.label = "XOR L"; break;
			case 0xAE: this.label = "XOR (HL)"; break;
			case 0xAF: this.label = "XOR A"; break;
			case 0xB0: this.label = "OR B"; break;
			case 0xB1: this.label = "OR C"; break;
			case 0xB2: this.label = "OR D"; break;
			case 0xB3: this.label = "OR E"; break;
			case 0xB4: this.label = "OR H"; break;
			case 0xB5: this.label = "OR L"; break;
			case 0xB6: this.label = "OR (HL)"; break;
			case 0xB7: this.label = "OR A"; break;
			case 0xB8: this.label = "CP B"; break;
			case 0xB9: this.label = "CP C"; break;
			case 0xBA: this.label = "CP D"; break;
			case 0xBB: this.label = "CP E"; break;
			case 0xBC: this.label = "CP H"; break;
			case 0xBD: this.label = "CP L"; break;
			case 0xBE: this.label = "CP (HL)"; break;
			case 0xBF: this.label = "CP A"; break;
			case 0xC0: this.label = "RET NZ"; break;
			case 0xC1: this.label = "POP BC"; break;
			case 0xC2: opBytes = 3; this.label = "JP NZ, a16"; break;
			case 0xC3: opBytes = 3; this.label = "JP a16"; break;
			case 0xC4: opBytes = 3; this.label = "CALL NZ, a16"; break;
			case 0xC5: this.label = "PUSH BC"; break;
			case 0xC6: opBytes = 2; this.label = "ADD A, d8"; break;
			case 0xC7: this.label = "RST 00H"; break;
			case 0xC8: this.label = "RET Z"; break;
			case 0xC9: this.label = "RET"; break;
			case 0xCA: opBytes = 3; this.label = "JP Z, a16"; break;
			case 0xCB: opBytes = 2; this.label = "PREFIX"; break;
			case 0xCC: opBytes = 3; this.label = "CALL Z, a16"; break;
			case 0xCD: opBytes = 3; this.label = "CALL a16"; break;
			case 0xCE: opBytes = 2; this.label = "ADC A, d8"; break;
			case 0xCF: this.label = "RST 08H"; break;
			case 0xD0: this.label = "RET NC"; break;
			case 0xD1: this.label = "POP DE"; break;
			case 0xD2: opBytes = 3; this.label = "JP NC, a16"; break;
			case 0xD4: opBytes = 3; this.label = "CALL NC, a16"; break;
			case 0xD5: this.label = "PUSH DE"; break;
			case 0xD6: opBytes = 2; this.label = "SUB d8"; break;
			case 0xD7: this.label = "RST 10H"; break;
			case 0xD8: this.label = "RET C"; break;
			case 0xD9: this.label = "RETI"; break;
			case 0xDA: opBytes = 3; this.label = "JP C, a16"; break;
			case 0xDC: opBytes = 3; this.label = "CALL C, a16"; break;
			case 0xDE: opBytes = 2; this.label = "SBC A, d8"; break;
			case 0xDF: this.label = "RST 18H"; break;
			case 0xE0: opBytes = 2; this.label = "LDH (a8), A"; break;
			case 0xE1: this.label = "POP HL"; break;
			case 0xE2: this.label = "LD (C), A"; break;
			case 0xE5: this.label = "PUSH HL"; break;
			case 0xE6: opBytes = 2; this.label = "AND d8"; break;
			case 0xE7: this.label = "RST 20H"; break;
			case 0xE8: opBytes = 2; this.label = "ADD SP, r8"; break;
			case 0xE9: this.label = "JP (HL)"; break;
			case 0xEA: opBytes = 3; this.label = "LD A, (a16)"; break;
			case 0xEE: opBytes = 2; this.label = "XOR d8"; break;
			case 0xEF: this.label = "RST 28H"; break;
			case 0xF0: opBytes = 2; this.label = "LDH A, (a8)"; break;
			case 0xF1: this.label = "POP AF"; break;
			case 0xF2: this.label = "LD A, (C)"; break;
			case 0xF3: this.label = "DI"; break;
			case 0xF5: this.label = "PUSH AF"; break;
			case 0xF6: opBytes = 2; this.label = "OR d8"; break;
			case 0xF7: this.label = "RST 30H"; break;
			case 0xF8: opBytes = 2; this.label = "LD HL, SP+r8"; break;
			case 0xF9: this.label = "LD SP,HL"; break;
			case 0xFA: opBytes = 3; this.label = "LD A, (a16)"; break;
			case 0xFB: this.label = "EI"; break;
			case 0xFE: opBytes = 2; this.label = "CP d8"; break;
			case 0xFF: this.label = "RST 38H"; break;
			default: this.label = "Unknown Opcode: "+this.opCode; this.type = OP_Type.NULL; return;
		}
		
		if(this.label.contains("LD") || this.label.contains("POP") || this.label.contains("PUSH"))
			this.type = OP_Type.STORE;
		else if(this.label.contains("AD") || this.label.contains("SUB") || this.label.contains("AND") || this.label.contains("OR") || this.label.contains("CP") || this.label.contains("SB") || this.label.contains("CCF") || this.label.contains("DAA") || this.label.contains("SCF") || this.label.contains("INC") || this.label.contains("DEC"))
			this.type = OP_Type.ALU;
		else if(this.label.contains("RST") || this.label.contains("J") || this.label.contains("CALL") || this.label.contains("RET"))
			this.type = OP_Type.JUMP;
		else if(this.label.contains("NOP") || this.label.contains("STOP") || this.label.contains("HALT") || this.label.contains("DI") || this.label.contains("EI"))
			this.type = OP_Type.CONTROL;
		else if(this.label.contains("PRE") || this.label.contains("RL") || this.label.contains("RR"))
			this.type = OP_Type.BIT;
		else
			this.type = OP_Type.NULL;
		
		
	}
	
	

}

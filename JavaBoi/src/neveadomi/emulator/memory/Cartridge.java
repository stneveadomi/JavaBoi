package neveadomi.emulator.memory;

import java.io.FileInputStream;
import java.io.IOException;

import neveadomi.emulator.AddressSpace;

public class Cartridge implements AddressSpace {
	
	public enum Destination {
		JP, NJP
	}
	
	public enum Type {
		ROM_ONLY(0),
		ROM_MBC1(1),
		ROM_MBC1_RAM(2),
		ROM_MBC1_RAM_BATT(3),
		ROM_MBC2(5),
		ROM_MBC2_BATTERY(6),
		ROM_RAM(8),
		ROM_RAM_BATTERY(9),
		ROM_MMM01(0xB),
		ROM_MMM01_SRAM(0xC),
		ROM_MMM01_SRAM_BATT(0xD),
		ROM_MBC3_TIMER_BATT(0xF),
		ROM_MBC3_TIMER_RAM_BATT(0x10),
		ROM_MBC3(0x11),
		ROM_MBC3_RAM(0x12),
		ROM_MBC3_RAM_BATT(0x13),
		ROM_MBC5(0x19),
		ROM_MBC5_RAM(0x1A),
		ROM_MBC5_RAM_BATT(0x1B),
		ROM_MBC5_RUMBLE(0x1C),
		ROM_MBC5_RUMBLE_SRAM(0x1D),
		ROM_MBC5_RUMBLE_SRAM_BATT(0x1E),
		POCKET_CAMERA(0x1F),
		BANDAI_TAMA5(0xFD),
		HUDSON_HUC3(0xFE);
		
		private int address;
		
		Type(int address)
		{
			this.address = address;
		}
		
		public static Type getByAddress(int address)
		{
			for(Type t: Type.values())
			{
				if(t.address == address)
				{
					return t;
				}
			}
			
			throw new IllegalArgumentException("Unsupported cartridge type: "+ Integer.toHexString(address));
		}
		
	}
	
	public Type type;
	
	public Destination destination;
	
	public boolean isGB;
	
	private int[] rom;
	
	public String title;
	
	public final int romBanks;
	
	public final int ramBanks;
	
	
	
	public Cartridge(String path) throws IOException
	{
		/*
		 * Initialize the ROM to an int array.
		 */
		FileInputStream ROM = new FileInputStream(path);
		byte[] byteBuffer = ROM.readAllBytes();
		ROM.close();
		rom = new int[byteBuffer.length];
		int pos = 0;
		for(byte operationCode : byteBuffer)
		{
			rom[pos++] = (operationCode & 0xFF);
		}
		
		/*
		 * Extract cartridge information from ROM.
		 */
		title = getTitle();
		
		isGB = isGB();
		
		type = Type.getByAddress(rom[0x147]);
		
		romBanks = getROMSize();
		
		ramBanks = getRAMSize();
		
		if(rom[0x14A] == 0)
		{
			destination = Destination.JP;
		} else 
		{
			destination = Destination.NJP;
		}
		
	}

	private int getROMSize() {
		switch(rom[0x148])
		{
		case 0: return 2;
		case 1: return 4;
		case 2: return 8;
		case 3: return 16;
		case 4: return 32;
		case 5: return 64;
		case 6: return 128;
		case 0x52: return 72;
		case 0x53: return 80;
		case 0x54: return 96;
		default: throw new IllegalArgumentException("Invalid RAM Size at 0x0148");
		}
	}

	private int getRAMSize() {
		switch(rom[0x149])
		{
		case 0: return 0;
		case 1: return 1;
		case 2: return 4;
		case 3: return 16;
		case 4: return 32;
		default: throw new IllegalArgumentException("Invalid RAM Size at 0x0148");
		}
	}

	private boolean isGB() {
		return rom[0x143]!=0x80;
	}

	private String getTitle() {
		String title = "";
		for(int pointer = 0x134; pointer < 0x143; pointer++)
		{
			
			title +=  (char)rom[pointer];
		}
		return title;
	}

	@Override
	public int getByte(int address) 
	{
		return rom[address];
	}
	
	@Override
	public int writeByte(int address, int value) 
	{
		int oldByte = rom[address];
		rom[address] = value;
		return oldByte;
	}

	@Override
	public boolean accepts(int address) {
		return (address>0)&&(address<rom.length);
	}
	
	public int size()
	{
		return rom.length;
	}

}

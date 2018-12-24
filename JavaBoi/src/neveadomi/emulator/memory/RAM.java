package neveadomi.emulator.memory;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import neveadomi.emulator.AddressSpace;

public class RAM implements AddressSpace {
	
	Map<Integer, Integer> rep;
	
	private int size;
	
	public RAM(int size, int startAddress) 
	{
		createNewRep();
		for(int pos = startAddress; pos < startAddress+size; pos++)
		{
			rep.put(pos, 0x00);
		}
		this.size = size;
		
	}

	private void createNewRep() {
		rep = new HashMap<Integer, Integer>();
		size = 0;
	}

	@Override
	public int getByte(int address) {
		return rep.get(address);
	}

	@Override
	public int writeByte(int address, int value) {
		int oldByte = getByte(address);
		rep.put(address, value);
		return oldByte;
	}

	@Override
	public boolean accepts(int address) {
		return rep.keySet().contains(address);
	}

	@Override
	public int size() {
		return rep.size();
	}

}

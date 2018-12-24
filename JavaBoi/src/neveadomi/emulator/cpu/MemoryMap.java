package neveadomi.emulator.cpu;

import java.util.Map;

import neveadomi.emulator.AddressSpace;

public class MemoryMap implements AddressSpace {
	
	private Map<Integer, Integer> rep;
	
	public MemoryMap() {
		//TODO implement.
	}

	@Override
	public int getByte(int address) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int writeByte(int address, int value) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean accepts(int address) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		return 0xFFFF;
	}

}

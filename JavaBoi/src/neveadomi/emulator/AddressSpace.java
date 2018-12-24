package neveadomi.emulator;

/**
 * This represents a fixed address space for various sets of memory.
 * @author Steven Neveadomi
 *
 */
public interface AddressSpace {
	
	public int getByte(int address);
	
	public int writeByte(int address, int value);
	
	public boolean accepts(int address);
	
	public int size();

}

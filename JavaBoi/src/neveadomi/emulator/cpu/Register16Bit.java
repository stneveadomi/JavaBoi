package neveadomi.emulator.cpu;

/**
 * @author Steven Neveadomi
 * 16Bit Register Representation.
 */
public class Register16Bit implements Register {
	
	
	private int[] rep = new int[16];
	
	private void createNewRep()
	{
		for(int x = 0; x < rep.length; x++)
		{
			rep[x] = 0;
		}
	}
	
	/**
	 * Default no arg constructor. Equal to 0.
	 */
	public Register16Bit()
	{
		createNewRep();
	}
	
	/**
	 * Constructor that sets the register to {@code value}.
	 * @requires value must be representable with 16 bits and is unsigned.
	 * @param value
	 */
	public Register16Bit(int value)
	{
		createNewRep();
		//im lazy and need to reverse a string to enter it into the register. Ehh. Whatever.
		String bin = new StringBuilder(Integer.toBinaryString(value)).reverse().toString();
		for(int bit = 0; bit<bin.length();bit++)
		{
			setBit(bit, Integer.parseInt(""+bin.charAt(bit)));
		}
	}
	
	

	/* (non-Javadoc)
	 * @see neveadomi.emulator.cpu.Register#setBit(int, int)
	 */
	@Override
	public void setBit(int bit, int value) {
		this.rep[bit] = value;

	}

	/* (non-Javadoc)
	 * @see neveadomi.emulator.cpu.Register#getBit(int)
	 */
	@Override
	public int getBit(int bit) {
		return this.rep[bit];
	}

	/* (non-Javadoc)
	 * @see neveadomi.emulator.cpu.Register#size()
	 */
	@Override
	public int size() {
		return 16;
	}

	/* (non-Javadoc)
	 * @see neveadomi.emulator.cpu.Register#value()
	 */
	@Override
	public int value() {
		String value = "";
		for(int x = 15; x >= 0;x--)
		{
			value += getBit(x);
		}
		
		return Integer.parseInt(value,2);
	}

}

package neveadomi.emulator.cpu;

/**
 * @author Steven Neveadomi
 * 16Bit Register Representation.
 */
public class Register16Bit implements Register {
	
	
	private Register8Bit repMS;
	private Register8Bit repLS;
	
	private void createNewRep()
	{
		repMS = new Register8Bit();
		repLS = new Register8Bit();
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
	
	public Register8Bit getMS8Bit() {
		return repMS;
	}
	
	public Register8Bit getLS8Bit() {
		return repLS;
	}
	
	/**
	 * Sets the 8 most significant bits of the register.
	 * @requires value in an unsigned binary representation is less than 8 bits.
	 */
	public void setMS8Bits(int value)
	{
		String bin = new StringBuilder(Integer.toBinaryString(value)).reverse().toString();
		for(int bit = 8; bit<16;bit++)
		{
			if(bit<bin.length()+8)
				setBit(bit, Integer.parseInt(""+bin.charAt(bit)));
			else
				setBit(bit, 0);
		}
	}
	
	/**
	 * Sets the 8 least significant bits of the register.
	 * @requires value in an unsigned binary representation is less than 8 bits.
	 */
	public void setLS8Bits(int value)
	{
		String bin = new StringBuilder(Integer.toBinaryString(value)).reverse().toString();
		for(int bit = 0; bit<8;bit++)
		{
			if(bit<bin.length()+8)
				setBit(bit, Integer.parseInt(""+bin.charAt(bit)));
			else
				setBit(bit, 0);
		}
	}
	
	

	/* (non-Javadoc)
	 * @see neveadomi.emulator.cpu.Register#setBit(int, int)
	 */
	@Override
	public void setBit(int bit, int value) {
		if(bit>7)
		{
			repMS.setBit(bit-8, value);
			return;
		}
		repLS.setBit(bit, value);

	}

	/* (non-Javadoc)
	 * @see neveadomi.emulator.cpu.Register#getBit(int)
	 */
	@Override
	public int getBit(int bit) {
		if(bit>7)
			return repMS.getBit(bit-8);
		return repLS.getBit(bit);
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

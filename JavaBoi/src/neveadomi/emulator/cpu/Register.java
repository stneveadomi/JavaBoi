package neveadomi.emulator.cpu;

public interface Register {
	
	/**
	 * Sets the {@code bit} in the register to the {@code value}.
	 * @requires 
	 * 0 <= bit <= this.size()
	 * value == 1 | value == 0
	 * @param bit
	 * @param value
	 */
	public void setBit(int bit, int value);
	
	/**
	 * Returns the int value of the {@code bit} in the register.
	 * @param bit
	 * @return value of the bit.
	 */
	public int getBit(int bit);
	
	/**
	 * Returns the size of the register.
	 * @return the number of bits in the register.
	 */
	public int size();
	
	/**
	 * Returns the int value of the register itself.
	 * @return unsigned int representation of register.
	 */
	public int value();

}

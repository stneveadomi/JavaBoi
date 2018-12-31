package neveadomi.emulator.cpu.opcode;

import java.util.List;

public interface OperationCode {
	
	public int getAddress();
	
	public String getLabel();
	
	public int getOPBytes();
	
	public List<String> getArgs();
	
	public int getOPCycles();

}

public abstract class Opcode implements IOpcode
{
	protected int opCodeBinary;
	private static String[] ocList = {"add", "addv", "and",
		      "br", "brf", "call", "dec",
			  "decv", "div", "dup",
		      "enter",
			  "halt",
			  "inc", "incv",
			  "ldc", "ldv",
			  "mul",
			  "neg", "not",
			  "or",
			  "pop",
			  "rem", "ret",
			  "shl", "shr", "sub", "stv",
			  "teq", "tge", "tgt", "tle,", "tlt", "tne", "trap",
			  "xor"};
	
	public int getBinary()
	{
		return opCodeBinary;
	}

	// Check if a given string is an opcode
	public static boolean isOpcode(String candidate)
	{
		for (int i = 0; i < ocList.length; i++)
		{
			if (ocList[i].equals(candidate))
			{
				return true;
			}
		}
	
		return false;
	}
	
	// Check if a given string is an opcode. If it is, return the opcode as a string
	public static String getOpCode(String candidate)
	{
		if (isOpcode(candidate))
		{
			return candidate;
		}
	
		return null;
	}
}

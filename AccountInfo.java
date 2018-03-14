/*
 * This class defines the AccountInfo object.
 *
 * Each object of this type will store the information for
 * a specific account.
 *
 */
 
 import java.util.Random;
 
 public class AccountInfo
 {
	private static Random random = new Random();
 
 	private String code;
	private String password;
 
	public AccountInfo (String code, String characters, int length)
	{
		setCode(code);
		setPassword(generatePassword(characters, length));
	}
	
	/** Generate and return a random password according to the static values */
	private static String generatePassword (String validCharacters, int length)
	{
		String password = "";
		
		for (int i = 0; i < length; i++)
		{
			char character = validCharacters.charAt(random.nextInt(validCharacters.length()));
			password += (""+character);
		}
		
		return password;
	}
	
	public String getCode()
	{
		return this.code;
	}
	
	public void setCode (String code)
	{
		this.code = code;
	}
	
	public String getPassword ()
	{
		return this.password;
	}
	
	public void setPassword (String password)
	{
		this.password = password;
	}
 }
/*
 * This class defines the AccountInfo object.
 *
 * Each object of this type will store the information for
 * a specific account.
 *
 */
 
 public class AccountInfo
 {
 	private String code;
	private String password;
 
	public AccountInfo (String code, String password)
	{
		setCode(code);
		setPassword(password);
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
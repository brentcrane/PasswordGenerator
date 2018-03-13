/*
 * This class defines the AccountInfo object.
 *
 * Each object of this type will store the information for
 * a specific account.
 *
 */
 
 public class AccountInfo
 {
	private String password;
	private String code;
 
	public AccountInfo (String password, String code)
	{
		setPassword(password);
		setCode(code);
	}
	
	public String getPassword ()
	{
		return this.password;
	}
	
	public void setPassword (String password)
	{
		this.password = password;
	}
	
	public String getCode()
	{
		return this.code;
	}
	
	public void setCode (String code)
	{
		this.code = code;
	}
 }
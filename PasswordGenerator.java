import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class PasswordGenerator
{
	private static String validCharacters;
	private static int length;	
	private static ArrayList <AccountInfo> accountList;
	private static Scanner input;
	private static Random random;

	/** Main method */
	public static void main (String [] args)
	{
		int passwordCount;
		String accountCode;
		String accountPassword;
	
		init();
		print("Enter the length of the passwords: ");
		length = input.nextInt();
		print("Enter the number of passwords to create: ");
		passwordCount = input.nextInt();
		print("\n");
		for (int i = 0; i < passwordCount; i++)
		{
			System.out.print("Enter the account code: ");
			accountCode = input.next();
			accountPassword = generatePassword();
			addAccountInfo(accountCode, accountPassword);
			print("Account added.\n");
		}
		displayAccounts();
		
		finish();
	}
	
	/** Initialize the static variables */
	private static void init ()
	{
		accountList = new ArrayList<>();
		validCharacters = "ABC";
		length = 0;
		input = new Scanner (System.in);
		random = new Random();
	}
	
	/** Clean up anything that needs cleaning */
	private static void finish ()
	{
		input.close();
	}
	
	/** Generate and return a random password according to the static values */
	private static String generatePassword ()
	{
		String password = "";
		
		for (int i = 0; i < length; i++)
		{
			char character = validCharacters.charAt(random.nextInt(validCharacters.length()));
			password += (""+character);
		}
		
		return password;
	}
	
	/** Add an account to the account list with the given values */
	private static void addAccountInfo (String code, String password)
	{
		accountList.add(new AccountInfo(code, password));
	}
	
	/** Display the data for the accounts in the ArrayList */
	private static void displayAccounts ()
	{
		for (int i = 0; i < accountList.size(); i++)
		{
			System.out.println(
				"Code: "+accountList.get(i).getCode()+
				"\tPassword: "+accountList.get(i).getPassword());
		}
	}
	
	/** Method to print strings, because I'm lazy */
	private static void print(String string)
	{
		System.out.print(string);
	}
}
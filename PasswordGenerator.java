/*
 * Primary class for my "password generator" program
 *
 * Created by Brent Crane
 * March 13th, 2018
 *
 */

import java.util.ArrayList;
import java.util.Scanner;

public class PasswordGenerator
{
	private static String validCharacters;
	private static int length;	
	private static ArrayList <AccountInfo> accountList;
	private static Scanner input;

	public static void main (String [] args)
	{
		int passwordCount;
		String accountCode;
		String accountPassword;
	
		accountList = new ArrayList<>();
		validCharacters = "abcdefghijklmnopqrstuvwxyz0123456789";
		length = 0;
		input = new Scanner (System.in);
		
		System.out.print("Enter the length of the passwords: ");
		length = input.nextInt();
		
		System.out.print("Enter the number of passwords to create: ");
		passwordCount = input.nextInt();
		
		System.out.println("\n====================\n");
		
		for (int i = 0; i < passwordCount; i++)
		{
			System.out.print("Enter the account code: ");
			accountCode = input.next();
			accountList.add(new AccountInfo(accountCode, validCharacters, length));
		}
		
		displayAccounts();
		input.close();
	}
	
	/** Display the data for the accounts in the ArrayList */
	private static void displayAccounts ()
	{
		System.out.println("\n====================\nGenerated Passwords:\n");
		for (int i = 0; i < accountList.size(); i++)
		{
			System.out.println(
				"Code: "+accountList.get(i).getCode()+
				"\tPassword: "+accountList.get(i).getPassword());
		}
	}
}
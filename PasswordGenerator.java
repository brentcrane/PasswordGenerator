/*
 * Primary class for my "password generator" program
 *
 * Created by Brent Crane
 * March 13th, 2018
 *
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
 
public class PasswordGenerator
{
	// Global variables
	private static Random random = new Random();
	private static String validCharacters;
	private static int length;
	private static ArrayList <AccountInfo> accountList;
	private static ArrayList <Character> availableCharacters;
	private static Scanner input;

	public static void main (String [] args)
	{
		// Local variables
		int passwordCount;
		int maximumRepeatingCharacters;
		int requiredLength;
		String accountCode;
		String accountPassword;

		// Open the scanner
		input = new Scanner (System.in);
	
		// Define the arraylists
		accountList = new ArrayList<>();
		availableCharacters = new ArrayList<Character>();

		// String that holds all valid password characters
		validCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_-!";
		
		// Get required parameters from the user
		System.out.print("Enter the maximum number of repeating characters: ");
		maximumRepeatingCharacters = input.nextInt();
		System.out.print("Enter the required length of the passwords: ");
		requiredLength = input.nextInt();
		System.out.print("Enter the number of passwords to create: ");
		passwordCount = input.nextInt();

		// Populate the list with the available characters for the passwords
		for (int i = 0; i < maximumRepeatingCharacters; i++)
		{
			for (int j = 0; j < validCharacters.length(); j++)
			{
				availableCharacters.add(validCharacters.charAt(j));
			}
		}


		System.out.println("\n====================\n");

		// Ask user to enter the codes for the passwords to be generated		
		for (int i = 0; i < passwordCount; i++)
		{
			System.out.print("Enter the account code: ");
			accountCode = input.next();

			String generatedPassword = generatePassword(requiredLength);

			accountList.add(new AccountInfo(accountCode, generatedPassword));
		}
		
		// Print out the resulting passwords and close the scanner
		displayAccounts();
		input.close();
	}

	
	// Generate and return a random password of the given length
	private static String generatePassword (int length)
	{
		String result = "";
		// Make a local copy of the character list. This avoids the problem where no two passwords could contain the same characters
		ArrayList<Character> listCopy = copyCharacterList(availableCharacters);
		
		// Add characters to the result list until the desired length is reached
		for (int i = 0; i < length; i++)
		{
			int characterIndex = random.nextInt(listCopy.size());
			char character = listCopy.get(characterIndex);
			listCopy.remove(characterIndex);
			result += (""+character);
		}
		
		return result;
	}


	// Display the data for the accounts in the accounts list
	private static void displayAccounts ()
	{
		System.out.println("\n====================\nGenerated Passwords:\n");
		for (int i = 0; i < accountList.size(); i++)
		{
			System.out.println(
				"Code: "+accountList.get(i).getCode()+
				"\nPassword: "+accountList.get(i).getPassword()+
				"\n");
		}
		System.out.println("\n====================");
	}


	// Make a copy of the character arraylist, as to allow for the use of the same characters between multiple passwords
	private static ArrayList<Character> copyCharacterList (ArrayList<Character> original)
	{
		ArrayList<Character> resultList = new ArrayList<>();
		for (Character c : original)
		{
			resultList.add(c);
		}
		return resultList;
	}
}
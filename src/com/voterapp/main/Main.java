package com.voterapp.main;
import java.util.Scanner;
import com.voterapp.exception.InvalidVoterException;
import com.voterapp.service.ElectionBoothImpl;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		try {
		System.out.println("Enter your Age");
		int age = sc.nextInt();
		System.out.println("Enter your Location");
		String location = sc.next();
		System.out.println("Enter your Voter Number");
		int vid = sc.nextInt();
		ElectionBoothImpl electionBooth = new ElectionBoothImpl(); 
		
			System.out.println(electionBooth.checkEligibilility(age, location, vid));
			
		} catch (InvalidVoterException e) {
			System.out.println(e.getMessage());
		}finally {
			sc.close();
		}
	}

}

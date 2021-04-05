package com.voterapp.service;

import com.voterapp.exception.InvalidVoterException;
import com.voterapp.exception.LocalityNotFoundException;
import com.voterapp.exception.NoVoterIDException;
import com.voterapp.exception.UnderAgeException;

public class ElectionBoothImpl implements ElectionBooth {

	String[] localities = { "delhi", "mumbai", "goa", "pune", "utrakhand", "punjab" };

	@Override
	public boolean checkEligibilility(int age, String locality, int vid) throws InvalidVoterException {
		try {
			if (checkAge(age) && checkLocality(locality) && checkVoterId(vid))
				return true;
		} catch (UnderAgeException | LocalityNotFoundException | NoVoterIDException e) {
			throw e;
		}

		return true;
	}

	private boolean checkAge(int age) throws UnderAgeException {
		if (age < 18) {
			throw new UnderAgeException("Voter is Under Age..");
		}
		return true;
	}

	private boolean checkLocality(String locality) throws LocalityNotFoundException {
		for (String loc : localities) {
			if (locality.equalsIgnoreCase(loc)) {
				return true;
			}
		}
		throw new LocalityNotFoundException("Locality doesn't Match..");
	}

	private boolean checkVoterId(int vid) throws NoVoterIDException {
		if (vid > 9999 && vid < 1000) {
			throw new NoVoterIDException("Voter Number is Invalid..");
		}
		return true;
	}
}

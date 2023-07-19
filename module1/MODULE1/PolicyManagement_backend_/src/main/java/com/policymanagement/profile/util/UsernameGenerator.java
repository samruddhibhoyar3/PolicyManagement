package com.policymanagement.profile.util;

public class UsernameGenerator {

	public static String generateUsername(String firstName, String lastName) {
		String formattedFirstName = getFormattedName(firstName, 2);
		String formattedLastName = getFormattedName(lastName, 4);
		String serialNumber = generateSerialNumber(4);
		return formattedFirstName + formattedLastName + serialNumber;
	}

	private static String getFormattedName(String name, int length) {
		if (name.length() >= length) {
			return name.substring(0, length).toLowerCase();
		} else {
			return name.toLowerCase() + generateRandomString(length - name.length());
		}
	}

	private static String generateSerialNumber(int length) {
		int min = (int) Math.pow(10, length - 1);
		int max = (int) Math.pow(10, length) - 1;
		int serialNumber = (int) (Math.random() * (max - min + 1)) + min;
		return String.format("%0" + length + "d", serialNumber);
	}

	private static String generateRandomString(int length) {
		StringBuilder sb = new StringBuilder();
		String characters = "abcdefghijklmnopqrstuvwxyz";
		for (int i = 0; i < length; i++) {
			int randomIndex = (int) (Math.random() * characters.length());
			sb.append(characters.charAt(randomIndex));
		}
		return sb.toString();
	}

}

package com.ontariotechu.sofe3980U;

public class Binary {
    private String number = "0";

    public Binary(String number) {
        for (int i = 0; i < number.length(); i++) {
            char ch = number.charAt(i);
            if (ch != '0' && ch != '1') {
                this.number = "0";
                return;
            }
        }
        int beg;
        for (beg = 0; beg < number.length(); beg++) {
            if (number.charAt(beg) != '0')
                break;
        }
        this.number = number.substring(beg);
        if (this.number.isEmpty()) {
            this.number = "0";
        }
    }

    public String getValue() {
        return this.number;
    }

    public static Binary add(Binary num1, Binary num2) {
        int ind1 = num1.number.length() - 1;
        int ind2 = num2.number.length() - 1;
        int carry = 0;
        String num3 = "";

        while (ind1 >= 0 || ind2 >= 0 || carry != 0) {
            int sum = carry;
            if (ind1 >= 0) sum += (num1.number.charAt(ind1--) == '1') ? 1 : 0;
            if (ind2 >= 0) sum += (num2.number.charAt(ind2--) == '1') ? 1 : 0;
            carry = sum / 2;
            num3 = ((sum % 2 == 0) ? "0" : "1") + num3;
        }
        return new Binary(num3);
    }

    public static Binary and(Binary num1, Binary num2) {
		int len1 = num1.number.length();
		int len2 = num2.number.length();
		int maxLen = Math.max(len1, len2);
		
		// Pad the shorter number with leading zeros
		String num1Padded = "0".repeat(maxLen - len1) + num1.number;
		String num2Padded = "0".repeat(maxLen - len2) + num2.number;
		
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < maxLen; i++) {
			char bit1 = num1Padded.charAt(i);
			char bit2 = num2Padded.charAt(i);
			result.append((bit1 == '1' && bit2 == '1') ? '1' : '0');
		}
		
		return new Binary(result.toString());
	}

    public static Binary or(Binary num1, Binary num2) {
		int len1 = num1.number.length();
		int len2 = num2.number.length();
		int maxLen = Math.max(len1, len2);
		
		// Pad the shorter number with leading zeros
		String num1Padded = "0".repeat(maxLen - len1) + num1.number;
		String num2Padded = "0".repeat(maxLen - len2) + num2.number;
		
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < maxLen; i++) {
			char bit1 = num1Padded.charAt(i);
			char bit2 = num2Padded.charAt(i);
			result.append((bit1 == '1' || bit2 == '1') ? '1' : '0');
		}
		
		return new Binary(result.toString());
	}

    public static Binary multiply(Binary num1, Binary num2) {
        int decimal1 = Integer.parseInt(num1.number, 2);
        int decimal2 = Integer.parseInt(num2.number, 2);
        int product = decimal1 * decimal2;
        return new Binary(Integer.toBinaryString(product));
    }
}

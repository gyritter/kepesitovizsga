package hu.nive.ujratervezes.kepesitovizsga.addigits;

public class AddDigits {

    public int addDigits(String inputs) {
        if (inputs == null || inputs.length() == 0) {
            return -1;
        }
        int sum = 0;
        for (char c : inputs.toCharArray()) {

            if (Character.isDigit(c)) {
                sum += c - '0';
            }
        }
        return sum;

    }
}

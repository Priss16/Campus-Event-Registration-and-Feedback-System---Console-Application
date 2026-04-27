package Campus.util;

import Campus.exception.InvalidDateFormatException;

public class DateValidator {
    public static void validate(String date) throws InvalidDateFormatException {
        if (!date.matches("\\d{2}-\\d{2}-\\d{4}")) {
            throw new InvalidDateFormatException(
                "Invalid date format. Use dd-mm-yyyy"
            );
        }
    }
}

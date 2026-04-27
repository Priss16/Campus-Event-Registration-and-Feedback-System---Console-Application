package Campus.util;

import Campus.exception.InvalidPhoneNumberException;

public class PhoneValidator {
    public static void validate(String phone) throws InvalidPhoneNumberException {
        if (!phone.matches("\\d{10}")) {
            throw new InvalidPhoneNumberException(
                "Phone number must contain exactly 10 digits"
            );
        }
    }
}

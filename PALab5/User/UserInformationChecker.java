package User;

import User.InvalidUserInfoException;

public class UserInformationChecker {
    protected static void validateUserName(String userName) {
        int i;
        for (i = 0; i < userName.length(); i++) {
            if (checkValidCharacter(userName.charAt(i)) == false) {
                throw new InvalidUserInfoException(userName);
            }
        }
    }

    protected static void validateUserID(int userID) {
        if (!(userID >= 0 && userID <= 999)) {
            throw new InvalidUserInfoException(userID);
        }
    }

    private static boolean checkValidCharacter(char character) {
        if (character >= 'a' && character <= 'z') {
            return true;
        } else if (character >= 'A' && character <= 'Z') {
            return true;
        } else if (character >= '0' && character <= '9') {
            return true;
        }
        return false;
    }
}

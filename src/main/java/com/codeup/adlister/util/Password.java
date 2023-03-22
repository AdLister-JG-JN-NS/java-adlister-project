package com.codeup.adlister.util;

import org.mindrot.jbcrypt.BCrypt;
// class for password
public class Password {
    private static final int ROUNDS = 12;
// hash and check password
    public static String hash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(ROUNDS));
    }

    public static boolean check(String password, String hash) {
        return BCrypt.checkpw(password, hash);
    }
}

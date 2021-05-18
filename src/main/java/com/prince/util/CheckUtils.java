/**
 * @AUTHOR Prince
 * @TIME 2021/5/17 16:32
 */

package com.prince.util;

public class CheckUtils {
    public static boolean checkUsername(String username){
        return username.matches("\\d{5,10}");
    }

    public static boolean checkPassword(String password){
        return password.matches("\\w{6,16}");
    }
}

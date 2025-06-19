/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author anish
 */


import java.util.HashMap;

public class OtpStore {
    private static final HashMap<String, String> map = new HashMap<>();

    public static void store(String email, String otp) {
        map.put(email, otp);
    }

    public static boolean verify(String email, String otp) {
        return map.containsKey(email) && map.get(email).equals(otp);
    }

    public static void remove(String email) {
    }
}

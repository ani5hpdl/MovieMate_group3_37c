/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author anish
 */
public class UserSession {
    private static Integer userId;
    
    public static void setUserId(int id){
        userId = id;
    }
    public static Integer getUserId(){
        return userId;  
    }
    public static void clear(){
        userId = null;
    }
}

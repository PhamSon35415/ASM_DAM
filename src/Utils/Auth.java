/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import model.nhanVienEntity;

public class Auth {

    public static nhanVienEntity user = null;

    public static void clear() {
        Auth.user = null;
    }

    public static boolean islogin() {
        return Auth.user != null;
    }

    public static boolean isManager() {
        return Auth.islogin() && user.getVaiTro2() == "Quản lí";
    }
}

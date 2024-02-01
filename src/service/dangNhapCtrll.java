/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Utils.DBConnect;
import model.nhanVienEntity;
import java.sql.*;

/**
 *
 * @author Admin
 */
public class dangNhapCtrll {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = "";

    public nhanVienEntity dangnhap(String maNV) {
        nhanVienEntity nv = null;
        sql = "select* from NhanVien where MaNV=?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, maNV);
            rs = ps.executeQuery();
            while (rs.next()) {
                nv = new nhanVienEntity(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }
            return nv;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

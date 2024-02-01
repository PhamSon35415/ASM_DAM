/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Utils.DBConnect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.nhanVienEntity;

/**
 *
 * @author Admin
 */
public class quanlyNvCtrll {
    
    Connection con = null;
    CallableStatement stmt = null;
    ResultSet rs = null;
    String sql = "";
    List<nhanVienEntity> list;
    
    public List<nhanVienEntity> getAllNV() {
        list = new ArrayList<>();
        try {
            sql = "{Call get_thongtinNV()}";
            con = DBConnect.getConnection();
            stmt = con.prepareCall(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                nhanVienEntity nv = new nhanVienEntity(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                list.add(nv);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public boolean deleteNV(String ma) {
        boolean result = false;
        try {
            sql = "";
            
        } catch (Exception e) {
        }
        return result;
    }
    
    public int AddNV(nhanVienEntity nv) {
        int result = 0;
        try {
            sql = "{Call themNV(?,?,?,?)}";
            con = DBConnect.getConnection();
            stmt = con.prepareCall(sql);
            stmt.setString(1, nv.getMaNV());
            stmt.setString(2, nv.getMatKhau());
            stmt.setString(3, nv.getHoTen());
            stmt.setInt(4, nv.getVaiTro());
            result = stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            result = 0;
        }
        return result;
    }
    
    public int UpdateNV(nhanVienEntity nv) {
        int result = 0;
        try {
            sql = "{Call UpdateNV(?,?,?,?)}";
            con = DBConnect.getConnection();
            stmt = con.prepareCall(sql);
            stmt.setString(1, nv.getMatKhau());
            stmt.setString(2, nv.getHoTen());
            stmt.setInt(3, nv.getVaiTro());
            result = stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            result = 0;
        }
        return result;
    }

    public nhanVienEntity getAt(int index) {
        return list.get(index);
    }
}

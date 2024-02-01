/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Utils.DBConnect;
import model.khoaHocEntity;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.chuyenDeEntity;
import java.util.Date;
/**
 *
 * @author Admin
 */
public class quanLyKhoaHocCtrll {

    Connection con = null;
    PreparedStatement ps = null;
    CallableStatement stmt = null;
    ResultSet rs = null;
    List<khoaHocEntity> list;
    String sql = "";

    public List<khoaHocEntity> getAll() {
        list = new ArrayList<>();
        try {
            sql = "{Call get_KhoaHoc}";
            con = DBConnect.getConnection();
            stmt = con.prepareCall(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                khoaHocEntity kh = new khoaHocEntity(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getDate(8), rs.getString(9));
                list.add(kh);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<khoaHocEntity> chonChuyenDe(String ten) {
        list = new ArrayList<>();
        try {
            sql = "{Call chon_ChuyenDe(?)}";
            con = DBConnect.getConnection();
            stmt = con.prepareCall(sql);
            stmt.setObject(1, ten);
            rs = stmt.executeQuery();
            while (rs.next()) {
                khoaHocEntity kh = new khoaHocEntity(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getDate(8), rs.getString(9));
                list.add(kh);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public List<chuyenDeEntity> getTenChuyenDe() {
        List<chuyenDeEntity> list = new ArrayList<>();
        try {
            sql = "{Call get_ChuyenDe}";
            con = DBConnect.getConnection();
            stmt = con.prepareCall(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                chuyenDeEntity cd;
                cd = new chuyenDeEntity(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7));
                list.add(cd);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int updateChuyende(Date ngayKG, int makh) {
        int result = 0;
        try {
            sql = "update KhoaHoc set NgayKG=? where MaKH=?";
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setDate(1, new java.sql.Date(ngayKG.getTime()));
            ps.setInt(2, makh);
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            result = 0;
        }
        return result;
    }

    public khoaHocEntity getAt(int index) {
        return list.get(index);
    }

   
}

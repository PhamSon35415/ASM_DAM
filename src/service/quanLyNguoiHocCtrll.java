/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Utils.DBConnect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.NguoiHocEntity;

/**
 *
 * @author Admin
 */
public class quanLyNguoiHocCtrll {

    Connection con = null;
    PreparedStatement ps = null;
    CallableStatement stmt = null;
    ResultSet rs = null;
    String sql = "";
    List<NguoiHocEntity> list;

    public List<NguoiHocEntity> getAll() {
        list = new ArrayList<>();
        try {
            sql = "{Call get_NguoiHoc}";
            con = DBConnect.getConnection();
            stmt = con.prepareCall(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                NguoiHocEntity nh = new NguoiHocEntity(rs.getString(1), rs.getString(2), rs.getBoolean(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getDate(9));
                list.add(nh);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    

    public int themNguoiHoc(NguoiHocEntity nh) {
        int result = 0;
        try {
            sql = "insert into NguoiHoc(MaNH,HoTen,GioiTinh,NgaySinh,DienThoai,Email,GhiChu,MaNV,NgayDK) values(?,?,?,?,?,?,?,?,?)";
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, nh.getMaNH());
            ps.setObject(2, nh.getHoTen());
            ps.setObject(3, nh.isGioiTinh());
            ps.setObject(4, nh.getNgaySinh());
            ps.setObject(5, nh.getDienThoai());
            ps.setObject(6, nh.getEmail());
            ps.setObject(7, nh.getGhiChu());
            ps.setObject(8, nh.getMaNV());
            ps.setObject(9, nh.getNgayDK());
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            result = 0;
        }
        return result;
    }

    public int UpdateNguoiHoc(NguoiHocEntity nh, String ma) {
        int result = 0;
        try {
            sql = "update NguoiHoc set HoTen=?,GioiTinh=?,NgaySinh=?,DienThoai=?,Email=?,GhiChu=? where MaNH=?";
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(7, nh.getMaNH());
            ps.setObject(1, nh.getHoTen());
            ps.setObject(2, nh.isGioiTinh());
            ps.setObject(3, nh.getNgaySinh());
            ps.setObject(4, nh.getDienThoai());
            ps.setObject(5, nh.getEmail());
            ps.setObject(6, nh.getGhiChu());
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            result = 0;
        }
        return result;
    }

    public List<NguoiHocEntity> TimNH(String ten) {
        list = new ArrayList<>();
        try {
            sql = "select * from NguoiHoc where HoTen like ?";
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ten);
            rs = ps.executeQuery();
            while (rs.next()) {
                NguoiHocEntity nh = new NguoiHocEntity(rs.getString(1), rs.getString(2), rs.getBoolean(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getDate(9));
                list.add(nh);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public NguoiHocEntity getAt(int index) {
        return list.get(index);
    }
}

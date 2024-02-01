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
import model.hocVienEtity;
import model.nhanVienEntity;

/**
 *
 * @author Admin
 */
public class quanLyHocVienCtrll {

    Connection con = null;
    PreparedStatement ps = null;
    CallableStatement stmt = null;
    ResultSet rs = null;
    String sql = "";
    List<hocVienEtity> list;
    List<NguoiHocEntity> listnh;

    public List<hocVienEtity> getAllhv() {
        list = new ArrayList<>();
        try {
            sql = "{Call get_HocVien}";
            con = DBConnect.getConnection();
            stmt = con.prepareCall(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                hocVienEtity hv = new hocVienEtity(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getDouble(5));
                list.add(hv);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<hocVienEtity> LocHV(String tenCD, int tenKH) {
        list = new ArrayList<>();
        try {
            sql = "{Call LocHocVien(?,?)}";
            con = DBConnect.getConnection();
            stmt = con.prepareCall(sql);
            stmt.setString(1, tenCD);
            stmt.setInt(2, tenKH);
            rs = stmt.executeQuery();
            while (rs.next()) {
                hocVienEtity hv = new hocVienEtity(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getDouble(5));
                list.add(hv);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<hocVienEtity> LocHVtheoCD(String tenCD) {
        List<hocVienEtity> list = new ArrayList<>();
        try {
            sql = "{Call LocHocVienTheoChuyenDe(?)}";
            con = DBConnect.getConnection();
            stmt = con.prepareCall(sql);
            stmt.setString(1, tenCD);
            rs = stmt.executeQuery();
            while (rs.next()) {
                hocVienEtity hv = new hocVienEtity(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getDouble(5));
                list.add(hv);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<NguoiHocEntity> getAllnh(int makh) {
        listnh = new ArrayList<>();
        try {
            sql = "{Call LocNguoiHoc(?)}";
            con = DBConnect.getConnection();
            stmt = con.prepareCall(sql);
            stmt.setInt(1, makh);
            rs = stmt.executeQuery();
            while (rs.next()) {
                NguoiHocEntity nh = new NguoiHocEntity(rs.getString(1), rs.getString(2), rs.getBoolean(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getDate(9));
                listnh.add(nh);
            }
            return listnh;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int themHV(NguoiHocEntity nh, int maHV, int makh) {
        int result = 0;
        try {
            sql = "insert into HocVien(MaHV,MaKH,MaNH,Diem) values(?,?,?,?)";
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, maHV);
            ps.setObject(2, makh);
            ps.setObject(3, nh.getMaNH());
            ps.setObject(4, 0);
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            result = 0;
        }
        return result;
    }

    public int DeleteHV(NguoiHocEntity nh) {
        int result = 0;
        try {
            sql = "delete from HocVien where MaNH LIKE ?";
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, nh.getMaNH());
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            result = 0;
        }
        return result;
    }

    public NguoiHocEntity getAt(int index) {
        return listnh.get(index);
    }

  
}

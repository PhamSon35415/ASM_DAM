/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Utils.DBConnect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.chuyenDeEntity;

/**
 *
 * @author Admin
 */
public class quanLyChuyenDeCtrll {

    Connection con = null;
    ResultSet rs = null;
    CallableStatement stmt = null;
    PreparedStatement ps = null;
    String sql = "";
    List<chuyenDeEntity> list;

    public List<chuyenDeEntity> getAllCD() {
        list = new ArrayList<>();
        try {
            sql = "{Call get_ChuyenDe}";
            con = DBConnect.getConnection();
            stmt = con.prepareCall(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                chuyenDeEntity cd = new chuyenDeEntity(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getString(5), rs.getString(6),rs.getString(7));
                list.add(cd);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int ThemCD(chuyenDeEntity cd) {
        int result = 0;
        try {
            sql = "insert into ChuyenDe(MaCD,TenCD,HocPhi,ThoiLuong,Hinh,MoTa,URL) values(?,?,?,?,?,?,?)";
            con = DBConnect.getConnection();
            ps = con.prepareCall(sql);
            ps.setObject(1, cd.getMaCD());
            ps.setObject(2, cd.getTenCD());
            ps.setObject(3, cd.getHocPhi());
            ps.setObject(4, cd.getThoiLuong());
            ps.setObject(5, cd.getHinh());
            ps.setObject(6, cd.getMoTa());
            ps.setObject(7, cd.getUrl());
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            result = 0;
        }
        return result;
    }

    public int UpdateCD(chuyenDeEntity cd,String ma) {
        int result = 0;
        try {
            sql = "update ChuyenDe set TenCD=?,HocPhi=?,ThoiLuong=?,Hinh=?,MoTa=?,URL=? where MaCD=?";
            con = DBConnect.getConnection();
            ps = con.prepareCall(sql);
            ps.setObject(1, cd.getTenCD());
            ps.setObject(2, cd.getHocPhi());
            ps.setObject(3, cd.getThoiLuong());
            ps.setObject(4, cd.getHinh());
            ps.setObject(5, cd.getMoTa());
            ps.setObject(6, cd.getUrl());
            ps.setObject(7, ma);
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            result = 0;
        }
        return result;
    }
    public chuyenDeEntity getAt(int index){
        return list.get(index);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class hocVienEtity {

    private Integer maHV, maKH;
    private String maNH, TenNH;
    private Double diem;

    public hocVienEtity() {
    }

    public hocVienEtity(Integer maHV, Integer maKH, String maNH, String TenNH, Double diem) {
        this.maHV = maHV;
        this.maKH = maKH;
        this.maNH = maNH;
        this.TenNH = TenNH;
        this.diem = diem;
    }

    public String getTenNH() {
        return TenNH;
    }

    public void setTenNH(String TenNH) {
        this.TenNH = TenNH;
    }
    public Integer getMaHV() {
        return maHV;
    }

    public void setMaHV(Integer maHV) {
        this.maHV = maHV;
    }

    public Integer getMaKH() {
        return maKH;
    }

    public void setMaKH(Integer maKH) {
        this.maKH = maKH;
    }

    public String getMaNH() {
        return maNH;
    }

    public void setMaNH(String maNH) {
        this.maNH = maNH;
    }

    public Double getDiem() {
        return diem;
    }

    public void setDiem(Double diem) {
        this.diem = diem;
    }

}

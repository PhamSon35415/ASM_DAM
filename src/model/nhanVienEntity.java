/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class nhanVienEntity {

    private String maNV, matKhau, hoTen;
    private int vaiTro;

    public nhanVienEntity() {
    }

    public nhanVienEntity(String maNV, String matKhau, String hoTen, int vaiTro) {
        this.maNV = maNV;
        this.matKhau = matKhau;
        this.hoTen = hoTen;
        this.vaiTro = vaiTro;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getVaiTro() {
        return vaiTro;
    }
    public String getVaiTro2(){
        String result=null;
        if(vaiTro==0){
            result= "Nhân viên";
        }else if(vaiTro==1){
            result= "Trưởng phòng";
        }
        return result;
    }

    public void setVaiTro(int vaiTro) {
        this.vaiTro = vaiTro;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlicuahangmaytinh;

import java.util.Scanner;

/**
 *
 * @author THONG
 */
public class KhachHang extends ConNguoi{
    private String MaKH;
    private String DiaChi;
    private String email;
    private static final Scanner in = new Scanner(System.in);

    public KhachHang() {
        System.out.println("Đối Tượng: Khách Hàng");
    }

    public KhachHang(String truyen_MaDoiTuong,String truyen_Ten,String truyen_Ho, int truyen_NamSinh,String truyen_SoDT,String truyen_GioiTinh,String truyen_MaKH,String truyen_DiaChi,String truyen_email) {
        super(truyen_MaDoiTuong,truyen_Ten,truyen_Ho, truyen_NamSinh, truyen_SoDT, truyen_GioiTinh);
        this.MaKH = truyen_MaKH;
        this.DiaChi = truyen_DiaChi;
        this.email = truyen_email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void setGioiTinh(String GioiTinh) {
        super.setGioiTinh(GioiTinh); //To change body of generated methods, choose Tools | Templates.
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    @Override
    public void setHo(String Ho) {
        super.setHo(Ho); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setTen(String Ten) {
        super.setTen(Ten); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setNamSinh(int NamSinh) {
        super.setNamSinh(NamSinh); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setSoDT(String SoDT) {
        super.setSoDT(SoDT); //To change body of generated methods, choose Tools | Templates.
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getGioiTinh() {
        return super.getGioiTinh(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getHo() {
        return super.getHo(); //To change body of generated methods, choose Tools | Templates.
    }

    public static Scanner getIn() {
        return in;
    }

    @Override
    public int getNamSinh() {
        return super.getNamSinh(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSoDT() {
        return super.getSoDT(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getTen() {
        return super.getTen(); //To change body of generated methods, choose Tools | Templates.
    }

    public String getMaKH() {
        return MaKH;
    }
    
    @Override
    public void Nhap() {
        System.out.println("Nhập Mã Khách Hàng");
        this.MaKH = in.nextLine();
        System.out.println("Nhập Địa Chỉ Khách Hàng");
        this.DiaChi = in.nextLine();
        System.out.println("Nhập email của Khách Hàng");
        String regex_email ="^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        this.email = in.nextLine();
        while(!email.matches(regex_email)){
            System.out.printf("Email Không Hợp lệ Vui lòng Nhập Lại: ");
            this.email = in.nextLine();
        }
        super.Nhap(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Xuat() {
        System.out.printf("%-20s %-20s %-30s  %-10s %-20s  %-20s  %-20s %-30s %-30s",this.MaKH,this.MaDoiTuong, this.Ho,this.Ten,this.NamSinh,this.GioiTinh,this.SoDT,this.email,this.DiaChi);
        System.out.println("");
    }
    @Override
    public String toString(){
        return super.toString()+","+MaKH+","+DiaChi+","+email;
    }
}

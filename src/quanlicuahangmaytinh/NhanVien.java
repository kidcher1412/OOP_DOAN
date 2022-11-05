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
public class NhanVien extends ConNguoi{
    private String MaNV;
    private long MucLuong;
    private String ChucVu;
    private int NamVaoLam;
    
    private static final Scanner in = new Scanner(System.in);
    public NhanVien() {
        System.out.println("Đối Tượng: Nhân Viên");
    }

    public NhanVien(String truyen_MaDoiTuong,String truyen_Ten,String truyen_Ho, int truyen_NamSinh,String truyen_SoDT,String truyen_GioiTinh,String MaNV, long MucLuong, String ChucVu, int truyen_NamVaoLam) {
        super(truyen_MaDoiTuong,truyen_Ten,truyen_Ho,truyen_NamSinh, truyen_SoDT, truyen_GioiTinh);
        this.MaNV = MaNV;
        this.MucLuong = MucLuong;
        this.ChucVu = ChucVu;
        this.NamVaoLam = truyen_NamVaoLam;
    }

    public void setChucVu(String ChucVu) {
        this.ChucVu = ChucVu;
    }

    public void setMucLuong(long MucLuong) {
        this.MucLuong = MucLuong;
    }

    @Override
    public void setGioiTinh(String GioiTinh) {
        super.setGioiTinh(GioiTinh); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setHo(String Ho) {
        super.setHo(Ho); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void setNamSinh(int NamSinh) {
        super.setNamSinh(NamSinh); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setSoDT(String SoDT) {
        super.setSoDT(SoDT); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setTen(String Ten) {
        super.setTen(Ten); //To change body of generated methods, choose Tools | Templates.
    }

    public String getChucVu() {
        return ChucVu;
    }

    public long getMucLuong() {
        return MucLuong;
    }

    

    @Override
    public String getGioiTinh() {
        return super.getGioiTinh(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getHo() {
        return super.getHo(); //To change body of generated methods, choose Tools | Templates.
    }

    public String getMaNV() {
        return MaNV;
    }

    @Override
    public String getTen() {
        return super.getTen(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getNamSinh() {
        return super.getNamSinh(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSoDT() {
        return super.getSoDT(); //To change body of generated methods, choose Tools | Templates.
    }

    public int getNamVaoLam() {
        return NamVaoLam;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public void setNamVaoLam(int NamVaoLam) {
        this.NamVaoLam = NamVaoLam;
    }
    
    
    @Override
    public void Nhap() {
        String val;
        System.out.printf("Nhập vào Mã Nhân Viên Của Nhân Viên: ");
        val = in.nextLine();
        if(!"".equals(val)) setMaNV(val);
        System.out.printf("Nhập vào chức vụ Của Nhân Viên: ");
                val = in.nextLine();
        if(!"".equals(val)) setChucVu(val);
        System.out.printf("Nhập vào Lương Hằng Tháng Của Nhân Viên: ");
        val = in.nextLine();
        if(!"".equals(val)) setMucLuong(Long.parseLong(val));
        System.out.printf("Nhập vào Năm Vào Làm Của Nhân Viên: ");
                val = in.nextLine();
        if(!"".equals(val)) setNamVaoLam(Integer.parseInt(val));
        super.Nhap(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Xuat() {
        System.out.printf("%-20s %-20s %-30s  %-10s %-20s  %-20s  %-20s %-30s %-20s %-10s",this.MaNV,this.MaDoiTuong, this.Ho,this.Ten,this.NamSinh,this.GioiTinh,this.SoDT,this.MucLuong,this.ChucVu,this.NamVaoLam);
        System.out.println("");
    }
    @Override
    public String toString(){
        return super.toString()+","+this.MaNV+","+this.MucLuong+","+this.ChucVu+","+this.NamVaoLam;
    }
}

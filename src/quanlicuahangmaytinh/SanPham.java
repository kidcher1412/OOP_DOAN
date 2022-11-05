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
public class SanPham {
    protected String MaSP;
    protected String TenSP;
    protected  long DonGia;
    protected  int SoLuongTon;
    protected ChiTietSanPham ChiTiet = new ChiTietSanPham();
    protected String NhaCungCap;
    private static final Scanner in = new Scanner(System.in);
// cónstrocter
    public SanPham(){
        System.out.println("Đã Thêm Một Sản Phẩm Vào Danh Sach");
        ChiTiet = new ChiTietSanPham();
    }
    public SanPham(String truyen_MaSP,String truyen_TenSP, long truyen_DonGia, int truyen_SoLuongTon, String truyen_NhaCungCap){
            this.MaSP = truyen_MaSP;
            this.TenSP = truyen_TenSP;
            this.DonGia = truyen_DonGia;
            this.SoLuongTon = truyen_SoLuongTon;
            this.NhaCungCap = truyen_NhaCungCap;
             //bo sung
    }
    public String getMaSP(){
        return MaSP;
    }
    public long getDonGia(){
        return DonGia;
    }
    public int getSoLuongTon(){
        return SoLuongTon;
    }
    public String getNhaCungCap(){
        return NhaCungCap;
    }
    public void setMaSP(String truyen_String){
        this.MaSP = truyen_String;
    }

    public String getTenSP(){
        return TenSP;
    }
    public void setDonGia(long truyen_Long){
        this.DonGia = truyen_Long;
    }
    public void setNhaCungCap(String truyen_String){
        this.NhaCungCap = truyen_String;
    }
    public void setSoLuongTon(int truyen_String){
        this.SoLuongTon = truyen_String;
    }
    public void Nhap(){
        System.out.println("Nhập Mã Sản Phẩm");
        this.MaSP = in.nextLine();
        System.out.println("Nhập Tên Sản Phẩm");
        this.TenSP = in.nextLine();
        System.out.println("Nhập Đơn Giá Sản Phẩm");
        this.DonGia = Long.parseLong(in.nextLine());
        System.out.println("Nhập Tên Nhà Cung Cấp Sản Xuất");
        this.NhaCungCap = in.nextLine();
        System.out.println("Nhập Số Lượng Tồn Sản Xuất");
        this.SoLuongTon = Integer.parseInt(in.nextLine());
        //bo sung chi tiet
    }
    public void Xuat(){
        System.out.printf("%-10s %-30s %-20s %-20s %-20s ",MaSP,TenSP,DonGia,NhaCungCap,SoLuongTon);
        System.out.println("");
    }
    public void Sua(){
        this.Nhap();
    }
    @Override
    public String toString(){
        return (getMaSP()+","+getTenSP()+","+getDonGia()+","+getSoLuongTon()+","+getNhaCungCap());
    }
    public String toStringChiTiet(){
        return this.ChiTiet.getCPU()+","+this.ChiTiet.getGPU()+","+this.ChiTiet.getHangSanXuat()+","+this.ChiTiet.getHeDieuHanh()+","+this.ChiTiet.getManHinh()+","+this.ChiTiet.getNamSanXuat()+","+this.ChiTiet.getRAM();
    }
    
    public boolean ChecktimKiem(String Ma_Check){
            return this.getMaSP().equals(Ma_Check);
         }
    public SanPham returnbyID(String truyen_MaCheck){
        if(this.MaSP.equals(truyen_MaCheck)) return this;
        return null;
    }
    public boolean check_SoLuongTon(byte check){
        if(check > this.SoLuongTon) return false;
        else return true;
    }
    public void Them_SoLuongTon(int truyen_Soluongthem){
        this.SoLuongTon = this.SoLuongTon  + truyen_Soluongthem;
    }
    public void Bot_SoLuongTon(int truyen_Soluongban){
        this.SoLuongTon = this.SoLuongTon  - truyen_Soluongban;
    }
}

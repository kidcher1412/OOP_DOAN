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
public class MayTinhBan extends SanPham{
    private String PhuKienDiKem;
    private static final Scanner in = new Scanner(System.in);
    public MayTinhBan(){
        super();
    }
    public MayTinhBan(String truyen_MaSP,String truyen_TenSP, long truyen_DonGia, int truyen_SoLuongTon, String truyen_NhaCungCap,String truyen_PhuKienDiKem){
        super(truyen_MaSP,truyen_TenSP,truyen_DonGia,truyen_SoLuongTon,truyen_NhaCungCap);
        this.PhuKienDiKem = truyen_PhuKienDiKem;
        System.out.println("Tạo 1 máy tính Thanh Cong");
    }

    public String getPhuKienDiKem() {
        return PhuKienDiKem;
    }

    public void setPhuKienDiKem(String truyen_PhuKienDiKem) {
        this.PhuKienDiKem = truyen_PhuKienDiKem;
    }
    @Override
    public void Nhap(){
        super.Nhap();
        System.out.println("Nhập vào Phụ Kiện Đi Kèm Khi Mua Máy");
        PhuKienDiKem = in.nextLine();
        ChiTiet.Nhap();
    }
    @Override
    public void Sua(){
        this.Nhap();
    }
    @Override
        public void Xuat(){
        System.out.printf("%-10s %-30s %-20s %-20s %-20s %-20s",MaSP,TenSP,DonGia,NhaCungCap,SoLuongTon,this.PhuKienDiKem);
        System.out.println("");
//        ChiTiet.Xuat();
    }
    @Override
    public String toString(){
        return (getMaSP()+","+getTenSP()+","+getDonGia()+","+getSoLuongTon()+","+getNhaCungCap()+","+getPhuKienDiKem());
    }
    @Override
    public boolean ChecktimKiem(String Ma_Check) {
        return super.ChecktimKiem(Ma_Check);
    }
}

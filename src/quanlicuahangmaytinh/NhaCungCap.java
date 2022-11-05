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
public class NhaCungCap {
    private String MaNCC;
    private String TenNCC;
    private Scanner in = new Scanner(System.in);
    public NhaCungCap() {
        System.out.println("Đã Thêm 1 nhà cung cấp");
    }

    public NhaCungCap(String MaNCC, String TenNCC) {
        this.MaNCC = MaNCC;
        this.TenNCC = TenNCC;
    }
    
    public void setMaNCC(String MaNCC) {
        this.MaNCC = MaNCC;
    }

    public void setTenNCC(String TenNCC) {
        this.TenNCC = TenNCC;
    }

    public String getMaNCC() {
        return MaNCC;
    }

    public String getTenNCC() {
        return TenNCC;
    }
    public void Nhap(){
        String val;
        System.out.println("Nhập Mã Nhà Cung Cấp");
        val = in.nextLine();
        setMaNCC(val);
        System.out.println("Nhập Tên Nhà Cung Cấp");
        val = in.nextLine();
        setTenNCC(val);
    }
    public void Xuat(){
        System.out.printf("%-10s %-30s ",getMaNCC(),getTenNCC());
        System.out.println("");
    }
    public boolean ChecktimKiem(String Ma_Check){
            return this.getMaNCC().equals(Ma_Check);
         }
    @Override
    public String toString(){
        return getMaNCC()+","+getTenNCC();
    }
    public NhaCungCap returnbyID(String truyen_MaCheck){
        if(ChecktimKiem(truyen_MaCheck)) return this;
        else return null;
    }
}

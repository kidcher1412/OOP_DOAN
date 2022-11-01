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
public class ConNguoi {
    protected String MaDoiTuong;    //CMND
    protected String Ho;
    protected String Ten;
    protected int NamSinh;
    protected String SoDT;
    protected String GioiTinh;
    private static final Scanner in = new Scanner(System.in);
    public ConNguoi(){
        System.out.println("Đã Tạo Một Đối Tượng Con Người");
    }

    public void setHo(String Ho) {
        this.Ho = Ho;
    }
    
    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public void setNamSinh(int NamSinh) {
        this.NamSinh = NamSinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public void setSoDT(String SoDT) {
        this.SoDT = SoDT;
    }

    public String getHo() {
        return Ho;
    }

    public String getMaDoiTuong() {
        return MaDoiTuong;
    }

    public void setMaDoiTuong(String MaDoiTuong) {
        this.MaDoiTuong = MaDoiTuong;
    }
    
    public String getTen() {
        return Ten;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public int getNamSinh() {
        return NamSinh;
    }

    public String getSoDT() {
        return SoDT;
    }
    
    public ConNguoi(String truyen_MaDoiTuong,String truyen_Ten,String truyen_Ho, int truyen_NamSinh,String truyen_SoDT,String truyen_GioiTinh){
        setMaDoiTuong(truyen_MaDoiTuong);
        setGioiTinh(truyen_GioiTinh);
        setTen(truyen_Ten);
        setHo(truyen_Ho);
        setNamSinh(truyen_NamSinh);
        setSoDT(truyen_SoDT);
    }
    public void Nhap(){
        String val;
        System.out.printf("Nhập Mã Đối Tượng");
        val = in.nextLine();
        if(!"".equals(val)) setMaDoiTuong(val);
        System.out.printf("Nhập họ Đối Tượng");
        val = in.nextLine();
        if(!"".equals(val)) setHo(val);
        System.out.printf("Nhập tên Đối Tượng");
        val = in.nextLine();
        if(!"".equals(val)) setTen(val);
        System.out.printf("Nhập năm Sinh Đối Tượng");
        val = in.nextLine();
        if(!"".equals(val)) setNamSinh(Integer.parseInt(val));
        System.out.printf("Nhập Giới Tính Đối Tượng");
        val = in.nextLine();
        if(!"".equals(val)) setGioiTinh(val);
        System.out.printf("Điền Số Điện Thoại Đối Tượng Bao Gồi 9 kí Tự");
        if(this.SoDT.length()<=8)
            while(this.SoDT.length()<8){
                System.out.printf("Điền Lại Số ĐT: ");
                this.SoDT = in.nextLine();
            }
    }
    public void Xuat(){
        //Xuat  Được Tạo ra chỉ để kế thừa unboxing
        System.out.printf(" %-50s  %-10s %-20s  %-20s  %-40s", this.Ho,this.Ten,this.NamSinh,this.GioiTinh,this.SoDT);
    }
    @Override
    public String toString(){
        return MaDoiTuong+","+Ten+","+Ho+","+NamSinh+","+SoDT+","+GioiTinh;
    }
    public boolean ChecktimKiem(String Ma_Check){
            return this.getMaDoiTuong().equals(Ma_Check);
         }
    public ConNguoi returnbyID(String Ma_Check){
        if(ChecktimKiem(Ma_Check)) return this;
        else return null;
    }
}

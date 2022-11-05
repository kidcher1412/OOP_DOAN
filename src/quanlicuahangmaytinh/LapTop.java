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
public class LapTop extends SanPham{
    private String ChatLuongLoa;
    private boolean CamUng;
    private boolean LedBanPhim;
    private static final Scanner in = new Scanner(System.in);
    public LapTop(){
        super();
    }
    public LapTop(String truyen_MaSP,String truyen_TenSP, long truyen_DonGia, int truyen_SoLuongTon, String truyen_NhaCungCap,String truyen_ChatLuongLoa, boolean truyen_CamUng, boolean truyen_LedBanPhim){
        super(truyen_MaSP,truyen_TenSP,truyen_DonGia,truyen_SoLuongTon,truyen_NhaCungCap);
        this.ChatLuongLoa = truyen_ChatLuongLoa;
        this.CamUng = truyen_CamUng;
        this.LedBanPhim = truyen_LedBanPhim;
        System.out.println("Tạo 1 LapTop Thanh Cong");
    }
    public String getChatLuongLoa(){
        return this.ChatLuongLoa;
    }
    public boolean getCamUng(){
        return this.CamUng;
    }
    public boolean getLedBanPhim(){
        return this.LedBanPhim;
    }
    public void setChatLuongLoa(){
        this.ChatLuongLoa = in.nextLine();
    }
    public void setCamUng(){
        this.CamUng = Boolean.parseBoolean(in.nextLine());
    }
    public void setLedBanPhim(){
        this.LedBanPhim = Boolean.parseBoolean(in.nextLine());
    }
    @Override
    public void Nhap(){
        super.Nhap();
        System.out.println("Nhập Vào Chất Lượng Loa");
        ChatLuongLoa=in.nextLine();
        byte val;
        System.out.println("Sản Phẩm có Màn Hình Cảm Ứng không(1. Có, 2. Không)");
        val = Byte.parseByte(in.nextLine());
        boolean check= true;
        while(check){
          switch(val){
            case 1:
                this.CamUng = true;
                check = false;
                break;
            case 2:
                this.CamUng = false;
                check = false;
                break;
            default:
                System.out.println("có chút gì đó sai sai Nhập Lại Lựa Chọn");
                val = in.nextByte();
            }
            if(!check) break;
        }
        System.out.println("Sản Phẩm có Led bàn Phím không(1. Có, 2. Không)");
        val = in.nextByte();
        check= true;
        while(check){
          switch(val){
            case 1:
                this.LedBanPhim = true;
                check = false;
                break;
            case 2:
                this.LedBanPhim = false;
                check = false;
                break;
            default:
                System.out.println("có chút gì đó sai sai Nhập Lại Lựa Chọn");
                val = in.nextByte();
            if(!check) break;
        }
        }
        ChiTiet.Nhap();
    }
    @Override
    public void Xuat(){
        System.out.printf("%-10s %-30s %-20s %-20s %-20s %-20s %-20s %-30s",MaSP,TenSP,DonGia,NhaCungCap,SoLuongTon,this.CamUng,this.LedBanPhim,this.ChatLuongLoa);
        System.out.println("");
//        ChiTiet.Xuat();
    }
    @Override
    public void Sua(){
        this.Nhap();
    }
    @Override
    public String toString(){
        return (getMaSP()+","+getTenSP()+","+getDonGia()+","+getSoLuongTon()+","+getNhaCungCap()+","+getChatLuongLoa()+","+getCamUng()+","+getLedBanPhim());
    }

    @Override
    public boolean ChecktimKiem(String Ma_Check) {
        return super.ChecktimKiem(Ma_Check);
    }
    
}

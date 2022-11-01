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
public class HoaDon {
    private String MaHD;
    private ChiTietHoaDon[] chitiethoadon;
    private String NgayLap;
    private long ThanhTien;
    private byte n;         //Số Lượng Chi Tiết
    private ConNguoi[] dsconnguoi;
    private SanPham[] dssanpham;
    private static final Scanner in = new Scanner(System.in);
    public HoaDon(ConNguoi[] truyen_dsconnguoi,SanPham[] truyen_sanpham) {
        this.dsconnguoi = truyen_dsconnguoi;
        this.dssanpham = truyen_sanpham;
        System.out.println("            Đã Tạo Ra Hóa Đơn!");
        System.out.println("|================================================|\n");
    }
    public HoaDon(String MaHD, String NgayLap, long ThanhTien, byte n, ConNguoi[] dsconnguoi, SanPham[] dssanpham) {
        this.MaHD = MaHD;
        this.NgayLap = NgayLap;
        this.ThanhTien = ThanhTien;
        this.n = n;
        this.dsconnguoi = dsconnguoi;
        this.dssanpham = dssanpham;
    }
    public void AddChiTiet(String MaCTHD, String nhanvien, String khachhang, String sanpham, byte soluong, ConNguoi[] dsconnguoi,SanPham[] dssanpham){
            System.out.println("CHưa tồn tại, tạo chi tiết");
            this.chitiethoadon = new ChiTietHoaDon[1];
            this.chitiethoadon[0] = new ChiTietHoaDon(MaCTHD, nhanvien, khachhang, sanpham, soluong, dsconnguoi, dssanpham);
    }
    public void InsertChiTiet(String MaCTHD, String nhanvien, String khachhang, String sanpham, byte soluong, ConNguoi[] dsconnguoi,SanPham[] dssanpham){
            System.out.println("da ton tai, thực hiện nạp chồng!!!");
            System.out.println("do dai ban dau "+ chitiethoadon.length);
            ChiTietHoaDon[] temp = chitiethoadon;
            chitiethoadon = new ChiTietHoaDon[temp.length+1];
            ChiTietHoaDon temp1 = new ChiTietHoaDon(MaCTHD, nhanvien, khachhang, sanpham, soluong, dsconnguoi, dssanpham);                          //Chinh Sua
//            System.out.println("do dai Lúc Sau "+ chitietphieunhap.length);
            System.arraycopy(temp,0,chitiethoadon,0,temp.length);
            chitiethoadon[chitiethoadon.length-1] = temp1;
    }

    public String getMaHD() {
        return MaHD;
    }
        public void Nhap(){
        
        System.out.printf("Nhập Vào Mã Hóa Đơn: ");
        this.MaHD= in.nextLine();
        System.out.printf("Nhập Ngày Lập Hóa Đơn: ");
        this.NgayLap = in.nextLine();
        System.out.printf("Nhập Số Sản Phẩm Được Mua: ");
        this.n =Byte.parseByte(in.nextLine());
        chitiethoadon = new ChiTietHoaDon[n];
        for(int i = 0;i<n;i++){
            chitiethoadon[i] = new ChiTietHoaDon(dsconnguoi,dssanpham);
            chitiethoadon[i].Nhap();
            ThanhTien = ThanhTien+chitiethoadon[i].setTongTien();
        }
    }
    public void Xuat(){
        System.out.println("                            |====================Hóa Đơn===================|\n");
        System.out.printf("Mã Hóa Đơn: "+this.MaHD+"\n");
        System.out.printf("Ngày Lập Phiếu: "+this.NgayLap+"\n");
        System.out.printf("Số Sản Phẩm trong Phiếu: "+this.n+"\n");
        System.out.printf("%-10s %-30s %-20s %-20s %-10s %-20s","Mã CTPN","Tên Sản Phẩm","Tên Nhân Viên Bán","Tên Khách Hàng","Số Lượng Mua","Tổng Tiền");
        System.out.println("");
        for(ChiTietHoaDon check:chitiethoadon){
            check.Xuat();
        }
        System.out.println("");
        System.out.printf("                                                                     Đơn Tổng của Hóa Đơn: "+this.ThanhTien+"VND\n");
        System.out.println("");
        System.out.println("                           |=====================================================|\n");
    }
    @Override
    public String toString(){
        return this.MaHD+","+this.NgayLap+","+this.ThanhTien+","+this.n;
    }
    public ChiTietHoaDon[] returnit(){
        return chitiethoadon;
    }
    public boolean ChecktimKiem(String Ma_Check){
            return this.getMaHD().equals(Ma_Check);
         }
    public HoaDon returnbyID(String Ma_Check){
        if(this.ChecktimKiem(Ma_Check)) return this;
        else return null;
    }
}

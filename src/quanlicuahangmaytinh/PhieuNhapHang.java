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
public class PhieuNhapHang{
    private String MaPNH;
    private ChiTietPhieuNhapHang[] chitietphieunhap;
    private String NgayLap;
    private long ThanhTien;
    private byte n;         //Số Lượng Chi Tiết
    private ConNguoi[] dsnhanvien;
    private NhaCungCap[] dsnhacungcap;
    private SanPham[] dssanpham;
    private static final Scanner in = new Scanner(System.in);
    public PhieuNhapHang(ConNguoi[] truyen_nhanvien,NhaCungCap[] truyen_nhacungcap,SanPham[] truyen_sanpham) {
        this.dsnhacungcap = truyen_nhacungcap;
        this.dsnhanvien = truyen_nhanvien;
        this.dssanpham = truyen_sanpham;
        System.out.println("            Đã Tạo Ra Phiếu Nhập Hàng");
        System.out.println("|================================================|\n");
    }

    public PhieuNhapHang(String MaPNH, String NgayLap, long ThanhTien, byte n, ConNguoi[] dsnhanvien, NhaCungCap[] dsnhacungcap, SanPham[] dssanpham) {
        this.MaPNH = MaPNH;
        this.NgayLap = NgayLap;
        this.ThanhTien = ThanhTien;
        this.n = n;
        this.dsnhanvien = dsnhanvien;
        this.dsnhacungcap = dsnhacungcap;
        this.dssanpham = dssanpham;
    }
    public void AddChiTiet(String MaCTPT, String truyen_nhanvien, String truyen_nhacungcap, String truyen_sanpham, byte truyen_soluong, ConNguoi[] dsnhanvien, NhaCungCap[] dsnhacungcap, SanPham[] dssanpham){
        if(this.chitietphieunhap == null){
            this.chitietphieunhap = new ChiTietPhieuNhapHang[1];
            chitietphieunhap[0] = new ChiTietPhieuNhapHang(MaCTPT, truyen_nhanvien, truyen_nhacungcap, truyen_sanpham, truyen_soluong, dsnhanvien, dsnhacungcap, dssanpham);
            return;
        }    
    }
    public void InsertChiTiet(String MaCTPT, String truyen_nhanvien, String truyen_nhacungcap, String truyen_sanpham, byte truyen_soluong, ConNguoi[] dsnhanvien, NhaCungCap[] dsnhacungcap, SanPham[] dssanpham){
//            System.out.println("da ton tai, thực hiện nạp chồng!!!");
//            System.out.println("do dai ban dau "+ chitietphieunhap.length);
            ChiTietPhieuNhapHang[] temp = chitietphieunhap;
            ChiTietPhieuNhapHang temp1 = new ChiTietPhieuNhapHang(MaCTPT, truyen_nhanvien, truyen_nhacungcap, truyen_sanpham, truyen_soluong, dsnhanvien, dsnhacungcap, dssanpham);
            chitietphieunhap = new ChiTietPhieuNhapHang[temp.length+1];
//            System.out.println("do dai Lúc Sau "+ chitietphieunhap.length);
            System.arraycopy(temp,0,chitietphieunhap,0,temp.length);
            chitietphieunhap[chitietphieunhap.length-1] = temp1;
    }
    public String getMaPNH() {
        return MaPNH;
    }
    
    public void Nhap(){
        
        System.out.printf("Nhập Vào Mã Phiếu Nhập Hàng: ");
        this.MaPNH = in.nextLine();
        System.out.printf("Nhập Ngày Lập Phiếu Nhập Hàng: ");
        this.NgayLap = in.nextLine();
        System.out.printf("Nhập Số Sản Phẩm Được Nhập: ");
        this.n =Byte.parseByte(in.nextLine());
        chitietphieunhap = new ChiTietPhieuNhapHang[n];
        for(int i = 0;i<n;i++){
            chitietphieunhap[i] = new ChiTietPhieuNhapHang(dsnhanvien,dsnhacungcap,dssanpham);
            chitietphieunhap[i].Nhap();
            ThanhTien = ThanhTien+chitietphieunhap[i].setTongTien();
        }
    }
    public void Xuat(){
        System.out.println("            |====================Phiếu Nhập Hàng===================|\n");
        System.out.printf("Mã Phiếu: "+this.MaPNH+"\n");
        System.out.printf("Ngày Lập Phiếu: "+this.NgayLap+"\n");
        System.out.printf("Số Sản Phẩm trong Phiếu: "+this.n+"\n");
        System.out.printf("%-10s %-30s %-20s %-20s %-10s %-20s","Mã CTPN","Tên Sản Phẩm","Tên Nhân Viên Nhập","Tên Nhà Cung Cấp","Số Lượng Nhập","Tổng Tiền");
        System.out.println("");
        for(ChiTietPhieuNhapHang check:chitietphieunhap){
            check.Xuat();
        }
        System.out.printf("                     Đơn Tổng của Phiếu: "+this.ThanhTien+"VND\n");
        System.out.println("");
        System.out.println("            |=====================================================|\n");
    }
    @Override
    public String toString(){
        return this.MaPNH+","+this.NgayLap+","+this.ThanhTien+","+this.n;
    }
    public ChiTietPhieuNhapHang[] returnit(){
        return chitietphieunhap;
    }
    public boolean ChecktimKiem(String Ma_Check){
            return this.getMaPNH().equals(Ma_Check);
         }
    public PhieuNhapHang returnbyID(String Ma_Check){
        if(ChecktimKiem(Ma_Check)) return this;
        else return null;
    }
}

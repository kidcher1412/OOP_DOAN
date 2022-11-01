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
public class ChiTietHoaDon {
    private String MaCTHD;
    private  long TongTien;
    private ConNguoi nhanvien;
    private ConNguoi khachhang;
    private SanPham sanpham;
    private byte soluong;
    private ConNguoi[] dsconnguoi;
    private SanPham[] dssanpham;
    private Scanner in = new Scanner(System.in);

    public void setMaCTHD(String MaCTHD) {
        this.MaCTHD = MaCTHD;
    }
    public final long setTongTien(){
        return soluong*sanpham.getDonGia();
    }
    public ChiTietHoaDon(ConNguoi[] truyen_connguoi,SanPham[] truyen_sanpham) {
        this.dsconnguoi = truyen_connguoi;
        this.dssanpham = truyen_sanpham;
        System.out.println("lenght "+dsconnguoi.length+ "  "+dssanpham.length );
    }
    public ChiTietHoaDon(String MaCTHD, String nhanvien, String khachhang, String sanpham, byte soluong, ConNguoi[] dsconnguoi, SanPham[] dssanpham) {
        this.dsconnguoi = dsconnguoi;
        this.dssanpham = dssanpham;
        this.MaCTHD = MaCTHD;
        for(ConNguoi x: this.dsconnguoi){
            if(x.returnbyID(nhanvien)!=null){
                this.nhanvien = x.returnbyID(nhanvien);
            }
        }

        for(ConNguoi check:this.dsconnguoi){
            if(check.returnbyID(khachhang)!=null){
                this.khachhang = check.returnbyID(khachhang);
            }
        }
        for(SanPham check1:this.dssanpham){
            if(check1.returnbyID(sanpham)!=null){
                this.sanpham = check1.returnbyID(sanpham);
            }
        }
        this.soluong = soluong;
        this.TongTien = this.setTongTien();
    }
    public void Nhap(){
        String val;
        boolean checknull = true;
        System.out.printf("Nhập Mã Chi Tiết Phiếu Thu: ");
        val = in.nextLine();
        setMaCTHD(val);
        System.out.printf("Nhập Số Lượng Hàng Chi Tiết Phiếu Thu: ");
        soluong = Byte.parseByte(in.nextLine());
        for(ConNguoi x:dsconnguoi) if(x instanceof NhanVien){
            NhanVien temp = (NhanVien) x;
            System.out.println(" Nhan Vien: "+ temp.getMaDoiTuong());
        }
        System.out.printf("Vui Lòng Nhập Mã CMND: ");
        val = in.nextLine();
        while(checknull){
            for(ConNguoi check:dsconnguoi){
                if(check.returnbyID(val)!=null){
                    System.out.println("thêm Nhân Viên "+ check.Ten+" vào Hóa Đơn");
                    this.nhanvien = check.returnbyID(val);
                    checknull = false;
                }
            }
            if(checknull){
                System.out.println("Không Tìm thấy Nhân Viên trong Hệ Thống Vui Lòng Thử Lại");
                System.out.printf("Vui Lòng Nhập Mã CMND: ");
                val = in.nextLine();
            } 
        }
        checknull =true;
        for(ConNguoi x:dsconnguoi) if(x instanceof KhachHang) System.out.println(" Khách Hàng: "+x.getMaDoiTuong());
        
        System.out.printf("Vui Lòng Nhập Mã CMND Khách Hàng: ");
        val = in.nextLine();
        
        while(checknull){
            for(ConNguoi check:dsconnguoi){
                if(check.returnbyID(val)!=null){
                    System.out.println("thêm Khách Hàng "+ check.Ten+" vào phiếu thu");
                    this.khachhang = check.returnbyID(val);
                    checknull = false;
                }
            }
            if(checknull){
                System.out.println("Không Tìm thấy Khách Hàng trong Hệ Thống Vui Lòng Thử Lại");
                System.out.printf("Vui Lòng Nhập Mã CMND: ");
                val = in.nextLine();
            } 
        }
        checknull =true;
        for(SanPham x:dssanpham) System.out.println(" Nha Cung Cap "+x.getMaSP());
        System.out.printf("Vui Lòng Nhập Mã Sản Phẩm: ");
        val = in.nextLine();
        
        while(checknull){
            for(SanPham check:dssanpham){
                if(check.returnbyID(val)!=null){
                    System.out.println("thêm Nhà Cung Cấp "+ check.getTenSP()+" vào phiếu thu");
                    this.sanpham = check.returnbyID(val);
                    checknull = false;
                }
            }
            if(checknull){
                System.out.println("Không Tìm thấy Sản Phẩm trong Hệ Thống Vui Lòng Thử Lại");
                System.out.printf("Vui Lòng Nhập Mã Sản Phẩm: ");
                val = in.nextLine();
            } 
        }
        TongTien = this.setTongTien();
    }
    public void Xuat(){
        System.out.printf("%-10s %-30s %-20s %-20s %-10s %-20s",this.MaCTHD,this.sanpham.getTenSP(),this.nhanvien.getTen(),this.khachhang.getTen(),this.soluong,this.TongTien+"VND");
        System.out.println("");
    }
    @Override
    public String toString(){
        return this.MaCTHD +","+ this.nhanvien.getMaDoiTuong() +","+ this.khachhang.getMaDoiTuong() +","+ this.sanpham.getMaSP()+","+this.soluong;
    }
}

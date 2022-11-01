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
public final class ChiTietPhieuNhapHang {
    private String MaCTPT;
    private  long TongTien;
    private ConNguoi nhanvien;
    private NhaCungCap nhacungcap;
    private SanPham sanpham;
    private byte soluong;
    private ConNguoi[] dsnhanvien;
    private NhaCungCap[] dsnhacungcap;
    private SanPham[] dssanpham;
    private Scanner in = new Scanner(System.in);

    public void setMaCTPT(String MaCTPT) {
        this.MaCTPT = MaCTPT;
    }
    public final long setTongTien(){
        return soluong*sanpham.getDonGia();
    }
    public ChiTietPhieuNhapHang(ConNguoi[] truyen_nhanvien,NhaCungCap[] truyen_nhacungcap,SanPham[] truyen_sanpham) {
        this.dsnhanvien = truyen_nhanvien;
        this.dsnhacungcap = truyen_nhacungcap;
        this.dssanpham = truyen_sanpham;
    }

    public ChiTietPhieuNhapHang(String MaCTPT, String nhanvien, String nhacungcap, String sanpham, byte soluong, ConNguoi[] dsnhanvien, NhaCungCap[] dsnhacungcap, SanPham[] dssanpham) {
        this.dsnhanvien = dsnhanvien;
        this.dsnhacungcap = dsnhacungcap;
        this.dssanpham = dssanpham;
        this.MaCTPT = MaCTPT;
        for(ConNguoi x: this.dsnhanvien){
            if(x.returnbyID(nhanvien)!=null){
                this.nhanvien = x.returnbyID(nhanvien);
            }
        }

        for(NhaCungCap check:this.dsnhacungcap){
            if(check.returnbyID(nhacungcap)!=null){
                this.nhacungcap = check.returnbyID(nhacungcap);
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
        setMaCTPT(val);
        System.out.printf("Nhập Số Lượng Hàng Chi Tiết Phiếu Thu: ");
        soluong = Byte.parseByte(in.nextLine());
        for(ConNguoi x:dsnhanvien) if(x instanceof NhanVien){
            NhanVien temp = (NhanVien) x;
            System.out.println(" Nhan Vien: "+ temp.getMaDoiTuong());
        }
        System.out.printf("Vui Lòng Nhập Mã CMND: ");
        val = in.nextLine();
        while(checknull){
            for(ConNguoi check:dsnhanvien){
                if(check.returnbyID(val)!=null){
                    System.out.println("thêm Nhân Viên "+ check.Ten+" vào phiếu thu");
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
        for(NhaCungCap x:dsnhacungcap) System.out.println(" Nha Cung Cap "+x.getMaNCC());
        
        System.out.printf("Vui Lòng Nhập Mã Nhà Cung Cấp: ");
        val = in.nextLine();
        
        while(checknull){
            for(NhaCungCap check:dsnhacungcap){
                if(check.returnbyID(val)!=null){
                    System.out.println("thêm Nhà Cung Cấp "+ check.getTenNCC()+" vào phiếu thu");
                    this.nhacungcap = check.returnbyID(val);
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
//        private String MaCTPT;
//    private  long TongTien;
//    private ConNguoi nhanvien;
//    private NhaCungCap nhacungcap;
//    private SanPham sanpham;
//    private byte soluong;
    public void Xuat(){
        System.out.printf("%-10s %-30s %-20s %-20s %-10s %-20s",this.MaCTPT,this.sanpham.getTenSP(),this.nhanvien.getTen(),this.nhacungcap.getTenNCC(),this.soluong,this.TongTien+"VND");
        System.out.println("");
    }
    public ChiTietPhieuNhapHang returnbyID(String truyen_MaCheck){
        if(this.MaCTPT.equals(truyen_MaCheck)) return this;
        else return null;
    }
    @Override
    public String toString(){
        return MaCTPT+","+nhanvien.MaDoiTuong+","+nhacungcap.getMaNCC()+","+sanpham.MaSP+","+soluong;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlicuahangmaytinh;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
        for(SanPham x:dssanpham) System.out.println("Các Sản Phẩm "+x.getMaSP());
        System.out.printf("Vui Lòng Nhập Mã Sản Phẩm Được Mua: ");
        val = in.nextLine();
        
        while(checknull){
            for(SanPham check:dssanpham){
                if(check.returnbyID(val)!=null){
                    System.out.println("thêm Sản Phẩm "+ check.getTenSP()+" vào Hóa Đơn");
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
        System.out.printf("Nhập Số Lượng Hàng Chi Tiết Phiếu Thu: ");
        soluong = Byte.parseByte(in.nextLine());
        for(SanPham x:  dssanpham){ 
            if(x.check_SoLuongTon(soluong) && x.ChecktimKiem(this.sanpham.getMaSP()))
                {System.out.println("Số Lượng Tồn Kho Vẫn Đủ! Thành Lập Chi Tiết! ");
                break;
            }
        }
        System.out.printf("Nhập Mã Chi Tiết Phiếu Thu: ");
        val = in.nextLine();
        setMaCTHD(val);
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
        
        for(SanPham check: dssanpham)
            for(int i = 0 ; i< dssanpham.length;i++){
                        if(dssanpham[i].ChecktimKiem(check.MaSP))
                        {
                            check.Bot_SoLuongTon(soluong);
                            dssanpham[i] = check;              //Cập Nhật Lại Danh Sach
                            break;
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
        public void ghiFile(){
        try {
            BufferedWriter fw = new BufferedWriter(new FileWriter("DanhSachSanPham.txt"));
            BufferedWriter fw1 = new BufferedWriter(new FileWriter("ChiTietSanPham.txt"));
            
            for (SanPham sanpham1 : dssanpham) {
                fw.write(sanpham1.toString()); 
                fw1.write(sanpham1.toStringChiTiet()); 
                fw.newLine();
                fw1.newLine();
            }
            System.out.println("Xuat File Thành Công");
            fw.close();
            fw1.close();
        } catch (IOException e) {
        }
        System.out.println("\nXuất file thành công!");
    }
}

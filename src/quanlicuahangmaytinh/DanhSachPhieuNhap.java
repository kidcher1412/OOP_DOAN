/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlicuahangmaytinh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author THONG
 */
public class DanhSachPhieuNhap {
    private static final Scanner sc = new Scanner(System.in);
    PhieuNhapHang[] phieunhaphang;
    private ConNguoi[] dsnhanvien;
    private NhaCungCap[] dsnhacungcap;
    private SanPham[] dssanpham;
    private byte biendem;
    public DanhSachPhieuNhap(ConNguoi[] truyen_nhanvien,NhaCungCap[] truyen_nhacungcap,SanPham[] truyen_sanpham) {
        this.dsnhacungcap = truyen_nhacungcap;
        this.dsnhanvien = truyen_nhanvien;
        this.dssanpham = truyen_sanpham;
        this.docFile();
    }
    
    public void ThaoTacDanhSach(){
        byte number;
        boolean exit = false;
            do {
            System.out.println();
            System.out.println("============ DANH SÁCH Phiếu Nhập ============");
            System.out.println("Hãy chọn Loại bạn muốn thao tác");
            System.out.println("1)......Thêm Phiếu Nhập Hàng");
            System.out.println("2)......In Phiếu Nhập Hàng");
            System.out.println("3)......Tim Kiếm Phiếu Nhập Hàng");
            System.out.println("4)......Xóa Phiếu Nhập Hàng");
            System.out.println("5)......Sửa Phiếu Nhập Hàng");
            System.out.println("0)......Thoát Danh Sách Này!");
            System.out.println("=========================================");
            System.out.print("Mời bạn nhập lựa chọn: ");
            number = sc.nextByte();   
            sc.nextLine();
                                      
            switch(number){
                case 1:
                    this.Nhap();
                    this.ghiFile();
                    break;
            
                case 2:
                    this.Xuat();
                    break;
            
                case 3:
                    String Ma_Check;
                    System.out.printf("Mời Nhập Mã Phiếu Nhập Cần Tìm: ");
                    Ma_Check=sc.nextLine();
                    boolean checknull = true;
                    for(int i = 0; i<phieunhaphang.length;i++)
                        if(phieunhaphang[i].ChecktimKiem(Ma_Check))
                        {
                            System.out.printf("%-10s %-30s %-20s %-20s %-10s %-20s","Mã CTPN","Tên Sản Phẩm","Tên Nhân Viên Nhập","Tên Nhà Cung Cấp","Số Lượng Nhập","Tổng Tiền");
                            System.out.println("");
                            phieunhaphang[i].Xuat();
                            checknull = false;
                        }
                    if(checknull) System.out.printf("%-80s","NONE!!!");
                    break;
            
                case 4:
                    this.ghiFile();
                    break;
                case 5:
                    String Ma_Check1;
                    System.out.printf("Mời Nhập Mã Phiếu Nhập Cần Sửa: ");
                    Ma_Check1=sc.nextLine();
                    boolean checknull1 = true;
                    for(int i = 0; i<phieunhaphang.length;i++)
                        if(phieunhaphang[i].ChecktimKiem(Ma_Check1))
                            phieunhaphang[i].Nhap();
                    break;
                case 0:
                    exit = true; 
                    System.out.println("Thoát thành công!");
                    break;
                default:
                    System.out.print("\nLựa chọn không hợp lệ! Vui lòng chọn lại...");
                    break;
            }
            if(exit == true)
                break;
        }
        while(true);
    }
    public void Nhap(){
        String val;
        int n;
        System.out.println("Nhập Số Lượng Phiếu Nhập Cần Thêm");
        n = Integer.parseInt(sc.nextLine());
        phieunhaphang = new PhieuNhapHang[n];
        for(int i = 0 ; i<n ;i++){
            phieunhaphang[i] = new PhieuNhapHang(dsnhanvien, dsnhacungcap, dssanpham);
            phieunhaphang[i].Nhap();
        }
    }
    public void Xuat(){
        System.out.printf("%-10s %-30s %-20s %-20s %-10s %-20s","Mã CTPN","Tên Sản Phẩm","Tên Nhân Viên Nhập","Tên Nhà Cung Cấp","Số Lượng Nhập","Tổng Tiền");
        System.out.println("");
        System.out.println("======================");
        for(PhieuNhapHang x:phieunhaphang)
            x.Xuat();
    }
    public void ghiFile(){
        try {
            BufferedWriter fw = new BufferedWriter(new FileWriter("DanhSachPhieuNhap.txt"));
            BufferedWriter fw1 = new BufferedWriter(new FileWriter("ChiTietPhieuNhap.txt"));
            
            for (PhieuNhapHang  x : phieunhaphang) {
                fw.write(x.toString());
                for (ChiTietPhieuNhapHang returnit : x.returnit()) {
//                    returnit.Xuat();
                    fw1.write(returnit.toString());
                }
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
    public void docFile(){
        try {
            biendem =0;
            BufferedReader fr = new BufferedReader(new FileReader("DanhSachPhieuNhap.txt"));
            BufferedReader fr1 = new BufferedReader(new FileReader("ChiTietPhieuNhap.txt"));
            String line = fr.readLine();
            String Line1 = fr1.readLine();
            while(line != null){
                String[] arr = line.split(",");
                biendem++;

                line = fr.readLine();
            }
            fr.close();
            fr = new BufferedReader(new FileReader("DanhSachPhieuNhap.txt"));
            line = fr.readLine();
            phieunhaphang = new PhieuNhapHang[biendem];
            int SoLuongPhieu = biendem;
            biendem = 0;
            byte soluongchitiet;
            while(line != null){
                String[] arr = line.split(",");
                String[] arr1 = Line1.split(",");
                phieunhaphang[biendem] = new PhieuNhapHang(arr[0],arr[1], Long.parseLong(arr[2]),Byte.parseByte(arr[3]), dsnhanvien, dsnhacungcap, dssanpham);
                soluongchitiet = Byte.parseByte(arr[3]);
                for(int i= 0 ; i <soluongchitiet;i++){
                    arr1 = Line1.split(",");
                    if(i==0) phieunhaphang[biendem].AddChiTiet(arr1[0], arr1[1],arr1[2], arr1[3], Byte.parseByte(arr1[4]), dsnhanvien, dsnhacungcap, dssanpham);
                    else phieunhaphang[biendem].InsertChiTiet(arr1[0], arr1[1],arr1[2], arr1[3], Byte.parseByte(arr1[4]), dsnhanvien, dsnhacungcap, dssanpham);
                    if(i!=soluongchitiet) Line1 = fr1.readLine();
                }

                biendem++;
                line = fr.readLine();
            }
            fr.close();
            fr1.close();
        } catch (Exception e) {
        }
        System.out.println("\nNhập file thành công!");
    }
}

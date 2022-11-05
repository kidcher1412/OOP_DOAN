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
    private PhieuNhapHang[] phieunhaphang;
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
    public void Nhap(){
        int n;
        System.out.println("Nhập Số Lượng Phiếu Nhập Cần Thêm");
        n = Integer.parseInt(sc.nextLine());
        PhieuNhapHang[] temp = phieunhaphang;
        PhieuNhapHang[] temp1 = new PhieuNhapHang[n];
        for(int i = 0 ; i<n ;i++){
            temp1[i] = new PhieuNhapHang(dsnhanvien, dsnhacungcap, dssanpham);
            temp1[i].Nhap();
        }
        phieunhaphang = new PhieuNhapHang[temp.length+temp1.length];
        System.arraycopy(temp,0,phieunhaphang,0,temp.length);
        System.arraycopy(temp1,0,phieunhaphang,temp.length,temp1.length);
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
    public PhieuNhapHang[] returnit(){
        return phieunhaphang;
    }
}

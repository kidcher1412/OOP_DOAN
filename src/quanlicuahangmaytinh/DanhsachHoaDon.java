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
public class DanhsachHoaDon {
    private static final Scanner sc = new Scanner(System.in);
    private HoaDon[] hoadon;
    private ConNguoi[] dsconnguoi;
    private SanPham[] dssanpham;
    private byte biendem;
    public DanhsachHoaDon(ConNguoi[] truyen_nhanvien,SanPham[] truyen_sanpham) {
        this.dsconnguoi = truyen_nhanvien;
        this.dssanpham = truyen_sanpham;
        //Tạo 1 Danh Sách Hóa Đơn
        this.docFile();
        System.out.println("Đọc Xong Danh Sach Hoa Don");
        
    }
    
    public void Nhap(){
        String val;
        int n;
        System.out.println("Nhập Số Lượng Hóa Đơn cần Thêm");
        n = Integer.parseInt(sc.nextLine());
        hoadon = new HoaDon[n];
        for(int i = 0 ; i<n ;i++){
            hoadon[i] = new HoaDon(dsconnguoi,dssanpham);
            hoadon[i].Nhap();
        }
    }
    public void Xuat(){
        System.out.println("");
        System.out.println("======================");
        for(HoaDon x:hoadon)
            x.Xuat();
    }
    public void ghiFile(){
        try {
            BufferedWriter fw = new BufferedWriter(new FileWriter("DanhSachHoaDon.txt"));
            BufferedWriter fw1 = new BufferedWriter(new FileWriter("ChiTietHoaDon.txt"));
            
            for (HoaDon  x : hoadon) {
                fw.write(x.toString());
                for (ChiTietHoaDon returnit : x.returnit()) {
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
            BufferedReader fr = new BufferedReader(new FileReader("DanhSachHoaDon.txt"));
            BufferedReader fr1 = new BufferedReader(new FileReader("ChiTietHoaDon.txt"));
            String line = fr.readLine();
            String Line1 = fr1.readLine();
            while(line != null){
                String[] arr = line.split(",");
                biendem++;

                line = fr.readLine();
            }
            System.out.println("Đọc Được File " + biendem);
            fr.close();
            fr = new BufferedReader(new FileReader("DanhSachHoaDon.txt"));
            line = fr.readLine();
            hoadon = new HoaDon[biendem];
            biendem = 0;
            byte soluongchitiet;
            while(line != null){
                String[] arr = line.split(",");
                String[] arr1 = Line1.split(",");
                
                hoadon[biendem] = new HoaDon(arr[0],arr[1],Long.parseLong(arr[2]),Byte.parseByte(arr[3]), dsconnguoi, dssanpham);
                soluongchitiet = Byte.parseByte(arr[3]);
                System.out.println("so lượng chi tiết hóa dớn "+biendem+" là "+soluongchitiet);
                    System.out.println("truyền dữ liệu vào hóa đơn "+biendem+ " có số lượng chi tiết "+soluongchitiet);
                for(int i= 0 ; i <soluongchitiet;i++){
                    arr1 = Line1.split(",");
                    for(String x:arr1) System.out.println("Dữ Liệu truyền "+x);
                    if(i==0){
                        System.out.println("tao chitiet hoa don moi");
                        hoadon[biendem].AddChiTiet(arr1[0], arr1[1], arr1[2], arr1[3], Byte.parseByte(arr1[4]), dsconnguoi, dssanpham);
                    } 
                    else hoadon[biendem].InsertChiTiet(arr1[0], arr1[1],arr1[2], arr1[3], Byte.parseByte(arr1[4]), dsconnguoi, dssanpham);
                    hoadon[biendem].Xuat();
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
    public HoaDon[] returnit(){
        return hoadon;
    }
}

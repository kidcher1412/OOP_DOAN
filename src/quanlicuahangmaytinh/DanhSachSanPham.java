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
public class DanhSachSanPham {
    private Scanner sc = new Scanner(System.in);
    private SanPham sanpham[];
    private int biendem = 0;        //so luong san pham
    byte number;
    boolean exit = false;

    public DanhSachSanPham() {
            this.docFile();
    }
    public void Them(){
        System.out.println("nhap so luong sản phẩm cần thêm");
        int n =Integer.parseInt(sc.nextLine());
        SanPham[] temp = new SanPham[n];
        SanPham[] temp2 = sanpham;
        byte valcheck = 0;
        String valretap;
//        sanpham = new SanPham[n];
        for(int i = 0 ; i< n;i++){
            System.out.println("Sản Phẩm Bạn Muốn Thêm là:");
            System.out.println("1. LAPTOP");
            System.out.println("2. Máy Tính Để Bàn");
            number = Byte.parseByte(sc.nextLine());
            switch(number){
                case 1:
                    temp[i] = new LapTop();
                    break;
                case 2:
                    temp[i] =new MayTinhBan();
                    break;
            }        
            temp[i].Nhap();
            for( SanPham checker:sanpham)
                if(checker.getMaSP().equals(temp[i].getMaSP()))            //Mở Rộng thêm điều kiện Class là Đẹp
                    valcheck++;
                while(valcheck>1){
                        System.out.println("Mã Sản Phẩm Đã Tồn tại, Vui lòng Nhập Mã khác: ");
                        valretap = sc.nextLine();
                        temp[i].setMaSP(valretap);
                        valcheck=0;
                        for( SanPham checker:sanpham)
                            if(checker.getMaSP().equals(temp[i].getMaSP()))
                                valcheck++;                                //neo để tiếp tục check
                    }
                valcheck =0;
        }
        sanpham = new SanPham[temp2.length+temp.length];
        System.arraycopy(temp2,0,sanpham,0,temp2.length);
        System.arraycopy(temp,0,sanpham,temp2.length,temp.length);
        ghiFile();
    }
    public void Xuat(){
        System.out.println("Sản Phẩm Bạn Xuất là:");
        System.out.println("1. LAPTOP");
        System.out.println("2. Máy Tính Để Bàn");
        System.out.println("3. tất cả sản phẩm");
        number = sc.nextByte();
        if(number ==1)
            System.out.printf("%-10s %-30s %-20s %-20s %-20s %-20s %-20s %-20s ","MaSP","Tên Sản Phẩm","DonGia","NhaCungCap","SoLuongTon","Cảm Ứng","Led Bàn Phím","Chất Lượng Loa");
        if(number ==2)
            System.out.printf("%-10s %-30s %-20s %-20s %-20s %-60s ","MaSP","Tên Sản Phẩm","DonGia","NhaCungCap","SoLuongTon","Phụ Kiện Tặng Kèm");
        System.out.println("");
        for(int i = 0 ; i< this.sanpham.length ; i++){
            switch(number){
                case 1:
                    if(sanpham[i] instanceof LapTop) {
                        sanpham[i].Xuat();
                        sanpham[i].ChiTiet.Xuat();
                        
                    }
                    else break;
                    break;
                case 2:
                    if(sanpham[i] instanceof MayTinhBan){
                        sanpham[i].Xuat();
                        sanpham[i].ChiTiet.Xuat();
                    }
                    else break;
                    break;
                case 3:
                    SanPham x =(SanPham) sanpham[i];
                    x.Xuat();
                    break;
            }
        }
    }
    
    public void ghiFile(){
        try {
            BufferedWriter fw = new BufferedWriter(new FileWriter("DanhSachSanPham.txt"));
            BufferedWriter fw1 = new BufferedWriter(new FileWriter("ChiTietSanPham.txt"));
            
            for (SanPham sanpham1 : sanpham) {
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
    
    public void docFile(){
        try {
            biendem =0;
            BufferedReader fr = new BufferedReader(new FileReader("DanhSachSanPham.txt"));
            String line = fr.readLine();
            while(line != null){
                String[] arr = line.split(",");
                System.out.println("Do dai: "+ arr.length);
                biendem++;
                System.out.println("bien chay: "+ biendem);
                line = fr.readLine();
            }
            fr.close();
            fr = new BufferedReader(new FileReader("DanhSachSanPham.txt"));
            line = fr.readLine();
            sanpham = new SanPham[biendem];
            biendem = 0;
            while(line != null){
                String[] arr = line.split(",");
                if(arr.length == 8)
                    sanpham[biendem++] = new LapTop(arr[0], arr[1],Long.parseLong(arr[2]),Integer.parseInt(arr[3]), arr[4], arr[5],Boolean.valueOf(arr[6]), Boolean.valueOf(arr[7])); 
                else
                    sanpham[biendem++] = new MayTinhBan(arr[0], arr[1],Long.parseLong(arr[2]),Integer.parseInt(arr[3]),arr[4], arr[5]); 
                line = fr.readLine();
            }
            fr.close();
            fr = new BufferedReader(new FileReader("ChiTietSanPham.txt"));
            line = fr.readLine();
            biendem = 0;
            while(line != null){
                String[] arr = line.split(",");
                    sanpham[biendem++].ChiTiet = new ChiTietSanPham(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6],Integer.parseInt(arr[7]));
                line = fr.readLine();
            }
            fr.close();
        } catch (Exception e) {
        }
        System.out.println("\nNhập file thành công!");
    }
    public SanPham[] returnit(){
        return sanpham;
    }
}

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
public class DanhSachConNguoi {
    private Scanner sc = new Scanner(System.in);
    private ConNguoi connguoi[];
    private byte number;
    private int biendem =0;

    public DanhSachConNguoi() {
        docFile();
    }
    
        public void Them(){
        System.out.println("nhap so luong người cần thêm");
        int n =Integer.parseInt(sc.nextLine());
        ConNguoi[] temp = new ConNguoi[n];
        ConNguoi[] temp2 = connguoi;
        byte valcheck = 0;
        String valretap;
//        connguoi = new ConNguoi[n];
        for(int i = 0 ; i< n;i++){
            System.out.println("Sản Phẩm Bạn Muốn Thêm là:");
            System.out.println("1. Nhân Viên");
            System.out.println("2. Khách Hàng");
            number = Byte.parseByte(sc.nextLine());
            switch(number){
                case 1:
                    temp[i] = new NhanVien();
                    break;
                case 2:
                    temp[i] =new KhachHang();
                    break;
            }        
            temp[i].Nhap();
        }
        connguoi = new ConNguoi[temp2.length+temp.length];
        System.arraycopy(temp2,0,connguoi,0,temp2.length);
        System.arraycopy(temp,0,connguoi,temp2.length,temp.length);
        ghiFile();
    }
    public void Xuat(){
        
        System.out.println("Sản Phẩm Bạn Xuất là:");
        System.out.println("1. Nhân Viên");
        System.out.println("2. Khách Hàng");
        number = Byte.parseByte(sc.nextLine());
        if(number ==1)
            System.out.printf("%-20s %-20s %-30s  %-10s %-20s  %-20s  %-20s %-30s %-20s %-10s", "MaNV", "MaCMND","Ho","Ten","Năm Sinh","Giới Tính","Số Điện Thoại","Mức Lượng Hiện tại","Chức Vụ","Năm Vào Làm");
        else 
            System.out.printf("%-20s %-20s %-30s  %-10s %-20s  %-20s  %-20s %-30s %-30s","MaKH", "MaCMND","Họ","Tên","Năm Sinh","Giới Tính", "SoDT","Email","Địa Chỉ");
        System.out.println("");
        for(int i = 0 ; i< this.connguoi.length ; i++){
            switch(number){
                case 1:
                    if(connguoi[i] instanceof NhanVien) connguoi[i].Xuat();
                    else break;
                    break;
                case 2:
                    if(connguoi[i] instanceof KhachHang) connguoi[i].Xuat();
                    else break;
                    break;
            }
        }
    }
        public void ghiFile(){
        try {
            BufferedWriter fw = new BufferedWriter(new FileWriter("DanhSachConNguoi.txt"));
            
            for (ConNguoi connguoi1 : connguoi) {
                fw.write(connguoi1.toString()); 
                fw.newLine();
            }
            System.out.println("Xuat File Thành Công");
            fw.close();  
        } catch (IOException e) {
        }
        System.out.println("\nXuất file thành công!");
    }
    
    public void docFile(){
        try {
            biendem =0;
            BufferedReader fr = new BufferedReader(new FileReader("DanhSachConNguoi.txt"));
            String line = fr.readLine();
            while(line != null){
                String[] arr = line.split(",");
                System.out.println("Do dai: "+ arr.length);
                biendem++;
                System.out.println("bien chay: "+ biendem);
                line = fr.readLine();
            }
            fr.close();
            fr = new BufferedReader(new FileReader("DanhSachConNguoi.txt"));
            line = fr.readLine();
            connguoi = new ConNguoi[biendem];
            biendem = 0;
            while(line != null){
                System.out.println("xet bien dem"+ biendem);  
                String[] arr = line.split(",");
                if(arr.length == 9)
                    connguoi[biendem++] = new KhachHang(arr[0], arr[1], arr[2], Integer.parseInt(arr[3]), arr[4], arr[5], arr[6], arr[7],arr[8]);
                
                else
                    connguoi[biendem++] = new NhanVien(arr[0], arr[1], arr[2],Integer.parseInt(arr[3]), arr[4], arr[5], arr[6],Long.parseLong(arr[7]), arr[8],Integer.parseInt(arr[9]));
                line = fr.readLine();
            }
            fr.close();
        } catch (Exception e) {
        }
        System.out.println("\nNhập file thành công!");
    }
    public ConNguoi[] returnit(){
        return connguoi;
    }
}

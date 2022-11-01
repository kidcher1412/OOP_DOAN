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
public class DanhSachNhaCungCap {
    private Scanner sc = new Scanner(System.in);
    private NhaCungCap[] nhacungcap;
    private int biendem = 0;        //so luong san pham
    boolean exit = false;

    public DanhSachNhaCungCap() {
        this.docFile();
    }
    
    public void ThaoTacDanhSach(){
        byte number;
            do {
            System.out.println();
            System.out.println("============ DANH SÁCH Nhà Cung Cấp ============");
            System.out.println("Hãy chọn Loại bạn muốn thao tác");
            System.out.println("1)......Thêm Nhà Cung Cấp");
            System.out.println("2)......In Nhà Cung Cấp");
            System.out.println("3)......Tim Kiếm Nhà Cung Cấp");
            System.out.println("4)......Xóa Nhà Cung Cấp");
            System.out.println("5)......Sửa Nhà Cung Cấp");
            System.out.println("0)......Thoát Danh Sách Này!");
            System.out.println("=========================================");
            System.out.print("Mời bạn nhập lựa chọn: ");
            number = sc.nextByte();   
            sc.nextLine();
                                      
            switch(number){
                case 1:
                    this.Them();
                    ghiFile();
                    break;
            
                case 2:
                    this.Xuat();
                    break;
            
                case 3:
                    String Ma_Check;
                    System.out.printf("Mời Nhập Mã Check: ");
                    Ma_Check=sc.nextLine();
                    boolean checknull = true;
                    for(int i = 0; i<nhacungcap.length;i++)
                        if(nhacungcap[i].ChecktimKiem(Ma_Check))
                        {
                            System.out.printf("%-10s %-30s","MaNCC","Tên Nhà Cung Cấp");
                            System.out.println("");
                            nhacungcap[i].Xuat();
                            checknull = false;
                        }
                    if(checknull) System.out.printf("%-80s","NONE!!!");
                    break;
            
                case 4:
//                    this.ghiFile();
                    break;
                case 5:
                    String Ma_Check1;
                    System.out.printf("Mời Nhập Mã Đối Tượng Cần Sửa: ");
                    Ma_Check1=sc.nextLine();
                    boolean checknull1 = true;
                    for (NhaCungCap nhacungcap1 : nhacungcap) {
                        if (nhacungcap1.ChecktimKiem(Ma_Check1)) {
                            nhacungcap1.Nhap();
                        }
                    }
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
    public void Them(){
        System.out.println("nhap so luong Nhà Cung Cấp Cần Thêm");
        int n =Integer.parseInt(sc.nextLine());
        nhacungcap = new NhaCungCap[n];
        for(int i = 0;i<n;i++)
        {
            nhacungcap[i] = new NhaCungCap();
            nhacungcap[i].Nhap();
        }
    }
    public void Xuat(){
        System.out.printf("%-10s %-30s","MaNCC","Tên Nhà Cung Cấp");
        System.out.println("");
        for(int i = 0;i<nhacungcap.length;i++)
            nhacungcap[i].Xuat();
    }
        public void ghiFile(){
        try {
            BufferedWriter fw = new BufferedWriter(new FileWriter("DanhSachNhaCungCap.txt"));
            
            for (NhaCungCap nhacungcap1 : nhacungcap) {
                fw.write(nhacungcap1.toString()); 
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
            BufferedReader fr = new BufferedReader(new FileReader("DanhSachNhaCungCap.txt"));
            String line = fr.readLine();
            while(line != null){
                String[] arr = line.split(",");
                System.out.println("Do dai: "+ arr.length);
                biendem++;
                System.out.println("bien chay: "+ biendem);
                line = fr.readLine();
            }
            fr.close();
            fr = new BufferedReader(new FileReader("DanhSachNhaCungCap.txt"));
            line = fr.readLine();
            nhacungcap = new NhaCungCap[biendem];
            biendem = 0;
            while(line != null){
                String[] arr = line.split(",");
                    nhacungcap[biendem++] = new NhaCungCap(arr[0],arr[1]);
                line = fr.readLine();
            }
            fr.close();
        } catch (Exception e) {
        }
        System.out.println("\nNhập file thành công!");
    }
    public NhaCungCap[] returnit(){
        return nhacungcap;
    }
}

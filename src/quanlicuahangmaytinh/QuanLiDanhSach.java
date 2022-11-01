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
public class QuanLiDanhSach{
    private final Scanner sc = new Scanner(System.in);
    private DanhSachSanPham ds1 = new DanhSachSanPham();
    private DanhSachNhaCungCap ds2 = new DanhSachNhaCungCap();
    private DanhSachConNguoi ds3 = new DanhSachConNguoi();
    private NhaCungCap[] nhacungcap = ds2.returnit();
    private SanPham[] sanpham = ds1.returnit();
    private ConNguoi[] connguoi = ds3.returnit();
    private DanhSachPhieuNhap ds4 = new DanhSachPhieuNhap(connguoi, nhacungcap, sanpham);
    private DanhsachHoaDon ds5 = new DanhsachHoaDon(connguoi, sanpham);
    public void LoaiDanhSach(){
        Scanner sc = new Scanner(System.in);
        byte number;
        boolean exit = false;
        do {
            System.out.println();
            System.out.println("=============== DANH SÁCH ===============");
            System.out.println("Hãy chọn danh sách bạn muốn thao tác");
            System.out.println("1)......Danh sách Cac Sản Phẩm");
            System.out.println("2)......Danh sách Nhà Cung Cấp");
            System.out.println("3)......Danh sách Con Người");
            System.out.println("4)......Danh sách Phiếu Nhập Hàng");
            System.out.println("5)......Danh sách Hóa Đơn");
            System.out.println("0)......Thoát chương trình!");
            System.out.println("=========================================");
            System.out.print("Mời bạn nhập lựa chọn: ");
            number = sc.nextByte();   
            sc.nextLine();
                                      
            switch(number){
                case 1:
                    ds1.ThaoTacDanhSach();
                    break;
            
                case 2:
                    ds2.ThaoTacDanhSach();
                    break;
            
                case 3:
                    ds3.ThaoTacDanhSach();
                    break;
            
                case 4:
                    ds4.ThaoTacDanhSach();
                    break;
                case 5:
//                    HoaDon test =new HoaDon(connguoi,sanpham);
//                    test.Nhap();
//                    test.Xuat();
                    ds5.ThaoTacDanhSach();
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
    
}

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
//                    ds1.ThaoTacDanhSach();
            do {
            System.out.println();
            System.out.println("=============== DANH SÁCH Sản Phẩm ===============");
            System.out.println("Hãy chọn Loại bạn muốn thao tác");
            System.out.println("1)......Thêm sản Phẩm");
            System.out.println("2)......In sản phẩm");
            System.out.println("3)......Tim Kiếm sản Phẩm");
            System.out.println("4)......Xóa Sản Phẩm");
            System.out.println("5)......Sửa Sản Phẩm");
            System.out.println("0)......Thoát Danh Sách Này!");
            System.out.println("=========================================");
            System.out.print("Mời bạn nhập lựa chọn: ");
            number = sc.nextByte();   
            sc.nextLine();
                                      
            switch(number){
                case 1:
                    ds1.Them();
                    ds1.ghiFile();
                    break;
            
                case 2:
                    ds1.Xuat();
                    break;
            
                case 3:
                    String Ma_Check;
                    System.out.printf("Mời Nhập Mã Check: ");
                    Ma_Check=sc.nextLine();
                    boolean checknull = true;
                    for(SanPham x:sanpham)
                        if(x.returnbyID(Ma_Check)!=null){
                            if(x instanceof LapTop) System.out.printf("%-10s %-30s %-20s %-20s %-20s %-20s %-20s %-20s ","MaSP","Tên Sản Phẩm","DonGia","NhaCungCap","SoLuongTon","Cảm Ứng","Led Bàn Phím","Chất Lượng Loa"+"\n");
                            else System.out.printf("%-10s %-30s %-20s %-20s %-20s %-60s ","MaSP","Tên Sản Phẩm","DonGia","NhaCungCap","SoLuongTon","Phụ Kiện Tặng Kèm"+"\n");
                            checknull = false;
                            x.Xuat();
                            x.ChiTiet.Xuat();
                        }
                    if(checknull) System.out.printf("NONE!!!");
                    break;
            
                case 4:
                    ds1.ghiFile();
                    break;
                case 5:
                    System.out.println("Nhập Mã Sản Phẩm cần sửa: ");
                    String Ma_Check1= sc.nextLine();
                    for(int i = 0; i<sanpham.length;i++){
                        if(sanpham[i].ChecktimKiem(Ma_Check1)){
                            if(sanpham[i] instanceof LapTop){
                                LapTop x =(LapTop) sanpham[i];
                                x.Nhap();
                                x.Xuat();
                                sanpham[i]=(LapTop) x;
                                ds1.ghiFile();
                            }
                                
                            else{
                                MayTinhBan x =(MayTinhBan) sanpham[i];
                                x.Nhap();
                                x.Xuat();
                                sanpham[i]=(MayTinhBan) x;
                                ds1.ghiFile();
                            }
                        break; 
                        } 
                    }
                    

                    
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
                    break;
            
                case 2:
//                    ds2.ThaoTacDanhSach();
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
                                ds2.Them();
                                ds2.ghiFile();
                                break;

                            case 2:
                                ds2.Xuat();
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
                                System.out.printf("Mời Nhập Mã Nhà Cung Cấp Cần Sửa: ");
                                Ma_Check1=sc.nextLine();
                                boolean checknull1 = true;
                                for (NhaCungCap nhacungcap1 : nhacungcap) {
                                    if (nhacungcap1.ChecktimKiem(Ma_Check1)) {
                                        nhacungcap1.Nhap();
                                        ds2.ghiFile();
                                    }
                                }
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
                                break;
            
                case 3:
//                    ds3.ThaoTacDanhSach();
                            do {
                        System.out.println();
                        System.out.println("=============== DANH SÁCH Con Người ===============");
                        System.out.println("Hãy chọn Loại bạn muốn thao tác");
                        System.out.println("1)...................Thêm Người....................");
                        System.out.println("2).....................In Người....................");
                        System.out.println("3)..................Tim Kiếm Người...................");
                        System.out.println("4).....................Xóa Người.....................");
                        System.out.println("5).....................Sửa Người.....................");
                        System.out.println("0)................Thoát Danh Sách Này!................");
                        System.out.println("====================================================");
                        System.out.print("Mời bạn nhập lựa chọn: ");
                        number = Byte.parseByte(sc.nextLine());

                        switch(number){
                            case 1:
                                ds3.Them();
                                ds3.ghiFile();
                                break;

                            case 2:
                                ds3.Xuat();
                                break;

                            case 3:
                                String Ma_Check;
                                System.out.printf("Mời Nhập Mã Đối Tượng(CMND): ");
                                Ma_Check=sc.nextLine();
                                boolean checknull = true;
                                for(ConNguoi x:connguoi){
                                    if(x.returnbyID(Ma_Check)!=null){
                                        if(x instanceof NhanVien) System.out.printf("%-20s %-20s %-30s  %-10s %-20s  %-20s  %-20s %-30s %-20s %-10s", "MaNV", "MaCMND","Ho","Ten","Năm Sinh","Giới Tính","Số Điện Thoại","Mức Lượng Hiện tại","Chức Vụ","Năm Vào Làm");
                                        else System.out.printf("%-20s %-20s %-30s  %-10s %-20s  %-20s  %-20s %-30s %-30s","MaKH", "MaCMND","Họ","Tên","Năm Sinh","Giới Tính", "SoDT","Email","Địa Chỉ");
                                        x.returnbyID(Ma_Check).Xuat();
                                        checknull = false;
                                    }
                                }
                                if(checknull) System.out.println("Không Có Đối Tượng!!!");
                                break;

                            case 4:
                                //ham xoa Con Người
                                break;
                            case 5:
                                String Ma_Check1;
                                System.out.printf("Mời Nhập Mã Đối Tượng(CMND): ");
                                Ma_Check1=sc.nextLine();
                                for (ConNguoi connguoi1 : connguoi) {
                                    if(connguoi1.ChecktimKiem(Ma_Check1)){
                                        if(connguoi1 instanceof KhachHang){
                                            connguoi1 =(KhachHang)connguoi1;
                                        }
                                        else{
                                            connguoi1 =(NhanVien)connguoi1;
                                        }
                                        connguoi1.Nhap();
                                    }

                                }
                                ds3.ghiFile();
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
                                break;

                case 4:
//                    ds4.ThaoTacDanhSach();
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
                                ds4.Nhap();
                                ds4.ghiFile();
                                break;

                            case 2:
                                ds4.Xuat();
                                break;

                            case 3:
                                String Ma_Check;
                                System.out.printf("Mời Nhập Mã Phiếu Nhập Cần Tìm: ");
                                Ma_Check=sc.nextLine();
                                boolean checknull = true;
                                for(int i = 0; i<ds4.returnit().length;i++)
                                    if(ds4.returnit()[i].ChecktimKiem(Ma_Check))
                                    {
                                        System.out.printf("%-10s %-30s %-20s %-20s %-10s %-20s","Mã CTPN","Tên Sản Phẩm","Tên Nhân Viên Nhập","Tên Nhà Cung Cấp","Số Lượng Nhập","Tổng Tiền");
                                        System.out.println("");
                                        ds4.returnit()[i].Xuat();
                                        checknull = false;
                                    }
                                if(checknull) System.out.printf("%-80s","NONE!!!");
                                break;

                            case 4:
                                ds4.ghiFile();
                                break;
                            case 5:
                                String Ma_Check1;
                                System.out.printf("Mời Nhập Mã Phiếu Nhập Cần Sửa: ");
                                Ma_Check1=sc.nextLine();
                                for(int i = 0; i<ds4.returnit().length;i++)
                                    if(ds4.returnit()[i].ChecktimKiem(Ma_Check1))
                                        ds4.returnit()[i].Nhap();
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
                                break;
                case 5:
//                    ds5.ThaoTacDanhSach();
                                do {
                        System.out.println();
                        System.out.println("============ DANH SÁCH Hóa Đơn ============");
                        System.out.println("Hãy chọn Loại bạn muốn thao tác");
                        System.out.println("1)......Thêm Hóa Đơn");
                        System.out.println("2)......In Hóa Đơn");
                        System.out.println("3)......Tim Kiếm Hóa Đơn");
                        System.out.println("4)......Xóa Hóa Đơn");
                        System.out.println("5)......Sửa Hóa Đơn");
                        System.out.println("0)......Thoát Danh Sách Này!");
                        System.out.println("=========================================");
                        System.out.print("Mời bạn nhập lựa chọn: ");
                        number = sc.nextByte();   
                        sc.nextLine();

                        switch(number){
                            case 1:
                                ds5.Nhap();
                                ds5.ghiFile();
                                break;

                            case 2:
                                ds5.Xuat();
                                break;

                            case 3:
                                String Ma_Check;
                                System.out.printf("Mời Nhập Mã Phiếu Nhập Cần Tìm: ");
                                Ma_Check=sc.nextLine();
                                boolean checknull = true;
                                for(int i = 0; i<ds5.returnit().length;i++)
                                    if(ds5.returnit()[i].ChecktimKiem(Ma_Check))
                                    {
                                        ds5.returnit()[i].Xuat();
                                        checknull = false;
                                    }
                                if(checknull) System.out.printf("%-80s","NONE!!!");
                                break;
                            case 4:
                                ds5.ghiFile();
                                break;
                            case 5:
                                String Ma_Check1;
                                System.out.printf("Mời Nhập Mã Phiếu Nhập Cần Sửa: ");
                                Ma_Check1=sc.nextLine();
                                for(int i = 0; i<ds5.returnit().length;i++)
                                    if(ds5.returnit()[i].ChecktimKiem(Ma_Check1))
                                        ds5.returnit()[i].Nhap();
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
                                break;
                            case 0:
                                exit = true; 
                                System.out.println("Hẹn Gặp Lại!");
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

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
public class ChiTietSanPham {
    private String CPU;
    private String GPU;
    private String RAM;
    private String ManHinh;
    private String HangSanXuat;
    private String NamSanXuat;
    private String HeDieuHanh;
    private int ThoiGianBaoHanh;
    private Scanner in = new Scanner(System.in);
    public ChiTietSanPham() {
    }

    public ChiTietSanPham(String CPU, String GPU, String RAM, String ManHinh, String HangSanXuat, String NamSanXuat, String HeDieuHanh,int ThoiGianBaoHanh) {
        this.CPU = CPU;
        this.GPU = GPU;
        this.RAM = RAM;
        this.ManHinh = ManHinh;
        this.HangSanXuat = HangSanXuat;
        this.NamSanXuat = NamSanXuat;
        this.HeDieuHanh = HeDieuHanh;
        this.ThoiGianBaoHanh = ThoiGianBaoHanh;
    }

    public String getCPU() {
        return CPU;
    }

    public String getGPU() {
        return GPU;
    }

    public String getHangSanXuat() {
        return HangSanXuat;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public String getHeDieuHanh() {
        return HeDieuHanh;
    }

    public String getManHinh() {
        return ManHinh;
    }

    public String getNamSanXuat() {
        return NamSanXuat;
    }

    public String getRAM() {
        return RAM;
    }

    public int getThoiGianBaoHanh() {
        return ThoiGianBaoHanh;
    }

    public void setThoiGianBaoHanh(int ThoiGianBaoHanh) {
        this.ThoiGianBaoHanh = ThoiGianBaoHanh;
    }
    
    
    public void setGPU(String GPU) {
        this.GPU = GPU;
    }

    public void setHangSanXuat(String HangSanXuat) {
        this.HangSanXuat = HangSanXuat;
    }

    public void setHeDieuHanh(String HeDieuHanh) {
        this.HeDieuHanh = HeDieuHanh;
    }

    public void setManHinh(String ManHinh) {
        this.ManHinh = ManHinh;
    }

    public void setNamSanXuat(String NamSanXuat) {
        this.NamSanXuat = NamSanXuat;
    }

    public void setRAM(String RAM) {
        this.RAM = RAM;
    }
    public void Nhap(){
        String val;
        System.out.println("Nhập Thông số CPU");
        val=in.nextLine();
        setCPU(val);
        System.out.println("Nhập Thông số GPU");
        val=in.nextLine();
        setGPU(val);
        System.out.println("Nhập Thông số Ram");
        val=in.nextLine();
        setRAM(val);
        System.out.println("Nhập Thông số màn Hình");
        val=in.nextLine();
        setManHinh(val);
        System.out.println("Nhập Thông số Thời Gian Bảo Hành: ");
        val=in.nextLine();
        setThoiGianBaoHanh(Integer.parseInt(val));
        System.out.println("Nhập Thông số Hệ Điều hành");
        val=in.nextLine();
        setHeDieuHanh(val);
        System.out.println("Nhập Thông số Hãng sản Xuất");
        val=in.nextLine();
        setHangSanXuat(val);
        System.out.println("Nhập Thông số Năm Sản Xuất");
        val=in.nextLine();
        setNamSanXuat(val);
    }
    public void Xuat(){
        System.out.println("Thông Tin Sản Phẩm: ");
        System.out.println("CPU: "+ getCPU());
        System.out.println("GPU: "+ getGPU());
        System.out.println("RAM: "+ getRAM());
        System.out.println("Màn Hình: "+ getManHinh());
        System.out.println("Hệ Điều Hành: "+ getHeDieuHanh());
        System.out.println("Thời Gian Bảo Hành: "+ getThoiGianBaoHanh()); 
        System.out.println("Hãng Sãn Xuất: "+ getHangSanXuat());
        System.out.println("Năm Sản Xuất: "+ getNamSanXuat());
    }
    @Override
    public String toString() {
        String caselog;
        caselog = getCPU()+"%-6s"+ getGPU()+"%-6s"+ getHangSanXuat()+"%-6s"+ getHeDieuHanh()+"%-6s"+ getManHinh()+"%-6s"+ getThoiGianBaoHanh()+ "%-6s"+ getNamSanXuat()+ "%-6s"+ getRAM();
        return caselog;
    }
    
    
}

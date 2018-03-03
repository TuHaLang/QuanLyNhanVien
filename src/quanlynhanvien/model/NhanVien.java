package quanlynhanvien.model;

import java.io.Serializable;
import java.util.Date;

public class NhanVien implements Serializable{
	private String maNhanVien;
	private String tenNhanVien;
	private String gioiTinh;
	private Date ngayVaoLamViec;
	private Date ngaySinh;
	private PhongBan phong;
	
	
	public NhanVien(String maNhanVien, String tenNhanVien, String gioiTinh, Date ngayVaoLamViec, Date ngaySinh) {
		super();
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.ngayVaoLamViec = ngayVaoLamViec;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public String getTenNhanVien() {
		return tenNhanVien;
	}
	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}
	public Date getNgayVaoLamViec() {
		return ngayVaoLamViec;
	}
	public void setNgayVaoLamViec(Date ngayVaoLamViec) {
		this.ngayVaoLamViec = ngayVaoLamViec;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public PhongBan getPhong() {
		return phong;
	}
	public void setPhong(PhongBan phong) {
		this.phong = phong;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.tenNhanVien;
	}
}

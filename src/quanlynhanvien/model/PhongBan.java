package quanlynhanvien.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;

public class PhongBan implements Serializable{
	private String maPhong;
	private String tenPhong;
	public PhongBan(String maPhong, String tenPhong) {
		super();
		this.maPhong = maPhong;
		this.tenPhong = tenPhong;
		dsNhanVien = new Vector<NhanVien>();
	}

	private Vector<NhanVien> dsNhanVien;
	
	
	public PhongBan() {
		super();
		dsNhanVien = new Vector<NhanVien>();
	}
	
	public void ThemNV(NhanVien nv) {
		this.dsNhanVien.add(nv);
		nv.setPhong(this);
		
	}
	
	public String getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}
	public String getTenPhong() {
		return tenPhong;
	}
	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}
	public Vector<NhanVien> getDsNhanVien() {
		return dsNhanVien;
	}
	public void setDsNhanVien(Vector<NhanVien> dsNhanVien) {
		this.dsNhanVien = dsNhanVien;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.tenPhong;
	}
}

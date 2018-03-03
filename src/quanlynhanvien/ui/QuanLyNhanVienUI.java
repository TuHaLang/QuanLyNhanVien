package quanlynhanvien.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import quanlynhanvien.io.QuanLyNhanVienIO;
import quanlynhanvien.model.NhanVien;
import quanlynhanvien.model.PhongBan;

public class QuanLyNhanVienUI extends JFrame{
	JComboBox<PhongBan> cboPhongBan;
	JList<NhanVien> listNhanVien;
	JTextField txtHoTen, txtMa, txtNgayVaoLamViec, txtNgaySinh, txtTenPhong, txtMaPhong;
	JButton btnThemNV, btnXoaNV, btnThoat, btnThemPhong, btnXoaPhong, btnLuu;
	JRadioButton radNam, radNu;
	ButtonGroup groupGioiTinh;
	PhongBan pbSelect = null;
	NhanVien nvSelect = null;
	
	static ArrayList<PhongBan> dsPhongBan = new ArrayList<PhongBan>();
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public QuanLyNhanVienUI(String tieude) {
		super(tieude);
		
		addControl();
		addEvens();
	}

	private void addEvens() {
		cboPhongBan.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(cboPhongBan.getSelectedIndex()==-1) return;
				pbSelect = (PhongBan) cboPhongBan.getSelectedItem();
				listNhanVien.setListData(pbSelect.getDsNhanVien());
			}
		});
		
		listNhanVien.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(listNhanVien.getSelectedIndex()==-1) return;
				nvSelect = (NhanVien) listNhanVien.getSelectedValue();
				txtMa.setText(nvSelect.getMaNhanVien());
				txtHoTen.setText(nvSelect.getTenNhanVien());
				txtNgayVaoLamViec.setText(sdf.format(nvSelect.getNgayVaoLamViec()));
				txtNgaySinh.setText(sdf.format(nvSelect.getNgaySinh()));
				if(nvSelect.getGioiTinh().equals("Nam")) {
					radNam.setSelected(true);
				}
				else radNu.setSelected(true);
			}
		});
		
		btnThoat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		btnXoaNV.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(pbSelect!=null) {
					pbSelect.getDsNhanVien().remove(nvSelect);
					nvSelect=null;
					listNhanVien.setListData(pbSelect.getDsNhanVien());
					JOptionPane.showMessageDialog(null, "Xóa nhân viên thành công !");
				}
				
			}
		});
		
		btnXoaPhong.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(pbSelect != null) {
					dsPhongBan.remove(pbSelect);
					cboPhongBan.removeItem(pbSelect);
					pbSelect=null;
					JOptionPane.showMessageDialog(null, "Xóa phòng thành công");
				}
			}
		});

		btnThemNV.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				XuLyThem();
			}
		});
		
		btnThemPhong.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(txtTenPhong.getText() != null && txtMaPhong.getText() != null) {
					try {
						if(txtMaPhong.getText().matches("\\w+")) {
							if(txtTenPhong.getText().matches("[0-9a-zA-Z áàạảãâấậẩầẫăắằẳẵặđéẻèẽẹêểếềễệìỉíịĩòóỏõọôổốồỗộơởớờỡợùủúụũưửừứựữýỷỵỹỳÁẢẠÀÃẤẦẬẨẪÂĂẲẮẰẴẶĐÉẺÈẸẼÊỂẾỀỆỄÍỈÌỊĨÓÒỎỌÕÔỐỔỒỘỖƠỜỞỚỢỠÚỦÙỤŨƯỪỨỬỰỮÝỶỲỴỸ]+")) {
								PhongBan pb = new PhongBan(txtMaPhong.getText(),txtTenPhong.getText());
								dsPhongBan.add(pb);
								cboPhongBan.addItem(pb);
								JOptionPane.showMessageDialog(null, "Thêm phòng thành công !");
							}
							else {
								JOptionPane.showMessageDialog(null, "Nhập sai định dạng tên phòng !");
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "Nhập sai định dạng mã phòng !");
						}
						
					}
					catch(Exception ex) {
						JOptionPane.showMessageDialog(null, ex);
					}
				}
			}
		});
		
		btnLuu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				XuLyLuu();
			}
		});
	}
	
	protected void XuLyLuu() {
		// TODO Auto-generated method stub
		boolean kt = QuanLyNhanVienIO.luuFile(dsPhongBan, "D:\\Java-Eclipse\\quanlynhanvien\\FileIO\\fileoutput.pvh");
		if(kt==true) {
			JOptionPane.showMessageDialog(null, "Lưu thành công !");
		}
		else {
			JOptionPane.showMessageDialog(null, "Lưu thất bại !");
		}
	}
	
	public void XuLyDocFile() {
		if(QuanLyNhanVienIO.docFile("D:\\Java-Eclipse\\quanlynhanvien\\FileIO\\fileoutput.pvh") != null) {
			dsPhongBan = QuanLyNhanVienIO.docFile("D:\\Java-Eclipse\\quanlynhanvien\\FileIO\\fileoutput.pvh");
			for(PhongBan pb : dsPhongBan) {
				cboPhongBan.addItem(pb);
			}
		}
	}

	protected void XuLyThem() {
		// TODO Auto-generated method stub
		if(pbSelect != null) {
			try {
				if(txtMa.getText().matches("\\w+")) {
					if(txtHoTen.getText().matches("[a-zA-Z áàạảãâấậẩầẫăắằẳẵặđéẻèẽẹêểếềễệìỉíịĩòóỏõọôổốồỗộơởớờỡợùủúụũưửừứựữýỷỵỹỳÁẢẠÀÃẤẦẬẨẪÂĂẲẮẰẴẶĐÉẺÈẸẼÊỂẾỀỆỄÍỈÌỊĨÓÒỎỌÕÔỐỔỒỘỖƠỜỞỚỢỠÚỦÙỤŨƯỪỨỬỰỮÝỶỲỴỸ]+")) {
						if(radNam.isSelected() || radNu.isSelected()) {
							NhanVien nv = new NhanVien(txtMa.getText(), txtHoTen.getText(), (radNam.isSelected())?radNam.getText():radNu.getText(), sdf.parse(txtNgayVaoLamViec.getText()), sdf.parse(txtNgaySinh.getText()));
							nvSelect=nv;
							pbSelect.ThemNV(nv);
							listNhanVien.setListData(pbSelect.getDsNhanVien());
							JOptionPane.showMessageDialog(null, "Thêm nhân viên thành công");
						}
						else {
							JOptionPane.showMessageDialog(null, "Bạn chưa chọn giới tính !");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Nhập sai định dạng tên !");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Nhập sai định dạng mã !");
				}
				
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}
	}


 	private void addControl() {
		Container con = getContentPane();
		
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		con.add(pnMain);
		
		JPanel pnThemPhong = new JPanel();
		pnThemPhong.setLayout(new FlowLayout());
		pnMain.add(pnThemPhong);
		
		JLabel lblMaPhong = new JLabel("Mã phòng:");
		txtMaPhong = new JTextField(5);
		JLabel lblTenPhong = new JLabel("Tên phòng:");
		txtTenPhong = new JTextField(10);
		btnThemPhong = new JButton("Thêm phòng");
		txtTenPhong = new JTextField(15);
		pnThemPhong.add(lblMaPhong);
		pnThemPhong.add(txtMaPhong);
		pnThemPhong.add(lblTenPhong);
		pnThemPhong.add(txtTenPhong);
		pnThemPhong.add(btnThemPhong);
		
		JPanel pnChonPhong = new JPanel();
		pnChonPhong.setLayout(new FlowLayout());
		pnMain.add(pnChonPhong);
		JLabel lblPhong = new JLabel("Chọn phòng ban:");
		pnChonPhong.add(lblPhong);
		cboPhongBan = new JComboBox<PhongBan>();
		pnChonPhong.add(cboPhongBan);
		
		JPanel pnDanhSach = new JPanel();
		pnDanhSach.setLayout(new GridLayout(1, 2));
		pnMain.add(pnDanhSach);
		
		JPanel pnDSNV = new JPanel();
		pnDSNV.setLayout(new BorderLayout());
		
		
		listNhanVien = new JList<NhanVien>();
		Border borderDSNV = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitleDSNV = BorderFactory.createTitledBorder(borderDSNV ,"Danh sách nhân viên");
		borderTitleDSNV.setTitleColor(Color.RED);
		borderTitleDSNV.setTitleJustification(TitledBorder.CENTER);
		pnDSNV.setBorder(borderTitleDSNV);
		JScrollPane sc = new JScrollPane(listNhanVien,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnDSNV.add(sc, BorderLayout.CENTER);
		pnDanhSach.add(pnDSNV);
		
		
		JPanel pnChiTiet = new JPanel();
		pnChiTiet.setLayout(new BoxLayout(pnChiTiet, BoxLayout.Y_AXIS) );
		pnDanhSach.add(pnChiTiet);
		Border borderChiTiet = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitleChiTiet = BorderFactory.createTitledBorder( borderChiTiet ,"Chi tiết");
		borderTitleChiTiet.setTitleColor(Color.RED);
		borderTitleChiTiet.setTitleJustification(TitledBorder.CENTER);
		pnChiTiet.setBorder(borderTitleChiTiet);
		
		JPanel pnMa = new JPanel();
		pnMa.setLayout(new FlowLayout());
		pnChiTiet.add(pnMa);
		JLabel lblMa = new JLabel(" Mã:");
		txtMa = new JTextField(15);
		pnMa.add(lblMa);
		pnMa.add(txtMa);
		
		JPanel pnHoTen = new JPanel();
		pnHoTen.setLayout(new FlowLayout());
		pnChiTiet.add(pnHoTen);
		JLabel lblHoTen = new JLabel("Họ tên:");
		txtHoTen = new JTextField(15);
		pnHoTen.add(lblHoTen);
		pnHoTen.add(txtHoTen);
		
		JPanel pnGioitinh = new JPanel();
		pnGioitinh.setLayout(new FlowLayout(FlowLayout.CENTER));
		pnChiTiet.add(pnGioitinh);
		JLabel lblGioiTinh = new JLabel("Giới tính");
		radNam = new JRadioButton("Nam");
		radNu = new JRadioButton("Nữ");
		groupGioiTinh = new ButtonGroup();
		groupGioiTinh.add(radNam);
		groupGioiTinh.add(radNu);
		pnGioitinh.add(lblGioiTinh);
		pnGioitinh.add(radNam);
		pnGioitinh.add(radNu);
		
		
		JPanel pnNgayVaoLamViec = new JPanel();
		pnNgayVaoLamViec.setLayout(new FlowLayout());
		pnChiTiet.add(pnNgayVaoLamViec);
		JLabel lblNgayVaoLamViec = new JLabel("Ngày vào:");
		txtNgayVaoLamViec = new JTextField(15);
		pnNgayVaoLamViec.add(lblNgayVaoLamViec);
		pnNgayVaoLamViec.add(txtNgayVaoLamViec);
		
		JPanel pnNgaySinh = new JPanel();
		pnNgaySinh.setLayout(new FlowLayout());
		pnChiTiet.add(pnNgaySinh);
		JLabel lblNgaySinh = new JLabel("Ngày sinh:");
		txtNgaySinh = new JTextField(15);
		pnNgaySinh.add(lblNgaySinh);
		pnNgaySinh.add(txtNgaySinh);
		
		lblMa.setPreferredSize(lblNgaySinh.getPreferredSize());
		lblHoTen.setPreferredSize(lblNgaySinh.getPreferredSize());
		lblNgayVaoLamViec.setPreferredSize(lblNgaySinh.getPreferredSize());
		
		JPanel pnButton = new JPanel();
		pnButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
		pnMain.add(pnButton);
		
		btnThemNV = new JButton("Thêm nhân viên");
		btnXoaNV = new JButton("Xóa nhân viên");
		btnXoaPhong = new JButton("Xóa Phòng");
		btnThoat = new JButton("Thoát");
		btnLuu = new JButton("Lưu");
		pnButton.add(btnThemNV);
		pnButton.add(btnXoaNV);
		pnButton.add(btnXoaPhong);
		pnButton.add(btnLuu);
		pnButton.add(btnThoat);
		
		
		XuLyDocFile();
	}
	
	public void showWindow() {
		this.setSize(600,350);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}

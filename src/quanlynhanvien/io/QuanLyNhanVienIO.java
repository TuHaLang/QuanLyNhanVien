package quanlynhanvien.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import quanlynhanvien.model.PhongBan;


public class QuanLyNhanVienIO extends JFrame{
	
		public static boolean luuFile(ArrayList<PhongBan> dsPhongBan, String path) {
			try {
				FileOutputStream fos = new FileOutputStream(path);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(dsPhongBan);
				oos.close();
				fos.close();
				return true;
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
			return false;
		}
		
		public static ArrayList<PhongBan> docFile(String path){
			ArrayList<PhongBan> dsPhongBan = new ArrayList<PhongBan>();
			try {
				FileInputStream fis = new FileInputStream(path);
				ObjectInputStream ois = new ObjectInputStream(fis);
				Object data = ois.readObject();
				if(data==null) return null;
				dsPhongBan = (ArrayList<PhongBan>) data;
				ois.close();
				fis.close();
				return dsPhongBan;
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, e);
				return null;
			}
		}
}

package entity;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author nhoxc
 *
 */
@Entity
public class HoaDon implements Comparable<HoaDon>{
	@Id
	private String maHD;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="khachhang")
	private KhachHang khachHang;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="nhanvien")
	private NhanVien nhanVien;
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="sanpham")
	private List<SanPham> dsSP;
	@ElementCollection
	private List<Integer> soLuong;
	private GregorianCalendar ngayMua = new GregorianCalendar();
	private static final float VAT = (float) 0.05;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HoaDon [maHD=");
		builder.append(maHD);
		builder.append(", khachHang=");
		builder.append(khachHang);
		builder.append(", nhanVien=");
		builder.append(nhanVien);
		builder.append(", dsSP=");
		builder.append(dsSP);
		builder.append(", soLuong=");
		builder.append(soLuong);
		builder.append(", ngayMua=");
		builder.append(ngayMua);
		builder.append("]");
		return builder.toString();
	}
	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HoaDon(String maHD, KhachHang khachHang, NhanVien nhanVien, List<SanPham> dsSP, List<Integer> soLuong,
			GregorianCalendar ngayMua) {
		super();
		this.maHD = maHD;
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
		this.dsSP = dsSP;
		this.soLuong = soLuong;
		this.ngayMua = ngayMua;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dsSP == null) ? 0 : dsSP.hashCode());
		result = prime * result + ((khachHang == null) ? 0 : khachHang.hashCode());
		result = prime * result + ((maHD == null) ? 0 : maHD.hashCode());
		result = prime * result + ((ngayMua == null) ? 0 : ngayMua.hashCode());
		result = prime * result + ((nhanVien == null) ? 0 : nhanVien.hashCode());
		result = prime * result + ((soLuong == null) ? 0 : soLuong.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDon other = (HoaDon) obj;
		if (dsSP == null) {
			if (other.dsSP != null)
				return false;
		} else if (!dsSP.equals(other.dsSP))
			return false;
		if (khachHang == null) {
			if (other.khachHang != null)
				return false;
		} else if (!khachHang.equals(other.khachHang))
			return false;
		if (maHD == null) {
			if (other.maHD != null)
				return false;
		} else if (!maHD.equals(other.maHD))
			return false;
		if (ngayMua == null) {
			if (other.ngayMua != null)
				return false;
		} else if (!ngayMua.equals(other.ngayMua))
			return false;
		if (nhanVien == null) {
			if (other.nhanVien != null)
				return false;
		} else if (!nhanVien.equals(other.nhanVien))
			return false;
		if (soLuong == null) {
			if (other.soLuong != null)
				return false;
		} else if (!soLuong.equals(other.soLuong))
			return false;
		return true;
	}
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	public List<SanPham> getDsSP() {
		return dsSP;
	}
	public void setDsSP(List<SanPham> dsSP) {
		this.dsSP = dsSP;
	}
	public List<Integer> getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(List<Integer> soLuong) {
		this.soLuong = soLuong;
	}
	public GregorianCalendar getNgayMua() {
		return ngayMua;
	}
	public void setNgayMua(GregorianCalendar ngayMua) {
		this.ngayMua = ngayMua;
	}
	public static float getVat() {
		return VAT;
	}
	@Override
	public int compareTo(HoaDon o) {
		// TODO Auto-generated method stub
		if(this.ngayMua.getTime().getTime() < o.getNgayMua().getTime().getTime())
			return -1;
		if(this.ngayMua.getTime().getTime() > o.getNgayMua().getTime().getTime())
			return 1;
		return this.khachHang.getMaKH().compareToIgnoreCase(o.getKhachHang().getMaKH());
	}
	public double thanhTien(int index) {
		double money = 0;
		for (SanPham x : dsSP) 
			money += x.getGiaTMDV() * soLuong.get(index);
		return money;
	}
	//
	public double tongTien() {
		double money = 0;
		for (int i = 0; i < soLuong.size(); i++)
			money += thanhTien(i);
		return money;
	}
	//
	public double thueVAT() {
		return tongTien() * VAT;
	}
}

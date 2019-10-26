package presentationlayer;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.hibernate.hql.ast.origin.hql.parse.HQLParser.new_key_return;

import businesslayer.QLHoaDon;
import businesslayer.QLKhachHang;
import businesslayer.QLLoaiSP;
import businesslayer.QLMau;
import businesslayer.QLNhaCC;
import businesslayer.QLNhanVien;
import businesslayer.QLSanPham;
import businesslayer.QLXuatSu;
import entity.HoaDon;
import entity.KhachHang;
import entity.LoaiSanPham;
import entity.Mau;
import entity.NhaCungCap;
import entity.NhanVien;
import entity.SanPham;
import entity.XuatSu;
import implementslayer.QLHoaDonimpl;
import implementslayer.QLKhachHangimpl;
import implementslayer.QLLoaiSPimpl;
import implementslayer.QLMauimpl;
import implementslayer.QLNhaCCimpl;
import implementslayer.QLNhanVienimpl;
import implementslayer.QLSanPhamimpl;
import implementslayer.QLXuatSuimpl;

public class Main {
	public static void main(String[] args) {
		EntityManager em=Persistence.createEntityManagerFactory("PtanNhom1").createEntityManager();
		LoaiSanPham loai1=new LoaiSanPham("10122212", "thietbi123");
		QLLoaiSPimpl loaidao=new QLLoaiSP(em);
		loaidao.ThemLTB(loai1);
		Mau mau1=new Mau("1232213121111", "xanh");
		QLMauimpl maudao=new QLMau(em);
		maudao.addMau(mau1);
		XuatSu xs1=new XuatSu("nuoc2012222123", "vietnam");
		QLXuatSuimpl xsdao=new QLXuatSu(em);
		xsdao.addXS(xs1);
		NhaCungCap ncc=new NhaCungCap("21213115132251");
		QLNhaCCimpl nccdao=new QLNhaCC(em);
		nccdao.addNCC(ncc);
		SanPham sp1=new SanPham("119112232322232131", "okok1", loai1, mau1, ncc, xs1, new GregorianCalendar(2019, 11, 20), "6", "15", 5, 10000, "mota");
		SanPham sp=new SanPham("117321232133221", "okok2", loai1, mau1, ncc, xs1, new GregorianCalendar(2019, 11, 20), "6", "15", 5, 10000, "mota");
		QLSanPhamimpl spdao=new QLSanPham(em);
		spdao.addTB(sp);
		NhanVien nv=new NhanVien("a11983212222321", "11432131", "tri", "156", "13213@gmail.com", 1999, false, false, "115 tran duy hung");
		QLNhanVienimpl nvdao=new QLNhanVien(em);
		nvdao.addAcc(nv);
		QLKhachHangimpl khdao=new QLKhachHang(em);
		
		KhachHang kh1=new KhachHang("a334533212133212", "tri", "176/35 tran huy lieu", "tritranminhh@gmail.com", "0938350282");
		khdao.ThemKH(kh1);
		QLHoaDonimpl hddao=new QLHoaDon(em);
		List<SanPham> list1=new ArrayList<SanPham>();
		List<Integer> list2=new ArrayList<Integer>();
		list1.add(sp);
		list1.add(sp1);
		list2.add(2);
		list2.add(3);
		HoaDon hd1=new HoaDon("34612312323113321213", kh1, nv, list1, list2, new GregorianCalendar(2019, 10, 14));
		System.out.println(hd1);
		nvdao.getListAcc();
	}
	

}

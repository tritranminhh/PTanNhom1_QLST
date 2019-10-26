package implementslayer;

import java.util.ArrayList;
import java.util.List;

import entity.NhanVien;
import entity.XuatSu;

public interface QLXuatSuimpl {
	XuatSu timNuoc(String tenNuoc);
	List<XuatSu> getDsXS();
	boolean addXS(XuatSu x);
	boolean removeXS(String maXS);
	boolean repairXS(XuatSu x);
}

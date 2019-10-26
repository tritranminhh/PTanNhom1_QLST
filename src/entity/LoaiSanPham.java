package entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class LoaiSanPham {
	@Id
	private String maLTB;
	private String TenLTB;
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="maSP")
	private List<SanPham> dssp;
	public void setMaLTB(String maLTB) {
		this.maLTB = maLTB;
	}
	public String getMaLTB() {
		return maLTB;
	}
	public String getTenLTB() {
		return TenLTB;
	}
	public void setTenLTB(String tenLTB) {
		this.TenLTB = tenLTB;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((TenLTB == null) ? 0 : TenLTB.hashCode());
		result = prime * result + ((dssp == null) ? 0 : dssp.hashCode());
		result = prime * result + ((maLTB == null) ? 0 : maLTB.hashCode());
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
		LoaiSanPham other = (LoaiSanPham) obj;
		if (TenLTB == null) {
			if (other.TenLTB != null)
				return false;
		} else if (!TenLTB.equals(other.TenLTB))
			return false;
		if (dssp == null) {
			if (other.dssp != null)
				return false;
		} else if (!dssp.equals(other.dssp))
			return false;
		if (maLTB == null) {
			if (other.maLTB != null)
				return false;
		} else if (!maLTB.equals(other.maLTB))
			return false;
		return true;
	}
	public List<SanPham> getDssp() {
		return dssp;
	}
	public void setDssp(List<SanPham> dssp) {
		this.dssp = dssp;
	}
	public LoaiSanPham(String maLTB, String tenLTB, List<SanPham> dssp) {
		super();
		this.maLTB = maLTB;
		TenLTB = tenLTB;
		this.dssp = dssp;
	}
	public LoaiSanPham(String maLTB, String tenLTB) {
		super();
		this.maLTB = maLTB;
		TenLTB = tenLTB;
	}
	public LoaiSanPham() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LoaiSanPham [maLTB=");
		builder.append(maLTB);
		builder.append(", TenLTB=");
		builder.append(TenLTB);
		builder.append(", dssp=");
		builder.append(dssp);
		builder.append("]");
		return builder.toString();
	}
	

	
}

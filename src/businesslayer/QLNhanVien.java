package businesslayer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entity.NhanVien;
import implementslayer.QLNhanVienimpl;

public class QLNhanVien implements QLNhanVienimpl{
	private EntityManager em;
	private List<NhanVien> mngAcc;

	public QLNhanVien(EntityManager em) {
		super();
		this.em = em;
		mngAcc=new ArrayList<NhanVien>();
		System.out.println(em.getClass());
	}

	@Override
	public boolean addAcc(NhanVien x) {
		// TODO Auto-generated method stub
		EntityTransaction tr=em.getTransaction();
		try {
			tr.begin();
			em.persist(x);
			tr.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	@Override
	public NhanVien searchAcc(String IDx) {
		// TODO Auto-generated method stub
		return em.find(NhanVien.class, IDx);
	}

	@Override
	public boolean removeAcc(String IDx) {
		// TODO Auto-generated method stub
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.remove(em.find(NhanVien.class, IDx));///?????
			tr.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	@Override
	public boolean changeInfor(NhanVien x) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void sorter() {
		// TODO Auto-generated method stub
		Collections.shuffle(mngAcc);
	}

	@Override
	public List<NhanVien> getListAcc() {
		// TODO Auto-generated method stub
		List<NhanVien> dsnv = em.createQuery("from NhanVien nv",NhanVien.class).getResultList();
		System.out.println(dsnv);
		return dsnv;
	}

}

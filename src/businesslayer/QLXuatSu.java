package businesslayer;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entity.NhaCungCap;
import entity.XuatSu;
import implementslayer.QLXuatSuimpl;

public class QLXuatSu implements QLXuatSuimpl{
private EntityManager em;

	public QLXuatSu(EntityManager em) {
	super();
	this.em = em;
}

	@Override
	public XuatSu timNuoc(String tenNuoc) {
		// TODO Auto-generated method stub
		return em.find(XuatSu.class, tenNuoc);
	}

	@Override
	public List<XuatSu> getDsXS() {
		// TODO Auto-generated method stub
		return em.createQuery("from XuatSu xs",XuatSu.class).getResultList();
	}

	@Override
	public boolean addXS(XuatSu x) {
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
	public boolean removeXS(String maXS) {
		// TODO Auto-generated method stub
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.remove(em.find(XuatSu.class,maXS));
			tr.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	@Override
	public boolean repairXS(XuatSu x) {
		// TODO Auto-generated method stub
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(x);
			tr.commit();
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	
	
	
}

package businesslayer;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entity.Mau;
import entity.NhanVien;
import implementslayer.QLMauimpl;

public class QLMau implements QLMauimpl{
private EntityManager em;

	public QLMau(EntityManager em) {
	super();
	this.em = em;
}

	@Override
	public Mau timMau(String tenMau) {
		// TODO Auto-generated method stub
		return em.find(Mau.class, tenMau);
	}

	@Override
	public List<Mau> getAll() {
		// TODO Auto-generated method stub
		return em.createQuery("from Mau mau",Mau.class).getResultList();
	}

	@Override
	public boolean addMau(Mau x) {
		// TODO Auto-generated method stub
		EntityTransaction tr=em.getTransaction();
		try {
			tr.begin();
			em.persist(x);
			tr.commit();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	@Override
	public boolean removeMau(String maMau) {
		// TODO Auto-generated method stub
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.remove(em.find(Mau.class, maMau));///?????
			tr.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	@Override
	public boolean repairMau(Mau x) {
		// TODO Auto-generated method stub
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(x);
			tr.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

}

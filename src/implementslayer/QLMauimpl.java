package implementslayer;

import java.util.List;

import entity.Mau;

public interface QLMauimpl {
Mau timMau(String tenMau);
List<Mau> getAll();
boolean addMau(Mau x);
boolean removeMau(String maMau);
boolean repairMau(Mau x);

}

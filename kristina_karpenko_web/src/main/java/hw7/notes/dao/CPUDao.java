package hw7.notes.dao;

import hw7.notes.domain.CPU;
import hw7.notes.domain.Vendor;

import java.util.List;

/**
 * Created by Администратор on 15.02.2016.
 */
public interface CPUDao {
    Long create(CPU cpu);
    CPU read(Long id);
    boolean update(CPU cpu);
    boolean delete(CPU cpu);
    List findAll();
    List findCPUbyVendor(Vendor vendor);
    CPU findCPUByName(String name);
}
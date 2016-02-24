package hw7.service;

import hw7.dao.*;
import hw7.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by i.gonchar on 2/15/2016.
 */
@Service("notebookService")
public class NotebookServiceImpl implements NotebookService {

    //Before Spring
   /* private NotebookDao notebookDao;
    private CPUDao cpuDao;
    private MemoryDao memoryDao;
    private SalesDao salesDao;
    private StoreDao storeDao;
    private VendorDao vendorDao;

    public NotebookServiceImpl(NotebookDao notebookDao, CPUDao cpuDao, MemoryDao memoryDao, VendorDao vendorDao, SalesDao salesDao, StoreDao storeDao) {
        this.notebookDao = notebookDao;
        this.cpuDao = cpuDao;
        this.memoryDao = memoryDao;
        this.salesDao = salesDao;
        this.storeDao = storeDao;
        this.vendorDao = vendorDao;
    }*/

    @Autowired(required = true)
    private CPUDao cpuDao;

    @Autowired(required = true)
    private MemoryDao memoryDao;

    @Autowired(required = true)
    private NotebookDao notebookDao;

    @Autowired(required = true)
    private SalesDao salesDao;

    @Autowired(required = true)
    private StoreDao storeDao;

    @Autowired(required = true)
    private VendorDao vendorDao;

    @Override
    public boolean updateCPU(CPU cpu) {
        if (cpu == null) return false;
        if (cpuDao.read(cpu.getId()) != null) {
            cpuDao.update(cpu);
        }
        return true;
    }

    @Override
    @Transactional
    public boolean createCPU(CPU cpu) {
        if (cpu == null) return false;
        cpuDao.create(cpu);
        return true;
    }

    @Override
    @Transactional
    public boolean updateMemory(Memory memory) {
        if (memory == null) return false;
        if (memoryDao.read(memory.getId()) != null) {
            memoryDao.update(memory);
        }
        return true;
    }

    @Override
    @Transactional
    public boolean createMemory(Memory memory) {
        if (memory == null) return false;
        memoryDao.create(memory);
        return true;
    }

    @Override
    @Transactional
    public boolean updateVendor(Vendor vendor) {
        if (vendor == null) return false;
        if (vendorDao.read(vendor.getId()) != null)
            vendorDao.update(vendor);
        return true;
    }

    @Override
    @Transactional
    public boolean createVendor(Vendor vendor) {
        if (vendor == null) return false;
        vendorDao.create(vendor);
        return true;
    }

    @Override
    @Transactional
    public boolean createStore(Store store) {
        if (store == null) return false;
        storeDao.create(store);
        return true;
    }

    @Override
    @Transactional
    public boolean createNotebok(Notebook notebook) {
        if (notebook == null) return false;
        notebookDao.create(notebook);
        return true;
    }

    @Override
    @Transactional
    public boolean updateNotebook(Notebook notebook) {
        if (notebook == null) return false;
        if (notebookDao.read(notebook.getId()) != null) {
            return notebookDao.update(notebook);
        } else {
            return (notebookDao.create(notebook) != null);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Vendor getVendorById(Long id) {
        return vendorDao.read(id);
    }

    @Override
    @Transactional(readOnly = true)
    public CPU getCPUById(Long id) {
        return cpuDao.read(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Memory getMemoryById(Long id) {
        return memoryDao.read(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Notebook getNotebookById(Long id) {
        return notebookDao.read(id);
    }

    @Override
    @Transactional
    public boolean removeFromStore(Store store, int amount) {
        return false;
    }

    @Override
    @Transactional(readOnly = true)
    public List getAllCPUs() {
        return cpuDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List getAllStores() {
        return storeDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List getAllMemories() {
        return memoryDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List getAllVendors() {
        return vendorDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List getAllNotebooks() {
        return notebookDao.findAll();
    }
}

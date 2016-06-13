package notes.service;


import notes.dao.NotebookDao;
import notes.domain.Notebook;

import java.util.Date;
import java.util.List;

/**
 * Created by Rrr on 09.02.2016.
 */
public class NotebookServiceImpl implements NotebookService {
    private NotebookDao notebookDao;

    public NotebookServiceImpl(NotebookDao dao) {
        notebookDao = dao;
    }

    @Override
    public List findAll() {
        return notebookDao.findAll();
    }

    @Override
    public Long add(Notebook ntb) {
       return notebookDao.create(ntb);
    }


    @Override
    public void changeSerialVendor(Long id, Integer serial, String vendor) {
        Notebook note = notebookDao.readById(id);
        if (note != null) {
            note.setSerial(serial);
            note.setVendor(vendor);
            notebookDao.update(note);
        }
    }
    @Override
    public void changePrice(Long id, Integer price) {
        Notebook note = notebookDao.readById(id);
        if (note != null) {
            note.setPrice(price);
            notebookDao.update(note);
        }
    }

    @Override
    public boolean delete(Long id) {
        Notebook ntb=notebookDao.readById(id);
        boolean isDeleted = false;
        if (ntb != null) {
            isDeleted = notebookDao.delete(ntb);
        }
        return isDeleted;

    }

    @Override
    public boolean deleteByModel(String model) {
         List<Notebook> ntb=notebookDao.findByModel(model);
        boolean isDeleted = false;
        if (ntb != null && !ntb.isEmpty()) {
            for (Notebook note : ntb) {
                isDeleted = notebookDao.delete(note);
                if (!isDeleted) break;
            }
        }
        return isDeleted;


    }

    @Override
    public List findByVendor(String vendor) {
        return notebookDao.findByVendor(vendor);
    }

    @Override
    public List findByPriceManufDate(Integer price, Date date) {
        return notebookDao.findByPriceManufDate( price, date);

    }

    @Override
    public List findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor) {
        return null;
    }
}
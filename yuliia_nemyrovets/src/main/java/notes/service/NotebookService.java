package notes.service;

import notes.domain.Notebook;

import java.util.Date;
import java.util.List;

/**
 * Created by Юлия on 12.02.2016.
 */
public interface NotebookService {

    Long create(Notebook notebook);

    List findAll();

    void changePrice(Long id, double price);

    void changeSerialVendor(Long id, String serial, String vendor);

    boolean delete(Long id);

    boolean deleteByModel(String model);

    List findByVendor(String vendor);

    List findByPriceManufDate(Double price, Date date);

    List findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor);
}

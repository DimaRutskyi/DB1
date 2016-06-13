package notes.service;

import notes.domain.Notebook;

import java.util.Date;
import java.util.List;

/**
 * Created by Rrr on 09.02.2016.
 */
public interface NotebookService {
    Long add(Notebook notebook);
    List findAll();

    void changePrice(Long id, Integer price);
    void changeSerialVendor(Long id, Integer serial, String vendor);
    boolean delete(Long id);
    boolean deleteByModel(String model);
    List findByVendor(String vendor);
    List findByPriceManufDate(Integer price, Date date);
    List findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor);


}

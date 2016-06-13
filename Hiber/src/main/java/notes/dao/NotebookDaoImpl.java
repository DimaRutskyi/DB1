package notes.dao;


import notes.domain.Notebook;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Date;
import java.util.List;

/**
* Created by Rrr on 09.02.2016.
*/
public class NotebookDaoImpl implements NotebookDao {
   private static Logger log = Logger.getLogger(NotebookDaoImpl.class);
   private SessionFactory factory;

   public NotebookDaoImpl(SessionFactory factory) {
       this.factory = factory;
   }

   @Override
   public Long create(Notebook ntb) {
       Session session = factory.openSession();
       Long id = null;
       try {
           session.beginTransaction();
           id = (Long)session.save(ntb);
           session.getTransaction().commit();
           return id;
       } catch (HibernateException e) {
           log.error("Transaction failed");
           session.getTransaction().rollback();
       } finally {
           session.close();
       }
       return id;
   }

   @Override

   public Notebook readById(Long id) {
       Session session = factory.openSession();
       Notebook note = null;
       try {
           note= (Notebook)session.get(Notebook.class, id);
       } catch (HibernateException e) {
           log.error("Transaction failed");
           session.getTransaction().rollback();
       } finally {
           session.close();
       }
       return note;
   }

   @Override
   public boolean update(Notebook ntb) {
       Session session = factory.openSession();
       boolean isUpdated = false;
       try {
               session.beginTransaction();
               session.update(ntb);
               session.getTransaction().commit();
               isUpdated = true;
           return true;
       } catch (HibernateException e) {
           log.error("Transaction failed");
           session.getTransaction().rollback();
       } finally {
           session.close();
       }
       return isUpdated;
   }

   @Override
   public boolean delete(Notebook ntb) {
       Session session = factory.openSession();
       boolean isDeleted = false;
       try {
           session.beginTransaction();
           session.delete(ntb);
           session.getTransaction().commit();
           isDeleted = true;
       } catch (HibernateException e) {
           log.error("Transaction failed");
           session.getTransaction().rollback();
       } finally {
           session.close();
       }
       return isDeleted;
   }

    @Override
   public List findAll() {
       Session session = factory.openSession();
       Query query = session.createQuery("from Notebook");
       return query.list();
   }
  /*  @Override
    public List<Notebook> findByModel(String model) {
        List<Notebook> list = new ArrayList<Notebook>();
        Session session = factory.openSession();
        Query query = null;
        try {
            query = session.createQuery("FROM Notebook nb WHERE nb.model = :model");
            query.setParameter("model", model);

            List results = query.list();
            for(Object res : results) {
                list.add((Notebook)res);
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }*/
    @Override
    public List findByModel(String model) {

        Session session = factory.openSession();
        Query query = session.createQuery("from Notebook ntb WHERE ntb.model = :model");
        return query.list();
    }

    @Override
    public List findByVendor(String vendor) {
        Session session = factory.openSession();
        Query query = session.createQuery("from Notebook ntb WHERE ntb.vendor = :vendor");
        query.setParameter("vendor", vendor);
        return query.list();
    }

    @Override
    public List findByPriceManufDate(Integer price, Date date) {
        Session session = factory.openSession();
        Query query = session.createQuery("from Notebook ntb WHERE ntb.price = :price AND ntb.manufactureDate=:date");
        query.setParameter("price", price);
        query.setParameter("date", date);
        return query.list();

    }

    @Override
    public List findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor) {
        return null;
    }
}

package hw7.notes.dao;

import hw7.notes.domain.CPU;
import hw7.notes.domain.Notebook;
import hw7.notes.domain.Vendor;
import org.hibernate.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Вадим on 14.02.2016.
 */
@SuppressWarnings("unchecked")
public class NotebookDaoImpl implements NotebookDao {

    private SessionFactory factory;

    public NotebookDaoImpl() {}

    public NotebookDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(Notebook notebook) {
        Session session = factory.openSession();
        Long id = null;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            id = (Long)session.save(notebook);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return id;
    }

    @Override
    public Notebook read(Long id) {
        Session session = factory.openSession();
        Notebook notebook = null;
        try {
            notebook = (Notebook)session.get(Notebook.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return notebook;
    }

    @Override
    public boolean update(Notebook notebook) {
        Session session = factory.openSession();
        boolean isUpdated = false;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(notebook);
            tx.commit();
            isUpdated = true;
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return isUpdated;
    }

    @Override
    public boolean delete(Notebook notebook) {
        Session session = factory.openSession();
        boolean isDeleted = false;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(notebook);
            tx.commit();
            isDeleted = true;
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return isDeleted;
    }

    @Override
    public List<Notebook> findAll() {
        Session session = factory.openSession();
        try {
            return (List<Notebook>)session.createQuery("FROM Notebook").list();
        } finally {
            session.close();
        }
    }

    ////////////////////////////////////////////////////////////////////////////

    public List<Notebook> findByPortion(int page, int size) {
        Session session = factory.openSession();
        try {
            Query query = session.createQuery("FROM Notebook");
            query.setFirstResult(page);
            query.setMaxResults(size);
            return (List<Notebook>)query.list();
        } finally {
            session.close();
        }
    }

    public List<Notebook> findGtAmount(int amount) {
        Session session = factory.openSession();
        try {
            SQLQuery query = session.createSQLQuery(
                    "select * from NOTEBOOK n"
            );
            query.addEntity(Notebook.class);
            query.setParameter("amount", amount);
            return query.list();
        } finally {
            session.close();
        }
    }

    public List<Notebook> findByCpuVendor(Vendor cpuVendor) {
        Session session = factory.openSession();
        try {
            SQLQuery query = session.createSQLQuery(
                    "select * from NOTEBOOK n, CPU c, VENDOR v " +
                            "where n.CPU_ID = c.CPU_ID " +
                            "and c.VENDOR_ID = v.VENDOR_ID " +
                            "and v.NAME like :vendorName"
            );
            query.addEntity(Notebook.class);
            query.setParameter("vendorName", cpuVendor.getName());
            return query.list();
        } finally {
            session.close();
        }
    }

    public List<Notebook> findAllOnStore() {
        return findAll();
    }

    public List<Notebook> findOnStorePresent() {
        Session session = factory.openSession();
        try {
            SQLQuery query = session.createSQLQuery(
                    "select * from NOTEBOOK n, STORE s " +
                            "where n.NOTEBOOK_ID = s.NOTEBOOK_ID"
            );
            query.addEntity(Notebook.class);
            return query.list();
        } finally {
            session.close();
        }
    }
}

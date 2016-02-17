package hw7.notes.dao;

import hw7.notes.domain.CPU;
import hw7.notes.domain.Memory;
import hw7.notes.domain.Vendor;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by s_okhoda on 16.02.2016.
 */
public class MemoryDaoImpl implements MemoryDao {
    private static Logger log = Logger.getLogger(MemoryDaoImpl.class);
    private SessionFactory factory;

    public MemoryDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(Memory memory) throws HibernateException {
        Session session = factory.openSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long) session.save(memory);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("Transaction failed", e);
            session.getTransaction().rollback();
            throw new HibernateException(e.getMessage() + ", " + e.getCause()
                    .getMessage());
        } finally {
            session.close();
        }
        return id;
    }

    @Override
    public Memory read(Long id) {
        if (id == null) {
            return null;
        }
        Session session = factory.openSession();
        Memory memory = null;
        try {
            memory = (Memory) session.get(Vendor.class, id);
        } catch (HibernateException e) {
            log.error("Transaction failed", e);
        } finally {
            session.close();
        }
        return memory;
    }

    @Override
    public boolean update(Memory memory) {
        if (memory == null){
            return false;
        }
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.update(memory);
            session.getTransaction().commit();
            return true;
        }
        catch (HibernateException e) {
            log.error("Transaction failed", e);
            session.getTransaction().rollback();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean delete(Memory memory) {
        if (memory == null){
            return false;
        }
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.delete(memory);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            log.error("Transaction failed", e);
            session.getTransaction().rollback();
            return false;
        } finally {
            session.close();
        }

    }

    @Override
    public List findAll() {
        Session session = factory.openSession();
        try {
            Query query = session.createQuery("from Memory");
            return query.list();
        } catch (HibernateException e) {
            log.error("Transaction failed", e);
            return null;
        } finally {
            session.close();
        }
    }
}

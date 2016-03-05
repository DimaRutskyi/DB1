package session15;

import org.hibernate.HibernateError;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Home on 20.02.2016.
 */
public class EmployeeDaoImpl implements EmployeeDao {
    ApplicationContext cont;
    public EmployeeDaoImpl(){
        cont = new ClassPathXmlApplicationContext("session15/context-db.xml");
    }

    @Override
    public Long create(Employee employee) {
        return null;
    }

    @Override
    public void read(Long id) {

    }

    @Override
    public void delete(Employee id) {

    }

    @Override
    public List<Employee> findAll() {
        Session session = null;
        List<Employee> resultObj = null;
        try {
            session = cont.getBean("sf", SessionFactory.class).openSession();
            Query query = session.createQuery("FROM Employee e");
            resultObj = query.list();
        } catch (HibernateError e){
            if(session != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if(session != null) {
                session.close();
            }
        }
        return resultObj;
    }

    @Override
    public List<Employee> findByDep(Long depId) {
        return null;
    }

    @Override
    public List<Employee> findEcceptDep(Long depId) {
        return null;
    }
}
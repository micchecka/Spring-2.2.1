package hiber.dao;

import hiber.model.Car;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CarDaoImp implements CarDao {
    @Autowired
    public CarDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    private final SessionFactory sessionFactory;
    @Override
    public void carAdd(Car car) {
      sessionFactory.getCurrentSession().save(car);
        }
    }


package by.nyurush.pet.dao.impl;

import by.nyurush.pet.dao.UserDao;
import by.nyurush.pet.entity.User;
import by.nyurush.pet.exception.DaoException;
import by.nyurush.pet.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {

    @Override
    public User save(User user) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(user);
            transaction.commit();
            return user;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DaoException("Cannot save user");
        }
    }

    @Override
    public void delete(User user) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DaoException("Cannot delete user");
        }
    }

    @Override
    public List<User> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from User", User.class).getResultList();
        } catch (Exception e) {
            throw new DaoException("Cannot find all users");
        }
    }

    @Override
    public Optional<User> findById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            User user = session.get(User.class, id);
            return Optional.ofNullable(user);
        } catch (Exception e) {
            throw new DaoException("Cannot find user by id");
        }
    }

}

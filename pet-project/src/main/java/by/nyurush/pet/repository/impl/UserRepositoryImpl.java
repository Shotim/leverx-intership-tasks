package by.nyurush.pet.repository.impl;

import by.nyurush.pet.repository.UserRepository;
import by.nyurush.pet.entity.User;
import by.nyurush.pet.exception.DaoException;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

import static by.nyurush.pet.util.HibernateUtil.getSessionFactory;

@Slf4j
public class UserRepositoryImpl implements UserRepository {

    @Override
    public User save(User user) {
        Transaction transaction = null;
        try (Session session = getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(user);
            transaction.commit();
            return user;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            log.warn("In UserDaoImpl: cannot save user {}", user);
            throw new DaoException("Cannot save user");
        }
    }

    @Override
    public void delete(User user) {
        Transaction transaction = null;
        try (Session session = getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            log.warn("In UserDaoImpl: cannot delete user {}", user);
            throw new DaoException("Cannot delete user");
        }
    }

    @Override
    public List<User> findAll() {
        try (Session session = getSessionFactory().openSession()) {
            return session.createQuery("from User", User.class).getResultList();
        } catch (Exception e) {
            log.warn("In UserDaoImpl: cannot find users");
            throw new DaoException("Cannot find all users");
        }
    }

    @Override
    public Optional<User> findById(Long id) {
        try (Session session = getSessionFactory().openSession()) {
            User user = session.get(User.class, id);
            return Optional.ofNullable(user);
        } catch (Exception e) {
            log.warn("In UserDaoImpl: cannot find user by id: {}", id);
            throw new DaoException("Cannot find user by id");
        }
    }

}

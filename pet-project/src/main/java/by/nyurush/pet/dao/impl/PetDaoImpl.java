package by.nyurush.pet.dao.impl;

import by.nyurush.pet.dao.PetDao;
import by.nyurush.pet.entity.Cat;
import by.nyurush.pet.entity.Dog;
import by.nyurush.pet.entity.Pet;
import by.nyurush.pet.entity.User;
import by.nyurush.pet.exception.DaoException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

import static by.nyurush.pet.util.HibernateUtil.getSessionFactory;

public class PetDaoImpl implements PetDao {

    @Override
    public Pet save(Pet pet) {
        Transaction transaction = null;
        try (Session session = getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(pet);
            transaction.commit();
            return pet;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DaoException("Cannot save pet");
        }
    }

    @Override
    public void delete(Pet pet) {
        Transaction transaction = null;
        try (Session session = getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(pet);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DaoException("Cannot delete pet");
        }
    }

    @Override
    public List<Pet> findAll() {
        try (Session session = getSessionFactory().openSession()) {
            return session.createQuery("from Pet", Pet.class).getResultList();
        } catch (Exception e) {
            throw new DaoException("Cannot find all pets");
        }
    }

    @Override
    public Optional<Pet> findById(Long id) {
        try (Session session = getSessionFactory().openSession()) {
            Pet pet = session.get(Pet.class, id);
            return Optional.ofNullable(pet);
        } catch (Exception e) {
            throw new DaoException("Cannot find pet by id");
        }
    }

    @Override
    public List<Cat> findAllCats() {
        try (Session session = getSessionFactory().openSession()) {
            return session.createQuery("from Cat", Cat.class).getResultList();
        } catch (Exception e) {
            throw new DaoException("Cannot find all cats");
        }
    }

    @Override
    public List<Dog> findAllDogs() {
        try (Session session = getSessionFactory().openSession()) {
            return session.createQuery("from Dog", Dog.class).getResultList();
        } catch (Exception e) {
            throw new DaoException("Cannot find all dogs");
        }
    }

    @Override
    public List<Pet> findAllByUser(User user) {
        try (Session session = getSessionFactory().openSession()) {

            Query<Pet> q = session.createQuery("from Pet pet where pet.user.id=?1",
                    Pet.class);
            q.setParameter(1, user.getId());

            return q.getResultList();
        } catch (Exception e) {
            throw new DaoException("Cannot find all pets by user");
        }
    }
}

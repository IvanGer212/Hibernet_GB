package dao.impl;

import entity.Product;
import dao.ProductDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class ProductDaoImpl implements ProductDao {
    @Override
    public Product findByID(Long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Product.class,id);
    }

    @Override
    public List<Product> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<Product> products = session.createQuery("FROM products").list();
        return products;
    }

    @Override
    public void deleteByID(Long id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Product product = session.get(Product.class, id);
        session.delete(product);
    }

    @Override
    public Product saveOrUpdate(Product product) {
        return null;
    }
}

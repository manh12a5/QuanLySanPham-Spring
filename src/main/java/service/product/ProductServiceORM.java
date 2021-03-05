package service.product;

import model.Product;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ProductServiceORM implements IProductService {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Product> findAll() {
        String query = "SELECT a FROM Product AS a";
        TypedQuery<Product> typedQuery = entityManager.createQuery(query, Product.class);
        return typedQuery.getResultList();
    }

    @Override
    public void save(Product product) {

    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public void update(int id, Product product) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<Product> findByName(String name) {
        return null;
    }
}

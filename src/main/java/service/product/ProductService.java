package service.product;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService {

    private static Map<Integer, Product> productMap;

    static {
        productMap = new HashMap<>();
        productMap.put(1, new Product(1, "iPhone 12", 21000000, 200, "Táo Mỹ"));
        productMap.put(2, new Product(2, "Samsung", 24000000, 200, "Hàn Xẻng"));
        productMap.put(3, new Product(3, "Oppo", 21000000, 200, "Ốp pồ"));
        productMap.put(4, new Product(4, "Xiaomi", 18000000, 200, "Táo Tàu"));
        productMap.put(5, new Product(5, "Realme", 10000000, 200, "Con của ốp pồ"));
        productMap.put(6, new Product(6, "iPhone 12 Pro Max", 30000000, 200, "Táo Mỹ"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id, product);
    }

    @Override
    public void remove(int id) {
        productMap.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productList = new ArrayList<>();
       for (Product product : findAll()) {
           if (product.getName().contains(name)) {
               productList.add(product);
           }
       }
        return productList;
    }

}

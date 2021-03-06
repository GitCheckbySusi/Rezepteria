package net.rezepteria.backend.mock;

import java.util.List;

import net.rezepteria.backend.DataService;
import net.rezepteria.backend.data.Category;
import net.rezepteria.backend.data.Product;
import net.rezepteria.backend.data.Rezept;

/**
 * Mock data model. This implementation has very simplistic locking and does not
 * notify users of modifications.
 */
public class MockDataService extends DataService {

    private static MockDataService INSTANCE;

    private List<Product> products;
    
    private List<Rezept> rezepte;
    
    private List<Category> categories;
    private int nextProductId = 0;
    private int nextRezeptId = 0;

    private MockDataService() {
        categories = MockDataGenerator.createCategories();
        products = MockDataGenerator.createProducts(categories);
        
        
        rezepte = MockDataGenerator.createRezepte(categories);
        
        nextProductId = products.size() + 1;
    }

    public synchronized static DataService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MockDataService();
        }
        return INSTANCE;
    }
    
    @Override
    public synchronized List<Category> getAllCategories() {
        return categories;
    }

    @Override
    public synchronized List<Product> getAllProducts() {
        return products;
    }



    @Override
    public synchronized void updateProduct(Product p) {
        if (p.getId() < 0) {
            // New product
            p.setId(nextProductId++);
            products.add(p);
            return;
        }
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == p.getId()) {
                products.set(i, p);
                return;
            }
        }

        throw new IllegalArgumentException("No product with id " + p.getId()
                + " found");
    }

    @Override
    public synchronized Product getProductById(int productId) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == productId) {
                return products.get(i);
            }
        }
        return null;
    }

    @Override
    public synchronized void deleteProduct(int productId) {
        Product p = getProductById(productId);
        if (p == null) {
            throw new IllegalArgumentException("Product with id " + productId
                    + " not found");
        }
        products.remove(p);
    }
    
    
    
    
    
    @Override
    public synchronized List<Rezept> getAllRezepte() {
        return rezepte;
    }



    @Override
    public synchronized void updateRezept(Rezept r) {
        if (r.getId() < 0) {
            // New product
            r.setId(nextRezeptId++);
            rezepte.add(r);
            return;
        }
        for (int i = 0; i < rezepte.size(); i++) {
            if (rezepte.get(i).getId() == r.getId()) {
            	rezepte.set(i, r);
                return;
            }
        }

        throw new IllegalArgumentException("No rezept with id " + r.getId()
                + " found");
    }

    @Override
    public synchronized Rezept getRezeptById(int rezeptId) {
        for (int i = 0; i < rezepte.size(); i++) {
            if (rezepte.get(i).getId() == rezeptId) {
                return rezepte.get(i);
            }
        }
        return null;
    }

    @Override
    public synchronized void deleteRezept(int rezeptId) {
        Rezept r = getRezeptById(rezeptId);
        if (r == null) {
            throw new IllegalArgumentException("Rezept with id " + rezeptId
                    + " not found");
        }
        rezepte.remove(r);
    }
    
    
}

package net.rezepteria.backend;

import java.io.Serializable;
import java.util.Collection;

import net.rezepteria.backend.data.Category;
import net.rezepteria.backend.data.Product;
import net.rezepteria.backend.data.Rezept;
import net.rezepteria.backend.mock.MockDataService;

/**
 * Back-end service interface for retrieving and updating product data.
 */
public abstract class DataService implements Serializable {

    public abstract Collection<Product> getAllProducts();

    public abstract Collection<Category> getAllCategories();

    public abstract void updateProduct(Product p);

    public abstract void deleteProduct(int productId);

    public abstract Product getProductById(int productId);
    
    
    public abstract Collection<Rezept> getAllRezepte();



    public abstract void updateRezept(Rezept p);

    public abstract void deleteRezept(int rezeptId);

    public abstract Rezept getRezeptById(int rezeptId);
    
    

    public static DataService get() {
        return MockDataService.getInstance();
    }

}

import dao.ProductDAO;
import entity.Product;

import java.util.List;

public class FactoryMain {
    public static void main(String[] args){

        //se crean los nuevos productos a registrar en la BD
        Product productM = new Product(1, "Aguacate", 5000.0);
        Product productN = new Product(2, "Limon", 200.0);

        //se crea una instancia del DAO
        ProductDAO dao = new ProductDAO();

        //almacenamos los productos en la BD
        dao.saveProduct(productM);
        dao.saveProduct(productN);

        //consultamos los productos
        List<Product> productList = dao.findAllProducts();
        System.out.println("productList size= " + productList.size());
        for(Product product : productList){
            System.out.println("product = " + product);
        }
    }
}

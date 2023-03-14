package edu.oralbama.crudProductos.business;

import edu.oralbama.crudProductos.models.ObjectRequest;
import edu.oralbama.crudProductos.models.Producto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductManagerInterface {
    public List<Producto> getListaProductos();
    public Producto getProductoName(String name) throws Exception;
    public Producto getProductDescription(String description);
    public Producto getProductPrice(String price);
    public String setProducto(Producto producto) throws Exception;
    public Producto updateProductAll(Producto productUpdate, String name) throws Exception;
    public Producto updateProduct(Producto productUpdate, String name) throws Exception;
    public String deleteProduct(String name);
}

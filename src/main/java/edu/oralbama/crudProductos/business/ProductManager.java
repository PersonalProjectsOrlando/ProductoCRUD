package edu.oralbama.crudProductos.business;

import edu.oralbama.crudProductos.models.Producto;
import edu.oralbama.crudProductos.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProductManager implements ProductManagerInterface{
    @Autowired
    private ProductRepository repositorio;

    @Override
    public List<Producto> getListaProductos() {
        return repositorio.findAll();
    }

    @Override
    public Producto getProductoName(String name) throws Exception {
        Optional<Producto> productBD = repositorio.findById(name);
        if(productBD.isPresent()){
            return productBD.get();
        }

        throw new Exception("!!Producto No existe!!");
    }

    @Override
    public Producto getProductDescription(String description) {
        return null;
    }

    @Override
    public Producto getProductPrice(String price) {
        return null;
    }

    @Override
    public String setProducto(Producto producto) throws Exception {
        try{
            getProductoName(producto.getName());    //Verifica que el product exista
        }catch (Exception e){
            repositorio.save(producto);
            return "Producto creado";
        }
        throw  new Exception("Producto existente");

    }
    @Transactional
    @Override
    public Producto updateProductAll(Producto productUpdate, String name) throws Exception {
        try{
            getProductoName(productUpdate.getName());
            repositorio.update(name, productUpdate.getDescription(),productUpdate.getPrice(),productUpdate.getStock());
            return  getProductoName(name);
        }catch (Exception e){
            throw new Exception("Objeto No existente");
        }

    }

    @Override
    public Producto updateProduct(Producto productUpdate, String name) throws Exception{
        Producto productoBd = getProductoName(name);
        try {
            /*if(productUpdate.getName() != null && !productUpdate.getName().equals("")){
                productoBd.setName(productoBd.getName());
            }*/
            if (productUpdate.getDescription() != null && !productUpdate.getDescription().equals("")) {
                productoBd.setDescription(productUpdate.getDescription());
            }
            if (productUpdate.getPrice() != null && !productUpdate.getPrice().equals("")) {
                productoBd.setPrice(productUpdate.getPrice());
            }
            if (String.valueOf(productUpdate.getStock()) != null && !String.valueOf(productUpdate.getStock()).equals("")) {
                productoBd.setStock(productUpdate.getStock());
            }
            return repositorio.save(productoBd);

        }catch (Exception e){
            throw new Exception("Producto no existe , fallo actualizacion de datos");
        }
    }

    @Override
    public String deleteProduct(String name) {
        repositorio.deleteById(name);
        return "Producto eliminado";
    }
}

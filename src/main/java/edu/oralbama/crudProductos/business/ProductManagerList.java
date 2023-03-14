package edu.oralbama.crudProductos.business;

import edu.oralbama.crudProductos.models.Producto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class ProductManagerList {
    private ArrayList<Producto> ListaProductos;
    Producto producto = new Producto();
    public ProductManagerList(){
      this.ListaProductos=new ArrayList<>();
      this.ListaProductos.add(new Producto("Arroz","Almidon","2000",50));
      this.ListaProductos.add(new Producto("Cerveza","Bebida","2200",32));
    }

    public ArrayList<Producto> getListaProductos() {

        return ListaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {

        ListaProductos = listaProductos;
    }
    public Producto readProduct(Producto producto){
        for(int i=0;i<ListaProductos.size();i++){
            producto = ListaProductos.get(i);
        }
        return producto;
    }
    public Producto getProductoName(String name) throws Exception{
        //readProduct(producto);
        for(int i=0;i<ListaProductos.size();i++){
            producto = ListaProductos.get(i);
            if(producto.getName().equals(name)){
                return producto;
            }
        }
        throw new Exception("El producto no existe :(");
    }
    public Producto getProductDescription(String description) throws Exception {
        //readProduct(producto);
        for(int i=0;i<ListaProductos.size();i++){
            producto = ListaProductos.get(i);
            if(producto.getDescription().equals(description)){
                return producto;
            }
        }
        throw new Exception("El producto no existe :(");

    }
    public Producto getProductPrice(String price) throws Exception {
        //readProduct(producto);
        for(int i=0;i<ListaProductos.size();i++){
            producto = ListaProductos.get(i);
            if(producto.getPrice().equals(price)){
                return producto;
            }
        }
        throw new Exception("El producto no existe :(");

    }
    public String setProducto(Producto producto) throws Exception{
        try{
            getProductoName(producto.getName()); // verifica si existe el producto y si si, muestra producto existente

        }catch (Exception e){
            this.ListaProductos.add(producto);
            return "Creacion exitosa de producto";
        }
        throw  new Exception("Producto existente");
    }

    public Producto updateProduct(Producto productUpdate, String name) throws Exception {
        try {
            //Producto productoBd=getProductoName(productUpdate.getName()); // verifica si existe el producto y si si, muestra producto existente
            Producto productoBd = getProductoName(name);
            if(productUpdate.getName() != null && !productUpdate.getName().equals("")){
                productoBd.setDescription(productUpdate.getDescription());
            }
            if(productUpdate.getDescription() != null && !productUpdate.getDescription().equals("")){
               productoBd.setDescription(productUpdate.getDescription());
            }
            if(productUpdate.getPrice() != null && !productUpdate.getPrice().equals("")){
                productoBd.setPrice(productUpdate.getPrice());
            }
            if(String.valueOf(productUpdate.getStock()) != null && !String.valueOf(productUpdate.getStock()).equals("")){
                productoBd.setStock(productUpdate.getStock());
            }
            return productoBd;
        }catch(Exception e){
            throw new Exception("Producto no existe , fallo actualizacion de datos");
        }

    }
    public Producto updateProductAll(Producto productoUpdate, String name) throws Exception{
        try{
            Producto productoBd = getProductoName(name);
            productoBd.setName(productoUpdate.getName());
            productoBd.setDescription(productoUpdate.getDescription());
            productoBd.setPrice(productoUpdate.getPrice());
            productoBd.setStock(productoUpdate.getStock());
            return productoBd;
        }catch(Exception e){
            throw new Exception("Producto No existe, fallo actualizacion de datos");
        }

    }
    public String deleteProduct(String name) throws Exception {
        try{
            Producto productoDb = getProductoName(name);
            this.ListaProductos.remove(productoDb);
            return "Producto eliminado";
        }

        catch(Exception e){
            throw new Exception("Producto No existe, No borrado");
        }
    }

}

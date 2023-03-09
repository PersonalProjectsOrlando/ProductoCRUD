package edu.oralbama.crudProductos.controller;

import edu.oralbama.crudProductos.business.ProductManager;
import edu.oralbama.crudProductos.models.ObjectRequest;
import edu.oralbama.crudProductos.models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ProductoController {
    @Autowired
    ProductManager productManager;
    Producto producto = new Producto();
    @GetMapping("/products")
    public ResponseEntity<ArrayList<Producto>> getProducts(){
        return new ResponseEntity<>(productManager.getListaProductos(), HttpStatus.OK);
    }
    @GetMapping("/productName")
    public ResponseEntity<Object> getProductName(@RequestParam String name) {
        try{
            producto = productManager.getProductoName(name);
            return new ResponseEntity<>(producto,HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping("/productDescription")
    public ResponseEntity<Object> getProductDescription(@RequestParam String description){
        try{
            producto = productManager.getProductDescription(description);
            return new ResponseEntity<>(producto,HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/productPrice")
    public ResponseEntity<Object> getProductPrice(@RequestParam String price){
        try{
            producto = productManager.getProductPrice(price);
            return new ResponseEntity<>(producto,HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/productName/{name}")
    public ResponseEntity<Object> getProductNamePath(@PathVariable String name){
        try{
            producto = productManager.getProductoName(name);
            return new ResponseEntity<>(producto,HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/productDescription/{description}")
    public ResponseEntity<Object> getProductDescriptionPath(@PathVariable String description){
        try{
            producto = productManager.getProductDescription(description);
            return new ResponseEntity<>(producto,HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/productPrice/{price}")
    public ResponseEntity<Object> getProductPricePath(@PathVariable String price){
        try{
            producto = productManager.getProductPrice(price);
            return new ResponseEntity<>(producto,HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //Metodo para crear un producto
    @PostMapping("/producto")
    public ResponseEntity<String> postProduct(@RequestBody Producto producto){
        try{
            String product = productManager.setProducto(producto);
            return new ResponseEntity<>(product,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/producto/{name}")
    public ResponseEntity<ObjectRequest> putProduct(@RequestBody Producto productUpdate, @PathVariable String name){
        try{
            Producto productBd = productManager.updateProductAll(productUpdate, name);
            return new ResponseEntity<>(new ObjectRequest("Actualizacion OK",productBd),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new ObjectRequest(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PatchMapping("/producto/{name}")
    public ResponseEntity<ObjectRequest> patchProduct(@RequestBody Producto productUpdate, @PathVariable String name){
        try{
            Producto productBd = productManager.updateProduct(productUpdate, name);
            return new ResponseEntity<>(new ObjectRequest("Actualizacion OK",productBd),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new ObjectRequest(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/product/{name}")
    public ResponseEntity<ObjectRequest> deleteProduct(@PathVariable String name){
        try{
            String mensaje = productManager.deleteProduct(name);
            return new ResponseEntity<>(new ObjectRequest(mensaje,null),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new ObjectRequest(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

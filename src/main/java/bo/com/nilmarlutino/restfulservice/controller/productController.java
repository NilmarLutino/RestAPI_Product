package bo.com.nilmarlutino.restfulservice.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import bo.com.nilmarlutino.restfulservice.controller.model.productID;
import bo.com.nilmarlutino.restfulservice.model.Product;

@RestController
public class productController {

    @PostMapping("/product")
    public ResponseEntity<productID> createProducto(@RequestBody final Product product) {
        productID result = new productID(UUID.randomUUID().toString());
        System.out.println(product);
        return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body(result);
    }

    @GetMapping("/product")
    public List<Product> getAllProducts() {
        List<Product> result = new ArrayList<>();
        result.add(new Product("1", "Product1", new BigDecimal("258.33")));
        result.add(new Product("2", "Product2", new BigDecimal("999.11")));
        result.add(new Product("3", "Product3", new BigDecimal("758.64")));
        return result;
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable final String id){
        System.out.println();
        return new Product("888","Returning a single product", new BigDecimal("458.44"));
    }

    @PatchMapping("/product")
    public void pathProduct(@RequestBody final Product product){
        System.out.println(product);
    }
    
    @PatchMapping("/product/{id}")
    public void pathProduct(@PathVariable final String id){
        System.out.println(id);
    }
}

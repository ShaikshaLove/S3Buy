package io.ibm.app.provider;
import io.ibm.app.model.Product;
import io.ibm.app.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author shaiksha ks
 * @version 1.0.0
 * created Date: 19/11/2018
 * It is a rest controller class, it has multiple methods
 * to create ,delete and a resource . to get all resources
 */


@RestController
@RequestMapping(value="/api/products")
public class RestProductController {

    @Autowired
    private IProductService productService;

    /*
     * Handler method for getting a list of resources(Products)
     */

    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    /*
     * Handler method for getting a resource (Products)
     */
    @RequestMapping(value="/{productId}",method = RequestMethod.GET)
    public ResponseEntity <?> getOneProduct(@PathVariable("productId")String productId){

           Product product= productService.getOneProductById(productId);
           System.out.println(product);
           if(product!=null)
           return ResponseEntity.ok(product);
          else
            return ResponseEntity.ok("No product is available with given Id "+productId);
        }


    /*s
     * Handler method for updating  a resource (Product)
     */
    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> updateProduct(@RequestBody Product product){
            productService.updateProduct(product);
            return ResponseEntity.ok("The product details are updated");
    }


    /*
     * Handler method for saving  a resource (Products)
     */

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public String saveProduct(@RequestBody Product product){


         return productService.saveProduct(product)+" for product "+product.getProductName();
    }

    /*
     * Handler method for deleting  a resource (Products)
     */

    @RequestMapping(value="/{productId}",method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteProduct(@PathVariable("productId")String productId) {
        try {
            productService.deleteProductById(productId);
            return ResponseEntity.ok("The product id deleted");

        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("No Record found with id "+productId);

        }
    }
}

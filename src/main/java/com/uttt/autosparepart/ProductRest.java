package com.uttt.autosparepart;

import com.uttt.autosparepart.entities.CategoryDO;
import com.uttt.autosparepart.entities.ProductDO;
import com.uttt.autosparepart.entities.ResponseTO;
import com.uttt.autosparepart.sevices.ProductServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin( origins="*")
@RestController
@RequestMapping("/product")
public class ProductRest {

    @Autowired
    ProductServiceI productServiceI;

    @PostMapping(value = "/guardarCategoria", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CategoryDO> save(@RequestBody CategoryDO categoryDO) {
        return new ResponseEntity<>(productServiceI.save(categoryDO), HttpStatus.OK) ;
    }

    @GetMapping(value = "/categorias", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<CategoryDO>> categories() {
        return new ResponseEntity<>(productServiceI.categories(), HttpStatus.OK) ;
    }

    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ResponseTO> deleteCategory(Long id) {
        return new ResponseEntity<>(productServiceI.delete(id), HttpStatus.OK) ;
    }


    @PostMapping(value = "/guardarProducto", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ProductDO> saveProduct(@RequestBody ProductDO productDO) {
        return new ResponseEntity<>(productServiceI.saveProduct(productDO), HttpStatus.OK) ;
    }

    @GetMapping(value = "/productos", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<ProductDO>> products() {
        return new ResponseEntity<>(productServiceI.products(), HttpStatus.OK) ;
    }

    @DeleteMapping(value = "/deleteProducto", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ResponseTO> deleteProduct(Long id) {
        return new ResponseEntity<>(productServiceI.deleteProduct(id), HttpStatus.OK) ;
    }
}

package com.unal.Api.Controller;

import com.unal.Business.Abstract.ProductService;
import com.unal.Core.Utilities.Results.DataResult;
import com.unal.Core.Utilities.Results.Result;
import com.unal.Entities.Concrete.Product;
import com.unal.Entities.Dto.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin
public class ProductsController {

    private ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getall")
    public DataResult<List<Product>> getAll() {
        return productService.getAll();
    }

    @GetMapping("/getallPage")
    public DataResult<List<Product>> getAll(int pageNo,int pageSize) {
        return productService.getAll(pageNo,pageSize);
    }

    @GetMapping("/getallSorted")
    public DataResult<List<Product>> getAllSorted() {
        return productService.getAllSorted();
    }
    @GetMapping("/getProductWithCategoryDetails")
    public DataResult<List<ProductWithCategoryDto>>  getProductWithCategoryDetails() {
        return productService.getProductWithCategoryDetails();
    }






    @PostMapping("/add")
    public Result add(@RequestBody Product product) {
        return productService.add(product);
    }

    @GetMapping("/getByProductName")
    public  DataResult<Product> getByProductName(@RequestParam String productName) {
        return productService.getByProductName(productName);
    }

    @GetMapping("/getByProductNameAndCategoryId")
    public DataResult<Product> getByProductNameAndCategoryId
            (@RequestParam(name = "productName") String productName,
             @RequestParam(name = "categoryId") int categoryId) {

        return productService.getByProductNameAndCategoryId(productName,categoryId);

    }

    @GetMapping("/getByProductNameOrCategoryId")
    public DataResult<List<Product>> getByProductNameOrCategoryId
            (@RequestParam(name = "productName") String productName,
             @RequestParam(name = "categoryId") int categoryId) {

        return productService.getByProductNameOrCategoryId(productName,categoryId);

    }

    @GetMapping("/getByCategoryIdIn")
    public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
        return productService.getByCategoryIdIn(categories);
    }


    @GetMapping("/getByProductNameContains")
    public  DataResult<List<Product>> getByProductNameContains(@RequestParam String productName) {
        return productService.getByProductNameContains(productName);
    }

    @GetMapping("/getByProductNameStartsWith")
    public  DataResult<List<Product>> getByProductNameStartsWith(String productName) {
        return productService.getByProductNameStartsWith(productName);
    }

    @GetMapping("/getByNameAndCategory")
    public  DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
        return productService.getByNameAndCategory(productName,categoryId);
    }

}

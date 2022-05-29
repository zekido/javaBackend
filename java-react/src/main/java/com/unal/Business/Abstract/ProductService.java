package com.unal.Business.Abstract;

import com.unal.Core.Utilities.Results.DataResult;
import com.unal.Core.Utilities.Results.Result;
import com.unal.Entities.Concrete.Product;
import com.unal.Entities.Dto.ProductWithCategoryDto;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductService {

    //List<Product> getAll(); data resulta T olarak list<Product verdik>
    DataResult<List<Product>> getAll();
    DataResult<List<Product>> getAll(int pageNo, int pageSize);
    DataResult<List<Product>> getAllSorted();
    Result add(Product product);

    DataResult<Product> getByProductName(String productName);

    DataResult<Product>  getByProductNameAndCategoryId(String productName, int categoryId);

    DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId);

    DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories);

    DataResult<List<Product>> getByProductNameContains(String productName);

    DataResult<List<Product>> getByProductNameStartsWith(String productName);

    DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId);

    DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();


}

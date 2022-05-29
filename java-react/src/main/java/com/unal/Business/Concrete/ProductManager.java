package com.unal.Business.Concrete;

import com.unal.Business.Abstract.ProductService;
import com.unal.Core.Utilities.Results.DataResult;
import com.unal.Core.Utilities.Results.Result;
import com.unal.Core.Utilities.Results.SuccessDataResult;
import com.unal.Core.Utilities.Results.SuccessResult;
import com.unal.DataAccess.Abstract.ProductDal;
import com.unal.Entities.Concrete.Product;
import com.unal.Entities.Dto.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements ProductService {

    private ProductDal productDal;

    @Autowired
    public ProductManager(ProductDal productDal) {
        this.productDal = productDal;
    }

    @Override
    public DataResult<List<Product>> getAll() {
        return new SuccessDataResult<List<Product>>
                (productDal.findAll(),"tüm data listelendi");
    }

    @Override
    public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        return new SuccessDataResult<List<Product>>
                (productDal.findAll(pageable).getContent(),"page size'a göre listelendi");
    }

    @Override
    public DataResult<List<Product>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC,"id");
        return new SuccessDataResult<List<Product>>
                (productDal.findAll(sort),"Sıralama başarılı");
    }

    @Override
    public Result add(Product product) {
        productDal.save(product);
        return new SuccessResult("Ürün başarıyla eklendi");
    }

    @Override
    public DataResult<Product> getByProductName(String productName) {
        return new SuccessDataResult<Product>
                (productDal.getByProductName(productName),"Data getirildi");
    }

    @Override
    public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
        return new SuccessDataResult<Product>
                (productDal.getByProductNameAndCategory_CategoryId(productName,categoryId)
                        ,"Data getirildi");
    }

    @Override
    public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>
                (productDal.getByProductNameOrCategory_CategoryId(productName,categoryId)
                        ,"Data getirildi");
    }

    @Override
    public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
        return new SuccessDataResult<List<Product>>
                (productDal.getByCategoryIn(categories)
                        ,"Data getirildi");
    }

    @Override
    public DataResult<List<Product>> getByProductNameContains(String productName) {
        return new SuccessDataResult<List<Product>>
                (productDal.getByProductNameContains(productName)
                        ,"Data getirildi");
    }

    @Override
    public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
        return new SuccessDataResult<List<Product>>
                (productDal.getByProductNameStartsWith(productName)
                        ,"Data getirildi");
    }

    @Override
    public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>
                (productDal.getByNameAndCategory(productName,categoryId)
                        ,"Data getirildi");
    }

    @Override
    public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {

        return new SuccessDataResult<List<ProductWithCategoryDto>>(
                productDal.getProductWithCategoryDetails());

    }
}

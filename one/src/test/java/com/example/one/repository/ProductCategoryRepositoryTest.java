package com.example.one.repository;

import com.example.one.domain.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    public void testFindOne(){
        ProductCategory productCategory = productCategoryRepository.findOne(1);
        System.out.println(productCategory);
    }

    @Test
    @Transactional
    public void testSave(){
        ProductCategory productCategory = new ProductCategory("girlLike",5);
        ProductCategory productResult = productCategoryRepository.save(productCategory);
        Assert.assertNotNull(productResult);

    }

    @Test
    public void findByCategoryTypeInTest(){
        List<Integer> list = Arrays.asList(2,3,4);
        List<ProductCategory> productCategories = productCategoryRepository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,productCategories.size());
    }

}
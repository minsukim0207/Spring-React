package com.kh.springchap02.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.springchap02.model.Product;

@Mapper
public interface ProductMapper {
	List<Product> getAllProduct();
}

package com.yedam.product.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.product.mapper.ProductMapper;
import com.yedam.product.vo.ProductVO;

public class productServiceMybatis implements ProductService {
	SqlSession session = DataSource.getInstance().openSession(true);
    ProductMapper mapper = session.getMapper(ProductMapper.class);
	@Override
	public List<ProductVO> productList() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ProductVO getProduct(String productCode) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<ProductVO> relateList() {
		// TODO Auto-generated method stub
		return null;
	}
}

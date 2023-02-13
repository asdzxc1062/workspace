package com.yedam.product.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Command;
import com.yedam.product.service.ProductService;
import com.yedam.product.service.productServiceMybatis;
import com.yedam.product.vo.ProductVO;

public class productList implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductService service = new productServiceMybatis();
		List<ProductVO> list = service.productList();
		
		String json = "";
		Gson gson = new GsonBuilder().create();
		json = gson.toJson(list);
		
		
		return json + ".json";
	}

}

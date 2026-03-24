package com.app.product.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.Action;
import com.app.Result;
import com.app.dao.ProductDAO;
import com.app.vo.ProductVO;

public class ProductListController implements Action {

	@Override
	public Result excute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		Result result = new Result();
		
		ProductDAO productDAO = new ProductDAO();
		List<ProductVO> products = productDAO.selectAll();
		
		req.setAttribute("products", products);
		
//		포워드
		result.setPath("/list.jsp");
		return result;
	}

}

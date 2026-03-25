package com.app.product.controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.Action;
import com.app.Result;
import com.app.dao.ProductDAO;
import com.app.exception.ProductNotFoundException;
import com.app.vo.ProductVO;

public class ProductReadController implements Action {

	@Override
	public Result excute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		Result result = new Result();
		
		Long id = Long.parseLong(req.getParameter("id"));
		ProductDAO productDAO = new ProductDAO();
		ProductVO productVO = new ProductVO();
		
//		ProductVO product = foundProduct.orElseThrow(ProductNotFoundException::new);
		ProductVO product = productDAO.select(id).orElseThrow(ProductNotFoundException::new);
		
		req.setAttribute("product", product);
		result.setPath("/read.jsp");
		
		return result;
	}

}

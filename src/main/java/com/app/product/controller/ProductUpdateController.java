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

public class ProductUpdateController implements Action {

	@Override
	public Result excute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		Result result = new Result();
		
		ProductDAO productDAO = new ProductDAO();
		Long id = Long.parseLong(req.getParameter("id"));
		ProductVO productVO = productDAO.select(id);
		Optional<ProductVO> foundProduct = Optional.ofNullable(productVO);
		
		req.setAttribute("product", foundProduct.orElseThrow(ProductNotFoundException::new));
		result.setPath("/update.jsp");
		
		return result;
	}

}

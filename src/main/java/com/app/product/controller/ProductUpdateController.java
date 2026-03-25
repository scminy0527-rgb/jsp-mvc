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
//		상품 상세에서 수정하기 버튼을 누르면 단순히 수정을 할 수 있는 페이지로 매개변수와 함께 이동을 하게 해주는 컨트롤러
		Result result = new Result();
		
		ProductDAO productDAO = new ProductDAO();
		Long id = Long.parseLong(req.getParameter("id"));
		ProductVO productVO = productDAO.select(id).orElseThrow(ProductNotFoundException::new);
//		Optional<ProductVO> foundProduct = Optional.ofNullable(productVO);
		
		req.setAttribute("product", productVO);
		result.setPath("/update.jsp");
		
		return result;
	}
}

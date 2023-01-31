package com.iu.home.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ProductDAO productDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        super();
        // TODO Auto-generated constructor stub
        productDAO = new ProductDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Product Page");
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/product/productList.jsp");
		view.forward(request, response);
		
//		try {
//			//Long num = productDAO.getProductNum();
//			List<ProductDTO> ar = productDAO.getProductList();
//			
//			//ar.get(0).getProduct_name()
//
//			
//			PrintWriter out = response.getWriter();
//			//out.println("<hl>" + num + "</h1>");
//			
//			for (ProductDTO productDTO:ar) { 
//				out.println("<h1>" + productDTO.getProduct_name() + "</h1>");
//			}
//
//			out.close();
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

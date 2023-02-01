package com.iu.home.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
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
	private ProductService productService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        super();
        // TODO Auto-generated constructor stub
        productDAO = new ProductDAO();
        productService = new ProductService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("Product Page");
		
		String uri = request.getRequestURI();
		uri=uri.substring(uri.lastIndexOf("/")+1);
//		System.out.println("url: "+request.getRequestURL());
		System.out.println("uri: "+uri);

		String path ="";
		switch (uri) {
		case "list.do":
			try {
				List<ProductDTO> ar = productService.getProductList();
				request.setAttribute("list", ar);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			path="productList.jsp";
			break;
		case "add.do":
			path="productAdd.jsp";
			break;
		case "update.do":
			path="productUpdate.jsp";
			break;
		case "delete.do":
			path="productDelete.jsp";
			break;
		case "detail.do":
			ProductDTO dto = new ProductDTO();
			Long num = Long.parseLong(request.getParameter("productNum")); //파라미터에 받아서 dto에
			dto.setProduct_num(num);
			//System.out.println(dto.getProduct_num()); 33받음
			try {
				dto = productService.getProductDetail(dto); //안댐.
				System.out.println(dto.getProduct_num());
				System.out.println(dto.getProduct_name());
				request.setAttribute("dto", dto);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			path="productDetail.jsp";
			break;
		default:
			path="productList.jsp";
			break;
		}

		
//		String name = request.getParameter("name");
//		String detail = request.getParameter("detail");
////		String price = request.getParameter("price");
//		System.out.println("name: "+ name);
//		System.out.println("detail: "+ detail);
////		System.out.println("pr: "+ price);
//
//		ProductDTO productDTO = new ProductDTO();
//		productDTO.setProduct_name(name);
//		productDTO.setProduct_detail(detail);
//		//ProductDAO productDAO = new ProductDAO();
//		
//		try {
//			productDAO.setProduct(productDTO);
//			
//			int result = productService.setAddProduct(productDTO, new ArrayList<ProductOptionDTO>());
//			System.out.println(result);
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/product/"+path);
		view.forward(request, response);
		
		//구버전 ar
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

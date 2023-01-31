package com.iu.home.product;

import java.util.List;

public class ProductService {
	private ProductDAO productDAO;
	
	//2 (인스턴스<>static) 초기화 블록
	{ this.productDAO = new ProductDAO(); }
	
	//3번 생성자로 생성
	public ProductService () {
		productDAO = new ProductDAO();
	}

	//4 setter
	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}
	
	//~3번은 클래스가 닫힐 때 같이 사라짐 (결합도가 강하다) 
	//4. setter는 주소가 밖에 있는걸 끌고와서 사용함. 안사라짐. (결합도가 낮다)
	//DAO 객체가 나중에 바뀔일 없으면 아무거나 써..
	
	public int setAddProductOption (ProductDTO productDTO, List<ProductOptionDTO> ar) throws Exception {	
		Long productNum = productDAO.getProductNum(); //시퀀스 생성해서 숫자변수에 담음.
		productDTO.setProduct_num(productNum); //외부의 DTO(번호 외 다른 정보 max) 받아와서 DTO에 숫자 담음
		int result = productDAO.setProduct(productDTO); //DTO 받아서 DATABASE에 보냄
		
		
		for (ProductOptionDTO productOptionDTO: ar) {	//옵션dto집합(번호 외 다른 정보 max) 불러옴
			productOptionDTO.setProduct_num(productNum); //상품번호를 옵션에 대입
			productDAO.setProductOption(productOptionDTO); //database에 보냄.
		}
		
		return result;	
	}
	
	
	
	public static void main(String[] args) {
		ProductDTO productDTO = new ProductDTO();
		ProductDAO dao = new ProductDAO();
		
		productDTO.setProduct_name("test1");
		productDTO.setProduct_detail("test1");
		productDTO.setProduct_score( 0.0 );
		
		ProductOptionDTO optionDTO = new ProductOptionDTO();
		optionDTO.setName("test1");
		optionDTO.setPrice(100L);
		optionDTO.setStock(10L);
		optionDTO.setProduct_num(null);
		
		ProductOptionDTO optionDTO2 = new ProductOptionDTO();
		optionDTO2.setName("test1");
		optionDTO2.setPrice(100L);
		optionDTO2.setStock(10L);
		optionDTO2.setProduct_num(null);
		
		try {
			Long num = dao.getProductNum(); 
			productDTO.setProduct_num(num);
			
			int result = dao.setProduct(productDTO); 
			
			optionDTO.setOption_num(num); 
			
			if(result >=0) { //상품이 하나 이상이면
				dao.setProductOption(optionDTO); //상품에 옵션주임
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

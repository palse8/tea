import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import beans.Category;
import beans.Product;
import dao.CategoryDAO;
import dao.ProductDAO;

public class SearchController {
	
	public String searchProductInfo(HttpServletRequest request){
		String nextPage = "TOP.jsp";
		
		String cateName = request.getParameter("categoryName");
		String proName = request.getParameter("productName");
		
		if(cateName != null && proName != null && !cateName.isEmpty() && !proName.isEmpty()){
			ProductDAO pDAO = new ProductDAO(ConnectionHelper.getConnection());
			try{
				ArrayList<Product> pList = pDAO.searchProduct(cateName, proName);
				request.setAttribute("productList", pList);
			}catch(SQLException e){
				request.setAttribute("Error", "データベース接続エラー");
			}
		}else{
			request.setAttribute("Error", "検索に該当する商品はありません");
		}
		
		return nextPage;
	}
	
	public String searchAll(HttpServletRequest request){
		
		String nextPage = "TOP.jsp";
		
		ProductDAO pDAO = new ProductDAO(ConnectionHelper.getConnection());

		try {
			HttpSession hs = request.getSession();
			ArrayList<Product> pList = pDAO.searchAllProduct();
			hs.setAttribute("productList", pList);
			
			ArrayList<Category> cList = (ArrayList<Category>)hs.getAttribute("categoryList");
			if(cList == null){
				CategoryDAO cDAO = new CategoryDAO(ConnectionHelper.getConnection());
				cList = cDAO.searchAllCategory();
			}
			hs.setAttribute("categoryList", cList);
		} catch (SQLException e) {
			request.setAttribute("Error", "データベース接続エラー");
			e.printStackTrace();
		}
		return nextPage;
	}

}

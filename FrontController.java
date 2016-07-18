

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs = request.getSession();
		String command = (String)hs.getAttribute("command");
		String nextPage = null;
		System.out.println("front : " + command);
		switch (command) {
		case "searchAll":
			System.out.println("front : incase");
			SearchController sc = new SearchController();
			nextPage = sc.searchAll(request);
			break;
		default:
			break;
		}
		
		request.getRequestDispatcher(nextPage).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		String nextPage = null;
		
		switch (command) {
		case "searchProductInfo":
			SearchController sc = new SearchController();
			nextPage = sc.searchProductInfo(request);
			break;
		case "addCart":
			OrderController oc1 = new OrderController();
			nextPage = oc1.addCart(request);
			break;
		case "register":
			OrderController oc2 = new OrderController();
			nextPage = oc2.register(request);
			break;
		case "deleteCart":
			OrderController oc3 = new OrderController();
			nextPage = oc3.deleteCart(request);
			break;
		case "changeCart":
			OrderController oc4 = new OrderController();
			nextPage = oc4.changeCart(request);
			break;
		case "order":
			OrderController oc5 = new OrderController();
			nextPage = oc5.order(request);
			break;
		case "addInputInfo":
			OrderController oc6 = new OrderController();
			nextPage = oc6.addInputInfo(request);
			break;
		default:
			break;
		}
		
		request.getRequestDispatcher(nextPage).forward(request, response);
	}

}

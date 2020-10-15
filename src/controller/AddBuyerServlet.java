package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Buyer;
import model.CarList;

/**
 * Servlet implementation class AddBuyerServlet
 */
@WebServlet(name = "addBuyerServlet", urlPatterns = { "/addBuyerServlet" })
public class AddBuyerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBuyerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String number = request.getParameter("pNum");
		
		Buyer br = new Buyer(name,number);
		BuyerHelper dao = new BuyerHelper();
		dao.insertBuyer(br);
		
		getServletContext().getRequestDispatcher("/add-buyer.jsp").forward(request, response);
	}

}

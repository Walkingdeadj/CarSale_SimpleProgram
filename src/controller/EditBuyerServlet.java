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
 * Servlet implementation class EditBuyerServlet
 */
@WebServlet(name = "editBuyerServlet", urlPatterns = { "/editBuyerServlet" })
public class EditBuyerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditBuyerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BuyerHelper dao = new BuyerHelper();
		String name = request.getParameter("name");
		String num = request.getParameter("pNum");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
				
		Buyer BuyerToUpdate = dao.searchForBuyerByID(tempId);
		BuyerToUpdate.setBuyerName(name);
		BuyerToUpdate.setBuyerPNum(num);
		
				
		dao.UpdateBuyer(BuyerToUpdate);

		getServletContext().getRequestDispatcher("/viewAllBuyersServlet").forward(request, response);
	}

}

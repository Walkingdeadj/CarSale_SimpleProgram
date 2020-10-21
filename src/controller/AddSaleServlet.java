package controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Buyer;
import model.CarList;
import model.CarSale;

/**
 * Servlet implementation class AddSaleServlet
 */
@WebServlet("/addSaleServlet")
public class AddSaleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSaleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer price = Integer.parseInt(request.getParameter("price"));
		Integer year = Integer.parseInt(request.getParameter("year"));
		Integer month = Integer.parseInt(request.getParameter("moth"));
		Integer day = Integer.parseInt(request.getParameter("day"));
		
		BuyerHelper dao = new BuyerHelper();
		Buyer buyer = dao.searchForBuyerByID(Integer.parseInt(request.getParameter("BuyerId")));
		
		CarListHelper dao2 = new CarListHelper();
		CarList car = dao2.searchForCarById(Integer.parseInt(request.getParameter("CarId")));
		
		@SuppressWarnings("deprecation")
		Date date = new Date(year,month,day);
		LocalDateAttributeConverter conv = new LocalDateAttributeConverter();
		LocalDate saleDate = conv.convertToEntityAttribute(date);
		
		CarSale sale = new CarSale(saleDate, price, buyer, car);
		
		CarSaleHelper dao3 = new CarSaleHelper();
		dao3.insertCarSale(sale);
		
		getServletContext().getRequestDispatcher("/add-sale.jsp").forward(request, response);
	}

}

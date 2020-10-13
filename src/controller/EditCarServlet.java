package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CarList;

/**
 * Servlet implementation class EditCarServlet
 */
@WebServlet("/editCarServlet")
public class EditCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CarListHelper dao = new CarListHelper();
		String model = request.getParameter("model");
		String make = request.getParameter("make");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
				
		CarList carToUpdate = dao.searchForCarById(tempId);
		carToUpdate.setModel(model);
		carToUpdate.setMake(make);
				
		dao.updateCar(carToUpdate);

		getServletContext().getRequestDispatcher("/viewAllCarsServlet").forward(request, response);
	}

}

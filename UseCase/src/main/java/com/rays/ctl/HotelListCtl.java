package com.rays.ctl;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import com.rays.bean.HotelBean;
import com.rays.model.HotelModel;

@WebServlet(name = "HotelListCtl", urlPatterns = { "/ctl/HotelListCtl" })
public class HotelListCtl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			HotelModel model = new HotelModel();

			HotelBean bean = new HotelBean();

			bean.setHotelName(request.getParameter("hotelName"));

			List<HotelBean> list = model.search(bean);

			request.setAttribute("list", list);

			request.getRequestDispatcher("/jsp/HotelList.jsp").forward(request, response);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String operation = request.getParameter("operation");

		try {

			if ("Delete".equals(operation)) {

				long id = Long.parseLong(request.getParameter("id"));

				HotelModel model = new HotelModel();

				model.delete(id);
			}

			response.sendRedirect("HotelListCtl");

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.ImageProduct;
import Model.Product;
import Model.Size;
import Service.ImageProduct_service;
import Service.Product_service;
import Service.Size_service;

/**
 * Servlet implementation class Detailpro_controller
 */
@WebServlet("/detail_product")
public class Detail_product_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Detail_product_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =Integer.parseInt(request.getParameter("id_product"));
		int id_cate = Integer.parseInt(request.getParameter("id_category"));
		Product_service pds = new Product_service();
		ImageProduct_service ipds = new ImageProduct_service();
		Size_service service = new Size_service();
		Product pd =pds.getProductById(id);
		List<ImageProduct> ipd =ipds.getImage(id);
		List<Product> listpd = pds.getProductByIdCate(id_cate);
		List<Size> sz = service.Size();
		request.setAttribute("Limages", ipd);
		request.setAttribute("product", pd);
		request.setAttribute("sz", sz);
		request.setAttribute("listproduct",listpd);
		request.setAttribute("page", "detail_product");
		request.getRequestDispatcher("decorators/web.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

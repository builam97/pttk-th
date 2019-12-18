package demo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demo.DAO.HangHoaDAO;
import demo.bean.HangHoa;

@WebServlet("/themmoi_hang")
public class ThemHangController extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String name_hang = req.getParameter("name_hang");
        String des_hang = req.getParameter("des_hang");
        Integer amount_hang = Integer.parseInt(req.getParameter("amount_hang"));
        Double price_hang = Double.parseDouble(req.getParameter("price_hang"));
        HangHoa hh = new HangHoa(name_hang, des_hang, price_hang, amount_hang);
        Integer nccId = Integer.parseInt(req.getParameter("nccId"));
        Integer hangId = HangHoaDAO.saveHangHoa(hh, nccId);
        resp.sendRedirect("./mathang?ncc_id=" + nccId);
    }

}

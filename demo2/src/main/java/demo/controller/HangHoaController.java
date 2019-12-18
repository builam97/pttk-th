package demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demo.DAO.HangHoaDAO;
import demo.bean.HangHoa;

@WebServlet("/mathang")
public class HangHoaController extends HttpServlet{
    private final String messageShow = "Khong tim thay Hang hoa. Vui long them moi";
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        Integer nccId = Integer.parseInt(req.getParameter("ncc_id"));
        req.setAttribute("ncc_id", nccId);
        String nameMh = req.getParameter("name_mh");
        List<HangHoa> listHh = new ArrayList<HangHoa>();
        if(nameMh != null && nameMh != "") {
            listHh = HangHoaDAO.findHangHoaByName(nccId, nameMh);
            req.setAttribute("listhh", listHh);
            if(listHh.size() ==0) {
                req.setAttribute("message", messageShow);
            }
        }
        
        RequestDispatcher dispatcher = req
                .getRequestDispatcher("/TimMatHangView.jsp");
        dispatcher.forward(req, resp);
    }
}

package demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import demo.DAO.NhaCungCapDAO;
import demo.DAO.PhieuNhapDAO;
import demo.bean.HangHoa;
import demo.bean.HangNhap;
import demo.bean.NhaCungCap;
import demo.bean.PhieuNhap;

@WebServlet("/bill")
public class BillServlet extends HttpServlet{

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<HangHoa> listHH = new ArrayList<HangHoa>();
        Integer nccId = Integer.parseInt(req.getParameter("nccId"));
        NhaCungCap ncc = NhaCungCapDAO.findNhaCungCapById(nccId);
        
        if((List<HangHoa>) session.getAttribute("cart") != null) {
            listHH = (List<HangHoa>) session.getAttribute("cart");
        }
        List<HangNhap> listNhap = new ArrayList<HangNhap>();
        listNhap = listHH.stream().map(hh -> new HangNhap(hh)).collect(Collectors.toList());
        PhieuNhap pn = new PhieuNhap(listNhap,ncc);
        PhieuNhapDAO.themPhieuNhap(pn);
        session.invalidate();
        RequestDispatcher dispatcher = req
                .getRequestDispatcher("/HomeView.jsp");
        dispatcher.forward(req, resp);
    }

}

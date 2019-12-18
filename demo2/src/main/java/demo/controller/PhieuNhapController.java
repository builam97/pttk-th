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
import demo.bean.HangHoa;
import demo.bean.NhaCungCap;

@WebServlet("/phieunhap")
public class PhieuNhapController extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        HttpSession session = req.getSession();
        List<HangHoa> listHH = new ArrayList<HangHoa>();
        Integer nccId = Integer.parseInt(req.getParameter("nccId"));
        NhaCungCap ncc = NhaCungCapDAO.findNhaCungCapById(nccId);
        String paramRemove = req.getParameter("removeHangId");
        
        if((List<HangHoa>) session.getAttribute("cart") != null) {
            listHH = (List<HangHoa>) session.getAttribute("cart");
            if(paramRemove != null && paramRemove != "") {
                Integer removeHangHoaId = Integer.parseInt(paramRemove);
                listHH = listHH.stream().filter(hh -> hh.getId() != removeHangHoaId).collect(Collectors.toList());
            }
        }
        req.setAttribute("listhh", listHH);
        session.setAttribute("cart", listHH);
        req.setAttribute("ncc", ncc);
        
        int tong = 0;
        for(HangHoa hh : listHH) {
            tong += hh.getPrice() * hh.getAmount();
        }
        req.setAttribute("tong", tong);
        RequestDispatcher dispatcher = req
                .getRequestDispatcher("/PhieuNhapView.jsp");
        dispatcher.forward(req, resp);
    }
    
}

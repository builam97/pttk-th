package demo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demo.DAO.NhaCungCapDAO;
import demo.bean.NhaCungCap;

@WebServlet("/nhacungcap")
public class TimNhaccController extends HttpServlet{
    private final String messageShow = "Khong tim thay Nha cung cap. Vui long them moi";
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String name = req.getParameter("name_ncc");
        List<NhaCungCap> listNcc = NhaCungCapDAO.findNhaCungCapByName(name);
        req.setAttribute("listNcc", listNcc);
        if(listNcc.size() ==0) {
            req.setAttribute("message", messageShow);
        }
        RequestDispatcher dispatcher = req
                .getRequestDispatcher("/TimNhaccView.jsp");
        dispatcher.forward(req, res);
    }
    
}

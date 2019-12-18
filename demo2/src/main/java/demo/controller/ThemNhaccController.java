package demo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demo.DAO.NhaCungCapDAO;
import demo.bean.NhaCungCap;

@WebServlet("/themmoi_ncc")
public class ThemNhaccController extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String name_ncc = req.getParameter("name_ncc");
        String address_ncc = req.getParameter("address_ncc");
        String sdt_ncc = req.getParameter("sdt_ncc");
        NhaCungCap ncc = new NhaCungCap(name_ncc, address_ncc,sdt_ncc);
        Integer nccId = NhaCungCapDAO.saveNhaCungCap(ncc);
        req.setAttribute("nccId", nccId);
        resp.sendRedirect("./mathang?ncc_id=" + nccId);
    }

}

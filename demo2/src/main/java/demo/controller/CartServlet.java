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

import demo.DAO.HangHoaDAO;
import demo.bean.HangHoa;

@WebServlet("/cart")
public class CartServlet extends HttpServlet{

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        Integer hanghoaId = Integer.parseInt(req.getParameter("hh_id"));
        Integer amount = Integer.parseInt(req.getParameter("amount"));
        Integer nccId = Integer.parseInt(req.getParameter("ncc_id"));
        HttpSession session = req.getSession();
        List<HangHoa> listHH = new ArrayList<HangHoa>();
        if((List<HangHoa>) session.getAttribute("cart") != null) {
            listHH = (List<HangHoa>) session.getAttribute("cart");
        }
        HangHoa hh = HangHoaDAO.findHangHoaById(hanghoaId);
        boolean[] isCheck = {false};
        listHH = listHH.stream().map(mh -> {
        	if(mh.getId() == hanghoaId) {
        		int temp = mh.getAmount();
        		mh.setAmount(temp+ amount);
        		isCheck[0] = true;
        	}
        	return mh;
        }).collect(Collectors.toList());
        if(!isCheck[0]) {
        	hh.setAmount(amount);
            listHH.add(hh);
        }
        session.setAttribute("cart", listHH);
        req.setAttribute("ncc_id", nccId);
        String nameMh = req.getParameter("name_mh");
        if(nameMh != null && nameMh != "") {
            List<HangHoa>listHh = HangHoaDAO.findHangHoaByName(nccId, nameMh);
            req.setAttribute("listhh", listHh);
        }
        RequestDispatcher dispatcher = req
                .getRequestDispatcher("/TimMatHangView.jsp");
        dispatcher.forward(req, resp);
    }

}

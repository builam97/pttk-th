package demo.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.mockito.Mockito;

import demo.controller.ThemHangController;

public class Test_ThemHangController extends Mockito {
    @Test
    public void testServlet() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);       
        HttpServletResponse response = mock(HttpServletResponse.class);    

        when(request.getParameter("name_hang")).thenReturn("Mac mini");
        when(request.getParameter("des_hang")).thenReturn("V2020");
        when(request.getParameter("amount_hang")).thenReturn("10");
        when(request.getParameter("price_hang")).thenReturn("1000");
        when(request.getParameter("nccId")).thenReturn("1");
        
        new ThemHangController().doPost(request, response);
    }
}

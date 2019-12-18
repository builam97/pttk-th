package demo.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.mockito.Mockito;

import demo.controller.ThemNhaccController;

public class Test_ThemNhaccController extends Mockito{
    @Test
    public void testServlet() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);       
        HttpServletResponse response = mock(HttpServletResponse.class);    

        when(request.getParameter("name_ncc")).thenReturn("24/7 electric");
        when(request.getParameter("address_ncc")).thenReturn("Da nang");
        when(request.getParameter("sdt_ncc")).thenReturn("0122");

        new ThemNhaccController().doPost(request, response);
    }
}

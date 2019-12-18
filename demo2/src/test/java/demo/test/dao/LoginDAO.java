package demo.test.dao;

import junit.framework.TestCase;

public class LoginDAO extends TestCase {

    public void testLoginSuccess() {
        boolean check = demo.DAO.LoginDAO.isCorrect("builam", "builam97");
        assertEquals(true, check);
    }
    public void testLoginFail() {
        boolean check = demo.DAO.LoginDAO.isCorrect("builam123", "builam97");
        assertEquals(false, check);
    }
}

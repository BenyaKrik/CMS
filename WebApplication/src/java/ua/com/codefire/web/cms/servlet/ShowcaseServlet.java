/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.web.cms.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ua.com.codefire.web.cms.db.controller.PhoneController;
import ua.com.codefire.web.cms.db.entity.Brand;

/**
 *
 * @author user
 */
@WebServlet(urlPatterns = "/showcase")
public class ShowcaseServlet extends HttpServlet {
    
    private PhoneController pc;

    @Override
    public void init() throws ServletException {
        pc = new PhoneController();
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        List<Brand> all = pc.getAll();
        req.setAttribute("phoneList", all);
        
        req.getRequestDispatcher("/WEB-INF/jsp/showcase.jsp").forward(req, resp);
        
    }
    
    
    
}

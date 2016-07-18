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
import ua.com.codefire.web.cms.db.controller.BrandController;
import ua.com.codefire.web.cms.db.controller.PhoneController;
import ua.com.codefire.web.cms.db.entity.Brand;
import ua.com.codefire.web.cms.db.entity.Phone;

/**
 *
 * @author user
 */
@WebServlet(urlPatterns = "/phone/remove")

public class PhoneRemoveServlet extends HttpServlet {
 
    private PhoneController pc;

    @Override
    public void init() throws ServletException {
        pc = new PhoneController();
        
    }

     @Override
     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         int phone_id;
  
        try {
             
            phone_id = Integer.parseInt(req.getParameter("id"));
             
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            resp.sendError(400);
            return;
        }
       
         pc.remove(phone_id);
          

        resp.sendRedirect(req.getContextPath().concat("/showcase"));
     }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//      
//    }

}

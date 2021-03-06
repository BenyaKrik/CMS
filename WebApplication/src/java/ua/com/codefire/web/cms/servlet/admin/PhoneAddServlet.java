/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.web.cms.servlet.admin;

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
@WebServlet(urlPatterns = "/admin/phone/add")
public class PhoneAddServlet extends HttpServlet {

    private BrandController bc;
    private PhoneController pc;

    @Override
    public void init() throws ServletException {
        pc = new PhoneController();
        bc = new BrandController();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Brand> all = bc.getAll();
        req.setAttribute("brandList", all);
        req.getRequestDispatcher("/WEB-INF/jsp/admin/phone.edit.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int brand_id;
        String model = req.getParameter("model");
        String body = req.getParameter("body");
        double cost;

        try {
            brand_id = Integer.parseInt(req.getParameter("brand_id"));
            cost = Double.parseDouble(req.getParameter("cost"));
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            resp.sendError(400);
            return;
        }

        Phone phone = new Phone(model, body, cost);
        phone.setBrand(bc.findOne(brand_id));
        phone = pc.save(phone);

        resp.sendRedirect(req.getContextPath().concat("/admin/phone/edit?id=" + phone.getId()));
    }

}

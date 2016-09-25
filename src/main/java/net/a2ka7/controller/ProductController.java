package net.a2ka7.controller;

import net.a2ka7.dao.ProductDao;
import net.a2ka7.dao.exception.DaoSystemException;
import net.a2ka7.dao.exception.NoSuchEntityException;
import net.a2ka7.dao.impl.ProductMockDao;
import net.a2ka7.entity.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProductController extends HttpServlet{
    public static final String PARAM_ID = "id";
    public static final String ATTRIBUTE_MODEL_TO_VIEW = "product";
    public static final String PAGE_OK = "product.jsp";
    public static final String PAGE_ERROR = "error.jsp";

    private ProductDao productDao = new ProductMockDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idString = req.getParameter(PARAM_ID);
        if (idString != null) {
            try {
                Integer id = Integer.valueOf(idString);
                Product model = productDao.selectById(id);
                req.setAttribute(ATTRIBUTE_MODEL_TO_VIEW, model);

                RequestDispatcher dispatcher = req.getRequestDispatcher(PAGE_OK);
                dispatcher.forward(req, resp);
                return;
            } catch (NumberFormatException | NoSuchEntityException | DaoSystemException e) {
                //NOP
            }
        }
        //FAIL
        resp.sendRedirect(PAGE_ERROR);
    }
}

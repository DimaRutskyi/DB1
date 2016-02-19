package hw7.notes.service;

import hw7.notes.domain.Vendor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by v.davidenko on 19.02.2016.
 */

@WebServlet("/listServlet")
public class ListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        serviceRefreshPage(req, resp);
    }

    public void serviceRefreshPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Map<String, String[]> parameterMap = req.getParameterMap();
        Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
        for(Map.Entry<String, String[]> entry : entries) {
            req.setAttribute(entry.getKey(), entry.getValue()[0]);
        }
        List<Vendor> vendorList = Menu.noteService.getAllVendors();
        req.setAttribute("vendorList", vendorList);
        req.getRequestDispatcher(Menu.REPORTS_PAGE).forward(req, resp);
    }
}

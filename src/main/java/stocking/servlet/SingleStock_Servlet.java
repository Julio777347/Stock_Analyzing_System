package stocking.servlet;

import net.sf.json.JSONObject;
import stocking.data_impl.DataFactory_Data_Impl;
import stocking.data_service.SingleSearch_Data_Service;
import stocking.po.StockPO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;

/**
 * Created by dell on 2017/5/23.
 */
@WebServlet(name = "singleStock")
public class SingleStock_Servlet extends HttpServlet {
    private SingleSearch_Data_Service ssds;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JSONObject jsonObject = new ToJSON().toJSONObject(request);
        if (jsonObject == null) {
            return;
        }

        ssds = DataFactory_Data_Impl.getInstance().singleSearch();
        String identifier = jsonObject.getString("identifier");//code或name
        StockPO stockPO = null;
        try {
            stockPO = ssds.getStockList(identifier);
        } catch (ParseException e) {
            e.printStackTrace();
            return;
        }

        new Send().doSend(response, stockPO);
    }
}

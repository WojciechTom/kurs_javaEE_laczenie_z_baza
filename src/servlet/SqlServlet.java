package servlet;

import data.City;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/SqlServlet")
public class SqlServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String param = request.getParameter("get");

        if ("show".equals(param)){

            try {
                List<City> lista = getCityList();
                request.setAttribute("cityList", lista);
                request.getRequestDispatcher("citylist.jsp").forward(request, response);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                response.sendError(500);
            }
        } else {
            response.sendError(403);
        }
    }


    private List<City> getCityList() throws ClassNotFoundException, SQLException {
        final String driver = "com.mysql.cj.jdbc.Driver";
        Class.forName(driver);

        List<City> cityList = null;
        final String dbPath = "jdbc:mysql://localhost:3306/world?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true"; //jdbc:mysql://localhost:3306/world?serverTimezone=UTC&allowPublicKeyRetrieval=true";
        final String sqlQuery = "SELECT Name, Population FROM city";

        Connection conn = DriverManager.getConnection(dbPath, "root", "admin");
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery);
        {
            String cityName = null;
            int population = 0;
            cityList = new ArrayList<>();
            while (resultSet.next()) {
                cityName = resultSet.getString("Name");
                population = resultSet.getInt("Population");
                System.out.println(cityName + " " + population + "WYDRUK");
                City city = new City(cityName, population);
                cityList.add(city);
            }
            System.out.println("po petli ");
            for (City c : cityList
            ) {
                System.out.println(c.getName());
            }
            return cityList;
        }


    }}


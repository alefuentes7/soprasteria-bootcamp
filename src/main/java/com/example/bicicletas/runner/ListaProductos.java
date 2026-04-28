package com.example.bicicletas.runner;
import java.sql.*;

public class ListaProductos {
        public static void main(String[] args) {
            String url ="jdbc:mysql://127.0.0.1:3306/productos?useSSL=false&serverTimezone=UTC";
            String user = "root";
            String password = "Alej@ndra1604";

            String sql = "SELECT id_producto, nombre, num_serie, precio FROM producto ORDER BY id_producto";

            try (Connection conn = DriverManager.getConnection(url, user, password);
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {

                while (rs.next()) {
                    System.out.println(
                        rs.getInt("id_producto") + " | " +
                        rs.getString("nombre") + " | " +
                        rs.getString("num_serie") + " | " +
                        rs.getBigDecimal("precio")
                    );

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

}

package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DB {

    private static Connection connection = null;


    // Classe de conexão
    public static Connection getConnection () {

        if (connection == null) {

            try {

                Properties properties = loadProprieties();

                String url = properties.getProperty("dburl");

                connection = DriverManager.getConnection(url, properties);

            } catch (SQLException e) {

                throw new DbExeption("Error -> " + e.getMessage());

            }

        }

        return connection;

    }

    // Fechar a cnexão
    public static void closeConnection () {

        if (connection != null) {

            try {

                connection.close();

            } catch (SQLException e) {

                throw new DbExeption("Error -> " + e.getMessage());

            }

        }

    }


    // Ler os dados do db.properties
    private static Properties loadProprieties () {

        try (FileInputStream fileInputStream = new FileInputStream("db.properties")) {

            Properties properties = new Properties();

            properties.load(fileInputStream);

            return properties;

        } catch (IOException e) {

            throw new DbExeption("Error -> " + e.getMessage());

        }

    }

    // Metodo Auxiliar para fechar um Resultset
    public static void closeResultSet(ResultSet resultSet){

        if (resultSet != null) {

            try {

                resultSet.close();

            } catch (SQLException e) {

                throw new DbExeption("Error -> " + e.getMessage());

            }

        }

    }

    // Metodo Auxiliar para fechar um Statement
    public static void closeStatment(Statement statement) {

        if (statement != null) {

            try {

                statement.close();

            } catch (SQLException e) {

                throw new DbExeption("Error -> " + e.getMessage());

            }

        }

    }

}

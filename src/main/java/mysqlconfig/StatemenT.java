package mysqlconfig;

import dataobjects.AddressTable;
import mysqlconfig.enums.ADDRESSFIELDS;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StatemenT {
    private Statement statement;

    public StatemenT() {
        try {
            makeStatemenT();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Statement makeStatemenT() throws SQLException {
        Connect c = null;

        c = new Connect();
        Connection conn = c.makeConnection();
        statement = conn.createStatement();
        return statement;
    }

    public AddressTable selectByFieldName(ADDRESSFIELDS addressfields, String data) throws SQLException {
        String select = "SELECT * FROM sys.address where " + addressfields + "='" + data + "'";
        ResultSet resultSet = null;
        resultSet = statement.executeQuery(select);
        resultSet.next();
        System.out.println(resultSet.getString("name"));
        return new AddressTable(resultSet);
    }

    public List<AddressTable> selectListTables(ADDRESSFIELDS addressfields, String data) throws SQLException {
        String select = "SELECT * FROM sys.address where " + addressfields + "='" + data + "'";
        ResultSet resultSet = null;
        resultSet = statement.executeQuery(select);
        List<AddressTable> addressTableList = new ArrayList<>();
        while (resultSet.next()) {
            addressTableList.add(new AddressTable(resultSet));
        }
        return addressTableList;
    }

    public List<AddressTable> selectListTablesMail(ADDRESSFIELDS addressfields, String data) throws SQLException {
        String select = "SELECT * FROM sys.address where " + addressfields + " like '%" + data + "'";
        ResultSet resultSet = null;
        resultSet = statement.executeQuery(select);
        List<AddressTable> adressTableList = new ArrayList<>();
        while (resultSet.next()) {
            adressTableList.add(new AddressTable(resultSet));
        }
        return adressTableList;
    }
    // Hometask method 1
    public Set<AddressTable> selectListUniqueNames(ADDRESSFIELDS addressfields) throws SQLException {
        String select = "SELECT " + addressfields + " FROM sys.address LIMIT 0,100";
        ResultSet resultSet = null;
        resultSet = statement.executeQuery(select);
        List<AddressTable> uniqueNames = new ArrayList<>();
        Set<AddressTable> uniqueNamesList = new HashSet<>(uniqueNames);
        while (resultSet.next()) {
            uniqueNames.add(new AddressTable(resultSet));
        }
        return uniqueNamesList;
    }
    // Hometask method 2
    public AddressTable getNameByID(ADDRESSFIELDS name, ADDRESSFIELDS id, String data) throws SQLException {
        String select = "SELECT " + name + " FROM sys.address where " + id + "='" + data + "'";
        ResultSet resultSet = null;
        resultSet = statement.executeQuery(select);
        resultSet.next();
        System.out.println(resultSet.getString("name"));
        return new AddressTable(resultSet);
    }
    // Hometask method 3
    public List<AddressTable> sameEmailUserList(ADDRESSFIELDS email, String emailAddress) throws SQLException {
        String select = "SELECT * FROM sys.address where " + email + "='" + emailAddress + "'";
        ResultSet resultSet = null;
        resultSet = statement.executeQuery(select);
        List<AddressTable> usersWithSameEmail = new ArrayList<>();
        while (resultSet.next()) {
            usersWithSameEmail.add(new AddressTable(resultSet));
        }
        return usersWithSameEmail;
    }
}

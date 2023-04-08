package dataobjects;

import mysqlconfig.enums.ADDRESSFIELDS;

import java.sql.ResultSet;
import java.sql.SQLException;
public class AddressTable {
    public    int id;

    public String getName() {
        return name;
    }

    public    String name, lastname, email, physicaladdress, birthday;

    public AddressTable(int id, String name, String lastname, String email, String physicaladdress, String birthday) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.physicaladdress = physicaladdress;
        this.birthday = birthday;
    }
    public AddressTable(ResultSet resultSet) {
        try {
            this.id = resultSet.getInt(ADDRESSFIELDS.ID.getFieldName());
            this.name = resultSet.getString(ADDRESSFIELDS.NAME.getFieldName());
            this.lastname = resultSet.getString(ADDRESSFIELDS.LAST_NAME.getFieldName());
            this.email = resultSet.getString(ADDRESSFIELDS.EMAIL.getFieldName());
            this.physicaladdress = resultSet.getString(ADDRESSFIELDS.PHYSICAL_ADDRESS.getFieldName());
            this.birthday = resultSet.getString(ADDRESSFIELDS.BIRTHDAY.getFieldName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

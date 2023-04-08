import dataobjects.AddressTable;
import mysqlconfig.StatemenT;
import mysqlconfig.enums.ADDRESSFIELDS;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLException;

public class TestDB {
    static StatemenT statemenT;

    @BeforeClass
    public static void b() {
        statemenT = new StatemenT();
    }

    @Test
    public void test1() throws SQLException {
        statemenT.selectByFieldName(ADDRESSFIELDS.NAME, "Sansa");
    }

    @Test
    public void test2() throws SQLException {
        Assert.assertNotNull(statemenT.selectByFieldName(ADDRESSFIELDS.NAME, "Robb").email);
    }

    @Test
    public void test3() throws SQLException {
        for (AddressTable l : statemenT.selectListTables(ADDRESSFIELDS.LAST_NAME, "Stark")) {
            System.out.println(l.name);
        }
    }

    @Test
    public void nameById() throws SQLException {
        statemenT.getNameByID(ADDRESSFIELDS.NAME, ADDRESSFIELDS.ID,"3");
    }

    @Test
    public void sameEmail() throws SQLException {
        for (AddressTable e : statemenT.sameEmailUserList(ADDRESSFIELDS.EMAIL, "lannister@got.com")) {
            System.out.println(e.name + " " + e.lastname);
        }
    }
    @Test
    public void uniqueName() throws SQLException {
        for (AddressTable u : statemenT.selectListUniqueNames(ADDRESSFIELDS.NAME)) {
            System.out.println(u.name);
        }
    }
}



package lesopdracht;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReizigerOracleDaolmpl extends OracleBaseDAO implements ReizigerDao {

    public Reiziger save(Reiziger reiziger) {
        try {
            Connection conn = getConnection();
            String sql = "INSERT INTO reiziger(REIZIGERID, VOORLETTERS, TUSSENVOEGSEL, ACHTERNAAM) VALUES(?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, reiziger.getId());
            preparedStatement.setString(2, reiziger.getVoorletters());
            preparedStatement.setString(3, reiziger.getTussenvoegsel());
            preparedStatement.setString(4, reiziger.getAchternaam());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return reiziger;
        } catch (SQLException e){
            System.out.println(e);
            return null;
        }
    }

    public List<Reiziger> findAll() {
        try{
            Connection conn = getConnection();
            String sql = "SELECT * FROM reiziger";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            List<Reiziger> list = new ArrayList<>();
            Reiziger reiziger;
            while (resultSet.next()) {
                reiziger = new Reiziger(resultSet.getInt("REIZIGERID"),
                            resultSet.getString("VOORLETTERS"),
                            resultSet.getString("TUSSENVOEGSEL"),
                            resultSet.getString("ACHTERNAAM"),
                            resultSet.getDate("GEBORTEDATUM")
                );
                list.add(reiziger);
            }
            resultSet.close();
            statement.close();
            return list;
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Reiziger> findByGBdatum(Date geboortedatum) {
        return null;
    }

    public Reiziger update(Reiziger reiziger) {
        return null;
    }

    public boolean delete(Reiziger reiziger) {
        return true;
    }
}

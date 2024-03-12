package repository.ToyRepositoryImpl;

import Config.DataBaseConnection;
import jdk.jfr.Category;
import model.Toy;
import repository.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ToyRepositoryDBImpl implements Repository<Toy> {
    private Connection getConnection() throws SQLException {
        return DataBaseConnection.getInstance();
    }

    private Toy createToy(ResultSet resultSet) throws SQLException {
        Toy toy = new Toy();
        toy.setId(resultSet.getLong("id"));
        toy.setName(resultSet.getString("name"));
        toy.setPrice(resultSet.getDouble("price"));
        toy.setCategory(resultSet.getString("category"));
        return toy;
    }

    @Override
    public List<Toy> list() {
        List<Toy>toysList=new ArrayList<>();
        try(Statement statement=getConnection().createStatement();
            ResultSet resultSet=statement.executeQuery(
                    """
                        SELECT p.*, c.name as category_name, c.id as category_id
                        FROM Toyos AS p
                        INNER JOIN categories AS c ON p.categoria_id = c.id;
                        """
            ))
        {
            while (resultSet.next()){
                Toy toy=createToy(resultSet);
                toysList.add(toy);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toysList;
    }

    @Override
    public Toy byId(int id) {
        Toy toy=null;
        try (PreparedStatement preparedStatement=getConnection()
                .prepareStatement(""" 
                                    SELECT p.*, c.name as category_name, c.id as category_id
                                    FROM Toyos AS p
                                    INNER JOIN categories AS c ON p.categoria_id = c.id
                                    WHERE p.id=?
                                    """)
        ) {
            preparedStatement.setLong(1,id);
            ResultSet resultSet= preparedStatement.executeQuery();
            if (resultSet.next()){
                toy=createToy(resultSet);
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return toy;
    }

    @Override
    public void save(Toy toy) {
        try(PreparedStatement preparedStatement = getConnection()
                .prepareStatement("""
                                       INSERT INTO Toyos(nombre,precio,fecha_registro,categoria_id) values (?,?,?,?)
                                       """)
        ){
            preparedStatement.setString(1, toy.getName());
            preparedStatement.setDouble(2, toy.getPrice());
            preparedStatement.setInt(3,toy.getAmount());
            preparedStatement.setString(4,toy.getCategory());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Toy toy) {
        try(PreparedStatement preparedStatement = getConnection()
                .prepareStatement("""
                                    UPDATE Toyos SET nombre = ?, precio = ?, fecha_registro = ? , categoria_id=? WHERE id = ?;
                                      """
                )
        ){
            preparedStatement.setString(1, toy.getName());
            preparedStatement.setDouble(2, toy.getPrice());
            preparedStatement.setInt(3,toy.getAmount());
            preparedStatement.setString(4,toy.getCategory());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    @Override
    public void delete(int id) {
        try(PreparedStatement preparedStatement = getConnection()
                .prepareStatement("""
                                      DELETE FROM Toys where id=?
                                      """)
        ){
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
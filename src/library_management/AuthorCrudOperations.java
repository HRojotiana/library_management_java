package library_management;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AuthorCrudOperations implements CrudOperations<Author>{
    ConnectionAndStatement connectionAndStatement = ConnectionAndStatement.getInstance();
    Connection connection = connectionAndStatement.getConnection();
    @Override
    public List<Author> findAll() {
        String sql = "SELECT * FROM \"author\"";
        List<Author> authorList= new ArrayList<>();
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Author author = new Author(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getString("sex")
                );
                authorList.add(author);
            }
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        return authorList;
    }

    @Override
    public List<Author> saveAll(List<Author> toSave) {
        String sql = "INSERT INTO \"author\" VALUES (?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            for (Author author : toSave) {
                preparedStatement.setString(1, author.getId());
                preparedStatement.setString(2, author.getName());
                preparedStatement.setString(3, author.getSex());

                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return toSave;
    }

    @Override
    public Author save(Author toSave) {
        String sql = "INSERT INTO \"author\" (id, name, sex) VALUES (?,?,?)";
        Author newAuthor = null;
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, toSave.getId());
            preparedStatement.setString(2, toSave.getName());
            preparedStatement.setString(3, toSave.getSex());

            newAuthor = new Author(toSave.getId(), toSave.getName(), toSave.getSex());
            preparedStatement.executeUpdate();
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        return newAuthor;
    }

    @Override
    public Author delete(Author toDelete) {
        String sql = "DELETE FROM \"author\" WHERE id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, toDelete.getId());
            preparedStatement.executeUpdate();
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        return toDelete;
    }
}

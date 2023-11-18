package library_management;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookCrudOperations implements CrudOperations<Book>{
    ConnectionAndStatement connectionAndStatement = ConnectionAndStatement.getInstance();
    Connection connection = connectionAndStatement.getConnection();

    @Override
    public List<Book> findAll() {
        List bookList = new ArrayList<>();
        String sql = "select * from \"book\"";
        Book book;
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                book = new Book(
                        resultSet.getString("id"),
                        resultSet.getString("book_name"),
                        resultSet.getInt("page_numbers"),
                        resultSet.getString("topic"),
                        resultSet.getDate("release_date"),
                        resultSet.getString("status"),
                        resultSet.getString("id_author")
                );
                bookList.add(book);
            }

        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        return bookList;
    }

    @Override
    public List<Book> saveAll(List<Book> toSave) {
        return null;
    }

    @Override
    public Book save(Book toSave) {
        Book newBook = null;
        String sql = "INSERT INTO \"book\" (id, book_name, page_numbers, topic, release_date, status, id_author) VALUES (?,?,?,?,?,?,?)";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, toSave.getId());
            preparedStatement.setString(2, toSave.getBookName());
            preparedStatement.setInt(3, toSave.getPageNumbers());
            preparedStatement.setString(4, toSave.getTopic());
            preparedStatement.setDate(5, (Date) toSave.getReleaseDate());
            preparedStatement.setString(6, toSave.getStatus());
            preparedStatement.setString(7, toSave.getIdAuthor());

            newBook = new Book(toSave.getId(), toSave.getBookName(), toSave.getPageNumbers(), toSave.getTopic(), toSave.getReleaseDate(), toSave.getStatus(), toSave.getIdAuthor());
            preparedStatement.executeUpdate();
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        return newBook;
    }

    @Override
    public Book delete(Book toDelete) {
        String sql = "DELETE FROM \"book\" WHERE id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, toDelete.getId());
            preparedStatement.executeUpdate();
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        return toDelete;
    }
}

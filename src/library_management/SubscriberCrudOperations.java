package library_management;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SubscriberCrudOperations implements CrudOperations<Subscriber>{
    ConnectionAndStatement connectionAndStatement = ConnectionAndStatement.getInstance();
    Connection connection = connectionAndStatement.getConnection();
    @Override
    public List<Subscriber> findAll() {
        String sql = "SELECT * FROM \"subsciber\"";
        List<Subscriber> subscriberList = new ArrayList<>();
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Subscriber subscriber = new Subscriber(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getString("reference"),
                        resultSet.getDate("birthdate")
                );

                subscriberList.add(subscriber);
            }
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        return subscriberList;
    }

    @Override
    public List<Subscriber> saveAll(List<Subscriber> toSave) {
        return null;
    }

    @Override
    public Subscriber save(Subscriber toSave) {
        String sql = "INSERT INTO \"subscriber\" (id, name, reference, birthdate) VALUES (?,?,?,?)";
        Subscriber newSubscriber = null;
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, toSave.getId());
            preparedStatement.setString(2, toSave.getName());
            preparedStatement.setString(3, toSave.getReference());
            preparedStatement.setDate(4, (Date) toSave.getBirthdate());

            newSubscriber = new Subscriber(toSave.getId(), toSave.getName(), toSave.getReference(), toSave.getBirthdate());
            preparedStatement.executeUpdate();
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        return newSubscriber;
    }

    @Override
    public Subscriber delete(Subscriber toDelete) {
        String sql = "DELETE FROM \"subscriber\" WHERE id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, toDelete.getId());
            preparedStatement.executeUpdate();
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        return toDelete;
    }
}

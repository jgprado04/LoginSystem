package br.loginsystem.com.Repository;

import br.loginsystem.com.Connection.ConnectionFactory;
import br.loginsystem.com.Model.UserModel;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Log4j2
public class JdbcRepository implements UserRepository {
    @Override
    public Optional<UserModel> listUser(String username) {
        try(Connection connection = ConnectionFactory.getConnection()) {
            log.info("Trying to list the user: ", username);
            PreparedStatement ps = preparedStatementListUser(connection, username);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                return Optional.of(UserModel.builder()
                        .username(rs.getString("username"))
                        .password(rs.getString("password"))
                        .firstname(rs.getString("firstname"))
                        .lastname(rs.getString("lastname"))
                        .build()
                );
            }
        } catch (SQLException e) {
            log.error("Erro to list the user: ", e);
        }
        return Optional.empty();
    }

    @Override
    public UserModel insertUser(UserModel userModel) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            log.info("Trying to add the user: ", userModel.getFirstname());
            resultSetInsertUser(connection, userModel);
        } catch (SQLException e) {
            log.error("Erro to trying to add the user: ", e);
        }
        return userModel;
    }

    private PreparedStatement preparedStatementListUser(Connection connection, String username) throws SQLException {
        String sql = "SELECT * FROM WHERE (username = ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, username);
        return ps;
    }

    private ResultSet resultSetInsertUser(Connection connection, UserModel userModel) throws SQLException {
        String sql = "INSERT INTO USERS(id, username, password, firstname, lastname) VALUES (users_seq.nextval, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, userModel.getUsername());
        ps.setString(2, userModel.getPassword());
        ps.setString(3, userModel.getFirstname());
        ps.setString(4, userModel.getLastname());
        return ps.executeQuery();
    }
}

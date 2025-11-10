package br.loginsystem.com.Repository;

import br.loginsystem.com.Model.UserModel;

import java.util.Optional;

public interface UserRepository {
    public Optional<?> listUser(String username);
    public UserModel insertUser(UserModel userModel);
}

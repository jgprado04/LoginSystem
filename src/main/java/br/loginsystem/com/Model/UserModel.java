package br.loginsystem.com.Model;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class UserModel {
    private String username;
    private String password;
    private String firstname;
    private String lastname;
}

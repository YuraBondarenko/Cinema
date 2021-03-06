package com.dev.cinema.model.dto.request;

import com.dev.cinema.lib.EmailValidatorAnnotation;
import com.dev.cinema.lib.PasswordValidatorAnnotation;

@PasswordValidatorAnnotation(field = "password", fieldMatch = "repeatPassword")
public class UserRequestDto {
    @EmailValidatorAnnotation
    private String email;
    private String password;
    private String repeatPassword;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }
}

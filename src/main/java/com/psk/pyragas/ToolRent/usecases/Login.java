package com.psk.pyragas.ToolRent.usecases;
import com.psk.pyragas.ToolRent.dao.ProfilesDAO;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serializable;

@Named
@SessionScoped
@WebServlet("/login")
@Getter @Setter
public class Login extends HttpServlet implements Serializable {

    @Getter
    private boolean isUserLoggedIn = false;

    private String username;
    private String password;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String checkFields() {
        boolean valid = ProfilesDAO.validate(username, password);
        if(valid) {
            setUserLoggedInToTrue();
            return "index";
        }
        return "login";
    }

    private boolean checkUsername(String username) {
        //TODO: search in db
        //TODO: save id
        return true;
    }

    private boolean checkPassword(String password) {
        //TODO: tikrinti pagal id
        return true;
    }

    public void setUserLoggedInToTrue() {
        this.isUserLoggedIn = true;
    }

    public void setUserLoggedInToFalse() {
        this.isUserLoggedIn = false;
    }

}
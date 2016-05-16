package by.museum.entities.security;

import by.museum.entities.MuseumBuild;
import by.museum.entities.ThematicSection;
import by.museum.entities.template.IdEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

/**
 * Created by shamaz on 15.05.2016.
 */
@Entity
@Table(name = "USER")
public class User extends IdEntity {

    @Column(name = "LOGIN", nullable = false)
    private String login;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "LAST_LOGIN")
    private LocalDate lastLogin;

    @Column(name = "IS_ADMIN")
    private boolean isAdmin;

    @ManyToMany
    @JoinTable(name = "USER_MUSEUMS",
            joinColumns = @JoinColumn(name = "ID_USER"),
            inverseJoinColumns = @JoinColumn(name = "ID_MUSEUM"))
    private Set<MuseumBuild> museums;

    public User() {
        //default constructor
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Set<MuseumBuild> getMuseums() {
        return museums;
    }

    public void setMuseums(Set<MuseumBuild> museums) {
        this.museums = museums;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDate lastLogin) {
        this.lastLogin = lastLogin;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
}

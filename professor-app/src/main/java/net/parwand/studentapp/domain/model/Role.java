package net.parwand.studentapp.domain.model;

import jakarta.persistence.*;

@Entity
public class Role {

    @Id
    @GeneratedValue
    private Long id;
    private String role;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Role() {
    }

    public Role(String role, User user) {
        this.role = role;
        this.user = user;
    }

    public Role(Long id, String role, User user) {
        this.id = id;
        this.role = role;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

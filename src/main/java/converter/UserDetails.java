/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

public class UserDetails {

    private Integer id;

    private String email;

    private String username;

    private String password;

    private String position;

    public UserDetails(Integer id, String email, String username, String password, String position) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.position = position;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPosition() {
        return position;
    }

}

package com.ryf.appbackend.jwtsecurity.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class JwtUserDetails implements UserDetails {


    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String role;

    public JwtUserDetails(JwtUser jwtUser) {
        this.id = jwtUser.getId();
        this.role = jwtUser.getRole();
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        List<String> byRole = Role.getByRole(role);
        return byRole != null ? byRole.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()) : null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}

class Role {


    /*
+-----------+------+-----------+---------+-------+
| Privilege | User | Moderator | Manager | Admin |
+-----------+------+-----------+---------+-------+
| Get       | Yes  | Yes       | Yes     | Yes   |
+-----------+------+-----------+---------+-------+
| Create    | No   | Yes       | Yes     | Yes   |
+-----------+------+-----------+---------+-------+
| Update   | No   | No        | Yes     | Yes   |
+-----------+------+-----------+---------+-------+
| Delete    | No   | No        | No      | No    |
+-----------+------+-----------+---------+-------+


    * */
    //TODO USE

//    private static List<String> user = Arrays.asList("GET");
//    private List<String> moderator = Arrays.asList("GET", "CREATE");
//    private List<String> manager = Arrays.asList("GET", "CREATE", "UPDATE");
//    private static List<String> admin = Arrays.asList("GET", "CREATE", "UPDATE", "DELETE");


    private static List<String> user = Arrays.asList("GET");
    private static List<String> admin = Arrays.asList("GET", "MODIFY");

    static List<String> getByRole(String role) {
        switch (role.toLowerCase()) {
            case "user":
                return user;
            case "admin":
                return admin;
        }
        return null;
    }


}

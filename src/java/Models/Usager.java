/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author Benjamin Alexander
 */
public class Usager implements UserDetails{ //extends User

    private final String username;
    private final String password;
    private final String courriel;
    private final boolean status;
    private final List<GrantedAuthority> roles;
    
    public Usager(String username,String password,boolean status,String courriel, List<GrantedAuthority> roles) {
        this.username=username;
        this.password=password;
        this.courriel = courriel;
        this.status=status;
        this.roles=roles;
    }
    public Usager(String username,String password, List<GrantedAuthority> roles) {
        this.username=username;
        this.password=password;
        this.roles=roles;
        this.courriel = null;
        this.status=true;
    }
    public String getCourriel() {
        return this.courriel;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
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
        return this.status;
    }   
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Collection;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Benjamin Alexander
 */
public class MyAuthenticationProvider implements AuthenticationProvider {

    private final UserManager userManager;

    public MyAuthenticationProvider() {
        this.userManager = new UserManager();
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        // récupérer l'usager de la base de données
        Usager user = (Usager) userManager.loadUserByUsername(username);
        // vérifier l'existance de l'usager
        if (user == null) {
            throw new UsernameNotFoundException("L'usager est inexistant");
        }
        // vérifier s'il s'agit du bon mot de passe
        // en utilisant la méthode matches de la classe BCryptPasswordEncoder
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (!encoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("Le mot de passe est incorect.");
        }
        // récupérer les roles de l'usager
        Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) user.getAuthorities();
        if (authorities == null || authorities.isEmpty()) {
            throw new BadCredentialsException("Erreur d'autorisation");
        }
        //la création du token (le jeton) d'authentification
        authentication = new UsernamePasswordAuthenticationToken(user, password, authorities);
        // mettre le jeton dans le conteneur du contexte de sécurité
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return authentication;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}

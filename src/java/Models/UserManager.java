/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;

/**
 *
 * @author Benjamin Alexander - 1933317
 */
public class UserManager implements UserDetailsManager{
    private LoginDataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    // Définition des requêtes SQL
    private final String insertUserQuery ="insert into Usagers(username,password,status, courriel) values(?,?,?,?)";
    private final String insertAuthQuery="insert into Roles values(?,?)";
    private final String selectPasswordQuery ="select password from Usagers where username=?";  
    private final String selectAuthQuery="select role from Roles  where username =?";
    private final String deleteUserAuthoritiesQuery="delete from Roles where username =?";
    private final String deleteUserQuery="delete from Usagers where username =?";
    private final String changePasswordQuery="update Usagers set password=? where username=? and password=?";
    private final String userExistsSql="select count(*) from Usagers  where username=?";
   
    public LoginDataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(LoginDataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    public UserManager(){
       // La création du datatsource
        this.dataSource = new LoginDataSource();
        
        // La création du jdbctemplate
        this.jdbcTemplate= new JdbcTemplate(dataSource);
    }

   public UserManager(LoginDataSource dataSource){
       
       // La création du datatsource
        this.dataSource = dataSource;
        
        // La création du jdbctemplate
        this.jdbcTemplate= new JdbcTemplate(dataSource);
    }
   
   // Les méthodes utilitaires privées
   private String getPassword(String username){
        return this.jdbcTemplate.queryForObject(selectPasswordQuery,new Object[]{username},String.class);         
    }
    private List<GrantedAuthority> getAuthorities(String username){
        List<GrantedAuthority> grantedAuthorities= (List<GrantedAuthority>)jdbcTemplate.query(selectAuthQuery,new String[]{username} ,new RoleMapper());
        return grantedAuthorities;         
    }
  
    private class RoleMapper implements RowMapper<GrantedAuthority> {
        @Override
        public GrantedAuthority mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new SimpleGrantedAuthority(rs.getString("role"));   
        }
    }
   
    // La redéfinition des méthodes héritées 
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // elle retourne un objet composé d'un usernane, password, list<role>
        try{
            // lire le mot de passe de l'usager
            String password=this.getPassword(username);
            if (password==null) throw new UsernameNotFoundException("Usager non trouvé");
            // lire les roles associés à l'usager
            List<GrantedAuthority> grantedAuthorities= this.getAuthorities(username);
            return new Usager(username,password,grantedAuthorities);
            
        }catch(EmptyResultDataAccessException ex){
            return null;          
        }
    }

    @Override
    public void createUser(UserDetails user) {
         // vérifier si l'usager existe déja
        if(this.userExists(user.getUsername())){
            throw new IncorrectResultSizeDataAccessException("Username existe déja",1);
        }
        // vérifier si l'usager a des roles
        if(user.getAuthorities().isEmpty()){
            throw new IncorrectResultSizeDataAccessException("L'usager doit avoir au moins un role",1);
        }
        // crypter le mot de passe
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        // inserer un usager
        this.jdbcTemplate.update(insertUserQuery,user.getUsername(), encodedPassword, true,((Usager)user).getCourriel());		
        // inserer les roles de l'usager
        List<GrantedAuthority> authorities=(List<GrantedAuthority>) user.getAuthorities();
	for (GrantedAuthority auth : authorities) {
		this.jdbcTemplate.update(insertAuthQuery, user.getUsername(), auth.getAuthority());
	}
        
        
    }
    @Override
    public boolean userExists(String username) {
        int count = this.jdbcTemplate.queryForObject(userExistsSql, new String[] {username}, Integer.class);
        return (count>0);  
        
    }
    
    @Override
    public void deleteUser(String username) {
        // supprimer les roles de l'usager
        this.jdbcTemplate.update(deleteUserAuthoritiesQuery, username);
        // supprimer l'usager
	this.jdbcTemplate.update(deleteUserQuery, username);
    }
   

    @Override
    public void changePassword(String oldPassword, String newPassword) {
        // lire l'usager connnecté
        Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
	if (currentUser == null) {
		throw new IncorrectResultSizeDataAccessException("Pour changer le mot de passe tu dois etre connecté",1);
	}
	String username = currentUser.getName();
         this.jdbcTemplate.update(changePasswordQuery, newPassword, username,oldPassword);
    }
    @Override
    public void updateUser(UserDetails user) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}


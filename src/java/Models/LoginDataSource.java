/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author Benjamin Alexander - 1933317
 */
public class LoginDataSource extends DriverManagerDataSource {

    public LoginDataSource() {
        super("jdbc:sqlserver://localhost;databaseName=GestionStages", "sa", "sql");
        this.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    }

    public LoginDataSource(String url, String username, String password, String className) {
        super(url, username, password);
        this.setDriverClassName(className);
    }

    public JdbcTemplate createJdbcTemplate() {
        return new JdbcTemplate(this);
    }
}

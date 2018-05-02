package config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "myutil.datasource.test")
public class TestDataSourceConfig {

    private String url;

    private String driverclassname;

    private String username;

    private String password;

    private String dbtype;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDriverclassname() {
        return driverclassname;
    }

    public void setDriverclassname(String driverclassname) {
        this.driverclassname = driverclassname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDbtype() {
        return dbtype;
    }

    public void setDbtype(String dbtype) {
        this.dbtype = dbtype;
    }

    @Override public String toString() {
        return "TestDataSourceConfig{" + "url='" + url + '\'' + ", driverclassname='" + driverclassname + '\'' + ", username='"
                + username + '\'' + ", password='" + password + '\'' + ", dbtype='" + dbtype + '\'' + '}';
    }
}

package cn.ivfzhou.java.mybatis.databaseidprovider;

import org.apache.ibatis.mapping.DatabaseIdProvider;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

public class MyDatabaseIDProvider implements DatabaseIdProvider {

    private Properties props;

    @Override
    public void setProperties(Properties p) {
        System.out.println("MyDatabaseIDProvider.setProperties：" + p);
        this.props = p;
    }

    @Override
    public String getDatabaseId(DataSource dataSource) throws SQLException {
        String productName = dataSource.getConnection().getMetaData().getDatabaseProductName();
        System.out.println("MyDatabaseIDProvider.getDatabaseId：productName=" + productName);
        return props.getProperty(productName);
    }

}

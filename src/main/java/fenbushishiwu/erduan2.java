package fenbushishiwu;



import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.jdbc.AtomikosDataSourceBean;

import javax.transaction.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;


public class erduan2 {
    private  static AtomikosDataSourceBean createAtomikosDataSourceBean (String dbName){
        Properties p=new Properties();
        p.setProperty("url","jdbc:mysql://localhost:3306/"+dbName);
        p.setProperty("user","root");
        p.setProperty("password","yyf123");
        //使用AtomikosDataSourceBean 封装com.mysql.jdbc.jdbc2.optional.MysqlXADataSource
        AtomikosDataSourceBean ds = new AtomikosDataSourceBean();
        ds.setUniqueResourceName(dbName);
        ds.setXaDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlXADataSource");
        ds.setXaProperties(p);
        return ds;
    }
    public static void main(String[] args) throws Exception{
        AtomikosDataSourceBean ds1=createAtomikosDataSourceBean("fortest");
        AtomikosDataSourceBean ds2=createAtomikosDataSourceBean("fortest1");
        Connection connection1 =null;
        Connection connection2 =null;
        PreparedStatement preparedStatement1 =null;
        PreparedStatement preparedStatement2 =null;
        //用Atomikos实现事务来构建
        UserTransaction userTransaction = new UserTransactionImp();

        try {
            //开启事务
            userTransaction.begin();
            //执行db1上面的sql
            connection1 = ds1.getConnection();
            preparedStatement1 = connection1.prepareStatement("insert into student values (?,29,null)");
            preparedStatement1.setString(1, "yx");
            preparedStatement1.execute();

            //执行db2上面的sql
            connection2 = ds2.getConnection();
            preparedStatement2 = connection2.prepareStatement("insert into student values (?,29,null)");
            preparedStatement2.setString(1, "yx");
            preparedStatement2.execute();
            //测试异常
//            System.out.println(1/0);
            //两段提交
            userTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            userTransaction.rollback();
        }  finally {
            try {
                preparedStatement1.close();
                preparedStatement2.close();
                connection1.close();
                connection2.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

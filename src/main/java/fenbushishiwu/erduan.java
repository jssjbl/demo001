package fenbushishiwu;

import com.mysql.jdbc.jdbc2.optional.MysqlXAConnection;
import com.mysql.jdbc.jdbc2.optional.MysqlXid;

import javax.sql.XAConnection;
import javax.transaction.xa.XAException;
import javax.transaction.xa.XAResource;
import javax.transaction.xa.Xid;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class erduan {
    public static void main(String[] args) throws ClassNotFoundException , SQLException {
        Class.forName("com.mysql.jdbc.jdbc2.optional.MysqlXADataSource");
        Connection connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/fortest", "root", "yyf123");
        XAConnection xac1= new MysqlXAConnection((com.mysql.jdbc.ConnectionImpl)connection1,true);
        XAResource xaResource1 = xac1.getXAResource();

        Connection connection2= DriverManager.getConnection("jdbc:mysql://localhost:3306/fortest1", "root", "yyf123");
        XAConnection xac2= new MysqlXAConnection((com.mysql.jdbc.ConnectionImpl)connection2,true);
        XAResource xaResource2 = xac2.getXAResource();
        //准备提交事务，询问返回结果
        int xaValue1 = XAResource.TMNOFLAGS;
        int xaValue2 = XAResource.TMNOFLAGS;
        //生成事务分支Id
        Xid xid1=null;
        Xid xid2=null;
        try {
            //分别执行RM1和RM2上的事务分支
            xid1=new MysqlXid("yyf001".getBytes(),"yyf002".getBytes(),1);
            //执行分支id事务
            xaResource1.start(xid1,XAResource.TMNOFLAGS);
            PreparedStatement preparedStatement1 = connection1.prepareStatement("insert into student values (?,29,null)");
            preparedStatement1.setString(1,"yx");
            preparedStatement1.execute();
            xaResource1.end(xid1,XAResource.TMSUCCESS);

            xid2=new MysqlXid("yyf003".getBytes(),"yyf004".getBytes(),1);
            xaResource2.start(xid2,XAResource.TMNOFLAGS);
            PreparedStatement preparedStatement2 = connection2.prepareStatement("insert into student values (?,29,null)");
            preparedStatement2.setString(1,"xh");
            preparedStatement2.execute();
//            int m=1/0;
            xaResource2.end(xid2,XAResource.TMSUCCESS);


            xaValue1 = xaResource1.prepare(xid1);
            xaValue2 = xaResource2.prepare(xid2);

            //两段提交
            boolean allCommit=false;
            if(xaValue1 == XAResource.XA_OK&&xaValue2 == XAResource.XA_OK){
                xaResource1.commit(xid1,allCommit);
                xaResource2.commit(xid2,allCommit);
            }else {
                xaResource1.rollback(xid1);
                xaResource2.rollback(xid2);
            }

        } catch (XAException e) {
            e.printStackTrace();
        } finally {
        }


    }
}

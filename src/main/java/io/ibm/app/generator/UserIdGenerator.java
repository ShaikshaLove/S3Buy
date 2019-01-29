package io.ibm.app.generator;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserIdGenerator implements IdentifierGenerator{
    Connection con;
    PreparedStatement stmt;
    @Override
    public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
        con=session.connection();
        String id="S3";
        try {
           stmt =con.prepareStatement("select s3userseq.nextval from dual");
           ResultSet rs=stmt.executeQuery();
           rs.next();
           String seq=rs.getString(1);
           id=id+seq;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(stmt!=null) try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return id;
    }
}

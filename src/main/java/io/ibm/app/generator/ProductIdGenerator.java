package io.ibm.app.generator;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductIdGenerator implements IdentifierGenerator {
    @Override
    public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
        String id="PRD";
        Connection con= session.connection();
        PreparedStatement pstmt= null;
        try {
            pstmt = con.prepareStatement("select product_seq.nextval from dual");
            ResultSet rs=pstmt.executeQuery();
            rs.next();
            id=id+rs.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(pstmt!=null){
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return id;
    }
}

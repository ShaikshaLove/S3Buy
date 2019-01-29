package io.ibm.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Rice_table")
public class Rice {

    @Id
    private int riceId;

    private String riceName;


    public int getRiceId() {
        return riceId;
    }

    public void setRiceId(int riceId) {
        this.riceId = riceId;
    }

    public String getRiceName() {
        return riceName;
    }

    public void setRiceName(String riceName) {
        this.riceName = riceName;
    }
}

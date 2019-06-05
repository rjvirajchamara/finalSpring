package lk.ijse.absd.entity;


import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class OrderDetail_PK implements Serializable {
    private String code;
    private String oid;

    public OrderDetail_PK() {
    }

    public OrderDetail_PK(String code, String oid) {
        this.code = code;
        this.oid = oid;
    }
    @Override
    public int hashCode(){
        int i = this.code.hashCode() + this.oid.hashCode();
        return i;
    }
    @Override
    public boolean equals(Object ob){
        if(this==ob)
            return true;
         if(ob==null)
            return false;
         if(getClass()!=ob.getClass())
            return false;
            Item it= (Item) ob;
        if(oid==null){
            if(code==null){
                return false;
            }else{}
        }
          return true;
    }



}

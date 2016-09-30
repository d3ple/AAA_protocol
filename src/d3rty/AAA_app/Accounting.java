package d3rty.AAA_app;

import java.util.Date;

/**
 * Created by Andrew on 30.09.2016.
 */
public class Accounting {

    public int ID;
    public Role Role;
    public int Amount;
    public Date Date_st;
    public Date Date_end;


    public Accounting(int ID , Role Role, int Amount, Date Date_st, Date Date_end) {
        this.ID = ID;
        this.Role  = Role;
        this.Amount   = Amount;
        this.Date_st  = Date_st;
        this.Date_end = Date_end;
    }

}

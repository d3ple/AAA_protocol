package d3rty.AAA_app;

import java.time.LocalDate;

public class Accounting {

    //private int id;
    private String role;
    private String resource;
    private LocalDate date_st;
    private LocalDate date_end;
    private long volume;


    public Accounting(String role, String resource, LocalDate date_st, LocalDate date_end, long volume) {
        //this.id = id;
        this.role = role;
        this.resource = resource;
        this.date_st = date_st;
        this.date_end = date_end;
        this.volume = volume;
    }


}

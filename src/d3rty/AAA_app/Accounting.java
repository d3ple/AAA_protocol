package d3rty.AAA_app;

import java.time.LocalDate;

public class Accounting {

    private String role;
    private String resource;
    private LocalDate dateSt;
    private LocalDate dateEnd;
    private long volume;


    public Accounting(String role, String resource, LocalDate dateSt, LocalDate dateEnd, long volume) {
        this.role = role;
        this.resource = resource;
        this.dateSt = dateSt;
        this.dateEnd = dateEnd;
        this.volume = volume;
    }


}

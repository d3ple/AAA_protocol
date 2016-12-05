package com.d3rty.aaaprotocol;

import java.time.LocalDate;

public class Accounting {

    private Role role;
    private String resource;
    private LocalDate dateSt;
    private LocalDate dateEnd;
    private long volume;

    public Accounting(Role role, String resource, LocalDate dateSt, LocalDate dateEnd, long volume) {
        this.role = role;
        this.resource = resource;
        this.dateSt = dateSt;
        this.dateEnd = dateEnd;
        this.volume = volume;
    }

    public Role getRole() {
        return role;
    }

    public LocalDate getDateSt() {
        return dateSt;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public long getVolume() {
        return volume;
    }

}

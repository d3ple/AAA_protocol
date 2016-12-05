CREATE TABLE USER (
    ID NUMBER AUTO_INCREMENT PRIMARY KEY,
    NAME VARCHAR(255),
    LOGIN VARCHAR(255) UNIQUE NOT NULL,
    PASSWORD VARCHAR(255) NOT NULL,
    SALT VARCHAR(255) NOT NULL
);

CREATE TABLE PERMISSION(
    ID NUMBER AUTO_INCREMENT PRIMARY KEY,
    USER_ID INT NOT NULL,
    ROLE VARCHAR(255) NOT NULL,
    RESOURCE VARCHAR(255) NOT NULL,
    CONSTRAINT PERMISSION_USER_ID_FK FOREIGN KEY(USER_ID) REFERENCES USER(ID)
);

CREATE TABLE ACCOUNTING (
    ID NUMBER AUTO_INCREMENT PRIMARY KEY,
    PERMISSION_ID INT NOT NULL,
    DATE_START DATE NOT NULL,
    DATE_END DATE NOT NULL,
    VOLUME NUMBER NOT NULL,
    CONSTRAINT ACCOUNTING_PERMISSION_ID_FK FOREIGN KEY(PERMISSION_ID) REFERENCES PERMISSION(ID)
);

CREATE INDEX IDX_PERMISSION ON PERMISSION (USER_ID, ROLE);
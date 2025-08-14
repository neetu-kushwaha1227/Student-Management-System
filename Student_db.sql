--Create a Student table

CREATE TABLE Student (
    id INT PRIMARY KEY AUTO_INCREMENT,
    SNAME VARCHAR2(100) NOT NULL,
    SPER INT NOT NULL,   
    SCLASS VARCHAR2(20) NOT NULL,
    GENDER VARCHAR2(10) NOT NULL
);

--Insert data 
Insert INTO Student(SNAME,SPER,SCLASS,GENDER) values('Ronak',67,'Viii','Male');
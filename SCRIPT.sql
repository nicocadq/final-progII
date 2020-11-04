CREATE DATABASE endProject;


USE endProject;


CREATE TABLE User( ci INT NOT NULL, name VARCHAR(64), lastName VARCHAR(64), birth DATE, mail VARCHAR(64), password VARCHAR(64), PRIMARY KEY (ci));

CREATE TABLE Functionary( ciUser INT NOT NULL, PRIMARY KEY (ciUser), FOREIGN KEY (ciUser) REFERENCES User(ci));

CREATE TABLE Teacher( ciUser INT NOT NULL, PRIMARY KEY (ciUser), FOREIGN KEY (ciUser) REFERENCES User(ci));

CREATE TABLE Subject( idSubject VARCHAR(64), name VARCHAR(64), orientation VARCHAR(64), generation VARCHAR(64), PRIMARY KEY (idSubject));

CREATE TABLE Student( ciUser INT NOT NULL, orientation VARCHAR(64), generation VARCHAR(64), state VARCHAR(64), PRIMARY KEY (ciUser), FOREIGN KEY (ciUser) REFERENCES User(ci));

CREATE TABLE Exam( idExam INT NOT NULL AUTO_INCREMENT, ciStudent INT NOT NULL, idSubject VARCHAR(64), date DATE, markFailed INT, PRIMARY KEY (idExam, ciStudent), FOREIGN KEY (idSubject) REFERENCES Subject(idSubject), FOREIGN KEY (ciStudent) REFERENCES Student(ciUser));

CREATE TABLE Absence(idAbsence INT NOT NULL AUTO_INCREMENT, ciStudent INT NOT NULL, idSubject VARCHAR(64) , type VARCHAR(64), date DATE, PRIMARY KEY (idAbsence, ciStudent), FOREIGN KEY (ciStudent) REFERENCES Student(ciUser), FOREIGN KEY (idSubject) REFERENCES Subject(idSubject));

CREATE TABLE Takes(ciStudent INT NOT NULL, idSubject VARCHAR(64), PRIMARY KEY (ciStudent, idSubject), FOREIGN KEY (ciStudent) REFERENCES Student(ciUser), FOREIGN KEY (idSubject) REFERENCES Subject(idSubject));

CREATE TABLE Teaches(idSubject VARCHAR(64), ciTeacher INT, PRIMARY KEY (idSubject), FOREIGN KEY (idSubject) REFERENCES Subject(idSubject), FOREIGN KEY (ciTeacher) REFERENCES Teacher(ciUser));

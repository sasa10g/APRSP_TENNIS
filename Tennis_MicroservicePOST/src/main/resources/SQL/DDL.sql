DROP TABLE IF EXISTS CourtType CASCADE;
DROP TABLE IF EXISTS Court CASCADE;
DROP TABLE IF EXISTS Employee CASCADE;
DROP TABLE IF EXISTS Player CASCADE;
DROP TABLE IF EXISTS Rank CASCADE;
DROP TABLE IF EXISTS Appointment CASCADE;
DROP TABLE IF EXISTS Match CASCADE;
DROP TABLE IF EXISTS Game CASCADE;

DROP SEQUENCE IF EXISTS court_type_seq CASCADE;
DROP SEQUENCE IF EXISTS court_seq CASCADE;
DROP SEQUENCE IF EXISTS employee_seq CASCADE;
DROP SEQUENCE IF EXISTS player_seq CASCADE;
DROP SEQUENCE IF EXISTS rank_seq CASCADE;
DROP SEQUENCE IF EXISTS appointment_seq CASCADE;
DROP SEQUENCE IF EXISTS match_seq CASCADE;
DROP SEQUENCE IF EXISTS game_seq CASCADE;

CREATE TABLE CourtType (
  CourtTypeID INT,
  CourtType VARCHAR(10) NOT NULL,

  CONSTRAINT PK_CourtType PRIMARY KEY (CourtTypeID)
);

CREATE TABLE Court (
  CourtID INT,
  CourtAddress VARCHAR(10) NOT NULL,
  CourtTypeID INT NOT NULL,

  CONSTRAINT PK_Court PRIMARY KEY (CourtID),
  CONSTRAINT FK_Court_CourtType FOREIGN KEY (CourtTypeID) REFERENCES CourtType(CourtTypeID)
);

CREATE TABLE Employee (
  EmployeeID INT,
  EmployeeFirstName VARCHAR(30) NOT NULL,
  EmployeeLastName VARCHAR(30) NOT NULL,
  EmployeeDateOfBirth DATE NOT NULL,
  DateOfEmployment DATE NOT NULL,
  EmployeeAddress VARCHAR(100) NOT NULL,
  EmployeeUsername VARCHAR(15) NOT NULL,
  EmployeePassword VARCHAR(15) NOT NULL,

  CONSTRAINT PK_Employee PRIMARY KEY (EmployeeID),
  CONSTRAINT UQ_EmployeeUsername UNIQUE (EmployeeUsername)
);

CREATE TABLE Player (
  PlayerID INT,
  PlayerFirstName VARCHAR(30) NOT NULL,
  PlayerLastName VARCHAR(30) NOT NULL,
  PlayerDateOfBirth DATE NOT NULL,
  DateOfJoining DATE NOT NULL,
  Height INT,
  Weight INT,
  PlayerAddress VARCHAR(100) NOT NULL,
  PlayerUsername VARCHAR(15) NOT NULL,
  PlayerPassword VARCHAR(15) NOT NULL,

  CONSTRAINT PK_Player PRIMARY KEY (PlayerID),
  CONSTRAINT UQ_PlayerUsername UNIQUE (PlayerUsername)
);

CREATE TABLE Rank (
  RankID INT,
  Position INT NOT NULL,
  PreviousPosition INT,
  PlayerID INT NOT NULL,

  CONSTRAINT PK_Rank PRIMARY KEY (RankID),
  CONSTRAINT FK_Rank_Player FOREIGN KEY (PlayerID) REFERENCES Player(PlayerID),
  CONSTRAINT UQ_Position UNIQUE (Position),
  CONSTRAINT UQ_PlayerID UNIQUE (PlayerID)
);

CREATE TABLE Appointment (
  AppointmentID INT,
  AppointmentTime TIME NOT NULL,

  CONSTRAINT PK_Appointment PRIMARY KEY (AppointmentID)
);

CREATE TABLE Match (
  MatchID INT,
  MatchDate DATE NOT NULL,
  ApprovedBySecondPlayer BOOLEAN,
  ApprovedByEmployee BOOLEAN,
  FirstPlayerSets INT,
  SeondPlayerSets INT,
  CourtID INT,
  CourtTypeID INT NOT NULL,
  FirstPlayerID INT NOT NULL,
  SecondPlayerID INT NOT NULL,
  AppointmentID INT NOT NULL,

  CONSTRAINT PK_Match PRIMARY KEY (MatchID),
  CONSTRAINT FK_Match_Court FOREIGN KEY (CourtID) REFERENCES Court(CourtID),
  CONSTRAINT FK_Match_FirstPlayer FOREIGN KEY (FirstPlayerID) REFERENCES Player(PlayerID),
  CONSTRAINT FK_Match_SecondPlayer FOREIGN KEY (SecondPlayerID) REFERENCES Player(PlayerID),
  CONSTRAINT FK_Match_Appointment FOREIGN KEY (AppointmentID) REFERENCES Appointment(AppointmentID)
);

CREATE TABLE Game (
  GameID INT,
  FirstPlayerPoints INT,
  SecondPlayerPoints INT,
  MatchID INT NOT NULL,

  CONSTRAINT PK_Game PRIMARY KEY (GameID),
  CONSTRAINT FK_Game_Match FOREIGN KEY (MatchID) REFERENCES Match(MatchID)
);

CREATE SEQUENCE court_type_seq
  INCREMENT 1;
CREATE SEQUENCE court_seq
  INCREMENT 1;
CREATE SEQUENCE employee_seq
  INCREMENT 1;
CREATE SEQUENCE player_seq
  INCREMENT 1;
CREATE SEQUENCE rank_seq
  INCREMENT 1;
CREATE SEQUENCE appointment_seq
  INCREMENT 1;
CREATE SEQUENCE match_seq
  INCREMENT 1;
CREATE SEQUENCE game_seq
  INCREMENT 1;
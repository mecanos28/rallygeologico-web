CREATE TABLE USERS (
  FacebookId INT PRIMARY KEY,
  Username VARCHAR(30) UNIQUE NOT NULL,
  FirstName VARCHAR(15),
  LastName VARCHAR(15),
  Email VARCHAR(30),
  PhotoURL VARCHAR (200),
  IsAdmin BIT DEFAULT 0
);

CREATE TABLE RALLY (
  RallyId INT PRIMARY KEY,
  Name VARCHAR(30) NOT NULL,
  PointsAwarded INT NOT NULL,
  ImageUrl VARCHAR (200),
  Description VARCHAR (5000)
);

CREATE TABLE COMPETITION(
  CompetitionId INT PRIMARY KEY,
  IsActive BIT DEFAULT 1,
  StartingDate DATETIME DEFAULT CURRENT_TIMESTAMP,
  FinishingDate DATETIME,
  IsPublic BIT DEFAULT 1,
  Name VARCHAR(30) NOT NULL,
  RallyId INT NOT NULL,
  FOREIGN KEY (RallyId) REFERENCES RALLY(RallyId)
);

CREATE TABLE INVITATION (
  InvitationId INT PRIMARY KEY,
  Accepted BIT DEFAULT 0,
  FacebookIdSend INT NOT NULL,
  FacebookIdReceive INT NOT NULL,
  CompetitionId INT NOT NULL,
  FOREIGN KEY (FacebookIdSend) REFERENCES USERS(FacebookId),
  FOREIGN KEY (FacebookIdReceive) REFERENCES USERS(FacebookId),
  FOREIGN KEY (CompetitionId) REFERENCES COMPETITION(CompetitionId)
);

CREATE TABLE COMPETITIONS_STATISTICS(
  FacebookId INT NOT NULL,
  CompetitionId INT NOT NULL,
  StartingDate DATETIME DEFAULT CURRENT_TIMESTAMP,
  FinishingDate DATETIME,
  Points INT DEFAULT 0,
  FOREIGN KEY (FacebookId) REFERENCES USERS(FacebookId),
  FOREIGN KEY (CompetitionId) REFERENCES COMPETITION(CompetitionId),
  PRIMARY KEY (FacebookId, CompetitionId)
);

CREATE TABLE DISTRICT (
  Name VARCHAR (40) PRIMARY KEY
);

CREATE TABLE CANTON (
  Name VARCHAR (40) PRIMARY KEY,
  DistrictName VARCHAR (40) NOT NULL,
  FOREIGN KEY (DistrictName) REFERENCES DISTRICT(Name)
);

CREATE TABLE PROVINCE (
  Name VARCHAR (20) PRIMARY KEY,
  CantonName VARCHAR (40) NOT NULL,
  FOREIGN KEY (CantonName) REFERENCES CANTON(Name)
);

CREATE TABLE SITE (
  SiteId INT PRIMARY KEY,
  Name VARCHAR(30) NOT NULL,
  PointsAwarded INT NOT NULL,
  QrUrl VARCHAR(200),
  Details VARCHAR(2000),
  Description VARCHAR(2000),
  Latitude FLOAT NOT NULL,
  Longitude FLOAT NOT NULL,
  ProvinceName VARCHAR (40) NOT NULL,
  FOREIGN KEY (ProvinceName) REFERENCES PROVINCE(Name)
);

CREATE TABLE RALLY_SITE(
  RallyId INT NOT NULL,
  SiteId INT NOT NULL,
  FOREIGN KEY (RallyId) REFERENCES RALLY(RallyId),
  FOREIGN KEY (SiteId) REFERENCES SITE(SiteId),
  PRIMARY KEY (RallyId, SiteId)
);

CREATE TABLE COMPETITION_STATISTICS_SITE(
  FacebookId INT NOT NULL,
  CompetitionId INT NOT NULL,
  SiteId INT NOT NULL,
  FOREIGN KEY (FacebookId) REFERENCES COMPETITIONS_STATISTICS(FacebookId),
  FOREIGN KEY (CompetitionId) REFERENCES COMPETITIONS_STATISTICS(CompetitionId),
  FOREIGN KEY (SiteId) REFERENCES SITE(SiteId),
  PRIMARY KEY (FacebookId, CompetitionId, SiteId)
);

CREATE TABLE TERM (
  TermID INT PRIMARY KEY,
  ImageUrl VARCHAR (2000),
  VideoUrl VARCHAR (200),
  Name VARCHAR (40) NOT NULL,
  Description VARCHAR(2000)
);

CREATE TABLE TERM_SITE(
  TermId INT NOT NULL,
  SiteId INT NOT NULL,
  FOREIGN KEY (TermId) REFERENCES TERM(TermId),
  FOREIGN KEY (SiteId) REFERENCES SITE(SiteId),
  PRIMARY KEY (TermId, SiteId)
);
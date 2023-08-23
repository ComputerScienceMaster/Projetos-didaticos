create database SENAIKeyGuardian;

-- KeyBearer: idKeyBearer, fullname, area, position, username, password
-- KeyLoan: idLoan, loanDate, KeyNumber, idRoom, status, lastLongitude, lastLatitude
-- Rooms: idRoom, RoomCode


-- Create KeyBearer table
CREATE TABLE KeyBearer (
  idKeyBearer SERIAL PRIMARY KEY,
  fullname VARCHAR(100) NOT NULL,
  area VARCHAR(100) NOT NULL,
  position VARCHAR(100) NOT NULL,
  username VARCHAR(100) NOT NULL,
  password VARCHAR(100) NOT NULL
);

-- Create Rooms table
CREATE TABLE Rooms (
  idRoom SERIAL PRIMARY KEY,
  RoomCode VARCHAR(100) NOT NULL
);

-- Create KeyLoan table
CREATE TABLE KeyLoan (
  idLoan SERIAL PRIMARY KEY,
  loanDate TIMESTAMP NOT NULL,
  KeyNumber VARCHAR(100) NOT NULL,
  idRoom INTEGER NOT NULL,
  status VARCHAR(100) NOT NULL,
  FOREIGN KEY (idRoom) REFERENCES Rooms(idRoom)
);

create table locationTracking (
	idTracking SERIAL PRIMARY KEY,
  	lastLongitude FLOAT NOT NULL,
  	lastLatitude FLOAT NOT NULL,
  	idLoan SERIAL not null,
  	FOREIGN KEY (idLoan) REFERENCES KeyLoan(idLoan)
)


INSERT INTO Rooms (RoomCode) VALUES
  ('Room001'),
  ('Room002'),
  ('Room003'),
  ('Room004'),
  ('Room005'),
  ('Room006'),
  ('Room007'),
  ('Room008'),
  ('Room009'),
  ('Room010'),
  ('Room011'),
  ('Room012'),
  ('Room013'),
  ('Room014'),
  ('Room015'),
  ('Room016'),
  ('Room017'),
  ('Room018'),
  ('Room019'),
  ('Room020');

SELECT idTracking, lastLongitude, lastLatitude, idLoan
            FROM locationTracking
            WHERE idLoan = 
            ORDER BY idTracking DESC
            LIMIT 1

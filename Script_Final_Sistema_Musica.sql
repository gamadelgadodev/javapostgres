DROP DATABASE Sistema_Musica

CREATE DATABASE Sistema_Musica;

USE Sistema_Musica;
--Tablas 
CREATE TABLE Miembro(
	idMiembro BIGINT IDENTITY (1,1) NOT NULL,
	NombreMiembro VARCHAR(100) NOT NULL,
	Edad INT,
	Email VARCHAR(200) NOT NULL,
	FechaNacimiento DATE NOT NULL,
	MiembroDesde DATE NOT NULL,
	TiempoMiembro INT,

	CONSTRAINT PK_MIEMBRO PRIMARY KEY (idMiembro)
)
 
CREATE TABLE Genero(
    idGenero BIGINT IDENTITY(1,1) NOT NULL,
    NombreGenero VARCHAR(100) NOT NULL,

    CONSTRAINT PK_GENERO PRIMARY KEY (idGenero)
)

CREATE TABLE Disquera(
    idDisquera BIGINT IDENTITY (1,1) NOT NULL,
    NombreDisquera VARCHAR(100) NOT NULL,
    PaginaWeb VARCHAR(200) NOT NULL,
    FechaFundacion DATE NOT NULL,
    NumeroArtistas INT DEFAULT 0,

    CONSTRAINT PK_DISQUERA PRIMARY KEY (idDisquera)
)

CREATE TABLE Compositor(
    idCompositor BIGINT IDENTITY (1,1) NOT NULL,
    NombreCompositor VARCHAR(100) NOT NULL,
    NumeroCanciones INT DEFAULT 0,
    PaisOrigen VARCHAR(100),

    CONSTRAINT PK_COMPOSITOR PRIMARY KEY (idCompositor)
)
CREATE RULE RL_PAISOR AS @NombrePais IN ('Reino Unido','Estados Unidos','Japón','México','Brasil','Canadá','China','Alemania','Rusia','India','Colombia','Argentina')
EXEC sp_bindrule 'RL_PAISOR', 'Compositor.PaisOrigen'
CREATE TABLE Artista(
    idArtista BIGINT IDENTITY (1,1) NOT NULL,
    idDisquera BIGINT NOT NULL,
    NombreArtista VARCHAR(100) NOT NULL,
    NumeroAlbumes INT DEFAULT 0,

    CONSTRAINT PK_ARTISTA PRIMARY KEY (idArtista),
    CONSTRAINT FK_DISQUERA FOREIGN KEY (idDisquera)
	REFERENCES Disquera (idDisquera) ON DELETE CASCADE
)

CREATE TABLE Playlist(
	idPlaylist BIGINT IDENTITY (1,1) NOT NULL,
	idMiembro BIGINT NOT NULL,
	NombrePlaylist VARCHAR(200) NOT NULL,
	DuracionTotal INT DEFAULT 0,
	FechaCreacion DATE NOT NULL,
	Privada VARCHAR(10) NOT NULL,
	
	CONSTRAINT PK_PLAYLIST PRIMARY KEY (idPlaylist),
	CONSTRAINT FK_MIEMBRO FOREIGN KEY (idMiembro)
	REFERENCES Miembro (idMiembro) ON DELETE CASCADE
)

CREATE RULE RL_PLAYPRIVACIDAD AS @Privacidad IN ('Publica','Privada')
EXEC sp_bindrule 'RL_PLAYPRIVACIDAD', 'Playlist.Privada'


CREATE TABLE Album(
    idAlbum BIGINT IDENTITY (1,1) NOT NULL,
    idGenero BIGINT NOT NULL,
    idArtista BIGINT NOT NULL,
    NombreAlbum VARCHAR(100) NOT NULL,
    CantidadCanciones INT NOT NULL,
    TipoAlbum VARCHAR(20),

    CONSTRAINT PK_ALBUM PRIMARY KEY (idAlbum),
    CONSTRAINT FK_GENERO FOREIGN KEY (idGenero)
	REFERENCES Genero (idGenero) ON DELETE CASCADE,
    CONSTRAINT FK_ARTISTA FOREIGN KEY (idArtista)
    REFERENCES Artista (idArtista)ON DELETE CASCADE
)
CREATE TABLE Cancion(
	idCancion BIGINT IDENTITY (1,1) NOT NULL,
	idAlbum BIGINT NOT NULL,
	idCompositor BIGINT NOT NULL,
	NombreCancion VARCHAR(200) NOT NULL,
	FechaLanzamiento DATE NOT NULL,
	Explicita VARCHAR(4) NOT NULL,
	Duracion TIME NOT NULL,
    
    CONSTRAINT PK_CANCION PRIMARY KEY (idCancion),
    CONSTRAINT FK_ALBUM FOREIGN KEY (idAlbum)
	REFERENCES Album (idAlbum) ON DELETE CASCADE,
    CONSTRAINT FK_COMPOSITOR FOREIGN KEY (idCompositor)
    REFERENCES Compositor (idCompositor) ON DELETE CASCADE
)

CREATE RULE RL_DURCANCI AS @Duracion != 00
EXEC sp_bindrule 'RL_DURCANCI', 'Cancion.Duracion'


CREATE TABLE DetallePlaylist(
	idDetallePlaylist BIGINT IDENTITY (1,1) NOT NULL,
	idPlaylist BIGINT NOT NULL,
	idCancion BIGINT NOT NULL,
	
	CONSTRAINT PK_DETALLEPLAYLIST PRIMARY KEY (idDetallePlaylist),
	CONSTRAINT FK_PLAYLIST FOREIGN KEY (idPlaylist)
	REFERENCES Playlist (idPlaylist) ON DELETE CASCADE,
	CONSTRAINT FK_CANCION FOREIGN KEY (idCancion)
	REFERENCES Cancion (idCancion)
)

--DISPARADORES
GO
CREATE TRIGGER TR_MIEMBRO_TIEMPO
ON Miembro
FOR INSERT,UPDATE AS
BEGIN
	UPDATE Miembro SET TiempoMiembro = DATEDIFF(MONTH,MiembroDesde,GETDATE()), Edad = DATEDIFF(YEAR,FechaNacimiento,GETDATE())
END

CREATE TRIGGER TR_ARTISTA_NUMERO
ON Artista
FOR INSERT, DELETE, UPDATE AS
    DECLARE @idDisquera AS BIGINT
BEGIN
    IF EXISTS(SELECT * FROM inserted)
    BEGIN
        SELECT @idDisquera= idDisquera FROM inserted
        UPDATE Disquera SET NumeroArtistas = (SELECT NumeroArtistas FROM Disquera WHERE idDisquera = @idDisquera) + 1 WHERE idDisquera = @idDisquera
    END
END

CREATE TRIGGER TR_ARTISTA_NUMEROM
ON Artista
FOR INSERT, DELETE, UPDATE AS
    DECLARE @idDisquera AS BIGINT
BEGIN
    IF EXISTS(SELECT * FROM deleted)
    
    BEGIN
        SELECT @idDisquera= idDisquera FROM deleted
        UPDATE Disquera SET NumeroArtistas = (SELECT NumeroArtistas FROM Disquera WHERE idDisquera = @idDisquera) - 1 WHERE idDisquera = @idDisquera
    END
END

CREATE TRIGGER TR_ALBUM_NUMERO
ON Album
FOR INSERT, DELETE, UPDATE AS
    DECLARE @idArtista AS BIGINT
BEGIN
    IF EXISTS(SELECT * FROM inserted)
    BEGIN
        SELECT @idArtista= idArtista FROM inserted
        UPDATE Artista SET NumeroAlbumes = (SELECT NumeroAlbumes FROM Artista WHERE idArtista = @idArtista) + 1 WHERE idArtista = @idArtista
    END
END

CREATE TRIGGER TR_ALBUM_NUMEROM
ON Album
FOR INSERT, DELETE, UPDATE AS
    DECLARE @idArtista AS BIGINT
BEGIN
    IF EXISTS(SELECT * FROM deleted)
    BEGIN
        SELECT @idArtista= idArtista FROM deleted
        UPDATE Artista SET NumeroAlbumes = (SELECT NumeroAlbumes FROM Artista WHERE idArtista = @idArtista) - 1 WHERE idArtista = @idArtista
    END
END

CREATE TRIGGER TR_TIPO_ALBUM
ON Album
FOR INSERT, DELETE, UPDATE AS
    DECLARE @idAlbum AS BIGINT
BEGIN
    IF EXISTS(SELECT * FROM inserted)
    BEGIN
        SELECT @idAlbum= idAlbum FROM inserted
		IF (SELECT CantidadCanciones FROM Album WHERE idAlbum = @idAlbum)>=10
				UPDATE Album SET TipoAlbum = 'LargaDuracion'
		ELSE
				UPDATE Album SET TipoAlbum = 'CortaDuracion'
    END
END


CREATE TRIGGER TR_CANCION_NUMERO
ON Cancion
FOR INSERT, DELETE, UPDATE AS
    DECLARE @idAlbum AS BIGINT
BEGIN
    IF EXISTS(SELECT * FROM inserted)
    BEGIN
        SELECT @idAlbum= idAlbum FROM inserted
        UPDATE Album SET CantidadCanciones = (SELECT CantidadCanciones FROM Album WHERE idAlbum = @idAlbum) + 1 WHERE idAlbum = @idAlbum
    END
END

CREATE TRIGGER TR_CANCION_NUMEROM
ON Cancion
FOR INSERT, DELETE, UPDATE AS
    DECLARE @idAlbum AS BIGINT
BEGIN
    IF EXISTS(SELECT * FROM deleted)
    BEGIN
        SELECT @idAlbum= idAlbum FROM deleted
        UPDATE Album SET CantidadCanciones = (SELECT CantidadCanciones FROM Album WHERE idAlbum = @idAlbum) - 1 WHERE idAlbum = @idAlbum
    END
END

CREATE TRIGGER TR_PLAYLISTDURS
ON DetallePlaylist
FOR INSERT, DELETE, UPDATE AS
    DECLARE @idPlaylist AS BIGINT
BEGIN
    IF EXISTS(SELECT * FROM inserted)
    BEGIN
        SELECT @idPlaylist= idPlaylist FROM inserted
        UPDATE Playlist SET DuracionTotal = (SELECT  SUM(
        DATEPART(SECOND, [Duracion]) + 
                60 * DATEPART(MINUTE, [Duracion]) + 
                3600 * DATEPART(HOUR, [Duracion] ) 
        )
    FROM (SELECT C.Duracion 
	FROM Cancion C INNER JOIN DetallePlaylist D
	ON C.idCancion = D.idCancion
	where D.idPlaylist = @idPlaylist) AS T1) WHERE idPlaylist =@idPlaylist
    END
END


CREATE TRIGGER TR_PLAYLISTDURM
ON DetallePlaylist
FOR INSERT, DELETE, UPDATE AS
    DECLARE @idPlaylist AS BIGINT
BEGIN
    IF EXISTS(SELECT * FROM deleted)
    BEGIN
        SELECT @idPlaylist= idPlaylist FROM deleted
        UPDATE Playlist SET DuracionTotal = (SELECT  SUM(
        DATEPART(SECOND, [Duracion]) + 
                60 * DATEPART(MINUTE, [Duracion]) + 
                3600 * DATEPART(HOUR, [Duracion] ) 
        )
    FROM (SELECT C.Duracion 
	FROM Cancion C INNER JOIN DetallePlaylist D
	ON C.idCancion = D.idCancion
	where D.idPlaylist = @idPlaylist) AS T1) WHERE idPlaylist =@idPlaylist
    END
END


CREATE TRIGGER TR_Compositor_NUMERO
ON Cancion
FOR INSERT, DELETE, UPDATE AS
    DECLARE @idCompositor AS BIGINT
BEGIN
    IF EXISTS(SELECT * FROM inserted)
    BEGIN
        SELECT @idCompositor= idCompositor FROM inserted
        UPDATE Compositor SET NumeroCanciones = (SELECT NumeroCanciones FROM Compositor WHERE idCompositor = @idCompositor) + 1 WHERE idCompositor = @idCompositor
    END
END

CREATE TRIGGER TR_Compositor_NUMERON
ON Cancion
FOR INSERT, DELETE, UPDATE AS
    DECLARE @idCompositor AS BIGINT
BEGIN
    IF EXISTS(SELECT * FROM deleted)
    BEGIN
        SELECT @idCompositor= idCompositor FROM inserted
        UPDATE Compositor SET NumeroCanciones = (SELECT NumeroCanciones FROM Compositor WHERE idCompositor = @idCompositor) - 1 WHERE idCompositor = @idCompositor
    END
END


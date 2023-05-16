
CREATE TABLE Documentos (
  idDocumento SERIAL PRIMARY KEY,
  nombreDocumento varchar(64),
	propietario varchar(50),
  estado varchar(2),
  usuariomodificacion varchar,
  FechaModificacionDocumento TIMESTAMP
);

CREATE TABLE Transferencia (
  idTransferencia SERIAL PRIMARY KEY,
  codigoUsuario INTEGER NOT NULL REFERENCES Usuario(codigoUsuario),
  FechaTransferencia TIMESTAMP DEFAULT NOW()
);

CREATE TABLE Detalle_Transferencia (
  IdDetalle SERIAL PRIMARY KEY,
  idTransferencia INTEGER NOT NULL REFERENCES Transferencia(idTransferencia),
  idDocumento INTEGER NOT NULL REFERENCES Documentos(idDocumento)
);
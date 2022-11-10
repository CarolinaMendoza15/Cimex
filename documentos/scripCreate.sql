-- tables
-- Table: producto
CREATE TABLE producto (
    id int  NOT NULL,
    nombre varchar(30)  NOT NULL,
    codigo varchar(5)  NOT NULL,
    stock int  NOT NULL,
    valorUnitario decimal(16,2)  NOT NULL,    
    stock_minimo int  NOT NULL,
    stock_recomendado int  NOT NULL,    
    proveedor_id int  NOT NULL,
    CONSTRAINT producto_pk PRIMARY KEY (id)
);

-- Table: proveedor
CREATE TABLE proveedor (
    id int  NOT NULL,
    nombre varchar(30)  NOT NULL,
    direccion varchar(30)  NOT NULL,
    telefono int  NOT NULL,
    CONSTRAINT proveedor_pk PRIMARY KEY (id)
);

-- Table: usuario
CREATE TABLE usuario (
    id int  NOT NULL,
    usuario varchar(30)  NULL,
    contrasenia varchar(10)  NULL,
    nombre varchar(30)  NULL,
    direccion varchar(30)  NOT NULL,
    telefono int  NOT NULL,
    CONSTRAINT usuario_pk PRIMARY KEY (id)
);


-- foreign keys
-- Reference: producto_proveedor (table: producto)
ALTER TABLE producto ADD CONSTRAINT producto_proveedor
    FOREIGN KEY (proveedor_id)
    REFERENCES proveedor (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;



-- End of file.

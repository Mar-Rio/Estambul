CREATE SCHEMA IF NOT EXISTS packsTuristicos DEFAULT CHARACTER SET utf8 ;
USE packsTuristicos ;


CREATE TABLE IF NOT EXISTS usuarios (
   id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  rol ENUM('admin', 'cliente') NOT NULL,
  nombre VARCHAR(45) NOT NULL,
  mail VARCHAR(45) NOT NULL,
  telefono INT(9) UNSIGNED NULL,
  tarjeta INT(20) UNSIGNED NULL,
  contraseña VARCHAR(20) NOT NULL,
  PRIMARY KEY (id))
ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS packs (
  id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(45) NULL DEFAULT 'Mi Pack',
  descripcion TEXT NULL,
  fecha_creacion DATETIME NOT NULL,
  fecha_inicio DATETIME NOT NULL,
  fecha_final DATETIME NOT NULL,
  id_usuario INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (id),
  INDEX fk_pack_usuario_idx (id_usuario ASC) ,
  CONSTRAINT fk_pack_usuario
    FOREIGN KEY (id_usuario)
    REFERENCES usuarios (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS tipos (
  codigo VARCHAR(10) NOT NULL,
  nombre VARCHAR(45) NULL,
  PRIMARY KEY (codigo))
ENGINE = InnoDB;

INSERT INTO tipos VALUES ('1', 'Restaurante'),('2', 'Hotel'),('3','Actividad');



CREATE TABLE IF NOT EXISTS actividades (
  id INT(4) NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(45) NOT NULL,
  descripcion TEXT NULL,
  imagen MEDIUMBLOB NULL,
  url VARCHAR(150) NULL,
  calidad ENUM('1', '2', '3', '4', '5') NULL,
  tipo VARCHAR(10) NOT NULL,
	precio DECIMAL(6,2) NULL,
  PRIMARY KEY (id),
  INDEX fk_actividad_tipo1_idx (tipo ASC) ,
  CONSTRAINT fk_actividad_tipo1
    FOREIGN KEY (tipo)
    REFERENCES tipos (codigo)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO actividades VALUE 
(1, 'Crucero Bosforo', 'Crucero por el canal del Bosforo que parte en dos la ciudad de Estambul y que permite ver todas sus maravillas desde el mar.', 
'/IMAGENES/bosforo1','https://www.estambul.es/crucero-bosforo','5', 03, 59), 
(2, 'Restaurante Banyan', 'Restaurante a las orillas del Bósforo donde se podrá saborear los deliciosos platos de la gastronomía Turca.', 
'/IMAGENES/banyan1','https://www.tripadvisor.es/Restaurant_Review-g293974-d784732-Reviews-Banyan-Istanbul.html', '4', 01, 45),
(3, 'Hotel Galata', 'Hotel con las últimas tendencias de diseño en pleno centro de Estambul.', '/IMAGENES/galata1', 'https://www.booking.com/hotel/tr/galata-istanbul.es.html', '4', 02, 80),
(4, 'Visita Mezquita Azul', 'Visita por los alrededores e interiores de la majestuosa y mas impresionante mezquita de Estambul.', '/IMAGENES/palacio1', 'https://es.wikipedia.org/wiki/Mezquita_Azul', '5', 03, 20),
(5, 'Hotel Pera', 'Hotel de estilo colonial construido en el siglo XVII, que te transporta a la belleza de otra epoca.', '/IMAGENES/pera2','https://www.booking.com/hotel/tr/pera-palace.es.html', '4' , 02, 95),
(6, 'REstaurante Sarnic', 'Restaurante de estilo gótico en el centro de Estambul.', '/IMAGENES/sarnic2','https://www.tripadvisor.es/Restaurant_Review-g293974-d697960-Reviews-Sarnic_Restaurant-Istanbul.html', '4', 01, 76),
(7, 'Hotel Submarino', 'Uno de los únicos hoteles submarinos en el mundo.', '/IMAGENES/submarino1','https://www.viajablog.com/hotel-submarino-en-estambul/', '5', 02,135),
(8, 'Restaurante Tugra', 'Restaurante especializado en la cocina turca, un refrescante lugar al lado del mar.', '/IMAGENES/tugra1', 'https://es.restaurantguru.com/Ciragan-Palace-Restaurant-Tugra-Istanbul', '5', 01, 95);
select * from actividades;

CREATE TABLE IF NOT EXISTS detalle_packs (
  id_pack INT(10) UNSIGNED NOT NULL,
  num_linea INT(2) NOT NULL,
  id_actividad INT(4) NOT NULL,
  num_plazas INT(2) NULL,
  fecha_inicio DATETIME NULL,
  fecha_final DATETIME NULL,
  duracion TIME NULL,
  PRIMARY KEY (id_pack, num_linea),
  INDEX fk_pack_actividad_actividad1_idx (id_actividad ASC) ,
  INDEX fk_pack_actividad_pack1_idx (id_pack ASC) ,
  CONSTRAINT fk_pack_actividad_pack1
    FOREIGN KEY (id_pack)
    REFERENCES packs (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_pack_actividad_actividad1
    FOREIGN KEY (id_actividad)
    REFERENCES actividades (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
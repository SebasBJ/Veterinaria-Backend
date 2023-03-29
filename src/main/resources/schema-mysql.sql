CREATE TABLE IF NOT EXISTS `propietarios_mascotas` (
  `nmid` int NOT NULL AUTO_INCREMENT,
  `dsnombre_completo` varchar(250) NOT NULL,
  `dstipo_documento` varchar(50) NOT NULL,
  `nmidentificacion` int(11) NOT NULL,
  `dsciudad` varchar(150) NOT NULL,
  `dsdireccion` varchar(250) NOT NULL,
  `nmtelefono` int(11) NOT NULL,
  `dtfecha_registro` date NOT NULL,
  PRIMARY KEY (`nmid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE IF NOT EXISTS `especie_mascotas` (
  `nmid` int NOT NULL AUTO_INCREMENT,
  `dsespecie` varchar(150) NOT NULL,
  PRIMARY KEY (`nmid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE IF NOT EXISTS `mascotas` (
  `nmid` int NOT NULL AUTO_INCREMENT,
  `dsnombre_mascota` varchar(250) NOT NULL,
  `dsraza` varchar(150) NOT NULL,
  `dtfecha_nacimiento` date NOT NULL,
  `nmid_propietarios` int(11) NOT NULL,
  `nmid_especie` int(11) NOT NULL,
  PRIMARY KEY (`nmid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE IF NOT EXISTS `usuarios` (
  `nmid` int NOT NULL AUTO_INCREMENT,
  `dsnombrecompleto` varchar(250) NOT NULL,
  `dscorreo` varchar(250) NOT NULL,
  `dsusuario` varchar(250) NOT NULL,
  `dsrol` varchar(150) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`nmid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

ALTER TABLE `mascotas` ADD CONSTRAINT `FK_mascota_propietarios` FOREIGN KEY (`nmid_propietarios`) REFERENCES `propietarios_mascotas` (`nmid`);
ALTER TABLE `mascotas` ADD CONSTRAINT `FK_mascota_especie` FOREIGN KEY (`nmid_especie`) REFERENCES `especie_mascotas` (`nmid`);
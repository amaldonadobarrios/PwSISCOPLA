
create database  dbsiscopla;



CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `cip` varchar(8) COLLATE utf8_spanish_ci NOT NULL,
  `grado` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `apepat` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `apemat` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `nombres` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `password` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `perfil` int(11) NOT NULL,
  `estado` int(11) NOT NULL,
  `usureg` varchar(8) COLLATE utf8_spanish_ci NOT NULL,
  `usumod` varchar(8) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fechareg` date NOT NULL,
  `fechamod` date DEFAULT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;


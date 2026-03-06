-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 06-03-2026 a las 19:32:02
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `umg`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnos`
--

CREATE TABLE `alumnos` (
  `ALU_Código` int(11) NOT NULL,
  `ALU_Nombre` varchar(50) DEFAULT NULL,
  `ALU_Dirección` varchar(50) DEFAULT NULL,
  `ALU_Status` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asignación_cursos_alumnos`
--

CREATE TABLE `asignación_cursos_alumnos` (
  `CAR_Código` int(11) NOT NULL,
  `CUR_Código` int(11) NOT NULL,
  `MAE_Código` int(11) NOT NULL,
  `ALU_Código` int(11) NOT NULL,
  `JOR_Código` int(11) NOT NULL,
  `ACA_Nota` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carreras`
--

CREATE TABLE `carreras` (
  `CAR_Código` int(11) NOT NULL,
  `CAR_Nombre` varchar(50) DEFAULT NULL,
  `CAR_Status` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cursos`
--

CREATE TABLE `cursos` (
  `CUR_Código` int(11) NOT NULL,
  `CUR_Nombre` varchar(50) DEFAULT NULL,
  `CUR_Status` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jornadas`
--

CREATE TABLE `jornadas` (
  `JOR_Código` int(11) NOT NULL,
  `JOR_Nombre` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `jornadas`
--

INSERT INTO `jornadas` (`JOR_Código`, `JOR_Nombre`) VALUES
(1, 'Matutina'),
(2, 'Vespertina'),
(3, 'Vespertina'),
(4, 'Matutina');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `maestros`
--

CREATE TABLE `maestros` (
  `MAE_Código` int(11) NOT NULL,
  `MAE_Nombre` varchar(50) DEFAULT NULL,
  `MAE_Dirección` varchar(50) DEFAULT NULL,
  `MAE_Status` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `maestros`
--

INSERT INTO `maestros` (`MAE_Código`, `MAE_Nombre`, `MAE_Dirección`, `MAE_Status`) VALUES
(2, 'Ing. Francisco', 'Zona 18', 'Activo'),
(7, 'Ing, Del Aguila', 'Zona 18', 'Activo'),
(87, 'Florian', 'Zona 18', 'Activo');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  ADD PRIMARY KEY (`ALU_Código`);

--
-- Indices de la tabla `asignación_cursos_alumnos`
--
ALTER TABLE `asignación_cursos_alumnos`
  ADD PRIMARY KEY (`CAR_Código`,`CUR_Código`,`MAE_Código`,`ALU_Código`,`JOR_Código`),
  ADD KEY `CUR_Código` (`CUR_Código`),
  ADD KEY `MAE_Código` (`MAE_Código`),
  ADD KEY `ALU_Código` (`ALU_Código`),
  ADD KEY `JOR_Código` (`JOR_Código`);

--
-- Indices de la tabla `carreras`
--
ALTER TABLE `carreras`
  ADD PRIMARY KEY (`CAR_Código`);

--
-- Indices de la tabla `cursos`
--
ALTER TABLE `cursos`
  ADD PRIMARY KEY (`CUR_Código`);

--
-- Indices de la tabla `jornadas`
--
ALTER TABLE `jornadas`
  ADD PRIMARY KEY (`JOR_Código`);

--
-- Indices de la tabla `maestros`
--
ALTER TABLE `maestros`
  ADD PRIMARY KEY (`MAE_Código`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `asignación_cursos_alumnos`
--
ALTER TABLE `asignación_cursos_alumnos`
  ADD CONSTRAINT `asignación_cursos_alumnos_ibfk_1` FOREIGN KEY (`CAR_Código`) REFERENCES `carreras` (`CAR_Código`),
  ADD CONSTRAINT `asignación_cursos_alumnos_ibfk_2` FOREIGN KEY (`CUR_Código`) REFERENCES `cursos` (`CUR_Código`),
  ADD CONSTRAINT `asignación_cursos_alumnos_ibfk_3` FOREIGN KEY (`MAE_Código`) REFERENCES `maestros` (`MAE_Código`),
  ADD CONSTRAINT `asignación_cursos_alumnos_ibfk_4` FOREIGN KEY (`ALU_Código`) REFERENCES `alumnos` (`ALU_Código`),
  ADD CONSTRAINT `asignación_cursos_alumnos_ibfk_5` FOREIGN KEY (`JOR_Código`) REFERENCES `jornadas` (`JOR_Código`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

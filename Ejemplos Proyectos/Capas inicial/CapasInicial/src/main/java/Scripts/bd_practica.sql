/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Soporte
 * Created: 10/02/2026
 */
CREATE DATABASE IF NOT EXISTS practica;
USE practica;
CREATE TABLE Empresa (
    codigoempresa int auto_increment,
    nombreempresa varchar(50),
    PRIMARY KEY (codigoempresa))
ENGINE=innodb DEFAULT CHARSET=Latin1;

-- phpMyAdmin SQL Dump
-- version 2.10.3
-- http://www.phpmyadmin.net
-- 
-- Host: localhost
-- Erstellungszeit: 28. November 2007 um 14:27
-- Server Version: 5.0.45
-- PHP-Version: 5.2.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

-- 
-- Datenbank: `euro08`
-- 

-- 
-- Daten für Tabelle `category`
-- 

INSERT INTO `category` (`name`, `id`) VALUES 
('A', 1),
('B', 2),
('C', 3),
('D', 4),
('E', 5),
('F', 6),
('G', 7);

-- 
-- Daten für Tabelle `match`
-- 

INSERT INTO `match` (`id`, `stade_fkey`, `datetime`, `team1_fkey`, `team2_fkey`) VALUES 
(1, 1, '2008-03-20 20:30:00', 1, 2),
(2, 4, '2008-04-13 12:00:00', 3, 1),
(3, 3, '2008-04-30 08:00:00', 1, 4),
(4, 1, '2008-05-12 15:00:00', 4, 3),
(5, 2, '2008-04-12 15:00:00', 2, 4);

-- 
-- Daten für Tabelle `order`
-- 


-- 
-- Daten für Tabelle `stade`
-- 

INSERT INTO `stade` (`id`, `name`, `country`, `city`) VALUES 
(1, 'Letzigrund', 'Schweiz', 'Zürich'),
(2, 'Joggeli', 'Schweiz', 'Basel'),
(3, 'Wankdorf', 'Schweiz', 'Bern'),
(4, 'Wienerli', 'Österreich', 'Wien');

-- 
-- Daten für Tabelle `stadecategory`
-- 

INSERT INTO `stadecategory` (`category_fkey`, `stade_fkey`, `tickets`, `description`) VALUES 
(1, 1, 300, 'Loge'),
(1, 2, 400, 'Loge'),
(1, 3, 200, 'Lounge'),
(1, 4, 600, 'Trohn'),
(2, 1, 350, 'Sitzplatz'),
(2, 2, 430, 'Sitzplatz'),
(2, 3, 520, 'Hängematte'),
(2, 4, 400, 'Aussichtsturm'),
(3, 1, 400, 'Stehplatz'),
(3, 2, 300, 'Stehplatz'),
(3, 3, 300, 'Stehplatz'),
(3, 4, 200, 'Podest'),
(4, 1, 150, 'Kajüte'),
(4, 2, 600, 'Bungalow'),
(4, 3, 500, 'Liegefplatz'),
(4, 4, 400, 'Kunstrasen'),
(5, 2, 200, 'Spezialplatz'),
(5, 4, 300, 'Spezialplatz');

-- 
-- Daten für Tabelle `team`
-- 

INSERT INTO `team` (`id`, `country`) VALUES 
(1, 'Schweiz'),
(2, 'Kroatien'),
(3, 'Schweden'),
(4, 'Deutschland');

-- 
-- Daten für Tabelle `ticket`
-- 

INSERT INTO `ticket` (`id`, `match_fkey`, `category_fkey`, `price`) VALUES 
(1, 1, 1, 100),
(2, 2, 1, 100),
(3, 3, 1, 100),
(4, 4, 1, 100),
(5, 5, 1, 100),
(6, 1, 2, 200),
(7, 2, 2, 200),
(8, 3, 2, 200),
(9, 4, 2, 200),
(10, 5, 2, 200),
(11, 1, 3, 300),
(12, 2, 3, 300),
(13, 3, 3, 300),
(14, 4, 3, 300),
(15, 5, 3, 300),
(16, 1, 4, 400),
(17, 2, 4, 400),
(18, 3, 4, 400),
(19, 4, 4, 400),
(20, 5, 4, 400),
(21, 5, 5, 1000),
(22, 5, 5, 1000);

-- 
-- Daten für Tabelle `user`
-- 

INSERT INTO `user` (`firstname`, `lastname`, `password`, `activationcode`, `email`, `id`, `superuser`) VALUES 
('admin', 'admin', '*4ACFE3202A5FF5CF467898FC58AAB1D615029441', 'admin', 'admin@euro08.ch', 1, 1),
('Lars', 'Schnyder', '*4223CCFA8D72A8864287F88C587AC16351F59164', 'euro08', 'schnl1@euro08.ch', 2, 0),
('Lorenz', 'Grimm', '*7E4D72ADDBCD2B1366219DCB2752B8AD5C0AEA0D', 'euro08', 'griml1@euro08.ch', 3, 0);

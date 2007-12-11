-- phpMyAdmin SQL Dump
-- version 2.10.3
-- http://www.phpmyadmin.net
-- 
-- Host: localhost 
-- Erstellungszeit: 11. Dezember 2007 um 18:11
-- Server Version: 5.0.45
-- PHP-Version: 5.2.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

-- 
-- Datenbank: `euro08`
-- 

-- --------------------------------------------------------

-- 
-- Tabellenstruktur für Tabelle `category`
-- 

CREATE TABLE `category` (
  `name` varchar(45) NOT NULL,
  `id` int(10) unsigned NOT NULL auto_increment,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

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

-- --------------------------------------------------------

-- 
-- Tabellenstruktur für Tabelle `game`
-- 

CREATE TABLE `game` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `stade_fkey` int(10) unsigned NOT NULL,
  `datetime` datetime NOT NULL,
  `team1_fkey` int(10) unsigned NOT NULL,
  `team2_fkey` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `match_stade_fkey` (`stade_fkey`),
  KEY `match_team1_fkey` (`team1_fkey`),
  KEY `match_team2_fkey` (`team2_fkey`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

-- 
-- Daten für Tabelle `game`
-- 

INSERT INTO `game` (`id`, `stade_fkey`, `datetime`, `team1_fkey`, `team2_fkey`) VALUES 
(1, 1, '2008-03-20 20:30:00', 1, 2),
(2, 4, '2008-04-13 12:00:00', 3, 1),
(3, 3, '2008-04-30 08:00:00', 1, 4),
(4, 1, '2008-05-12 15:00:00', 4, 3),
(5, 2, '2008-04-12 15:00:00', 2, 4);

-- --------------------------------------------------------

-- 
-- Tabellenstruktur für Tabelle `ordering`
-- 

CREATE TABLE `ordering` (
  `user_fkey` int(10) unsigned NOT NULL,
  `ticket_fkey` int(10) unsigned NOT NULL,
  `id` int(10) unsigned NOT NULL auto_increment,
  `quantity` int(10) unsigned NOT NULL default '1',
  `status` tinyint(1) NOT NULL,
  `seat` int(11) NOT NULL default '0',
  PRIMARY KEY  (`id`),
  KEY `order_user_fkey` (`user_fkey`),
  KEY `order_ticket_fkey` (`ticket_fkey`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=20 ;

-- 
-- Daten für Tabelle `ordering`
-- 

INSERT INTO `ordering` (`user_fkey`, `ticket_fkey`, `id`, `quantity`, `status`, `seat`) VALUES 
(2, 1, 9, 1, 0, 0),
(2, 1, 12, 1, 0, 0),
(2, 1, 17, 1, 0, 0),
(2, 1, 18, 1, 0, 0),
(2, 11, 19, 1, 0, 0);

-- --------------------------------------------------------

-- 
-- Tabellenstruktur für Tabelle `stade`
-- 

CREATE TABLE `stade` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `name` varchar(45) NOT NULL,
  `country` varchar(45) NOT NULL,
  `city` varchar(45) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

-- 
-- Daten für Tabelle `stade`
-- 

INSERT INTO `stade` (`id`, `name`, `country`, `city`) VALUES 
(1, 'Letzigrund', 'Schweiz', 'Zürich'),
(2, 'Joggeli', 'Schweiz', 'Basel'),
(3, 'Wankdorf', 'Schweiz', 'Bern'),
(4, 'Wienerli', 'Österreich', 'Wien');

-- --------------------------------------------------------

-- 
-- Tabellenstruktur für Tabelle `stadecategory`
-- 

CREATE TABLE `stadecategory` (
  `category_fkey` int(10) unsigned NOT NULL,
  `stade_fkey` int(10) unsigned NOT NULL,
  `tickets` int(10) unsigned NOT NULL default '0',
  `description` varchar(45) NOT NULL,
  PRIMARY KEY  (`category_fkey`,`stade_fkey`),
  KEY `stadecategory_stade_fkey` (`stade_fkey`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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

-- --------------------------------------------------------

-- 
-- Tabellenstruktur für Tabelle `team`
-- 

CREATE TABLE `team` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `country` varchar(45) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

-- 
-- Daten für Tabelle `team`
-- 

INSERT INTO `team` (`id`, `country`) VALUES 
(1, 'Schweiz'),
(2, 'Kroatien'),
(3, 'Schweden'),
(4, 'Deutschland');

-- --------------------------------------------------------

-- 
-- Tabellenstruktur für Tabelle `ticket`
-- 

CREATE TABLE `ticket` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `match_fkey` int(10) unsigned NOT NULL,
  `category_fkey` int(10) unsigned NOT NULL,
  `price` int(10) unsigned NOT NULL,
  PRIMARY KEY  USING BTREE (`id`),
  KEY `ticket_category_fkey` (`category_fkey`),
  KEY `ticket_game_fkey` (`match_fkey`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=23 ;

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

-- --------------------------------------------------------

-- 
-- Tabellenstruktur für Tabelle `user`
-- 

CREATE TABLE `user` (
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `activationcode` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `id` int(10) unsigned NOT NULL auto_increment,
  `superuser` tinyint(1) NOT NULL,
  `active` tinyint(1) NOT NULL,
  `card` varchar(50) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

-- 
-- Daten für Tabelle `user`
-- 

INSERT INTO `user` (`firstname`, `lastname`, `password`, `activationcode`, `email`, `id`, `superuser`, `active`, `card`) VALUES 
('admin', 'admin', 'euro08', 'admin', 'admin@euro08.ch', 1, 1, 1, ''),
('Lars', 'Schnyder', 'euro08', 'euro08', 'schnl1@euro08.ch', 2, 0, 1, ''),
('Lorenz', 'Grimm', 'euro08', 'euro08', 'griml1@euro08.ch', 3, 0, 1, ''),
('Hans', 'Muster', 'euro08', 'activationcode', 'hans@muster.ch', 4, 0, 0, ''),
('Christian', 'Hunziker', 'euro08', 'activationcode', 'chrigu@euro08.ch', 5, 0, 0, '');

-- 
-- Constraints der exportierten Tabellen
-- 

-- 
-- Constraints der Tabelle `game`
-- 
ALTER TABLE `game`
  ADD CONSTRAINT `match_stade_fkey` FOREIGN KEY (`stade_fkey`) REFERENCES `stade` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `match_team1_fkey` FOREIGN KEY (`team1_fkey`) REFERENCES `team` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `match_team2_fkey` FOREIGN KEY (`team2_fkey`) REFERENCES `team` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

-- 
-- Constraints der Tabelle `ordering`
-- 
ALTER TABLE `ordering`
  ADD CONSTRAINT `order_ticket_fkey` FOREIGN KEY (`ticket_fkey`) REFERENCES `ticket` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `order_user_fkey` FOREIGN KEY (`user_fkey`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

-- 
-- Constraints der Tabelle `stadecategory`
-- 
ALTER TABLE `stadecategory`
  ADD CONSTRAINT `stadecategory_category_fkey` FOREIGN KEY (`category_fkey`) REFERENCES `category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `stadecategory_stade_fkey` FOREIGN KEY (`stade_fkey`) REFERENCES `stade` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

-- 
-- Constraints der Tabelle `ticket`
-- 
ALTER TABLE `ticket`
  ADD CONSTRAINT `ticket_category_fkey` FOREIGN KEY (`category_fkey`) REFERENCES `category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ticket_match_fkey` FOREIGN KEY (`match_fkey`) REFERENCES `game` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

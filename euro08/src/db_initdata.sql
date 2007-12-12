-- phpMyAdmin SQL Dump
-- version 2.10.3
-- http://www.phpmyadmin.net
-- 
-- Host: localhost
-- Erstellungszeit: 12. Dezember 2007 um 08:48
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
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

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
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

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
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=45 ;

-- 
-- Daten für Tabelle `ordering`
-- 

INSERT INTO `ordering` (`user_fkey`, `ticket_fkey`, `id`, `quantity`, `status`, `seat`) VALUES 
(3, 6, 5, 1, 0, 0),
(3, 6, 6, 1, 0, 0),
(3, 6, 7, 1, 0, 0),
(3, 6, 8, 1, 0, 0),
(7, 6, 32, 1, 0, 0),
(7, 11, 33, 1, 0, 0),
(7, 2, 34, 1, 0, 0),
(7, 15, 35, 1, 0, 0);

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
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

-- 
-- Daten für Tabelle `stade`
-- 

INSERT INTO `stade` (`id`, `name`, `country`, `city`) VALUES 
(1, 'Letzigrund', 'Schweiz', 'ZÃ¼rich'),
(2, 'Joggeli', 'Schweiz', 'Basel'),
(3, 'Wankdorf', 'Schweiz', 'Bern'),
(4, 'Wienerli', 'Ã–sterreich', 'Wien');

-- --------------------------------------------------------

-- 
-- Tabellenstruktur für Tabelle `stadecategory`
-- 

CREATE TABLE `stadecategory` (
  `id` int(11) NOT NULL auto_increment,
  `stade_fkey` int(11) NOT NULL,
  `category_fkey` int(11) NOT NULL,
  `tickets` int(10) NOT NULL,
  `description` varchar(45) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=39 ;

-- 
-- Daten für Tabelle `stadecategory`
-- 

INSERT INTO `stadecategory` (`id`, `stade_fkey`, `category_fkey`, `tickets`, `description`) VALUES 
(1, 2, 5, 200, 'Spezialplatz'),
(3, 3, 4, 500, 'Liegefplatz'),
(7, 3, 3, 300, 'Stehplatz'),
(9, 1, 3, 400, 'Stehplatz'),
(11, 3, 2, 520, 'HÃ¤ngematte'),
(13, 1, 2, 1, 'Sitzplatz'),
(15, 3, 1, 200, 'Lounge'),
(17, 4, 5, 300, 'Spezialplatz'),
(21, 1, 1, 300, 'Loge'),
(22, 4, 1, 600, 'Trohn'),
(24, 2, 1, 400, 'Loge'),
(25, 4, 2, 400, 'Aussichtsturm'),
(27, 2, 2, 430, 'Sitzplatz'),
(29, 4, 3, 200, 'Podest'),
(31, 2, 3, 300, 'Stehplatz'),
(33, 4, 4, 400, 'Kunstrasen'),
(35, 2, 4, 600, 'Bungalow'),
(36, 1, 4, 150, 'KajÃ¼te');

-- --------------------------------------------------------

-- 
-- Tabellenstruktur für Tabelle `team`
-- 

CREATE TABLE `team` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `country` varchar(45) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

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
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=23 ;

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
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

-- 
-- Daten für Tabelle `user`
-- 

INSERT INTO `user` (`firstname`, `lastname`, `password`, `activationcode`, `email`, `id`, `superuser`, `active`, `card`) VALUES 
('admin', 'admin', 'euro08', 'admin', 'admin@euro08.ch', 1, 1, 1, ''),
('Lars', 'Schnyder', 'euro08', 'euro08', 'schnl1@euro08.ch', 2, 0, 1, ''),
('Lorenz', 'Grimm', 'euro08', 'euro08', 'griml1@euro08.ch', 3, 0, 1, ''),
('Hans', 'Muster', 'euro08', 'activationcode', 'hans@muster.ch', 4, 0, 0, ''),
('Christian', 'Hunziker', 'euro08', 'activationcode', 'chrigu@euro08.ch', 5, 0, 0, ''),
('grimm', 'grimm', '123456', '1q1sis38b8395', 'grimm@g.ch', 6, 0, 1, '4111111111111111'),
('kjök', 'kölkö', 'asdfasdf', '1ovfwhdb5bjav', 'kjök@llk.sd', 7, 0, 1, '2342423234283429'),
('Emmanuel', 'Benoist', 'euro08', '24f1kn2m94s3', 'benoist@euro08.ch', 8, 0, 1, '4901 1700 0129 0298');

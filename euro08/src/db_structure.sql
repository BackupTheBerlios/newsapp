-- phpMyAdmin SQL Dump
-- version 2.10.3
-- http://www.phpmyadmin.net
-- 
-- Host: localhost
-- Erstellungszeit: 28. November 2007 um 14:26
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

-- --------------------------------------------------------

-- 
-- Tabellenstruktur für Tabelle `match`
-- 

CREATE TABLE `match` (
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

-- --------------------------------------------------------

-- 
-- Tabellenstruktur für Tabelle `order`
-- 

CREATE TABLE `order` (
  `user_fkey` int(10) unsigned NOT NULL,
  `ticket_fkey` int(10) unsigned NOT NULL,
  `id` int(10) unsigned NOT NULL auto_increment,
  `quantity` int(10) unsigned NOT NULL default '1',
  `status` bit(1) NOT NULL default '\0',
  PRIMARY KEY  (`id`),
  KEY `order_user_fkey` (`user_fkey`),
  KEY `order_ticket_fkey` (`ticket_fkey`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

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

-- --------------------------------------------------------

-- 
-- Tabellenstruktur für Tabelle `team`
-- 

CREATE TABLE `team` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `country` varchar(45) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

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
  KEY `ticket_match_fkey` (`match_fkey`),
  KEY `ticket_category_fkey` (`category_fkey`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=23 ;

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
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

-- 
-- Constraints der exportierten Tabellen
-- 

-- 
-- Constraints der Tabelle `match`
-- 
ALTER TABLE `match`
  ADD CONSTRAINT `match_stade_fkey` FOREIGN KEY (`stade_fkey`) REFERENCES `stade` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `match_team1_fkey` FOREIGN KEY (`team1_fkey`) REFERENCES `team` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `match_team2_fkey` FOREIGN KEY (`team2_fkey`) REFERENCES `team` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

-- 
-- Constraints der Tabelle `order`
-- 
ALTER TABLE `order`
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
  ADD CONSTRAINT `ticket_match_fkey` FOREIGN KEY (`match_fkey`) REFERENCES `match` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

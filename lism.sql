-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Dim 13 Avril 2014 à 21:12
-- Version du serveur: 5.5.24-log
-- Version de PHP: 5.3.13

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `lism`
--

-- --------------------------------------------------------

--
-- Structure de la table `cours`
--

CREATE TABLE IF NOT EXISTS `cours` (
  `idCours` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `libelleCours` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`idCours`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `cours`
--

INSERT INTO `cours` (`idCours`, `libelleCours`) VALUES
(1, 'Anglais'),
(2, 'Communication'),
(3, 'Framework');

-- --------------------------------------------------------

--
-- Structure de la table `courssession`
--

CREATE TABLE IF NOT EXISTS `courssession` (
  `idCoursSession` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `dateDebut` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `dateFin` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `description` varchar(2000) NOT NULL DEFAULT '',
  `idCours` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`idCoursSession`),
  KEY `FK_courssession_1` (`idCours`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `courssessionitem`
--

CREATE TABLE IF NOT EXISTS `courssessionitem` (
  `idCoursSessionItem` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `dateHeureCours` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `idEnseignant` int(10) unsigned NOT NULL DEFAULT '0',
  `idSalle` int(10) unsigned NOT NULL DEFAULT '0',
  `idCoursSession` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`idCoursSessionItem`),
  KEY `FK_courssessionitem_1` (`idEnseignant`),
  KEY `FK_courssessionitem_2` (`idSalle`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `enseignant`
--

CREATE TABLE IF NOT EXISTS `enseignant` (
  `idEnseignant` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `prenomEnseignant` varchar(45) NOT NULL DEFAULT '',
  `nomEnseignant` varchar(45) NOT NULL DEFAULT '',
  `login` varchar(45) NOT NULL DEFAULT '',
  `mdp` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`idEnseignant`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

CREATE TABLE IF NOT EXISTS `etudiant` (
  `idEtudiant` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `prenomEtudiant` varchar(45) NOT NULL DEFAULT '',
  `nomEtudiant` varchar(45) NOT NULL DEFAULT '',
  `login` varchar(45) NOT NULL DEFAULT '',
  `mdp` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`idEtudiant`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `etudiant`
--

INSERT INTO `etudiant` (`idEtudiant`, `prenomEtudiant`, `nomEtudiant`, `login`, `mdp`) VALUES
(1, 'Lionel', 'Lienafa', 'llienafa', 'llienafa');

-- --------------------------------------------------------

--
-- Structure de la table `etudiantcourseval`
--

CREATE TABLE IF NOT EXISTS `etudiantcourseval` (
  `idEtudiant` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `idCoursSession` int(10) unsigned NOT NULL DEFAULT '0',
  `idEvalSession` int(10) unsigned NOT NULL DEFAULT '0',
  `noteEval` decimal(10,0) NOT NULL DEFAULT '0',
  `status` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`idEtudiant`,`idCoursSession`,`idEvalSession`),
  KEY `FK_etudiantcourseval_2` (`idCoursSession`),
  KEY `FK_etudiantcourseval_3` (`idEvalSession`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `evalsession`
--

CREATE TABLE IF NOT EXISTS `evalsession` (
  `idEvalSession` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `dateDebut` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `dateFin` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `idCoursSession` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`idEvalSession`),
  KEY `FK_evalsession_1` (`idCoursSession`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `inscriptionsession`
--

CREATE TABLE IF NOT EXISTS `inscriptionsession` (
  `idEtudiant` int(10) unsigned NOT NULL,
  `idCoursSession` int(10) unsigned NOT NULL,
  PRIMARY KEY (`idEtudiant`,`idCoursSession`),
  KEY `idCoursSession` (`idCoursSession`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `salle`
--

CREATE TABLE IF NOT EXISTS `salle` (
  `idSalle` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `libelleSalle` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`idSalle`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `salle`
--

INSERT INTO `salle` (`idSalle`, `libelleSalle`) VALUES
(1, 'B1-09'),
(2, 'A0-06'),
(3, 'B1-14'),
(4, 'D1-10');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `courssession`
--
ALTER TABLE `courssession`
  ADD CONSTRAINT `FK_courssession_1` FOREIGN KEY (`idCours`) REFERENCES `cours` (`idCours`);

--
-- Contraintes pour la table `courssessionitem`
--
ALTER TABLE `courssessionitem`
  ADD CONSTRAINT `FK_courssessionitem_1` FOREIGN KEY (`idEnseignant`) REFERENCES `enseignant` (`idEnseignant`),
  ADD CONSTRAINT `FK_courssessionitem_2` FOREIGN KEY (`idSalle`) REFERENCES `salle` (`idSalle`);

--
-- Contraintes pour la table `etudiantcourseval`
--
ALTER TABLE `etudiantcourseval`
  ADD CONSTRAINT `FK_etudiantcourseval_1` FOREIGN KEY (`idEtudiant`) REFERENCES `etudiant` (`idEtudiant`),
  ADD CONSTRAINT `FK_etudiantcourseval_2` FOREIGN KEY (`idCoursSession`) REFERENCES `courssession` (`idCoursSession`),
  ADD CONSTRAINT `FK_etudiantcourseval_3` FOREIGN KEY (`idEvalSession`) REFERENCES `evalsession` (`idEvalSession`);

--
-- Contraintes pour la table `evalsession`
--
ALTER TABLE `evalsession`
  ADD CONSTRAINT `FK_evalsession_1` FOREIGN KEY (`idCoursSession`) REFERENCES `courssession` (`idCoursSession`);

--
-- Contraintes pour la table `inscriptionsession`
--
ALTER TABLE `inscriptionsession`
  ADD CONSTRAINT `inscriptionsession_ibfk_3` FOREIGN KEY (`idCoursSession`) REFERENCES `courssession` (`idCoursSession`),
  ADD CONSTRAINT `inscriptionsession_ibfk_1` FOREIGN KEY (`idEtudiant`) REFERENCES `etudiant` (`idEtudiant`),
  ADD CONSTRAINT `inscriptionsession_ibfk_2` FOREIGN KEY (`idCoursSession`) REFERENCES `courssession` (`idCoursSession`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

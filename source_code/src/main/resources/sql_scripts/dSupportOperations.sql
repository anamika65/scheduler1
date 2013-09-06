CREATE TABLE IF NOT EXISTS dSupportOperations (
  `dSuppOpID` int(11) NOT NULL AUTO_INCREMENT,
  `OPSC01` varchar(30) DEFAULT NULL,
  `OPSC02` varchar(30) DEFAULT NULL,
  `OpDate` date DEFAULT NULL,
  `Op1` varchar(30) DEFAULT NULL,
  `Op2` varchar(30) DEFAULT NULL,
  `Ass1` varchar(30) DEFAULT NULL,
  `EntryDate` date NOT NULL,
  `CatalogID` int(11) NOT NULL, 
  `CatalogName` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`dSuppOpID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;


INSERT INTO `dsupportoperations` (`dSuppOpID`, `OPSC01`, `OPSC02`, `OpDate`, `Op1`, `Op2`, `Ass1`, `EntryDate`, `CatalogID`, `CatalogName`) VALUES
(1, '32', '44', '2000-10-01', 'NOVOTNY', '', '', '2013-02-01', 0, 'Not mapped'),
(2, '5-863.3', '5-849.3', '2003-01-26', 'GERTLER', '', '', '2013-03-24', 4, 'Difficult'),
(3, '5-399.5', '', '2012-08-30', 'RIEDER', '', 'GILLEN', '2013-03-24', 1, 'Blood vessel'),
(4, '5-403.03', '', '2012-08-30', 'FRIESS', '', 'NOVOTNY', '2013-03-24', 4, 'Difficult'),
(5, '5-484.35', '', '2012-08-30', 'NOVOTNY', '', '', '2013-03-24', 7, 'Stomache'),
(6, '5-491.3', '', '2012-08-30', 'FRIESS', '', '', '2013-03-24', 7, 'Stomache'),
(7, '5-491.3', '', '2012-08-30', 'RIEDER', 'GILLEN', 'GILLEN', '2013-03-24', 7, 'Stomache'),
(8, '5-547.0', '', '2012-08-30', 'SCHUHMACHE', '', 'FRIESS', '2013-03-24', 7, 'Stomache'),
(9, '5-555.1', '5-555.1', '2012-08-30', 'GILLEN', '', 'FRIESS', '2013-03-24', 4, 'Difficult'),
(10, '5-895.0B', '5-454.20', '2012-08-30', 'FRIESS', '', '', '2013-03-24', 4, 'Difficult'),
(12, '5-399.5', '', '2012-08-31', 'GERTLER', 'SCHUHMACHE', '', '2013-03-24', 1, 'Blood vessel'),
(14, '5-469.10', '5-541.2', '2012-08-31', 'GILLEN', 'SCHUHMACHE', '', '2013-03-24', 7, 'Stomache');

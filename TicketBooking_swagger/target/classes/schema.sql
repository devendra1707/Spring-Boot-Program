
CREATE TABLE IF NOT EXISTS `ticket` (
  `ticket_id` int(11) NOT NULL auto_increment,
  `booking_date` datetime NOT NULL,
  `dest_station` varchar(255) NOT NULL,
  `email` varchar(255) default NULL,
  `passenger_name` varchar(255) NOT NULL,
  `source_station` varchar(255) NOT NULL,
  PRIMARY KEY  (`ticket_id`)
) ;

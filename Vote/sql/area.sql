CREATE TABLE `area` (
  `electionID` varchar(10) NOT NULL DEFAULT '' COMMENT '選舉場次編號',
  `cityName` varchar(10) CHARACTER SET big5 NOT NULL DEFAULT '' COMMENT '縣市名稱',
  `name` varchar(20) CHARACTER SET big5 NOT NULL DEFAULT '' COMMENT '選區名稱',
  `citizen` int(11) DEFAULT '0' COMMENT '選舉人數',
  `participant` int(11) DEFAULT '0' COMMENT '投票人數',
  `validNum` int(11) DEFAULT '0' COMMENT '有效票數',
  `invalidNum` int(11) DEFAULT '0' COMMENT '無效票數',
  `votedNo` int(11) NOT NULL DEFAULT '0' COMMENT '候選人號次',
  `votes` int(11) DEFAULT '0' COMMENT '候選人得票數',
  PRIMARY KEY (`electionID`,`cityName`,`name`,`votedNo`)
) DEFAULT CHARSET='Big5';
CREATE TABLE `candidate` (
  `electionID` varchar(10) NOT NULL DEFAULT '' COMMENT '選舉場次編號',
  `cityName` varchar(10) CHARACTER SET big5 NOT NULL DEFAULT '' COMMENT '縣市名稱',
  `areaName` varchar(20) CHARACTER SET big5 NOT NULL DEFAULT '' COMMENT '選區名稱',
  `votedNo` int(11) NOT NULL DEFAULT '0' COMMENT '候選人號次',
  `name` varchar(20) CHARACTER SET big5 NOT NULL DEFAULT '' COMMENT '姓名',
  `partyName` varchar(20) CHARACTER SET big5 NOT NULL DEFAULT '' COMMENT '政黨',
  `votes` int(11) DEFAULT '0' COMMENT '候選人得票數',
  `elected` char(1) DEFAULT 'N' COMMENT '是否當選 (Y:當選,N:落選)', 
  PRIMARY KEY (`electionID`,`cityName`,`areaName`,`votedNo`)
) DEFAULT CHARSET='Big5';

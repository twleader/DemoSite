<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>選區投票結果查詢</title>
	<script type="type/javascript" src="../scripts/jquery-1.11.2.min.js"></script>
	<sj:head jqueryui="true"/>
</head>
<body>

<s:url var="findElection" action="findElection" />
<s:url var="findCityName" action="findCityName" />
<s:url var="findAreaName" action="findAreaName" />
<s:url var="remoteurl" action="showAreaResult" />
<s:url var="saveurl" action="saveVotes" />

<s:form id="formaAreaResult" theme="xhtml">
	<sj:select
		label="選舉場次"
        href="%{findElection}"
        id="electionID"
        name="electionID"
        list="electionList"
        emptyOption="false"
        headerKey="-1"
        headerValue="請選擇"
        onChangeTopics="reloadCityName"
    /> 

	<sj:select
		label="縣市"	
        href="%{findCityName}"
        id="cityName"
        name="cityName"
        list="cityNameList"
        emptyOption="false"
        headerKey="-1"
        headerValue="請選擇"
        reloadTopics="reloadCityName"
        onChangeTopics="reloadAreaName"
    /><br/>
        
	<sj:select
		label="選區"	
        href="%{findAreaName}"
        id="areaName"
        name="areaName"
        list="areaNameList"
        emptyOption="false"
        headerKey="-1"
        headerValue="請選擇"
        reloadTopics="reloadAreaName"
    />
    
    <sj:textfield label="得票數" id="votes" name="votes" />
</s:form>

        
    <sj:submit 
        href="%{remoteurl}"
        targets="showAreaResult" 
        value="查詢" 
        indicator="indicator"
        button="true"
    />
    
    <sj:submit 
        href="%{saveurl}"
        targets="showAreaResult" 
        value="儲存" 
        indicator="indicator"
        button="true"
    />

<br/><br/>

<sj:div id="showAreaResult" />

</body>
</html>
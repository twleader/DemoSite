<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>選區投票結果查詢</title>
	<sj:head jqueryui="true"/>
</head>
<body>

<s:url var="findElection" action="findElection" />
<s:url var="findCityName" action="findCityName" />
<s:url var="findAreaName" action="findAreaName" />
<s:url var="remoteurl" action="showAreaResult" />

<s:form id="formaAreaResult" theme="xhtml">
    選擇場次: 
	<sj:select
        href="%{findElection}"
        id="electionID"
        name="electionID"
        list="election"
        emptyOption="false"
        headerKey="-1"
        headerValue="請選擇"
        onChangeTopics="reloadCityName"
    /><br/>

	縣市: 
	<sj:select
        href="%{findCityName}"
        id="cityName"
        name="cityName"
        list="cityName"
        emptyOption="false"
        headerKey="-1"
        headerValue="請選擇"
        reloadTopics="reloadCityName"
    /><br/>
        
	選區: <sj:select
        href="%{findAreaName}"
        id="areaName"
        name="areaName"
        list="areaName"
        emptyOption="false"
        headerKey="-1"
        headerValue="請選擇"/><br/>
        
    <sj:submit 
        href="%{remoteurl}"
        targets="showAreaResult" 
        value="查詢" 
        indicator="indicator"
        button="true"
    />
    
</s:form>

<sj:div id="showAreaResult" />

</body>
</html>
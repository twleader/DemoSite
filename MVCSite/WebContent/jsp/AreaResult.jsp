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
<s:url var="remoteurl" action="showStock" />

<s:form id="formaAreaResult" theme="xhtml">
    
	<sj:select
        href="%{findElection}"
        id="echo"
        name="echo"
        list="electionID"
        emptyOption="false"
        headerKey="-1"
        headerValue="請選擇"/>

    <sj:submit 
        href="%{remoteurl}"
        targets="stockPrice" 
        value="送出" 
        indicator="indicator"
        button="true"
    />
    
</s:form>

<sj:div id="stockPrice" />

</body>
</html>
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

<s:url var="remoteurl" action="areaResult" />

<s:form id="formIndex" theme="xhtml">
    
</s:form>

    <sj:submit 
    	formIds="formIndex"
        href="%{remoteurl}"
        value="候選人得票查詢" 
        indicator="indicator"
        button="true"
    />


</body>
</html>
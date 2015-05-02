<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>

<script type="text/javascript">
$.subscribe('rowselect', function(event, data) {
	selRowId = event.originalEvent.id;
	votes = $('#gridtable').jqGrid ('getCell', selRowId, 'votes');
	$('#votes').val(votes);
});
</script>

<s:url var="remoteurl" action="findCandidate" />

<sjg:grid
        id="gridtable"
        caption="候選人得票統計"
        dataType="json"
        href="%{remoteurl}"
        pager="true"
        gridModel="candidateList"
        rowList="10,15,20"
        formIds="formaAreaResult"
        rowNum="15"
        rownumbers="true"
        viewrecords="true"
        shrinkToFit="true"
        onSelectRowTopics="rowselect"
    >
        <sjg:gridColumn name="electionID" index="electionID" title="選舉場次" sortable="false"/>
        <sjg:gridColumn name="cityName" index="cityName" title="縣市" sortable="false"/>
        <sjg:gridColumn name="areaName" index="areaName" title="選區" sortable="true"/>
        <sjg:gridColumn name="votedNo" index="votedNo" title="號次" sortable="true"/>
        <sjg:gridColumn name="name" index="name" title="姓名" sortable="true"/>
        <sjg:gridColumn name="partyName" index="partyName" title="黨籍" sortable="true"/>
        <sjg:gridColumn name="votes" index="votes" title="得票數" sortable="true"/>
        <sjg:gridColumn name="elected" index="elected" title="當選?" sortable="true"/>
    </sjg:grid>

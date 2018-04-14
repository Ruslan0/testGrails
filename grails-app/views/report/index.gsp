
<%@ page import="reporting.Report" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'report.label', default: 'Report')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-report" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><g:link controller='logout' action=''>Logout</g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-report" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="project" title="${message(code: 'report.project.label', default: 'Project')}" />
					
						<g:sortableColumn property="workdate" title="${message(code: 'report.workdate.label', default: 'Workdate')}" />
					
						<g:sortableColumn property="hours" title="${message(code: 'report.hours.label', default: 'Hours')}" />
					
						<g:sortableColumn property="descriptoin" title="${message(code: 'report.descriptoin.label', default: 'Descriptoin')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${reportInstanceList}" status="i" var="reportInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${reportInstance.id}">${fieldValue(bean: reportInstance, field: "project")}</g:link></td>
					
						<td><g:formatDate date="${reportInstance.workdate}" /></td>
					
						<td>${fieldValue(bean: reportInstance, field: "hours")}</td>
					
						<td>${fieldValue(bean: reportInstance, field: "descriptoin")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${reportInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>

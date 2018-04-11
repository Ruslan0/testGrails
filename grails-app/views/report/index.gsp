
<%@ page import="reporting.Report" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'report.label', default: 'Reports')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-report" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
				<li><g:link controller='logout' action=''>Logout</g:link></li>
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
					
						<g:sortableColumn property="name" title="${message(code: 'report.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="city" title="${message(code: 'report.city.label', default: 'City')}" />
					
						<g:sortableColumn property="startDate" title="${message(code: 'report.startDate.label', default: 'Start Date')}" />
					
						<g:sortableColumn property="endDate" title="${message(code: 'report.endDate.label', default: 'End Date')}" />
					
						<g:sortableColumn property="purpose" title="${message(code: 'report.purpose.label', default: 'Purpose')}" />
					
						<g:sortableColumn property="notes" title="${message(code: 'report.notes.label', default: 'Notes')}" />

						<g:sortableColumn property="user" title="${message(code: 'report.user.label', default: 'User')}" />

					</tr>
				</thead>
				<tbody>
				<g:each in="${reportInstanceList}" status="i" var="reportInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${reportInstance.id}">${fieldValue(bean: reportInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: reportInstance, field: "city")}</td>
					
						<td><g:formatDate date="${reportInstance.startDate}" /></td>
					
						<td><g:formatDate date="${reportInstance.endDate}" /></td>
					
						<td>${fieldValue(bean: reportInstance, field: "purpose")}</td>
					
						<td>${fieldValue(bean: reportInstance, field: "notes")}</td>

						<td>${fieldValue(bean: reportInstance, field: "user")}</td>

					</tr>
				</g:each>
        </tbody>
			</table>
			<div class="pagination">
				<g:paginate next="Forward" prev="Back" total="${reportInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>


<%@ page import="reporting.Report" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'report.label', default: 'Report')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-report" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-report" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list report">
			
				<g:if test="${reportInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="report.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${reportInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${reportInstance?.city}">
				<li class="fieldcontain">
					<span id="city-label" class="property-label"><g:message code="report.city.label" default="City" /></span>
					
						<span class="property-value" aria-labelledby="city-label"><g:fieldValue bean="${reportInstance}" field="city"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${reportInstance?.startDate}">
				<li class="fieldcontain">
					<span id="startDate-label" class="property-label"><g:message code="report.startDate.label" default="Start Date" /></span>
					
						<span class="property-value" aria-labelledby="startDate-label"><g:formatDate date="${reportInstance?.startDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${reportInstance?.endDate}">
				<li class="fieldcontain">
					<span id="endDate-label" class="property-label"><g:message code="report.endDate.label" default="End Date" /></span>
					
						<span class="property-value" aria-labelledby="endDate-label"><g:formatDate date="${reportInstance?.endDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${reportInstance?.purpose}">
				<li class="fieldcontain">
					<span id="purpose-label" class="property-label"><g:message code="report.purpose.label" default="Purpose" /></span>
					
						<span class="property-value" aria-labelledby="purpose-label"><g:fieldValue bean="${reportInstance}" field="purpose"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${reportInstance?.notes}">
				<li class="fieldcontain">
					<span id="notes-label" class="property-label"><g:message code="report.notes.label" default="Notes" /></span>
					
						<span class="property-value" aria-labelledby="notes-label"><g:fieldValue bean="${reportInstance}" field="notes"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:reportInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${reportInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>

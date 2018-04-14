
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
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
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
			
				<g:if test="${reportInstance?.project}">
				<li class="fieldcontain">
					<span id="project-label" class="property-label"><g:message code="report.project.label" default="Project" /></span>
					
						<span class="property-value" aria-labelledby="project-label"><g:fieldValue bean="${reportInstance}" field="project"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${reportInstance?.workdate}">
				<li class="fieldcontain">
					<span id="workdate-label" class="property-label"><g:message code="report.workdate.label" default="Workdate" /></span>
					
						<span class="property-value" aria-labelledby="workdate-label"><g:formatDate date="${reportInstance?.workdate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${reportInstance?.hours}">
				<li class="fieldcontain">
					<span id="hours-label" class="property-label"><g:message code="report.hours.label" default="Hours" /></span>
					
						<span class="property-value" aria-labelledby="hours-label"><g:fieldValue bean="${reportInstance}" field="hours"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${reportInstance?.descriptoin}">
				<li class="fieldcontain">
					<span id="descriptoin-label" class="property-label"><g:message code="report.descriptoin.label" default="Descriptoin" /></span>
					
						<span class="property-value" aria-labelledby="descriptoin-label"><g:fieldValue bean="${reportInstance}" field="descriptoin"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${reportInstance?.employer}">
				<li class="fieldcontain">
					<span id="employer-label" class="property-label"><g:message code="report.employer.label" default="Employer" /></span>
					
						<g:each in="${reportInstance.employer}" var="e">
						<span class="property-value" aria-labelledby="employer-label"><g:link controller="employer" action="show" id="${e.id}">${e?.encodeAsHTML()}</g:link></span>
						</g:each>
					
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

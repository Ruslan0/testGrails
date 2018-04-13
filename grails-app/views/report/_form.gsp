<%@ page import="reporting.Report" %>



<div class="fieldcontain ${hasErrors(bean: reportInstance, field: 'project', 'error')} required">
	<label for="project">
		<g:message code="report.project.label" default="Project" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="project" required="" value="${reportInstance?.project}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: reportInstance, field: 'workdate', 'error')} required">
	<label for="workdate">
		<g:message code="report.workdate.label" default="Workdate" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="workdate" precision="day"  value="${reportInstance?.workdate}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: reportInstance, field: 'hours', 'error')} required">
	<label for="hours">
		<g:message code="report.hours.label" default="Hours" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="hours" type="number" value="${reportInstance.hours}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: reportInstance, field: 'descriptoin', 'error')} required">
	<label for="descriptoin">
		<g:message code="report.descriptoin.label" default="Descriptoin" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="descriptoin" required="" value="${reportInstance?.descriptoin}"/>

</div>


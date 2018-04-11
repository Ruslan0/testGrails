<%@ page import="reporting.Report" %>



<div class="fieldcontain ${hasErrors(bean: reportInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="report.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${reportInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: reportInstance, field: 'city', 'error')} required">
	<label for="city">
		<g:message code="report.city.label" default="City" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="city" required="" value="${reportInstance?.city}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: reportInstance, field: 'startDate', 'error')} required">
	<label for="startDate">
		<g:message code="report.startDate.label" default="Start Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="startDate" precision="day"  value="${reportInstance?.startDate}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: reportInstance, field: 'endDate', 'error')} required">
	<label for="endDate">
		<g:message code="report.endDate.label" default="End Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="endDate" precision="day"  value="${reportInstance?.endDate}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: reportInstance, field: 'purpose', 'error')} required">
	<label for="purpose">
		<g:message code="report.purpose.label" default="Purpose" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="purpose" required="" value="${reportInstance?.purpose}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: reportInstance, field: 'notes', 'error')} required">
	<label for="notes">
		<g:message code="report.notes.label" default="Notes" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="notes" required="" value="${reportInstance?.notes}"/>

</div>


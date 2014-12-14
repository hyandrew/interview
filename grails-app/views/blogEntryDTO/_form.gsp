<%@ page import="interview.BlogEntryDTO" %>



<div class="fieldcontain ${hasErrors(bean: blogEntryDTOInstance, field: 'content', 'error')} required">
	<label for="content">
		<g:message code="blogEntryDTO.content.label" default="Content" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="content" required="" value="${blogEntryDTOInstance?.content}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: blogEntryDTOInstance, field: 'title', 'error')} required">
	<label for="title">
		<g:message code="blogEntryDTO.title.label" default="Title" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="title" required="" value="${blogEntryDTOInstance?.title}"/>

</div>



<%@ page import="interview.BlogEntryDTO" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'blogEntryDTO.label', default: 'BlogEntryDTO')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-blogEntryDTO" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-blogEntryDTO" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="content" title="${message(code: 'blogEntryDTO.content.label', default: 'Content')}" />
					
						<g:sortableColumn property="dateCreated" title="${message(code: 'blogEntryDTO.dateCreated.label', default: 'Date Created')}" />
					
						<g:sortableColumn property="title" title="${message(code: 'blogEntryDTO.title.label', default: 'Title')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${blogEntryDTOInstanceList}" status="i" var="blogEntryDTOInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${blogEntryDTOInstance.id}">${fieldValue(bean: blogEntryDTOInstance, field: "content")}</g:link></td>
					
						<td><g:formatDate date="${blogEntryDTOInstance.dateCreated}" /></td>
					
						<td>${fieldValue(bean: blogEntryDTOInstance, field: "title")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${blogEntryDTOInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>

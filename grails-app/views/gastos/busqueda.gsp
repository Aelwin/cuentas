<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'cuenta.label', default: 'Cuenta')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#list-cuenta" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="search" action="index"><g:message code="default.search.label" /></g:link></li>
            </ul>
        </div>
        <div id="list-cuenta" class="content scaffold-list" role="main">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <div>
                <span>
                    <g:message code="cuenta.fechaDesde.label" />
                    <g:formatDate format="dd-MM-yyyy" date="${params.fechaDesde}"/>
                </span>
                <span>
                    <g:message code="cuenta.fechaHasta.label" />
                    <g:formatDate format="dd-MM-yyyy" date="${params.fechaHasta}"/>
                </span>
            </div>
            <div>
                <span>
                    <g:message code="gastos.total.label" args="${gastoTotal}" />
                </span>
            </div>            
            <f:table collection="${gastos}" domainClass="jlr.Cuenta" properties="['id', 'nombre', 'tipo', 'importe', 'fecha', 'descripcion']"/>

            <div class="pagination">
                <g:paginate total="${gastosCount ?: 0}" />
            </div>
        </div>
    </body>
</html>
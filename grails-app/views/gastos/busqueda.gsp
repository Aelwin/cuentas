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
            <!--<f:table collection="${gastos}" domainClass="jlr.Cuenta" properties="['id', 'nombre', 'tipo', 'importe', 'fecha', 'descripcion']"/>-->
            <table>
                <thead>
                    <!--<g:each in="${grailsApplication.getDomainClass('jlr.Cuenta').persistentProperties}" var="p" status="i">
                        <g:set var="propTitle">cuenta.${p.name}.label</g:set>
                        <g:sortableColumn property="${p.name}" title="${message(code: propTitle, default: p.naturalName)}" />
                    </g:each>-->
                    <tr>
                        <g:sortableColumn property="fecha" title="${message(code: 'cuenta.fecha.label', default: 'Fecha')}" />
                        <g:sortableColumn property="importe" title="${message(code: 'cuenta.importe.label', default: 'Importe')}" />
                        <g:sortableColumn property="nombre" title="${message(code: 'cuenta.nombre.label', default: 'Nombre')}" />
                        <th>${message(code: 'cuenta.descripcion.label', default: 'Descripcion')}</th>
                    </tr>
                </thead>
                <tbody>
                    <g:each in="${gastos}" var="gastosInstance" status="i">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                            <td><g:formatDate format="dd/MM/yyyy" date="${gastosInstance.fecha}"/></td>
                            <td>${gastosInstance.importe}</td>
                            <td>${gastosInstance.nombre}</td>
                            <td>${gastosInstance.descripcion}</td>
                        </tr>
                    </g:each>
                </tbody>
            </table>
            <div class="pagination">
                <g:paginate total="${gastosCount ?: 0}" params="${params}"/>
            </div>
        </div>
    </body>
</html>
<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'cuenta.label', default: 'Cuenta')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
    	<div class="nav" role="navigation">
    		<ul>
                <li><g:link controller="cuenta" action="index">Cuenta</g:link></li>
                <li><g:link controller="gastos" action="index">Búsqueda</g:link></li>
                <li><g:link controller="graficas" action="gastosPorTipo">Gráficas</g:link></li>
            </ul>
    	</div>
    	<div id="principal" class="content" role="main">
    		<h1>Página inicial</h1>
    	</div>
    </body>
</html>
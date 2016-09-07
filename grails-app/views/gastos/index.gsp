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
        <div>
            <g:form name="buscarForm" action="busqueda">
                <fieldset class="form">
                    <h3>Buscar entre fechas:</h3>
                    <div>
                        <label class="fieldcontain" for="fechaDesde"><g:message code="cuenta.fechaDesde.label" /></label>
                        <g:datePicker name="fechaDesde"  precision="day" relativeYears="[5..-5]" default="none" noSelection="['':'--']" value="${filtroSoporte?.fechaDesde}"/>
                    </div>
                    <div>
                        <label class="fieldcontain" for="fechaHasta"><g:message code="cuenta.fechaHasta.label" /></label>
                        <g:datePicker name="fechaHasta"  precision="day" relativeYears="[5..-5]" default="none" noSelection="['':'--']" value="${filtroSoporte?.fechaHasta}"/>
                    </div>
                </fieldset>
                <fieldset class="form">
                    <h3>Buscar por tipo de gasto:</h3>
                    <div>
                        <label class="fieldcontain" for="nombreGasto"><g:message code="gasto.nombre.label" /></label>
                        <g:select name="nombreGasto" from="${nombreCuentaList}" noSelection="['':'Seleccione...']"></g:select>
                    </div>
                </fieldset>
                <fieldset class="buttons">
                    <g:submitButton name="buscar" class="search" value="${message(code: 'default.button.search.label')}" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>    
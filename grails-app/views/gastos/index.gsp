<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'cuenta.label', default: 'Cuenta')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
        <style type="text/css">            
            #fechaMes_year {
                display: none;
            }
            #fechas {
                display: flex;
            }
        </style>
        <script type="text/javascript">
            $(function() {                
                $("#fechaMes_month").change(function() {                    
                    $("#fechaMes_year").val(new Date().getFullYear());
                }); 
            });          
        </script>
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
                <div id="fechas">
                    <fieldset class="form">
                        <h3>Buscar entre fechas:</h3>
                        <div>
                            <label class="fieldcontain" for="fechaDesde"><g:message code="cuenta.fechaDesde.label" /></label>
                            <g:datePicker name="fechaDesde"  precision="day" relativeYears="[5..-5]" default="none" noSelection="['':'--']" />
                        </div>
                        <div>
                            <label class="fieldcontain" for="fechaHasta"><g:message code="cuenta.fechaHasta.label" /></label>
                            <g:datePicker name="fechaHasta"  precision="day" relativeYears="[5..-5]" default="none" noSelection="['':'--']" />
                        </div>
                    </fieldset>
                    <fieldset class="form">
                        <h3>Buscar por mes:</h3>
                        <div>
                            <label class="fieldcontain" for="fechaMes"><g:message code="cuenta.fechaMes.label" /></label>
                            <g:datePicker name="fechaMes"  precision="month" relativeYears="[0..0]" default="none" noSelection="['':'--']" />
                        </div>
                    </fieldset>
                </div>
                <fieldset class="form">
                    <h3>Buscar por tipo de gasto:</h3>
                    <div>
                        <label class="fieldcontain" for="nombreGasto"><g:message code="gasto.nombre.label" /></label>
                        <g:select name="nombreGasto" from="${nombreCuentaList}" noSelection="['':'Seleccione...']"></g:select>
                    </div>
                </fieldset>
                <fieldset class="form">
                    <h3>Buscar por descripción:</h3>
                    <div>
                        <label class="fieldcontain" for="descripcion"><g:message code="gasto.descripcion.label" /></label>
                        <g:textField name="descripcion"  placeholder="${message(code: 'gasto.descripcion.buscar')}"/>
                    </div>
                </fieldset>
                <fieldset class="buttons">
                    <g:submitButton name="buscar" class="search" value="${message(code: 'default.button.search.label')}" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>    
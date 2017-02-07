<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'grafica.label', default: 'Gráficas')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
        <g:javascript library='jquery' />
        <asset:javascript src="Chart.js"/>
        <script>
            var chartData = {};
            $(function() {
                respondCanvas();
                cargarGrafica();
            });

            function respondCanvas() {
                var ctx = $("#miGrafica");
                var miGrafica = new Chart(ctx, {
                    type: 'line',
                    data: chartData
                });
            }

            function cargarGrafica() {
                $.ajax({
                    url: 'rellenarDatos',
                    method: 'POST',
                    dataType: 'json',
                    data: {'nombreCuenta': $("#nombreCuenta option:selected").val()},
                    success: function (d) {
                       chartData = {
                            labels: d.etiquetas,
                            datasets: [{
                                data: d.datos,
                                label: $("#nombreCuenta option:selected").text(),
                                backgroundColor: 'rgba(255, 0, 0, 0.5)' //rojo
                            }]
                       };
                       respondCanvas();
                    }
                });
            }
        </script>
    </head>
    <body>
        <a href="#list-cuenta" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><a href="${createLink(action: 'compararGastosPorTipo')}"><g:message code="graficas.compararGastos"/></a></li>
            </ul>
        </div>
        <div class="content" role="main">
            <div class="fieldcontain">
                <label for="nombreCuenta">Tipo:</label>
                <g:select id="nombreCuenta" name="nombreCuenta" from="${jlr.NombreCuenta.list()}" optionValue="nombre" optionKey="id" onchange="cargarGrafica()"/>
            </div>
            <canvas id="miGrafica" height="210"></canvas>
        </div>
    </body>
</html>
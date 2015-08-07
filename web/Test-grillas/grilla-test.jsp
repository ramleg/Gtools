<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Test Grilla</title>
    
    <link rel="stylesheet" type="text/css" href="../resources/css/css-pruebas/demos.css" />

    <link rel="stylesheet" type="text/css" href="../resources/css/css-pruebas/jsgrid.css" />
    <link rel="stylesheet" type="text/css" href="../resources/css/css-pruebas/theme.css" />

    <script src="../resources/js/JQuery/jquery-2.1.4.js"></script>
    <script src="db.js"></script>

    <script src="../resources/js/js-pruebas/jsgrid.core.js"></script>
    <script src="../resources/js/js-pruebas/jsgrid.load-indicator.js"></script>
    <script src="../resources/js/js-pruebas/jsgrid.load-strategies.js"></script>
    <script src="../resources/js/js-pruebas/jsgrid.sort-strategies.js"></script>
    <script src="../resources/js/js-pruebas/jsgrid.field.js"></script>
    <script src="../resources/js/js-pruebas/jsgrid.field.text.js"></script>
    <script src="../resources/js/js-pruebas/jsgrid.field.number.js"></script>
    <script src="../resources/js/js-pruebas/jsgrid.field.select.js"></script>
    <script src="../resources/js/js-pruebas/jsgrid.field.checkbox.js"></script>
    <script src="../resources/js/js-pruebas/jsgrid.field.control.js"></script>
</head>
<body>
    <h1>Testeo de grilla</h1>
    <div id="jsGrid"></div>

    <script>
        $(function() {

            $("#jsGrid").jsGrid({
                height: "70%",
                width: "80%",
                filtering: true,
                editing: true,
                sorting: true,
                paging: true,
                autoload: true,
                pageSize: 15,
                pageButtonCount: 5,
                deleteConfirm: "Do you really want to delete the client?",
                controller: db,
                fields: [
                    { name: "OU Org", type: "select", items: db.ouorg, valueField: "Id", textField: "Name", width: 100 },
                    { name: "Positions", type: "text", width: 100},
                    { type: "control" }
                ]
            });

        });
    </script>
</body>
</html>



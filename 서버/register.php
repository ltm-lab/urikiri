<?php 
    require('./database.php');

    $n = mysql_fetch_array(mysql_query("SELECT * FROM `users` ORDER BY num DESC"));
    $num = ++$n['num'];

    mysql_query("INSERT INTO `users` (num, id, name, platform, fr_code) VALUES ('$num', '".mysql_real_escape_string($_POST["id"])."', '".mysql_real_escape_string($_POST["name"])."', '".mysql_real_escape_string($_POST["platform"])."', '".mysql_real_escape_string($_POST["id"])."')");

    $response = array();
    $response["success"] = true;

    echo json_encode($response);
?>
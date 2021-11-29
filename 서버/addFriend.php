<?php 
    require('./database.php');

    $n = mysql_fetch_array(mysql_query("SELECT * FROM `friends` ORDER BY num DESC"));
    $num = ++$n['num'];

    mysql_query("INSERT INTO `friends` (num, sender, receiver, status) VALUES ('$num', '".mysql_real_escape_string($_POST["sender"])."', '".mysql_real_escape_string($_POST["receiver"])."', '0')");

    $response = array();
    $response["success"] = true;

    echo json_encode($response);
?>
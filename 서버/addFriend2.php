<?php 
    require('./database.php');

    $friends1 = mysql_fetch_array(mysql_query("SELECT * FROM `users` WHERE id = '".mysql_real_escape_string($_POST["sender"])."'"));

    if($friends1["friends"] == "") {
        mysql_query("UPDATE `users` SET `friends`='".mysql_real_escape_string($_POST["receiver"])."' WHERE id = '".mysql_real_escape_string($_POST["sender"])."'");
    } else {
        $friends1["friends"] .= ",".mysql_real_escape_string($_POST["receiver"]);
        mysql_query("UPDATE `users` SET `friends`='".$friends1["friends"]."' WHERE id = '".mysql_real_escape_string($_POST["sender"])."'");
    }

    $friends2 = mysql_fetch_array(mysql_query("SELECT * FROM `users` WHERE id = '".mysql_real_escape_string($_POST["receiver"])."'"));

    if($friends2["friends"] == '') {
        mysql_query("UPDATE `users` SET `friends`='".mysql_real_escape_string($_POST["sender"])."' WHERE id = '".mysql_real_escape_string($_POST["receiver"])."'");
    } else {
        $friends2["friends"] .= ",".mysql_real_escape_string($_POST["sender"]);
        mysql_query("UPDATE `users` SET `friends`='".$friends2["friends"]."' WHERE id = '".mysql_real_escape_string($_POST["receiver"])."'");
    }

    $response = array();
    $response["success"] = true;

    echo json_encode($response);
?>
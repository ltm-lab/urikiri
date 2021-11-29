<?php 
    require('./database.php');

    $user = mysql_fetch_array(mysql_query("SELECT * FROM `users` WHERE id = '".mysql_real_escape_string($_POST["userid"])."'"));

    $friend = explode(',', $user['friends']);
    $friends = [];
    $j = 0;

    for($i=0;$i<count($friend); $i++) {
        if($friend[$i] != $_POST["delid"]) {
           $friends[$j] = $friend[$i];
           $j++;
        }
    }

    $friends = implode(',', $friends);

    mysql_query("UPDATE `users` SET `friends`='$friends' WHERE id = '".mysql_real_escape_string($_POST["userid"])."'");

    $response = array();
    $response["success"] = true;

    echo json_encode($response);
?>
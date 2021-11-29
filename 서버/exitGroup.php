<?php 
    require('./database.php');

    $user = mysql_fetch_array(mysql_query("SELECT * FROM `users` WHERE id = '".mysql_real_escape_string($_POST["userid"])."'"));

    $group = explode(',', $user['groups']);
    $groups = [];
    $j = 0;

    for($i=0;$i<count($group); $i++) {
        if($group[$i] != $_POST["groupid"]) {
           $groups[$j] = $group[$i];
           $j++;
        }
    }

    $groups = implode(',', $groups);

    mysql_query("UPDATE `users` SET `groups`='$groups' WHERE id = '".mysql_real_escape_string($_POST["userid"])."'")

    $response = array();
    $response["success"] = true;

    echo json_encode($response);
?>
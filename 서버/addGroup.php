<?php 
    require('./database.php');

    $n = mysql_fetch_array(mysql_query("SELECT * FROM `groups` ORDER BY num DESC"));
    $num = ++$n['num'];

    function generateRandomString($length = 10) { 
        $characters = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ'; 
        $charactersLength = strlen($characters); 
        $randomString = ''; 

        for ($i = 0; $i < $length; $i++) { 
            $randomString .= $characters[mt_rand(0, $charactersLength - 1)]; 
        } 
        
        return $randomString; 
    }

    $code = generateRandomString();

    mysql_query("INSERT INTO `groups` (num, title, subtitle, members, code) VALUES ('$num', '".mysql_real_escape_string($_POST["title"])."', '".mysql_real_escape_string($_POST["subtitle"])."', '".mysql_real_escape_string($_POST["members"])."', '$code')");

    $users = explode(',', $_POST['members']);

    for($i=0;$i<count($users);$i++) {
        $group = mysql_fetch_array(mysql_query("SELECT * FROM `users` WHERE id = '".$users[$i]."'"));

        if($group["groups"] == '') {
            mysql_query("UPDATE `users` SET `groups`='$num' WHERE id = '".$users[$i]."'")
        } else {
            $group["groups"] .= ",".$num
            mysql_query("UPDATE `users` SET `groups`='".$group["groups"]."' WHERE id = '".$users[$i]."'")
        }
    }

    $response = array();
    $response["success"] = true;

    echo json_encode($response);
?>
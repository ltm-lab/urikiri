<?php 
    require('./database.php');

    $result = '';

    $query = mysql_query("SELECT * FROM `users` WHERE id = '".mysql_real_escape_string($_POST["userid"])."'");
    $friends = mysql_fetch_array($query);
    $friends = explode(',', $friends['friends']);

    for($i=0; $i<count($friends); $i++) {
        $query = mysql_query("SELECT * FROM `users` WHERE id = '".$friends[$i]."'");
        $friends = mysql_fetch_array($query);
        $result .= $info['name'];
        
        if($i != count($friends)) {
            $result .= "|";
        }
    }
    
    echo $result;
?>
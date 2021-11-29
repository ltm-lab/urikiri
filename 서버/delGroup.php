<?php 
    require('./database.php');

    mysql_query("DELETE FROM `groups` WHERE num = '".mysql_real_escape_string($_POST["groupNum"])."'");
?>
<?php
    $con = mysql_connect('localhost', 'urikiri', 'urkr2021@') or die('Couldn\'t connect to MySQL server');
    mysql_select_db('urikiri', $con) or die('Couldn\'t select the database');
?>
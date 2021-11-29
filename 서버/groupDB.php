<?php 
    require('./database.php');

    if($_POST['userid']) {
        $result = '';

        $query = mysql_query("SELECT * FROM `users` WHERE id = '".mysql_real_escape_string($_POST["userid"])."'");
        $groups = mysql_fetch_array($query);

        $groups = explode(',', $groups['groups']);

        for($i=0; $i<count($groups); $i++) {
            $query = mysql_query("SELECT * FROM `groups` WHERE num = '".$groups[$i]."'");
            $info = mysql_fetch_array($query);
            $result .= "[";
            $result .= $info['title'].",";
            $result .= $info['subtitle'].",";
            $result .= "1]";
        }
        
        echo $result;
    } else {
?>
        <!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>그룹 DB</title>
    </head>
    <body>
        <?php
            $groups = mysql_query("SELECT * FROM `groups`");
            while($arr = mysql_fetch_array($groups)) {
                echo '<br/><div>
                <p>
                <b>ID : </b> '.$arr['num'].'<br/>
                <b>Title : </b> '.$arr['title'].'<br/>
                <b>Subtitle : </b> '.$arr['subtitle'].'<br/>
                <b>Members : </b> '.$arr['members'].'<br/>
                <b>Code : </b> '.$arr['code'].'
                </p>
                </div>
                <br /><hr />';
            }
        ?>
    </body>
</html>

<?php
    }
?>

<?php
    //ENCODING
    mb_internal_encoding('UTF-8');
    mb_http_output('UTF-8');
    //SETTING VARIABLES
    $fname= $_POST['firstname'];
    $lname= $_POST['lastname'];
    $email_to= $_POST['email'];
    $campus= $_POST['campus'];
    $carrera= $_POST['carrera'];
    $id = '000200';
    $carrera= str_replace('"',' ',$carrera);
    //UPERCASE
    $fname = strtoupper($fname);
    $lname = strtoupper($lname);
    $email_to = strtoupper($email_to);
    //OPENING GILE
    $file = fopen("../database/registroAdminCESS.csv","a");
    $rows = count(file("../database/registroAdminCESS.csv"));
    $rows = ($rows -1) + 1;
    $id = $id + $rows;

    $form_data = array(array($id, $fname, $lname, $email_to, $campus,$carrera));
    
    foreach ($form_data as $line) {
      fputcsv($file, $line);
    }

    fclose($file);
    


    //mandar email
    //  $email_from = 'info@cess.edu.mx';
    //  $email_subject = "Registro completado";
    //  $email_body = "Bienvenido a la plataforma del CESS \n\n".
    //      "ID: Tu correo gmail institucional (john.doe@cess.edu.mx) \n".
    //      "Contraseña: Curso-2020 \n\n".
    //      "Entrar a la plataforma: https://moodle.cess.edu.mx \n";
    //  $headers = "From: $email_from \r\n";
    //  $headers .= "Reply-To: $email_to \r\n";

    //  mail($email_to,$email_subject,$email_body, $headers);
    
    header("Location: http://www.cess.edu.mx/")    
    
?>
  

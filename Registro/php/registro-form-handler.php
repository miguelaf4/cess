<?php
    $fname= $_POST['firstname'];
    $lname= $_POST['lastname'];
    $email_to= $_POST['email'];
    $campus= $_POST['campus'];
    $carrera= $_POST['carrera'];
    $id = '000200';
    $grupo= $_POST['cohort1'];

    $carrera= str_replace('"',' ',$carrera);

    
    $file = fopen("../database/registroCESS.csv","a");
    $rows = count(file("../database/registroCESS.csv"));
    $rows = ($rows -1) + 1;
    $id = $id + $rows;

    $form_data = array(
      array( $id, $fname, $lname, $email_to,'Curso-2020', $campus,$carrera)
    );

    foreach ($form_data as $line) {
      fputcsv($file, $line);
    }

    fclose($file);
    


    //mandar email
     $email_from = 'info@cess.edu.mx';
     $email_subject = "Registro completado";
     $email_body = "Bienvenido a la plataforma del CESS \n\n".
         "ID: Tu correo gmail institucional (john.doe@cess.edu.mx) \n".
         "Contraseña: Curso-2020 \n\n".
         "Entrar a la plataforma: https://moodle.cess.edu.mx \n";
     $headers = "From: $email_from \r\n";
     $headers .= "Reply-To: $email_to \r\n";

     mail($email_to,$email_subject,$email_body, $headers);
    
    header("Location: http://www.cess.edu.mx/")    
    
?>
  

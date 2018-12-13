<?php

$data['host'] ='Mail.Cloudservicesme.com';
$data['type'] = 'pop3 or imap';
$data['protocol_type'] = 'ssl or tls or none';
$data['port'] = '993 or 995';
$data['login_name'] = 'arun@kryptolabs.com';
$data['password'] = 'P@ssw0rd';

public function testconnectionAction()
    {

        $data = $_POST;


        if($data['type'] == 'pop3' && $data['protocol_type'] == 'none')
        {
               $hostname = '{'.$data['host'].':'.$data['port'].'/pop3}INBOX';
             $username = $data['login_name'];
              $password = $data['password'];
            $imap = imap_open($hostname,$username,$password)or die(imap_last_error());

            if (!imap_ping($imap)) {
                echo "Test Failed.";
                }else{
                      echo "Test Successfull.";
                }
        }elseif($data['type'] == 'imap' && $data['protocol_type'] == 'none') {
             $hostname = '{'.$data['host'].':'.$data['port'].'}INBOX';
             $username = $data['login_name'];
              $password = $data['password'];
            $imap = imap_open($hostname,$username,$password);
            if (!imap_ping($imap)) {
                echo "Test Failed.";
                }else{
                      echo "Test Successfull.";
                }
        }
      if($data['type'] == 'pop3' && $data['protocol_type'] == 'ssl')
      {
             $hostname = '{'.$data['host'].':'.$data['port'].'/pop3/ss}INBOX';
             $username = $data['login_name'];
             $password = $data['password'];
            $imap = imap_open($hostname,$username,$password);
      //  
            if (!imap_ping($imap)) {
                echo "Test Failed.";
                }else{
                      echo "Test Successfull.";
                }
      }
      if($data['type'] == 'imap' && $data['protocol_type'] == 'ssl')
      {
        $hostname = '{'.$data['host'].':'.$data['port'].'/imap/ssl/novalidate-cert}INBOX';
        $username = $data['login_name'];
        $password = $data['password'];

/* try to connect */
        $inbox = imap_open($hostname,$username,$password);

            if (!imap_ping($inbox)) {
                echo "Test Failed.";
                }else{
                      echo "Test Successfull.";
                }
      }

       if($data['type'] == 'pop3' && $data['protocol_type'] == 'tls')
      {
             $hostname = '{'.$data['host'].':'.$data['port'].'/pop3/tls}INBOX';
             $username = $data['login_name'];
             $password = $data['password'];
             $imap = imap_open($hostname,$username,$password)or die(imap_last_error());
            if (!imap_ping($imap)) {
                echo "Test Failed.";
                }else{
                      echo "Test Successfull.";
                }
      }
      if($data['type'] == 'imap' && $data['protocol_type'] == 'tls')
      {
        $hostname = '{'.$data['host'].':'.$data['port'].'/imap/tls}INBOX';
             $username = $data['login_name'];
             $password = $data['password'];
             $imap = imap_open($hostname,$username,$password);

            if (!imap_ping($imap)) {
                echo "Test Failed.";
                }else{
                      echo "Test Successfull.";
                }
      }

    }

?>

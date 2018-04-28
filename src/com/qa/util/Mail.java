package com.qa.util;

/*import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.PasswordAuthentication;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;*/

public class Mail {
	
	
}
	/*final String username = "monekatyagi@gmail.com";
    final  String password = "m@9555154747";
    

    
public void sendEmail () throws IOException
{
       try {
    	  File file_screenshot = new File("Output_Folder//Output.zip");
           file_screenshot.delete();
           
    	   File srcFile = new File("Output_Folder//Screenshots");
    	   File[] files = srcFile.listFiles();
    	   
    	   
    	   FileOutputStream fos = new FileOutputStream("Output_Folder//Output.zip");
    	   ZipOutputStream zos = new ZipOutputStream(fos);
       
       for(int i=0;i<files.length;i++) {
    	   byte[] buffer = new byte[1024];
    	   FileInputStream fis = new FileInputStream(files[i]);
    	   zos.putNextEntry(new ZipEntry(files[i].getName()));
    	   int length;
    	   while((length=fis.read(buffer))>0) {
    		   zos.write(buffer,0,length);
    	   }
    	   zos.closeEntry();
    	   fis.close();
       }
       zos.close();
       
       }
       catch(Exception e) {}
       
       
   
       
       
   Properties props = new Properties();
   props.put("mail.smtp.auth", true);
   props.put("mail.smtp.starttls.enable", true);
   props.put("mail.smtp.host", "smtp.gmail.com");
   props.put("mail.smtp.port", "587");

   Session session = Session.getInstance(props,new javax.mail.Authenticator() {
               protected PasswordAuthentication getPasswordAuthentication() {
                   return new PasswordAuthentication(username, password);
               }
           });

   try {

       Message message = new MimeMessage(session);
       message.setFrom(new InternetAddress(username));
      
       
       message.setRecipients(Message.RecipientType.TO,
               InternetAddress.parse("monekatyagi@gmail.com"));
      
       message.setRecipients(Message.RecipientType.CC,
               InternetAddress.parse("monikatyagi7335@gmail.com"));
       
       message.setRecipients(Message.RecipientType.BCC,
               InternetAddress.parse("joshikavita256@gmail.com"));
       
       
       
       
       message.setSubject("Automation Suite Report");
       message.setText("Please find the attached Automation Suite Report");

       // Handle attachment 1
       MimeBodyPart messageBodyPart1 = new MimeBodyPart();
       messageBodyPart1.attachFile("Output_Folder//Output.zip");

       // Handle attachment 2
       MimeBodyPart messageBodyPart2 = new MimeBodyPart();
       messageBodyPart2.attachFile("Output_Folder//OutputReport.txt");

       MimeMultipart multipart = new MimeMultipart("related");

       multipart.addBodyPart(messageBodyPart1);
       multipart.addBodyPart(messageBodyPart2);

       message.setContent(multipart);

       // Send message
       Transport.send(message);
      
   } catch (MessagingException e) {
       e.printStackTrace();
   }

}



}
*/
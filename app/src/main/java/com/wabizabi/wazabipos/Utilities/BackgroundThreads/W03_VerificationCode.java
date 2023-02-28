package com.wabizabi.wazabipos.Utilities.BackgroundThreads;

import android.content.Context;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.wabizabi.wazabipos.Database.RealmSchemas.RealmUser;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import io.realm.Realm;

public class W03_VerificationCode extends Worker {
    public W03_VerificationCode(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        try(Realm realm = Realm.getDefaultInstance()){
            RealmUser user = realm.where(RealmUser.class).findFirst();
            String sender = "wazabimailer@gmail.com";
            String authenticator = "bbdpuntwhznunolf";
            String recipient = user.getEmail();
            StringBuffer s = new StringBuffer("Wazabi Mailer Here!\n");
            s.append("\n");
            s.append("ーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーー\n");
            s.append("ーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーー\n");
            s.append("A request was recieved from " + Build.MANUFACTURER + " - " + Build.PRODUCT + "\n\n");
            s.append(user.getVerficationCode() +  " is your Verification Code for the Wazabi App\n");
            s.append("\n");
            s.append("To ensure the safety of your account, please change the password immediately after successfully logging into your device.\n");
            s.append("Have a good day!");
            String password = s.toString();

            Properties properties = new Properties();
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", "587");
            Session session = Session.getInstance(properties, new javax.mail.Authenticator(){
                @Override
                protected PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication(sender, authenticator);
                }
            });
            try{
                Message mail = new MimeMessage(session);
                mail.setFrom(new InternetAddress(sender));
                mail.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
                mail.setSubject("Verification Code");
                mail.setText(password);
                Transport.send(mail);
            } catch (MessagingException e){
                throw new RuntimeException(e);
            }
        }
        return Result.success();
    }
}

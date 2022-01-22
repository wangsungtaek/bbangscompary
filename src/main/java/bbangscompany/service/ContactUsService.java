package bbangscompany.service;

import bbangscompany.domain.ContactUs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ContactUsService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void contactUs(ContactUs contactUs) {
        String content = "";

        // 수신 대상을 담을 ArrayList 생성
        ArrayList<String> toUserList = new ArrayList<>();

        // 수신 대상 추가
        toUserList.add("tjdxorv@naver.com");
        toUserList.add("bbangs_blog@naver.com");

        // 수신 대상 개수
        int toUserSize = toUserList.size();

        // SimpleMailMessage (단순 텍스트 구성 메일 메시지 생성할 때 이용)
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        // 수신자 설정
        simpleMailMessage.setTo((String[]) toUserList.toArray(new String[toUserSize]));

        // 메일 제목
        simpleMailMessage.setSubject("[ 빵스컴퍼니 문의 ] " + contactUs.getSubject());

        // 메일 내용
        content = "이름 : " + contactUs.getName() + "\n이메일 : " + contactUs.getEmail() + "\n내용 : " + contactUs.getMessage();
        simpleMailMessage.setText(content);

        // 메일 발송
        javaMailSender.send(simpleMailMessage);
    }
}

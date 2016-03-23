package net.anyjava.jpa.service;

import net.anyjava.SpringDemoApplication;
import net.anyjava.jpa.domain.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * Created by anyjava on 2016. 3. 23..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringDemoApplication.class)
@Transactional
public class MemberServiceTest {

    @Autowired MemberService memberService;

    @Test
    public void join() throws Exception {

        // Given
        Member member = new Member();
        member.setName("SON");

        // When
        Long memberId = memberService.join(member);

        // Then
        assertEquals(member, memberService.findOne(memberId));

    }

    @Test(expected = IllegalStateException.class)
    public void 중복회원가입() {

        // Given
        Member member1 = new Member();
        member1.setName("SON2");

        Member member2 = new Member();
        member2.setName("SON2");

        // When
        memberService.join(member1);
        memberService.join(member2);

        // Then
        fail("예외발생해야함");
    }
}
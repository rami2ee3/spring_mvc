package org.rami.sample;

import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SampleTests {

    @Autowired
    private Restaurant restaurant;

    @Autowired
    private SampleHotel hotel;

    @Test
    public void testHotel(){
        log.info(hotel);
    }

    @Test
    public void test1(){
        System.out.println("test1............");
        log.info("test11............");
        log.info(restaurant);
    }
}

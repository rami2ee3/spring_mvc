package org.zerock.sample;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

//의존성주입 종류 : 필드주입 setter주입 생성자주입
@Component
@ToString
@RequiredArgsConstructor
public class SampleHotel {

    private final Chef chef;


}

package org.zerock.sample;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@ToString
@RequiredArgsConstructor
public class Restaurant {

    private final Chef chef;
}

package org.rami.domain;

import lombok.Data;

@Data
public class NoticeVO {
    private int id;
    private String title;
    private String content;
    private String writer;
}

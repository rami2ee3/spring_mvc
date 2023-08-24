package org.rami.domain;

import lombok.Data;

import java.util.Date;
@Data
public class FormBoardVO {
    private int id;
    private String title;
    private String content;
    private String writer;
    private Date created_at;
    private Date updated_at;
    private boolean is_deleted;
}

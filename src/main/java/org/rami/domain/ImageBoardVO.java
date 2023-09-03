package org.rami.domain;

import lombok.Data;

import java.util.Date;

@Data
public class ImageBoardVO {
    private int id;
    private String title, content, writer;
    private Date created_at, updated_at;
    private boolean is_deleted;
}

package org.rami.domain;

import lombok.Data;

@Data
public class AjaxBoardReply2VO {
    private int id;
    private int ajax_board2_id;
    private String content;
    private String writer;
    private String created_at;
    private String updated_at;
    private boolean is_deleted;
}

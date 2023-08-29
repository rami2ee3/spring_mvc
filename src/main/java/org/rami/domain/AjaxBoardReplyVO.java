package org.rami.domain;

import lombok.Data;

@Data
public class AjaxBoardReplyVO {
    private int id;
    private int ajax_board_id;
    private String content;
    private String writer;
    private String created_at;
    private String updated_at;
    private boolean is_deleted;

}

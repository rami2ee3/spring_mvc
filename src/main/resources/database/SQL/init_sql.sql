-- auto-generated definition
CREATE TABLE ajax_board
(
    id         int AUTO_INCREMENT
        PRIMARY KEY,
    title      varchar(128)                         NULL,
    content    text                                 NULL,
    writer     varchar(32)                          NULL,
    created_at timestamp  DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at timestamp  DEFAULT CURRENT_TIMESTAMP NOT NULL ON UPDATE CURRENT_TIMESTAMP,
    is_deleted tinyint(1) DEFAULT 0                 NULL
);

create table ajax_board2
(
    id         int auto_increment
        primary key,
    title      varchar(128)                         null,
    writer     varchar(32)                          null,
    content    text                                 null,
    created_at timestamp  default CURRENT_TIMESTAMP null,
    updated_at timestamp  default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    is_deleted tinyint(1) default 0                 null
);


create table ajax_board_reply
(
    id            int auto_increment
        primary key,
    ajax_board_id int unsigned                         null comment '글번호',
    content       varchar(256)                         null,
    writer        varchar(32)                          null,
    created_at    timestamp  default CURRENT_TIMESTAMP null,
    updated_at    timestamp  default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP,
    is_deleted    tinyint(1) default 0                 null
)
    comment 'ajax게시판 답글 테이블';

create table ajax_board_reply2
(
    id             int auto_increment
        primary key,
    ajax_board2_id int unsigned                         null,
    content        varchar(256)                         null,
    writer         varchar(32)                          null,
    created_at     timestamp  default CURRENT_TIMESTAMP null,
    updated_at     timestamp  default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    is_deleted     tinyint(1) default 0                 null
);

create table borad
(
    id      int auto_increment
        primary key,
    title   varchar(128) null,
    content text         null
);

create table form_board
(
    id         int auto_increment comment '글 번호'
        primary key,
    title      varchar(64)                          null comment '제목',
    content    text                                 null comment '내용',
    writer     varchar(32)                          null comment '작성자',
    created_at timestamp  default CURRENT_TIMESTAMP not null comment '등록일시',
    updated_at timestamp  default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '수정일시',
    is_deleted tinyint(1) default 0                 null
)
    comment '폼액션 연습용 보드 테이블';


create table notice
(
    id      int auto_increment
        primary key,
    title   varchar(128) null comment '공지사항 제목',
    content text         null comment '공지사항 내용',
    writer  varchar(32)  null comment '작성자'
)
    comment '공지사항 테이블';

-- auto-generated definition
CREATE TABLE member
(
    id            int AUTO_INCREMENT
        PRIMARY KEY,
    user_id       varchar(32)                          NULL,
    user_pw       varchar(64)                          NULL,
    user_name     varchar(32)                          NULL,
    user_address  varchar(128)                         NULL,
    last_login_at timestamp  DEFAULT CURRENT_TIMESTAMP NULL,
    created_at    timestamp  DEFAULT CURRENT_TIMESTAMP NULL,
    updated_at    timestamp  DEFAULT CURRENT_TIMESTAMP NULL ON UPDATE CURRENT_TIMESTAMP,
    is_deleted    tinyint(1) DEFAULT 0                 NULL
);


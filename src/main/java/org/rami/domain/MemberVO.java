package org.rami.domain;

import lombok.Data;

import java.util.Date;

@Data
public class MemberVO {
    private int id;
    private String userId, userPw, userName, userAddress;
    private Date lastLoginAt, createdAt, updatedAt;
    private boolean isDeleted;
}

package com.ibk.interbank.apiexchangerate.entity.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginDTO {

    private String username;
    private String password;
}

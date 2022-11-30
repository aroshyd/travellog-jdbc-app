package com.example.demoapp.response;


import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorDto implements Serializable {

    private String friendlyMessage;

    private int code;

    private Boolean show;


    public ErrorDto(int code, String friendlyMessage) {
        this.code = code;
        this.friendlyMessage = friendlyMessage;
        this.show = true;
    }

    public ErrorDto(int code, String friendlyMessage, boolean show) {
        this.code = code;
        this.friendlyMessage = friendlyMessage;
        this.show = show;
    }




}

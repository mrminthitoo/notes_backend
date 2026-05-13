package com.mrminthitoo.notes_backend.utils.response;

import com.mrminthitoo.notes_backend.commons.enums.ErrorCodes;
import lombok.Data;

@Data
public class RESTResponser {

    String message;
    ErrorCodes errorCode;
    Object errors;
    Object data;
    String timeStamp;

}

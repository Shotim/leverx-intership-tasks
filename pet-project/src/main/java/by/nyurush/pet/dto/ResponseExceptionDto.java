package by.nyurush.pet.dto;

import lombok.Data;

@Data
public class ResponseExceptionDto {

    private String servletName;
    private String exceptionType;
    private String requestUri;
    private String exceptionMessage;
}

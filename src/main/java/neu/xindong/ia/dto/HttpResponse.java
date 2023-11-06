package neu.xindong.ia.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Data
/*
public class HttpResponse {
    private int code;
    private Object data;
    private String message;
}*/

public record HttpResponse<T>(
        int code, T data, String msg) {
    public static <T> HttpResponse<T> success(T data) {
        return new HttpResponse<T>(
                200, data, "请求成功"
        );
    }

    public static <T> HttpResponse<T> success() {
        return success(null);
    }

    public static <T> HttpResponse<T> failure(
            int code, String msg) {
        return new HttpResponse<T>(
                code, null, msg
        );
    }
}
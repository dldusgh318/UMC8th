package umc.spring.apiPayload.code.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import umc.spring.apiPayload.code.BaseErrorCode;
import umc.spring.apiPayload.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {

    //일반적 응답
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500","서보 에러, 관리자에게 문의 바람"),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST,"COMMON400","잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED,"COMMON401","인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청입니다."),


    // 멤버 관려 에러
    MEMBER_NOT_FOUND(HttpStatus.BAD_REQUEST, "MEMBER4001", "사용자가 없습니다."),
    NICKNAME_NOT_EXIST(HttpStatus.BAD_REQUEST, "MEMBER4002", "닉네임은 필수 입니다."),
    INVALID_PASSWORD(HttpStatus.BAD_REQUEST, "MEMBER4003", "패스워드가 불일치합니다."),
    DUPLICATE_JOIN_REQUEST(HttpStatus.BAD_REQUEST, "MEMBER4004", "해당 이메일로 이미 가입된 사용자가 존재합니다."),
    INVALID_TOKEN(HttpStatus.BAD_REQUEST, "MEMBER4005", "유효하지 않은 토큰입니다."),


    //
    ARTICLE_NOT_FOUND(HttpStatus.NOT_FOUND, "ARTICLE4001", "게시글이 없습니다."),
    TEMP_EXCEPTION(HttpStatus.BAD_REQUEST, "TEMP4001", "이거는 테스트"),

    FOOD_CATEGORY_NOT_FOUND(HttpStatus.NOT_FOUND,"FOODCATEGORY4001","음식 카테고리가 없습니다."),
    STORE_NOT_FOUND(HttpStatus.NOT_FOUND,"STORE4001","가게가 없습니다."),
    MISSION_NOT_FOUND(HttpStatus.NOT_FOUND,"MISSION4001","미션이 없습니다."),
    ALREADY_CHALLENGED_MISSION(HttpStatus.NOT_FOUND,"MISSION4002","미션에 이미 도전중입니다."),

    INVALID_PAGE(HttpStatus.BAD_REQUEST, "PAGE4001","유효한 페이지가 아닙니다."),

    ;


    private final HttpStatus status;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDTO getReason(){
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

    @Override
    public ErrorReasonDTO getReasonHttpStatus(){
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(status)
                .build();
    }
}

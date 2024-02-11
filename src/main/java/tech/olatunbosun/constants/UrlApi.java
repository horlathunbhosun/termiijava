package tech.olatunbosun.constants;


// This class is used to store the base url for the api and other endpoints
public class UrlApi {

    private static final String BASE_URL = "https://api.ng.termii.com/api/";
    // url for the api
    public  static final String GET_SENDER_ID_URL = BASE_URL + "sender-id";
    public static final String REQUEST_SENDER_ID_URL = BASE_URL + "sender-id/request";
    public static final String SEND_MESSAGE_URL = BASE_URL + "sms/send";
    public static final String SEND_BULK_MESSAGE_URL = BASE_URL + "sms/send/bulk";
    public static final String SEND_NUMBER_MESSAGE_URL = BASE_URL + "sms/number/send";
    public static final String SEND_TEMPLATE_MESSAGE_URL = BASE_URL + "sms/send/template";
    public static final String SEND_TOKEN_URL = BASE_URL + "sms/otp/send";
    public static final String VOICE_TOKEN_URL = BASE_URL + "sms/otp/send/voice";
    public static final String VOICE_CALL_URL = BASE_URL + "sms/otp/call";
    public static final String EMAIL_TOKEN_URL = BASE_URL + "email/otp/send";
    public static final String VERIFY_TOKEN_URL = BASE_URL + "sms/otp/verify";
    public static final String IN_APP_TOKEN_URL = BASE_URL + "sms/otp/generate";





}

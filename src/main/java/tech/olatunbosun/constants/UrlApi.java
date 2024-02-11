package tech.olatunbosun.constants;


// This class is used to store the base url for the api and other endpoints
public class UrlApi {

    private static final String BASE_URL = "https://api.ng.termii.com/api/";

    //
    public  static final String GET_SENDER_ID_URL = BASE_URL + "sender-id";
    public static final String REQUEST_SENDER_ID_URL = BASE_URL + "sender-id/request";

    public static final String SEND_MESSAGE_URL = BASE_URL + "sms/send";
    public static final String SEND_BULK_MESSAGE_URL = BASE_URL + "sms/send/bulk";




}

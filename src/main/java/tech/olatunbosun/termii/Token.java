package tech.olatunbosun.termii;

import org.json.JSONObject;
import tech.olatunbosun.constants.UrlApi;

import java.util.HashMap;

public class Token {
    private ApiCall apiCall;

    //send token
    //https://developer.termii.com/send-token
    public JSONObject sendToken(HashMap<String, Object> queryMap) {
        apiCall = new ApiCall(UrlApi.SEND_TOKEN_URL, queryMap);
        return apiCall.makePostRequest();
    }

    //send voice token
    //https://developer.termii.com/voice-token
    public JSONObject sendVoiceToken(HashMap<String, Object> queryMap) {
        apiCall = new ApiCall(UrlApi.VOICE_TOKEN_URL, queryMap);
        return apiCall.makePostRequest();
    }

    //send email token
    //https://developer.termii.com/email-token
    public JSONObject sendEmailToken(HashMap<String, Object> queryMap) {
        apiCall = new ApiCall(UrlApi.EMAIL_TOKEN_URL, queryMap);
        return apiCall.makePostRequest();
    }

    //send voice call
    //https://developer.termii.com/voice-call
    public JSONObject sendVoiceCall(HashMap<String, Object> queryMap) {
        apiCall = new ApiCall(UrlApi.VOICE_CALL_URL, queryMap);
        return apiCall.makePostRequest();
    }

    //verify token
    //https://developer.termii.com/verify-token
    public JSONObject verifyToken(HashMap<String, Object> queryMap) {
        apiCall = new ApiCall(UrlApi.VERIFY_TOKEN_URL, queryMap);
        return apiCall.makePostRequest();
    }

    //generate in-app token
    //https://developer.termii.com/in-app-token
    public JSONObject generateInAppToken(HashMap<String, Object> queryMap) {
        apiCall = new ApiCall(UrlApi.IN_APP_TOKEN_URL, queryMap);
        return apiCall.makePostRequest();
    }

}

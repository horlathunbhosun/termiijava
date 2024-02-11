package tech.olatunbosun.termii;

import org.json.JSONObject;
import tech.olatunbosun.constants.UrlApi;

import java.util.HashMap;

public class SenderID {

    private ApiCall apiCall;

   // https://developer.termii.com/sender-id
    //get all senderId
    public JSONObject getAllSenderId() {
        apiCall = new ApiCall(UrlApi.GET_SENDER_ID_URL, null);
        return apiCall.makeGetRequest();
    }

    // request for senderId
    public JSONObject requestSenderId(HashMap<String, Object> queryMap) {
        apiCall = new ApiCall(UrlApi.REQUEST_SENDER_ID_URL, queryMap);
        return apiCall.makePostRequest();
    }
}

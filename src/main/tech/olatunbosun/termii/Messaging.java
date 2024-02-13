package main.tech.olatunbosun.termii;

import org.json.JSONObject;
import main.tech.olatunbosun.constants.UrlApi;

import java.util.HashMap;
import java.util.List;

public class Messaging {

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


    //send message
    //https://developer.termii.com/messaging-api
    public JSONObject sendMessage(HashMap<String, Object> queryMap) {
        Object to = queryMap.get("to");
        if (to instanceof List) {
            List<String> toList = (List<String>) to;
            if (toList.size() > 100) {
                JSONObject errorJson = new JSONObject();
                errorJson.put("error", "Cannot send to more than 100 recipients at a time on this message endpoint. Use the sendBulkMessage method instead.");
                return errorJson;
            }
            for (int i = 0; i < toList.size(); i += 100) {
                int end = Math.min(i + 100, toList.size());
                List<String> subList = toList.subList(i, end);
                queryMap.put("to", subList);
                apiCall = new ApiCall(UrlApi.SEND_MESSAGE_URL, queryMap);
                apiCall.makePostRequest();
            }
        } else {
            apiCall = new ApiCall(UrlApi.SEND_MESSAGE_URL, queryMap);
            return apiCall.makePostRequest();
        }
        return null;
    }

    //send bulk message
    public JSONObject sendBulkMessage(HashMap<String, Object> queryMap) {

        Object to = queryMap.get("to");
        //check if to is a list else  return error that to must be a list
        if (to instanceof List) {
            List<String> toList = (List<String>) to;
            if (toList.size() > 10000) {
                JSONObject errorJson = new JSONObject();
                errorJson.put("error", "Cannot send to more than 10000 recipients at a time on this message endpoint");
                return errorJson;
            }
            for (int i = 0; i < toList.size(); i += 10000) {
                int end = Math.min(i + 10000, toList.size());
                List<String> subList = toList.subList(i, end);
                queryMap.put("to", subList);
                apiCall = new ApiCall(UrlApi.SEND_BULK_MESSAGE_URL, queryMap);
                apiCall.makePostRequest();
            }
        } else {
            JSONObject errorJson = new JSONObject();
            errorJson.put("error", "to must be a list of phone numbers");
            return errorJson;
        }
        return null;
    }

    //send message number api endpoint
    //https://developer.termii.com/number
    public JSONObject sendMessageNumberApi(HashMap<String, Object> queryMap) {
        apiCall = new ApiCall(UrlApi.SEND_NUMBER_MESSAGE_URL, queryMap);
        return apiCall.makePostRequest();
    }

    //send message template api endpoint
    //https://developer.termii.com/templates
    public JSONObject sendMessageTemplateApi(HashMap<String, Object> queryMap) {
        apiCall = new ApiCall(UrlApi.SEND_TEMPLATE_MESSAGE_URL, queryMap);
        return apiCall.makePostRequest();
    }


}

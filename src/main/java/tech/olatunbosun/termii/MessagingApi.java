package tech.olatunbosun.termii;

import org.json.JSONObject;
import tech.olatunbosun.constants.UrlApi;

import java.util.HashMap;
import java.util.List;

public class MessagingApi {

    private ApiCall apiCall;


    //send message
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


}

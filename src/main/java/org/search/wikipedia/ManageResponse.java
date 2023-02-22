package org.search.wikipedia;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.ArrayList;

public class ManageResponse {
    private ArrayList<PageInfo> pageInfos = new ArrayList<>();
    private String responseBody;

    public ManageResponse(String responsBody) {
        this.responseBody = responsBody;
    }

    public ArrayList<PageInfo> getInformation() {
        Gson gson = new Gson();
        JsonObject jsonResponse = gson.fromJson(responseBody, JsonObject.class);
        JsonObject query = jsonResponse.getAsJsonObject("query");
        for (int i = 0; i < query.getAsJsonArray("search").size(); i++) {
            JsonObject result = query.getAsJsonArray("search").get(i).getAsJsonObject();
            String title = result.get("title").getAsString();
            String snippet = result.get("snippet").getAsString().replaceAll("<[^>]*>", "");
            String pageId = result.get("pageid").getAsString();
            String url = "https://en.wikipedia.org/wiki?curid=" + pageId;
            PageInfo pageInfo = new PageInfo(title, snippet, url);
            pageInfos.add(pageInfo);

        }

        return pageInfos;
    }


}

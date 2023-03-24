package utils;

import com.google.common.base.Charsets;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;


public class JsonReader implements DataReader
{
    public Object[][] readData(String fileName)  {
        System.out.println("Json Reader has started!!!");
        File jsonFile = new File("./jsonData/"+fileName+".json");
        String jsonString = null;
        try {
            jsonString = FileUtils.readFileToString(jsonFile, Charsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();
        JsonObject jsonObj = gson.fromJson(jsonString, JsonObject.class);
        JsonArray jsonArray = jsonObj.getAsJsonArray("Sheet1");
        int i=0,j=0;
        int rowCount = jsonArray.size();
        int colCount =jsonArray.get(0).getAsJsonObject().size();
        Object[][] data = new Object[rowCount][colCount];

        for(i=0;i<rowCount;i++)
        {
            JsonObject singleJsonObject = jsonArray.get(i).getAsJsonObject();
            j=0;
            for (String key : singleJsonObject.keySet())
            {
                data[i][j] = singleJsonObject.get(key).toString().replace("\"","");
                j++;
            }
        }
        return data;
    }
}

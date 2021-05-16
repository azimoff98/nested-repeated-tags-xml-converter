package com.azercell.util;

import com.azercell.model.Wrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.json.XML;

import java.io.IOException;

@Slf4j
public class CustomConverter {

    private static final ObjectMapper MAPPER = new ObjectMapper();


    public static Wrapper doConvert(final String xml){
        final String json = fromXmlToJson(xml);
        return fromJsonToWrapper(json);
    }

    private static Wrapper fromJsonToWrapper(String json){
        Wrapper wrapper = new Wrapper();
        try{
            wrapper = MAPPER.readValue(json, Wrapper.class);
        }catch (IOException ex){
            log.error("Deserialization is unsuccessful ", ex);
        }
        return wrapper;
    }

    private static String fromXmlToJson(String xml){
        JSONObject jsonObject = XML.toJSONObject(xml);
        return jsonObject.toString(4);
    }

}

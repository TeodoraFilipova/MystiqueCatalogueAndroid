package com.example.mystiquecatalogue_android.repositories;



import com.example.mystiquecatalogue_android.http.HttpRequester;
import com.example.mystiquecatalogue_android.parsers.base.JsonParser;
import com.example.mystiquecatalogue_android.repositories.base.Repository;

import java.io.IOException;
import java.util.List;

public class HttpRepository<T> implements Repository<T> {
    private final HttpRequester mHttpRequester;
    private final String mServerUrl;
    private final JsonParser<T> mJsonParser;

    public HttpRepository(
            String serverUrl,
            HttpRequester httpRequester,
            JsonParser<T> jsonParser
    ) {
        mServerUrl = serverUrl;
        mHttpRequester = httpRequester;
        mJsonParser = jsonParser;
    }

    @Override
    public List<T> getAll() throws IOException {
        String jsonArray = null;
        jsonArray = mHttpRequester.get(mServerUrl);

        return mJsonParser.fromJsonArray(jsonArray);
    }

    @Override
    public T add(T item) throws IOException {
            String requestBody = mJsonParser.toJson(item);
            String responseBody = mHttpRequester.post(mServerUrl, requestBody);

            return mJsonParser.fromJson(responseBody);
    }

    @Override
    public T getById(int id) throws IOException {
        String url = mServerUrl + "/" + id;
        String json = null;
        json = mHttpRequester.get(url);
        return mJsonParser.fromJson(json);
    }

    @Override
    public T updateById(int id, T item) throws IOException {
        String url = mServerUrl + "/update/" + id;
        String requestBody = mJsonParser.toJson(item);
        String responseBody = mHttpRequester.put(url, requestBody);

        return mJsonParser.fromJson(responseBody);
    }
}

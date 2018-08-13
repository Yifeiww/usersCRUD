package com.yifei.db;

import org.json.JSONObject;

public interface DBConnection {


    /**
     * Get all the documents in a collection
     * @param collection
     * @return
     * @throws Exception
     */
    public JSONObject getCollection(String collection) throws Exception;

    /**
     * Get a single document in a collection by document id
     * @param collection
     * @param id
     * @return
     * @throws Exception
     */
    public JSONObject getDocument(String collection, String id) throws Exception;

    /**
     * Insert a new document to a collection
     * @param collection
     * @param newUser
     * @return
     * @throws Exception
     */
    public JSONObject addDocument(String collection, JSONObject newUser) throws Exception;


}

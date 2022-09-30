package services;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;


import java.util.ArrayList;
import java.util.Date;

public class MongoConnection {
    MongoClientURI uri;
    MongoClient mongoClient;

    public MongoConnection(){
        uri = new MongoClientURI("mongodb+srv://juan:juan@database.9fvhqx8.mongodb.net/?retryWrites=true&w=majority");
        mongoClient = new MongoClient(uri);
    }

    public void putMessage(Message message){
        mongoClient = new MongoClient(uri);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("database");
        MongoCollection<Document> collection = mongoDatabase.getCollection("colection");
        Document document = new Document();
        document.put("info",message.getInfo());
        document.put("date",message.getDate());
        collection.insertOne(document);
    }

    public ArrayList<Message> getMessages(){
        MongoDatabase mongoDatabase = mongoClient.getDatabase("database");
        MongoCollection<Document> collection = mongoDatabase.getCollection("colection");
        FindIterable findIterable = collection.find();
        ArrayList<Document> documents = new ArrayList<Document>();
        ArrayList<Message> messages = new ArrayList<Message>();
        for(Document doc: documents){
            if(doc.get("info") != null && doc.get("date") != null){
                messages.add(new Message((String) doc.get("info"),(Date) doc.get("date")));
            }
        }
        return messages;
    }

}

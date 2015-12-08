package com.cs319.graderppCore.storage;

import com.cs319.graderppCore.utils.Result;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 * Created by yusuf on 08-Dec-15.
 */
public class MongoCoreBinder {
    private MongoCollection<Document> _user_list, _course_list, _task_list, _submission_list;
    private  String[] _collection_keys = {"user_list", "course_list", "task_list", "submission_list"};
    private String[] _user_keys = {"_id", "name", "password", "full_name", "user_type",
            "course_list", "task_list", "submission_list"};
    private String[] _course_keys = {"_id", "name", "code", "instructor_id"};
    private String[] _task_keys = {"_id", "name", "course_id", "ta_id", "due_date",
            "count_test_case", "memory_size", "stack_size", "num_proceses", "time_limit"};

    private String[] _submission_keys = {"_id", "task_id", "student_id","due_date",
            "status", "compile_success", "compile_log", "grade_logs", "memory_sizes", "running_times"};

    public MongoCoreBinder(){
        MongoClient mongoClient = new MongoClient(
                new MongoClientURI("mongodb://root:graderpp@ds043694.mongolab.com:43694/graderpp"));
        MongoDatabase db = mongoClient.getDatabase("graderpp");

        //MongoClient mongoClient = new MongoClient("localhost");
        //MongoDatabase db = mongoClient.getDatabase("db0");

        _user_list = db.getCollection(_collection_keys[0]);
        _course_list = db.getCollection(_collection_keys[1]);
        _task_list = db.getCollection(_collection_keys[2]);
        _submission_list = db.getCollection(_collection_keys[3]);
    }

    public boolean updateDB(Result r, String submission_id){
        Document curr_submission = new Document("_id", new ObjectId(submission_id));

        Document new_submission = new Document();
        //new_submission.append(_submission_keys[3], );
        new_submission.append(_submission_keys[4], 2);
        new_submission.append(_submission_keys[5], r.isCompileSuccess());
        new_submission.append(_submission_keys[6], r.getCompileLog());
        new_submission.append(_submission_keys[7], r.getGrade_log());
        new_submission.append(_submission_keys[8], r.getMemory());
        new_submission.append(_submission_keys[9], r.getTime());

        UpdateResult ur = _submission_list.updateOne(curr_submission,
                new Document("$set", new_submission));

        return ur.getModifiedCount() == 1;

    }

    public int getTestCaseNum(String taskID) {
        FindIterable<Document> iterable = _task_list.find(new Document("_id", new ObjectId(taskID)));
        for(Document it: iterable) {
            return it.getInteger("count_test_case");
        }
        return 0;
    }

}


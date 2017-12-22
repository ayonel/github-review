package me.ayonel.github.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Author: ayonel
 * Date: 2017/12/9
 * Blog: https://ayonel.me
 * GitHub: https://github.com/ayonel
 * Email: ayonel@qq.com
 */
@Document(collection="pullpredict")
public class PullPredict {
    @Id
    private String id;

    private int number;
    private String org;
    private String repo;
    private double created_at;
    private double closed_at;
    private String title;
    private String submitted_by;
    private boolean merged;
    private boolean predict_merged;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getRepo() {
        return repo;
    }

    public void setRepo(String repo) {
        this.repo = repo;
    }

    public double getCreated_at() {
        return created_at;
    }

    public void setCreated_at(long created_at) {
        this.created_at = created_at;
    }

    public double getClosed_at() {
        return closed_at;
    }

    public void setClosed_at(long closed_at) {
        this.closed_at = closed_at;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubmitted_by() {
        return submitted_by;
    }

    public void setSubmitted_by(String submitted_by) {
        this.submitted_by = submitted_by;
    }

    public boolean isMerged() {
        return merged;
    }

    public void setMerged(boolean merged) {
        this.merged = merged;
    }


    public boolean getPredict_merged() {
        return predict_merged;
    }

    public void setPredict_merged(boolean predictMerged) {
        this.predict_merged = predictMerged;
    }

    @Override
    public String toString(){
        return "" + org + ":" + number;
    }
}

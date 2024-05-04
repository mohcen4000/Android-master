package com.uc2.dzprostatecare.pojo;

import java.io.Serializable;

public class Article implements Serializable {

    String articleName;
    String articleSummary;
    String articleContent;
    Boolean status;
    Integer imageUrl;

    public Article(String articleName, String articleSummary,String articleContent,Boolean status,Integer imageUrl) {
        this.articleName = articleName;
        this.articleSummary = articleSummary;
        this.articleContent=articleContent;
        this.status = status;
        this.imageUrl=imageUrl;
    }

    public String getArticleName() {
        return articleName;
    }

    public String getArticleSummary() {
        return articleSummary;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public Boolean getStatus() {
        return status;
    }

    public Integer getImageUrl() {
        return imageUrl;
    }


    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public void setArticleSummary(String articleSummary) {
        this.articleSummary = articleSummary;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }



}

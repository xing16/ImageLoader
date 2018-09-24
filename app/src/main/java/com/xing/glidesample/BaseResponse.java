package com.xing.glidesample;

import java.util.List;

public class BaseResponse {

    private boolean error;
    private List<MeiziBean> results;

    public BaseResponse() {
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<MeiziBean> getResults() {
        return results;
    }

    public void setResults(List<MeiziBean> results) {
        this.results = results;
    }


    @Override
    public String toString() {
        return "BaseResponse{" +
                "error=" + error +
                ", results=" + results +
                '}';
    }
}

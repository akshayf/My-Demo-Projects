package com.mvp.akshayfaye.supporting;

public interface GetQuoteInteractor {

    interface OnFinishedListener {
        void onFinished(String string);
    }

    void getNextQuote(OnFinishedListener listener);
}
package com.mvp.akshayfaye.mvp_demo;

public interface MainContract {

    interface MainView {
        void showProgress();

        void hideProgress();

        void setQuote(String string);
    }

    interface GetQuoteInteractor {
        interface OnFinishedListener {
            void onFinished(String string);
        }

        void getNextQuote(OnFinishedListener onFinishedListener);
    }

    interface MainPresenter {
        void onButtonClick();

        void onDestroy();
    }
}
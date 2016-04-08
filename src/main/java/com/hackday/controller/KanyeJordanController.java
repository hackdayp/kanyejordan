package com.hackday.controller;


import com.hackday.client.twitter.Tweet;
import com.hackday.client.twitter.TwitterClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class KanyeJordanController {

    @Autowired
    @Qualifier("twitterClient")
    private TwitterClient twitterClient;

    @RequestMapping("/kj")
    public String kanyeJordan(Map<String, Object> model) {
        List<Tweet> tweets = twitterClient.getTweets();
        for(Tweet tweet: tweets) {
            tweet.setText("Liz Lemon, " + tweet.getText());
        }
        model.put("tweets", tweets);
        return "kanyeJordan";
    }


    @RequestMapping("/test")
    public String test(Map<String, Object> model) {
        List<Tweet> tweets = twitterClient.getTweets();
        for(Tweet tweet: tweets) {
            tweet.setText("Liz Lemon, " + tweet.getText());
        }
        model.put("tweets", tweets);
        return "kanyeJordan";
    }

}

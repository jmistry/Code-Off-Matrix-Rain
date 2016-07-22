package com.prolificidea.codeoff.twitter;

import twitter4j.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jaisheel.Mistry on 2016/07/22.
 */
public class TweetSearcher {

    public static List<String> getTweets(){
        List<String> tweetList = new ArrayList<String>();
        Twitter twitter = new TwitterFactory().getInstance();
        try {
            String queryString = "%23icj2016";
            Query query = new Query(queryString);
            QueryResult result;
            do {
                result = twitter.search(query);
                List<Status> tweets = result.getTweets();
                for (Status tweet : tweets) {
                    String tweetString = "@" + tweet.getUser().getScreenName() + " - " + tweet.getText();
                    tweetList.add(tweetString);
                }
            } while ((query = result.nextQuery()) != null);
        } catch (TwitterException te) {
            tweetList.add("No tweets found ");
            tweetList.add("No tweets found , ah what a pity");
            tweetList.add("No tweets found , ah what a pity, this is quite sad");
        }

        return tweetList;
    }
}

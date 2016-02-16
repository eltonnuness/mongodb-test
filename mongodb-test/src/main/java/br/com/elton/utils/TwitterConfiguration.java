package br.com.elton.utils;

import java.util.List;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;


/**
 * 
 * Classe responsável por realizar consumo da API do TWITTER
 *
 * @author Elton
 * @since 16/02/2016
 * @version 1.0
 */
public class TwitterConfiguration {
	private static final String TWITTER_CONSUMER_KEY = "xxxxxxxxxxxxxxxxxx";
	private static final String TWITTER_SECRET_KEY = "xxxxxxxxxxxxxxxxxxxxxxxx";
	private static final String TWITTER_ACCESS_TOKEN = "xxxxxxxxxxxxxxxxxxxxx";
	private static final String TWITTER_ACCESS_TOKEN_SECRET = "xxxxxxxxxxxxxxxxx";

	public void config() {

		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey(TWITTER_CONSUMER_KEY)
				.setOAuthConsumerSecret(TWITTER_SECRET_KEY)
				.setOAuthAccessToken(TWITTER_ACCESS_TOKEN)
				.setOAuthAccessTokenSecret(TWITTER_ACCESS_TOKEN_SECRET);
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();
		try {
			List<Status> tweets = twitter.getHomeTimeline();
			for (Status tweet : tweets) {
				System.out.println("@" + tweet.getUser().getScreenName()
						+ " - " + tweet.getText());
			}
			System.exit(0);
		} catch (TwitterException te) {
			te.printStackTrace();
			System.out.println("Failed to search tweets: " + te.getMessage());
			System.exit(-1);
		}

	}

}

import 'dotenv/config';
import fetch from 'node-fetch';

const BEARER_TOKEN = process.env.BEARER_TOKEN;
const USERNAME = "erbmjha";  // Replace with the username you want to track

async function getLatestTweet(username) {
    const userUrl = `https://api.twitter.com/2/users/by/username/${username}?user.fields=id`;

    const userResponse = await fetch(userUrl, {
        method: "GET",
        headers: { "Authorization": `Bearer ${BEARER_TOKEN}` }
    });

    if (!userResponse.ok) {
        console.error("Error fetching user ID:", userResponse.status, await userResponse.text());
        return;
    }

    const userData = await userResponse.json();
    const userId = userData.data.id;

    const tweetsUrl = `https://api.twitter.com/2/users/${userId}/tweets?max_results=5&tweet.fields=public_metrics`;

    const tweetResponse = await fetch(tweetsUrl, {
        method: "GET",
        headers: { "Authorization": `Bearer ${BEARER_TOKEN}` }
    });

    if (!tweetResponse.ok) {
        console.error("Error fetching tweets:", tweetResponse.status, await tweetResponse.text());
        return;
    }

    const tweetData = await tweetResponse.json();
    if (!tweetData.data || tweetData.data.length === 0) {
        console.log("No tweets found.");
        return;
    }

    const latestTweet = tweetData.data[0];
    console.log(`Latest Tweet: ${latestTweet.text}`);
    console.log(`Likes: ${latestTweet.public_metrics.like_count}`);
    console.log(`Replies: ${latestTweet.public_metrics.reply_count}`);
}

getLatestTweet(USERNAME);

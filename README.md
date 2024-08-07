# Bundle Calculator

## Question Description

Social media Influencers have been basing the price of their social media post on a single post
basis. So If a brand required 10 posts (for example spread over a period) then they would be charged
10x the cost of a single post. One company has decided to allow social media influencers to sell
posts in bundles and charge the brand on a per bundle basis. So if the Influencer sold image based
posts in bundles of 5 and 10 and brand ordered 15 they would get a bundle of 10 and a bundle of 5.

The company currently allows the influencer to monitize the following submission formats:

Submission format | Format code | Bundles
----------------- | ----------- | -------
Image | IMG | 5 @ $450 10 @ $800
Audio | Flac | 3 @ $427.50 6 @ $810 9 @ $1147.50
Video | VID | 3 @ $570 5 @ $900 9 @ $1530

## Task

Given a brands order, you are required to determine the cost and bundle breakdown for each
submission format. **For simplicity, each order should contain the minimal number of bundles**.

### Input:

Each order has a series of lines with each line containing the number of items followed by the
submission format code An example post:

```
10 IMG
15 FLAC
13 VID
```

### Output:

A successfully passing test(s) that demonstrates the following bundleBreakdown: (The format of the bundleBreakdown is
not important)

```
10 IMG $800
  1 x 10 $800
15 FLAC $1957.50
  1 x 9 $1147.50
  1 x 6 $810
13 VID $2370
  2 x 5 $1800
  1 x 3 $570
```

## Requirements

* `Gradle` and `Lombok` has to be used in this code test
* Using `stream` and `lambda expression` when you can
* Use `log` instead of `system.out.println`
* Unit test is required

## Solution
The requirement says to get the 

## Run and Result

```
11 VID

Apr 28, 2021 4:43:02 PM com.codetest.ioprocessors.OutputProcess returnResultInfo
INFO: 11 $2040.0
Apr 28, 2021 4:43:02 PM java.util.ArrayList forEach
INFO: 2* $570.0
Apr 28, 2021 4:43:02 PM java.util.ArrayList forEach
INFO: 1* $900.0
```





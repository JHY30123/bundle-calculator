# Bundle Calculator

## Question Description

Social media Influencers have been basing the price of their social media post on a single post
basis. So If a brand required 10 posts (for example spread over a period) then they would be charged
10x the cost of a single post. One company has decided to allow social media influencers to sell
posts in bundles and charge the brand on a per bundle basis. So if the Influencer sold image based
posts in bundles of 5 and 10 and brand ordered 15 they would get a bundle of 10 and a bundle of 5.

The company currently allows the influencer to monitize the following submission formats:

| Submission format | Format code | Bundles                           |
|-------------------|-------------|-----------------------------------|
| Image             | IMG         | 5 @ $450 10 @ $800                |
| Audio             | Flac        | 3 @ $427.50 6 @ $810 9 @ $1147.50 |
| Video             | VID         | 3 @ $570 5 @ $900 9 @ $1530       |

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
In the requirement, the only restriction is the order should contain the minimal number of bundles. So, the problem can be converted
to a `Coin Change` problem.

The implementation is divided into three parts:
1. `BundleCalculator` - This class is responsible for calculating the minimum number of bundles for the given order.
2. `BundleProcessor` - This class is responsible for processing the order and calculating the cost and bundle breakdown for each submission format.
3. `OutputProcess` - This class is responsible for printing the output in the required format. All the required content is populated in the `BundleBreakdown` object.

## Run and Result

```
15 FLAC
13 VID
10 IMG

Aug 15, 2024 5:21:39 PM BundleCalculator lambda$main$0
INFO: BundleBreakdown(number=15, format=VID, totalPrice=2670.0, breakdownDetail=[2 x 3 $1140.0, 1 x 9 $1530.0])
Aug 15, 2024 5:21:39 PM BundleCalculator lambda$main$0
INFO: BundleBreakdown(number=15, format=FLAC, totalPrice=1957.5, breakdownDetail=[1 x 6 $810.0, 1 x 9 $1147.5])
Aug 15, 2024 5:21:39 PM BundleCalculator lambda$main$0
INFO: BundleBreakdown(number=13, format=VID, totalPrice=2370.0, breakdownDetail=[1 x 3 $570.0, 2 x 5 $1800.0])
Aug 15, 2024 5:21:39 PM BundleCalculator lambda$main$0
INFO: BundleBreakdown(number=10, format=IMG, totalPrice=800.0, breakdownDetail=[1 x 10 $800.0])
```





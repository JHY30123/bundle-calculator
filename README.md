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

The only constraint is that each order line should use the minimal number of bundles, so this is a
`Coin Change` (minimum coins) problem, solved with a bottom-up dynamic program.

The implementation is layered:
1. `BundleProcessor` — reads stdin and parses each line into an immutable `Post`.
2. `BundleService` — the stateless DP that finds the fewest bundle sizes summing exactly to the
   requested amount.
3. `BreakdownService` — combines the DP result with the `BundleDictionary` price table to produce a
   `BundleBreakdown` (bundles listed largest-first, with the total price).
4. `BundleCalculator` — the CLI entry point that wires the above together and logs each breakdown.

If an amount cannot be composed exactly from the available bundle sizes (e.g. `7 IMG` with bundles
of 5 and 10), the breakdown is empty with a zero total and a warning is logged.

## Build and Run

The build pins a Java 17 toolchain, so any installed JDK 17+ works:

```
./gradlew test          # run the unit tests
./gradlew run           # start the CLI, then type order lines and press enter on a blank line
```

Pipe input directly:

```
printf '10 IMG\n15 FLAC\n13 VID\n' | ./gradlew run -q
```

## Docker

Build the image and run the CLI in a container. Use `-i` so the container can read order lines
from stdin:

```
docker build -t bundle-calculator .
printf '10 IMG\n15 FLAC\n13 VID\n' | docker run -i --rm bundle-calculator
```

The image is built in two stages: a `gradle:8.2-jdk17` stage compiles and packages the application
distribution, and a slim `eclipse-temurin:17-jre` stage runs it.

## Continuous Integration

Every push and pull request runs `./gradlew build` (compile + tests) via GitHub Actions; see
[`.github/workflows/ci.yml`](.github/workflows/ci.yml)

## License

Released under the [MIT License](LICENSE).

## Run and Result

```
10 IMG
15 FLAC
13 VID

INFO: BundleBreakdown(amount=10, format=IMG, totalPrice=800.00, breakdownDetail=[1 x 10 $800.00])
INFO: BundleBreakdown(amount=15, format=FLAC, totalPrice=1957.50, breakdownDetail=[1 x 9 $1147.50, 1 x 6 $810.00])
INFO: BundleBreakdown(amount=13, format=VID, totalPrice=2370.00, breakdownDetail=[2 x 5 $1800.00, 1 x 3 $570.00])
```





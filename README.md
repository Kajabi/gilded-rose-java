# Gilded Rose Kata in Java

Hi and welcome to team Gilded Rose. As you know, we are a small inn with a prime location in a prominent city run by a friendly innkeeper named Allison. We also buy and sell only the finest goods. Unfortunately, our goods are constantly degrading in quality as they approach their sell by date. We have a system in place that updates our inventory for us. It was developed by a no-nonsense type named Leeroy, who has moved on to new adventures. Your task is to add the new feature to our system so that we can begin selling a new category of items.

## Our Current System

- All items have a `daysRemaining` value which denotes the number of days we have to sell the item

- All items have a `quality` value which denotes how valuable the item is

- At the end of each day our system lowers both values for every item

### Pretty simple, right? Well this is where it gets interesting:

- Once the sell by date has passed, Quality degrades twice as fast

- The Quality of an item is never negative

- "Aged" items actually increase in Quality the older they get

- The Quality of an item is never more than 50, unless "Legendary"

- "Legendary" items never have to be sold or decrease in Quality. They never change.

- "Backstage passes", like "Aged" items, increases in Quality as it's Days Remaining value approaches zero; Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but Quality drops to 0 after the concert

## Our Task

We have recently signed a supplier of conjured items. This requires an update to our system:

- "Conjured" items degrade in Quality twice as fast as normal items

The tests are always the source of truth in this scenario. You'll start out with some some passing and a few that are disabled because they would not yet pass. You can add tests, but do not change the tests that are already written other than to enable the disabled ones.

Feel free to make any changes to the `tick` method and add any new code as long as everything still works correctly.

### Requirements

- Make all tests pass

- Refactor giant if statements into something cleaner

- Show us what it's like to to work with you

- This is a chance to show some creativity and how you like to go about solving problems

- It's also an opportunity to show how you work with a team as you are welcome to ask questions and talk through ideas

## Other Notes

A `pom.xml` has been set up if you want or need to use it. It specifies the version and style of JUnit used. The versions of Java and Maven used in writing the kata are listed in `.tool-versions`. The [`asdf` CLI version manager](https://asdf-vm.com) was used to install both Java and Maven. If you have that tool with those plugins installed, then simply running `asdf install` should have you set up.

There is every reason to believe that other versions of Java and likely of Maven will work. Other versions of JUnit should work. If you want to change to Junit 4 style from Jupiter that is allowed, but the imports in the test file will need to be adjusted.
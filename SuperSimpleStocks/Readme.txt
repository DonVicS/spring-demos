I have used Spring Boot, because it’s helpful and gets the job done; and if I wanted to extend this exercise it would be time-saving.

I have created two services, one for Stocks and one for Trades. The functionality requested in the document happens inside the services so I didn’t bother adding a controller, it wasn’t necessary to get the exercise done, from my point of view.

There are some case scenarios for which there is no info about what to do in the document so I didn’t check them in this exercise. For example: It’s not specified what to do if there are no trades for some stock in the last 15 minutes, like in opening market time so, I only contemplate the case in which there is always trades in the last 15 minutes.

I think I got the formulas right.

I am using the “ComandLineRunner” to inject data in the services at the beginning of the app. I’m doing it for a demonstration purpose.

In the test classes you can check how for a given stock you can get all the data using the formulas provided in the document and the four trades that happen within 15 minutes, leaving the other two out, since they’re older. You can also get the All-Share-Index; I did it with the trades of the last 15 minutes. The document doesn’t specify if I have to use only those or all of them.

I hope everything is OK, and I didn’t miss anything.

Run the test classes to see this working.

Thank you.

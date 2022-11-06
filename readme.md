schema.sql - database
data.sql - creates accounts

Postman calls
List all accounts
http://localhost:8080/accounts - list all accounts

Transfer from one account (senderAccountId) to another (receiverAccountId)
http://localhost:8080/transfer - transfer amount from one account to another
body
{"senderAccountId":1, "receiverAccountId":2, "amount":100}

Withdraw from accountId
http://localhost:8080/withdraw
{"accountId":1, "amount":100}

Deposit to accountId
http://localhost:8080/deposit
{"accountId":1, "amount":100}
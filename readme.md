Postman calls
http://localhost:8080/accounts - list all accounts

http://localhost:8080/transfer - transfer amount from one account to another
body
{"senderAccountId":1, "receiverAccountId":2, "amount":100}
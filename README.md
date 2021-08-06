# amqp-issue

# Condition1:Use springboot version:2.1.8.RELEASE
Run this application local and call 'localhost:8080/sendMsg'.Consumer and producer work normally.


# Condition2:Use springboot version:2.3.7.RELEASE
Run this application local and call 'localhost:8080/sendMsg'.Producer work normally.But two consumers only one work nomally.What differance between two consumers? Only differance is method param.The consumer which occurs error with annotation '@headers'.

# If it defined as a bug, I'm willing to contribute.Thank you！

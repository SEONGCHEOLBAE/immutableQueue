# 1. ImmutableQueue

    passed build and test

    1) ImmutableQueue

        - has queue interface
        - Queues where all types of types are available
        - Junit(version.jupiter) available

    # how to test this code?
        - download this code
        - move "bin" folder
        - execute command: java -jar junit-platform-console-standalone-1.5.2.jar -cp 'com/queueTest' --select-package com.queue --include-classname='.*'

    # Is the explanation unkind?
         - Sorry... Because that's my first git hub project


# 2. Design Question: Design A Google Analytic like Backend System.
    We need to provide Google Analytic like services to our customers. Pls provide a high level solution design for the backend system. Feel free to choose any open source tools as you want.
	
	The system needs to:

	1) handle large write volume: Billions write events per day.
	
	2) handle large read/query volume: Millions merchants want to get insight about their business. Read/Query patterns are time-series related metrics. 
	
	3) provide metrics to customers with at most one hour delay.
	
	4) run with minimum downtime.
	
	5) have the ability to reprocess historical data in case of bugs in the processing logic.

  - solution
[solution]: https://github.com/SEONGCHEOLBAE/immutableQueue/blob/master/structure.pdf

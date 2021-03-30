# FSU-2020-Fall-OOAD-Decorator
Homework for decorator and adapter patterns

There are two steps for this homework

1. Adapter
1.a Create a class SleeperAdapter that adapts the Sleeper class from a TimeEater interface to a WasteTime interface.
1.b Change TimeRunner so that it uses the SleeperAdapter object, rather than the WastefulLoop object
1.c Do not change anything but the line "WasteTime waster = new WastefulLoop();" 
2. Decorator 
2.a. Create a TimeDifferenceDecorator for WasteTime
2.a.i  Wrapper the twiddle() method so that it takes time returned and computes the difference between the amount of time passed and the amount of time requested
2.a.ii Output the difference to System.out
2.b Add the decorator around SleepAdapter in TimeRunner
2.c Add your output to blackboard

Final output should look something like

Slept 0
Total amount of time twiddled is 27ms, difference from expected 27ms
Slept 1
Total amount of time twiddled is 1003ms, difference from expected 3ms
Slept 2
Total amount of time twiddled is 2002ms, difference from expected 2ms
Slept 3
Total amount of time twiddled is 3002ms, difference from expected 2ms
Slept 4
Total amount of time twiddled is 4002ms, difference from expected 2ms
Total amount of time wasted is 10038ms, difference from expected 38ms

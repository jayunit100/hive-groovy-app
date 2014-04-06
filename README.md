JavaAndGroovy
=============

Summary
-------

This project uses <code> groovy </code> and <code> java </code> together, builds with gradle.
Its aim is to connect to a hive instance remotely.

Not working yet:  But I think this project can be used for anyone wanting to access hive server 2 using groovy and or java in a modern gradle enviornment.

Edit the Unit test to specify your server credentials,and then off you go.  Just run it as a test in eclipseafter  doing the following. For my particular project, the JDBC Connection hangs.  To test:

0) cd to this directory
1) Download gradle
2) Run "gradle build"

Then, to hack on it

3) gradle eclipse
4) Import the project into eclipse.


SERVER
------

You want to make sure hive server is running.  Other than that, theres not much to it.


NOTES
-----
To connect to this instance, I use port forwarding: 

10,000 is the port that hive server runs on:
ssh -i jon.pem root@ec2-54-213-193-118.us-west-2.compute.amazonaws.com -L 9999:localhost:10000

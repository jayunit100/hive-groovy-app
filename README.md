JavaAndGroovy
=============

This project can be used as 

- a template for a java / groovy gradle project w/ unit tests.
- a template for a hive based JDBC app.

Summary
-------

This project uses <code> groovy </code> and <code> java </code> together, builds with gradle.
Its aim is to connect to a hive instance remotely.

Not working yet:  But I think this project can be used for anyone wanting to access hive server 2 using groovy and or java in a modern gradle enviornment.

Edit the Unit test to specify your server credentials,and then off you go.  Just run it as a test in eclipseafter  doing the following. For my particular project, the JDBC Connection hangs.  To test:

1. cd to this directory
1. Download gradle (```wget https://services.gradle.org/distributions/gradle-2.1-all.zip -O /opt/gradle.zip)```
1. ```(cd /opt/ && unzip gradle.zip)```
1. ```alias gradle=/opt/gradle/bin/gradle```
1. Run ```gradle build```, jar will now be in the build/ dir.
1. Run ```gradle eclipse``` to start editing in eclipse.


If just using as a java app
----------------------------

Your all set.  Delete the hive dependencies and replace classes as necessary.


If running HIVE stuff
---------------------
You want to make sure hive server is running.  Other than that, theres not much to it.


NOTES
-----
To connect to this instance, I use port forwarding: 

10,000 is the port that hive server runs on:
ssh -i jon.pem root@ec2-54-213-193-118.us-west-2.compute.amazonaws.com -L 9999:localhost:10000

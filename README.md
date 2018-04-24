# DBEX7-KFS
> by Kristian Flejsborg Sørensen (cph-kf96)

## Technical Comparison of an SQL and Graph Database
Exercise details can be found [here](https://github.com/datsoftlyngby/soft2018spring-databases-teaching-material/blob/master/assignments/Neo4J%20Exercise.ipynb)   

### setup
the test is done on a virtual mechine running linux os through the use of vagrant for setup, the virtual mechine is given 8192 megabyte worth of ram, and 4 cores running 4.2 ghz speed, the two databases are run in seperate containers and not running at the same time to give as much resources to each database as possible, the Neo4J have been given the suggest upgraded Ram usage, which may explain a crash that happens down the line as the given ram parameter is 8-10 gigs when the virtual box only gets 8.   

### Database structure

#### MySql
the tables where set up as follows   
Nodes   
![](https://i.gyazo.com/63e84b838907a6b744b4b132eb39505d.png)   
Edges   
![](https://i.gyazo.com/dec2b67c3b8f686d10a05a7799bff083.png)   
due to some confusion I created the Nodes normally, but Edges where made with both source and target being foriegn keys, but somehow this was not registered, so had to apply it individually with index, this is after several reconstructions of the table to ensure speed and efficiency.

#### Neo4J
the Neo4J table have been inplemented with standard parameters, if I understand correctly it handles the edges as FK by default so not much needs to be done, but I do wonder if it was needed and if it had a effect on the test.

### Results

|            | MySql - Average   | MySql - Median | Neo4J - Average   | Neo4J - Median |
|------------|-------------------|----------------|-------------------|----------------|
| depth of 1 | 27.1 milisecond   | 8 milisecond   | 60.95 milisecond  | 60 milisecond  |
| depth of 2 | 27.6 milisecond   | 10 milisecond  | 65.1 milisecond   | 64 milisecond  |
| depth of 3 | 87.1 milisecond   | 80 milisecond  | 110.15 milisecond | 88 milisecond  |
| depth of 4 | 643.05 milisecond | 393 milisecond | 986.7 milisecond  | 694 milisecond |
| depth of 5 | 18.4931 seconds   | 18.808 seconds | 24.118,95 seconds | 15.248 seconds |   

all data can be found in the following links
[mysqlDeepth1](https://gist.github.com/Retroperspect/76df196d763a0725efa3d6e97c9d0500) | [mysqlDeepth2](https://gist.github.com/Retroperspect/566767689d9c1db1ad4941ddaa4879bf) | [mysqlDeepth3](https://gist.github.com/Retroperspect/eadc0881c68ed843f58baedb0b404aa5) | [mysqlDeepth4](https://gist.github.com/Retroperspect/90d743dba0e662c4aa664920b0440d86) | [mysqlDeepth5](https://gist.github.com/Retroperspect/e27486315d1518ad6bf1e38d25bedd25) | [Neo4JDeepth1](https://gist.github.com/Retroperspect/c99a685ce9bdb3e5990022ef8d6c5553) | [Neo4JDeepth2](https://gist.github.com/Retroperspect/8431b90e758fc84616e9e120034e301c) | [Neo4JDeepth3](https://gist.github.com/Retroperspect/303f2af15340d96d00f40042eadae239) | [Neo4JDeepth4](https://gist.github.com/Retroperspect/5b327b67402f234c4b09b8c5c66132c6) | [Neo4JDeepth5](https://gist.github.com/Retroperspect/65a817aafaca080d7a78f604f089eb57)   

### conclusion
it's interesting to see the difference between the two databases, although I'm somewhat sure I allocated additional Ram for the Neo4J container, it did run out of memory one time on a case where it only needed "0.5 gigs" of ram for the query, which confuses me, it's also interesting that the test is somewhat unreliable, given some people are connected to very few people that are connect to few people aswell, while others are almost connected to everything.   
by the limited data MySql seems to be the winner on the average use case, though Neo4J seem to show promise in the Median on the depth 5 case, it struggles to follow suit, it must be noted however that even though Neo4J is slower in the first 2 depths it does show a preplanning phase before it execute the query, resulting in similair timing on both depth 1 and 2, if you removed the difference it would be clear the execution of the query is faster on Neo4J side, but I say the deadline pressure and my limited experience with Neo4J is likely the cause of this divide in performance.

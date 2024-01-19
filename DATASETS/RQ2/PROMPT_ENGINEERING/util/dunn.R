setwd("/Users/mdipenta/JSS-GPTSniffer/dunn")
t<-read.csv("metrics_dist.csv")
t$Prompt.type=as.factor(t$Prompt.type)
library(dunn.test)
capture.output(
dunn.test(t$distance,t$Prompt.type,method="BH"),
file="dunn-test.txt")

#! /bin/bash

javac rsn170330/*.java

java rsn170330.FindKLargestElements 1000000 1
java rsn170330.FindKLargestElements 1000000 2
echo
java rsn170330.FindKLargestElements 2000000 1
java rsn170330.FindKLargestElements 2000000 2
echo ''
java rsn170330.FindKLargestElements 4000000 1
java rsn170330.FindKLargestElements 4000000 2
echo ""
java rsn170330.FindKLargestElements 8000000 1
java rsn170330.FindKLargestElements 8000000 2
printf "\n"
java -Xms2g rsn170330.FindKLargestElements 16000000 1
java -Xms2g rsn170330.FindKLargestElements 16000000 2
printf "\n"
java -Xms2g rsn170330.FindKLargestElements 32000000 1
java -Xms2g rsn170330.FindKLargestElements 32000000 2
printf "\n"
java -Xms3g rsn170330.FindKLargestElements 64000000 1
java -Xms3g rsn170330.FindKLargestElements 64000000 2
printf "\n"
java -Xms3g rsn170330.FindKLargestElements 128000000 1
java -Xms3g rsn170330.FindKLargestElements 128000000 2
printf "\n"
java -Xms4g rsn170330.FindKLargestElements 256000000 1
java -Xms6g rsn170330.FindKLargestElements 256000000 2

exit 0
#!/bin/bash

rm termlist.txt

for file in $1 
do
   echo "Processing $file"
   xsltproc extract_terms.xsl $file >> termlist.txt
done

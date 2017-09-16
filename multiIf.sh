#!/bin/sh

echo -n "enter a number > "
read number
if [ $number -eq 1 ]; then
	echo "one"
elif [ $number -eq 2 ]; then 
	echo "two"
else 
    echo "not one or two"
fi

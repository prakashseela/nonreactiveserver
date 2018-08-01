#!/bin/sh
watch -d -n 0.5 'netstat -n -p tcp | grep 127 | grep 8002'

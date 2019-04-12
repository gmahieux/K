#!/bin/sh
microk8s.start
microk8s.reset
sleep 2
microk8s.enable dashboard
microk8s.enable dns
microk8s.enable registry
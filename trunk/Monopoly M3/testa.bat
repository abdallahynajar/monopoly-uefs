@echo off
set CLASSPATH=.;lib\easyaccept.jar;classes;%CLASSPATH%
set JAVA=java easyaccept.EasyAccept easy.UserStoriesFacade

%JAVA% testes/us1.txt 
%JAVA% testes/us2.txt 
%JAVA% testes/us3.txt 
%JAVA% testes/us4.txt 
%JAVA% testes/us5.txt 
%JAVA% testes/us6.txt 
%JAVA% testes/us7.txt 
%JAVA% testes/us8.txt 
%JAVA% testes/us9.txt 
%JAVA% testes/us10.txt 
%JAVA% testes/us11.txt 
%JAVA% testes/us12.txt 
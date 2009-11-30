@echo off
set JAVA=java -cp lib\easyaccept.jar;ant2 easyaccept.EasyAccept game.test.FacadeMonopoly

%JAVA% easyTests/us1.txt
%JAVA% easyTests/us2.txt
%JAVA% easyTests/us3.txt
%JAVA% easyTests/us4.txt

pause

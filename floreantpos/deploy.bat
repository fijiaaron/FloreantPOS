set FLOREANTPOS_VERSION=floreantpos-1.2.2
set SCIPIO_VERSION=scipio-1.0.5
set COMBINED_VERSION=%FLOREANTPOS_VERSION%-%SCIPIO_VERSION%

set BUILD_PATH=target\%COMBINED_VERSION%-bin\%COMBINED_VERSION%
set DEPLOY_PATH=\temp\scipio

xcopy /Y target\classes\floreantpos.properties %BUILD_PATH%
xcopy /Y target\classes\scipio.properties %BUILD_PATH%
xcopy /Y target\classes\update_posdb.bat %BUILD_PATH%
xcopy /Y target\classes\derbyrun.jar %BUILD_PATH%
xcopy /Y /E /I target\classes\database %BUILD_PATH%\database

xcopy /Y /E /I %BUILD_PATH% %DEPLOY_PATH%\%COMBINED_VERSION%

cd %DEPLOY_PATH%\%COMBINED_VERSION%
xcopy /Y /E /I sample-db\* .

;IF NOT EXIST posdb GOTO :UNZIP
;
;:UNZIP
;jar xf posdb.zip
;
;start /D %DEPLOY_PATH%\%COMBINED_VERSION% start-server.bat
;update_posdb.bat
